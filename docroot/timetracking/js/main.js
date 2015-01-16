AUI.add(
	'liferay-timetracking',
	function(A) {
		var AObject = A.Object;
		var HistoryManager = Liferay.HistoryManager;
		var Lang = A.Lang;
		var Node = A.Node;
		var Util = Liferay.Util;

		var owns = AObject.owns;

		var ACTION_START = 0;

		var ACTION_LIST = 1;

		var ACTION_LIST_SESSIONS = 2;

		var COLUMNS_TODAY_ACTIVITY_SESSIONS = [Liferay.Language.get('column-activityname'), Liferay.Language.get('column-starttime'), Liferay.Language.get('column-endtime'), Liferay.Language.get('column-duration')];

		var CSS_MESSAGE_ERROR = 'alert alert-error';

		var CSS_MESSAGE_SUCCESS = 'alert alert-success';

		var DATA_ACTIVITY_ID = 'data-activityId';

		var DATA_ACTIVITY_NAME = 'data-activityName';

		var EVENT_CLICK = 'click';

		var EVENT_SUBMIT = 'submit';

		var INVALID_VALUE = A.Attribute.INVALID_VALUE;

		var LIFECYCLE_RENDER = 0;

		var LIFECYCLE_ACTION = 1;

		var LIFECYCLE_RESOURCE = 2;

		var MESSAGE_TYPE_ALERT = 'alert';

		var MESSAGE_TYPE_ERROR = 'error';

		var MESSAGE_TYPE_SUCCESS = 'success';

		var SELECTOR_ACTIVITY_MESSAGES_START = '#activityMessagesStart';

		var SELECTOR_START_ACTIVITY_FORM = 'form.start-activity-form';

		var SELECTOR_TODAY_ACTIVITY_SESSION_LIST = '#today-activity-session-list';

		var STR_ACTION = 'action';

		var STR_START_ACTIVITY_JSP = '/timetracking/start_activity.jsp';

		var STR_EMPTY = '';

		var STR_BOUNDING_BOX = 'boundingBox';

		var STR_CONTENT_BOX = 'contentBox';

		var STR_PAGE = 'page';

		var STR_RESPONSE_DATA = 'responseData';

		var STR_ROWS_PER_PAGE = 'rowsPerPage';

		var STR_SELECTED = 'active';

		var STR_SUCCESS = 'success';

		var STR_URI = 'uri';

		var TPL_ACTIVITY_LIST_CONTAINER = '<ul class="nav nav-pills nav-stacked">';

		var TPL_ACTIVITY_LIST =
			'<li class="activity-item results-row {cssClassSelected}" data-activityName="{titleCurrentValue}" data-activityId="{activityId}" tabIndex="0">' +
				'<a href="javascript:;" data-activityId="{activityId}" tabIndex="-1">' +
					'<span class="activity-item-name" data-activityId="{activityId}">{titleCurrentValue}</span>' +
					'<span tabindex="0" class="activity-item-actions-trigger" data-activityId="{activityId}"  data-activityName="{titleCurrentValue}"></span>' +
				'</a>' +
			'</li>';

		var TPL_MESSAGES_PORTLET = '<div class="hide lfr-message-response" id="porletMessages" />';

		var TimeTracking = A.Component.create(
			{
				NAME: 'TimeTracking',

				EXTENDS: A.Base,

				prototype: {
					initializer: function(config) {
						var instance = this;

						instance._ioActivity = {};

						instance._originalConfig = config;

						instance.portletId = config.portletId;

						instance._prefixedPortletId = '_' + config.portletId + '_';

						instance._portletMessageContainer = Node.create(TPL_MESSAGES_PORTLET);

						instance._container = A.one('.activity-portlet-content');
						instance._hideMessageTask = A.debounce(instance._hideMessage, 7000);

						instance._container.placeBefore(instance._portletMessageContainer);

						var activityList = A.one(instance._activityListSelector);

						activityList.on(EVENT_CLICK, instance._onActivityListItemClick, instance);

						var startActivityButton = A.one('#startActivityButton');

						if (startActivityButton) {
							startActivityButton.on('click', instance._onActivityStartButtonClick, instance, 0);
						}

						HistoryManager.on('stateChange', instance._onStateChange, instance);

						instance._getActivityList();

						instance._getTodayActivitySessionList();
					},

					_addTodayActivitySessionItem: function(item) {
						var instance = this;

						var todayActivitySessionListTable = instance._todayActivitySessionListTable;

						if (!todayActivitySessionListTable) {
							var data = [];

							data[0] = item;

							todayActivitySessionListTable = instance._createDataTable(data, SELECTOR_TODAY_ACTIVITY_SESSION_LIST);

							instance._todayActivitySessionListTable = todayActivitySessionListTable;
						}
						else {
							todayActivitySessionListTable.addRow(item);
						}
					},

					_afterActivitiesPaginationChangeRequest: function(event) {
						var instance = this;

						var lastState = event.lastState;
						var state = event.state;

						var historyState = {};

						var paginationMap = instance._getActivitiesPaginationMap();

						AObject.each(
							paginationMap,
							function(item, index, collection) {
								if (owns(state, index)) {
									var historyEntry = item.historyEntry;

									var newItemValue = state[index];

									var value = INVALID_VALUE;

									if (newItemValue === item.defaultValue &&
										Lang.isValue(HistoryManager.get(historyEntry))) {

										value = null;
									}
									else if (lastState && (newItemValue !== lastState[index])) {
										value = newItemValue;
									}

									if (value !== INVALID_VALUE) {
										historyState[historyEntry] = value;
									}
								}
							}
						);

						if (!AObject.isEmpty(historyState)) {
							HistoryManager.add(historyState);
						}

						instance._getActivityList();
					},

					_bindCloseEvent: function(contextPanel) {
						var instance = this;

						contextPanel.get(STR_BOUNDING_BOX).on('key', contextPanel.hide, 'up:27', contextPanel);
					},

					_createActivityPanelStart: function() {
						var instance = this;

						instance._activityPanelStart = Liferay.Util.Window.getWindow(
							{
								dialog: {
									cssClass: 'portlet-timetracking-dialog'
								},
								title: Liferay.Language.get('start-activity')
							}
						);

						instance._activityPanelStart.hide();

						//instance._bindCloseEvent(instance._activityPanelAdd);

						return instance._activityPanelStart;
					},

					_createDataTable: function(data, selector) {
						var columns = [
							{
								key: 'activityName',
								label: COLUMNS_TODAY_ACTIVITY_SESSIONS[0]
							},
							{
								formatter: formatDate,
								key: 'startDate',
								label: COLUMNS_TODAY_ACTIVITY_SESSIONS[1]
							},
							{
								formatter: formatDate,
								key: 'endDate',
								label: COLUMNS_TODAY_ACTIVITY_SESSIONS[2]
							},
							{
								key: 'duration',
								label: COLUMNS_TODAY_ACTIVITY_SESSIONS[3]
							}
						];

						function formatDate(object) {
							return object.value && A.DataType.Date.format(new Date(object.value), {format: "%x %X"});
						};

						if (!data) {
							data = {};
						}

						var dataTable = new A.DataTable(
							{
								columns: columns,
								data: data,
								sortable: true
							}
						).render(selector);

						return dataTable;
					},

					_createURL: function(action, lifecycle, params) {
						var instance = this;

						var path = STR_EMPTY;

						var url;

						var config = instance._originalConfig;

						if (!params) {
							params = {};
						}

						if (lifecycle == LIFECYCLE_RENDER) {
							url = Liferay.PortletURL.createURL(config.baseRenderURL);

							url.setWindowState('exclusive');
						}
						else if (lifecycle == LIFECYCLE_ACTION) {
							url = Liferay.PortletURL.createURL(config.baseActionURL);

							url.setWindowState('exclusive');
						}
						else if (lifecycle == LIFECYCLE_RESOURCE) {
							url = Liferay.PortletURL.createURL(config.baseResourceURL);
						}
						else {
							throw 'Internal error. Unimplemented lifecycle.';
						}

						url.setPortletId(instance.portletId);

						if (action === ACTION_START) {
							path += STR_START_ACTIVITY_JSP;

							params.mvcPath = path;
						}

						for (var key in params) {
							if (owns(params, key)) {
								url.setParameter(key, params[key]);
							}
						}

						url.setDoAsGroupId(themeDisplay.getScopeGroupId());

						return url;
					},

					_displayActivityList: function() {
						var instance = this;

						var activityList = instance._activityList;

						var activityListContainer = A.one(instance._activityListSelector);

						instance._showLoading('.activity-list');

						if (activityList && activityList.length) {
							var buffer = [TPL_ACTIVITY_LIST_CONTAINER];

							A.each(
								activityList,
								function(item, index, collection) {
									item.cssClassSelected = STR_EMPTY;

									var auxItem = A.clone(item);

									auxItem.titleCurrentValue = Util.escapeHTML(auxItem.activityName);

									buffer.push(Lang.sub(TPL_ACTIVITY_LIST, auxItem));
								}
							);

							buffer.push('</ul>');

							activityListContainer.html(buffer.join(STR_EMPTY));
						}
						else {
							activityListContainer.html(STR_EMPTY);
						}
					},

					_displayTodayActivitySessionList: function() {
						var instance = this;

						instance._showLoading(TPL_ACTIVITY_LIST_CONTAINER);

						var todayActivitySessionList = instance._todayActivitySessionList;

						if (todayActivitySessionList && todayActivitySessionList.length) {
							var	todayActivitySessionListTable = instance._createDataTable(todayActivitySessionList, SELECTOR_TODAY_ACTIVITY_SESSION_LIST);

							instance._todayActivitySessionListTable = todayActivitySessionListTable;
						}
					},

					_getActivityId: function(exp) {
						var instance = this;

						return A.one(exp).attr(DATA_ACTIVITY_ID);
					},

					_getActivityName: function(exp) {
						var instance = this;

						return A.one(exp).attr(DATA_ACTIVITY_NAME);
					},

					_getActivityList: function() {
						var instance = this;

						var pagination = instance._getActivitiesPagination();

						var config = instance._originalConfig;

						var itemsPerPage = config.itemsPerPage;

						var currentPage = 0;

						currentPage = pagination.get(STR_PAGE);

						if (!currentPage) {
							var paginationMap = instance._getActivitiesPaginationMap();

							currentPage = paginationMap[STR_PAGE].defaultValue;
						}

						currentPage -= 1;

						var start = currentPage * itemsPerPage;
						var end = start + itemsPerPage;

						var params = {
							start: start,
							end: end
						};

						var activityURL = instance._createURL(ACTION_LIST, LIFECYCLE_RESOURCE, params);

						activityURL.setResourceId('getActivities');

						var ioActivity = instance._ioActivity[ACTION_LIST];

						if (!ioActivity) {
							ioActivity = A.io.request(
								null,
								{
									autoLoad: false,
									dataType: 'json',
									on: {
										success: function(event, id, obj) {
											var response = this.get(STR_RESPONSE_DATA);

											instance._onActivityListSuccess(response);

											var total = response.total;

											pagination.set('total', Math.ceil(total / itemsPerPage));
											pagination.set('visible', (total > itemsPerPage));

											pagination.setState(response);
										},
										failure: function(event, id, obj) {
											instance._onActivityStartFailure(obj);
										}
									}
								}
							);

							instance._ioActivity[ACTION_LIST] = ioActivity;
						}

						ioActivity.set(STR_URI, activityURL.toString());

						ioActivity.start();
					},

					_getActivitiesPagination: function() {
						var instance = this;

						var activitiesPagination = instance._activitiesPagination;

						if (!activitiesPagination) {
							var originalConfig = instance._originalConfig;

							var config = {
								boundingBox: '.activity-list-pagination',
								circular: false,
								visible: false
							};

							var paginationMap = instance._getActivitiesPaginationMap();

							AObject.each(
								paginationMap,
								function(item, index, collection) {
									config[index] = Number(HistoryManager.get(item.historyEntry)) || item.defaultValue;
								}
							);

							activitiesPagination = new A.Pagination(config).render();

							activitiesPagination.after('changeRequest', instance._afterActivitiesPaginationChangeRequest, instance);

							instance._activitiesPagination = activitiesPagination;
						}

						return activitiesPagination;
					},

					_getActivitiesPaginationMap: function() {
						var instance = this;

						var paginationMap = instance._paginationMap;

						if (!paginationMap) {
							paginationMap = {
								page: {
									historyEntry: instance._prefixedPortletId + STR_PAGE,
									defaultValue: 1,
									formatter: Number
								},
								rowsPerPage: {
									historyEntry: instance._prefixedPortletId + STR_ROWS_PER_PAGE,
									defaultValue: instance._originalConfig.itemsPerPage,
									formatter: Number
								}
							};

							instance._paginationMap = paginationMap;
						}

						return paginationMap;
					},

					_getTodayActivitySessionList: function() {
						var instance = this;

						var activityURL = instance._createURL(ACTION_LIST_SESSIONS, LIFECYCLE_RESOURCE);

						activityURL.setResourceId('getTodayActivitySessions');

						var ioActivity = instance._ioActivity[ACTION_LIST_SESSIONS];

						if (!ioActivity) {
							ioActivity = A.io.request(
								null,
								{
									autoLoad: false,
									dataType: 'json',
									on: {
										success: function(event, id, obj) {
											var response = this.get(STR_RESPONSE_DATA);

											instance._onTodayActivitySessionListSuccess(response);
										},
										failure: function(event, id, obj) {
											instance._onActivityStartFailure(obj);
										}
									}
								}
							);

							instance._ioActivity[ACTION_LIST_SESSIONS] = ioActivity;
						}

						ioActivity.set(STR_URI, activityURL.toString());

						ioActivity.start();
					},

					_hideMessage: function(container) {
						var instance = this;

						container = container || instance._portletMessageContainer;

						container.hide();
					},

					_initializeActivityPanelStart: function(action) {
						var instance = this;

						var activityFormStart = instance._activityPanelStart.get(STR_CONTENT_BOX).one(SELECTOR_START_ACTIVITY_FORM);

						activityFormStart.detach(EVENT_SUBMIT);

						activityFormStart.on(EVENT_SUBMIT, instance._onActivityFormSubmit, instance, activityFormStart, action);
						/*
						var closeButton = categoryFormAdd.one(SELECTOR_BUTTON_CANCEL);

						closeButton.on(EVENT_CLICK, instance._onCategoryAddButtonClose, instance);

						instance._categoryFormAdd = categoryFormAdd;

						instance._loadVocabularySelect(instance._activities, instance._selectedVocabularyId);*/
					},

					_onActivityStartSuccess: function(response, action) {
						var instance = this;

						var exception = response.exception;

						if (!exception) {
							instance._sendMessage(MESSAGE_TYPE_SUCCESS, Liferay.Language.get('your-request-processed-successfully'));

							instance._activityPanelStart.hide();

							instance._getActivityList();

							instance._addTodayActivitySessionItem(response.activitySessionItem);
						}
						else {
							var errorKey = STR_EMPTY;

							if	(exception.indexOf('TMActivityNameException') > -1) {
								errorKey = Liferay.Language.get('please-enter-an-activity-name');
							}
							else if (exception.indexOf('TMDateTimeException') > -1) {
								errorKey = Liferay.Language.get('please-enter-a-start-date-that-comes-before-the-end-date');
							}
							else if (exception.indexOf('DuplicateTMActivityNameException') > -1) {
								errorKey = Liferay.Language.get('an-activity-with-the-given-name-has-already-existed');
							}
							else {
								errorKey = Liferay.Language.get('your-request-failed-to-complete');
							}

							instance._sendMessage(MESSAGE_TYPE_ERROR, errorKey, SELECTOR_ACTIVITY_MESSAGES_START);
						}
					},

					_onActivityActionFailure: function(response) {
						var instance = this;

						instance._sendMessage(MESSAGE_TYPE_ERROR, Liferay.Language.get('your-request-failed-to-complete'), SELECTOR_CATEGORY_MESSAGES_START);
					},

					_onActivityFormSubmit: function(event, form, action) {
						var instance = this;

						event.halt();

						instance._startActivity(form);
					},

					_onActivityListItemClick: function(event) {
						var instance = this;

						var target = event.target;

						if (event.target.hasClass('activity-item-actions-trigger')) {
							var activity = {};

							activity.activityId = instance._getActivityId(target);
							activity.activityName = instance._getActivityName(target);

							instance._showActivityPanelStart(activity);
						}
					},

					_onActivityListSuccess: function(response) {
						var instance = this;

						this._activityList = response.activities;

						instance._displayActivityList();
					},

					_onActivityStartButtonClick: function(event) {
						var instance = this;

						instance._showActivityPanelStart();
					},

					_onStateChange: function(event) {
						var instance = this;

						var changed = event.changed;
						var removed = event.removed;

						var paginationState = {};

						var paginationMap = instance._getActivitiesPaginationMap();

						AObject.each(
							paginationMap,
							function(item, index, collection) {
								var historyEntry = item.historyEntry;

								var value;

								if (owns(changed, historyEntry)) {
									value = item.formatter(changed[historyEntry].newVal);
								}
								else if (owns(removed, historyEntry)) {
									value = item.defaultValue;
								}

								if (value) {
									paginationState[index] = value;
								}
							}
						);

						if (!AObject.isEmpty(paginationState)) {
							instance._activitiesPagination.setState(paginationState);

							instance._getActivityList();
						}
					},

					_onTodayActivitySessionListSuccess: function(response) {
						var instance = this;

						instance._todayActivitySessionList = response.todayActivitySessionList;

						instance._displayTodayActivitySessionList();
					},

					_sendMessage: function(type, message, container) {
						var instance = this;

						var output = A.one(container || instance._portletMessageContainer);
						var typeClass = 'alert alert-' + type;

						output.removeClass(CSS_MESSAGE_ERROR).removeClass(CSS_MESSAGE_SUCCESS);
						output.addClass(typeClass);
						output.html(message);

						output.show();

						instance._hideMessageTask(output);
					},

					_showActivityPanelStart: function(activity) {
						var instance = this;

						var activityPanelStart = instance._activityPanelStart;

						var activityURL = instance._createURL(ACTION_START, LIFECYCLE_RENDER);

						if (activity) {
							activityURL.setParameter('activityId', activity.activityId);
							activityURL.setParameter('activityName', activity.activityName);
						} else {
							var namespace = instance._prefixedPortletId;

							var idPrefix = '#' + namespace;

							var activityNameField =  A.one(idPrefix + 'activityNameField');

							if (activityNameField && activityNameField.val()) {
								activityURL.setParameter('activityName', activityNameField.val());
							}
						}

						if (!activityPanelStart) {
							activityPanelStart = instance._createActivityPanelStart();

							activityPanelStart.plug(
								A.Plugin.IO,
								{
									autoLoad: false,
									uri: activityURL.toString()
								}
							);
						}
						else if (instance._currentActivityPanelStartIOHandle) {
							instance._currentActivityPanelStartIOHandle.detach();

							activityPanelStart.io.set(STR_URI, activityURL.toString());
						}

						activityPanelStart.show();

						activityPanelStart._syncUIPosAlign();

						instance._currentActivityPanelStartIOHandle = activityPanelStart.io.after(
							STR_SUCCESS,
							A.bind('_initializeActivityPanelStart', instance, ACTION_START)
						);

						activityPanelStart.io.start();
					},

					_showLoading: function(container) {
						var instance = this;

						A.all(container).html('<div class="loading-animation" />');
					},

					_startActivity: function(form) {
						var instance = this;

						var ioActivity = instance._ioActivity[ACTION_START];

						if (!ioActivity) {
							ioActivity = A.io.request(
								null,
								{
									autoLoad: false,
									dataType: 'json',
									on: {
										success: function(event, id, obj) {
											var response = this.get(STR_RESPONSE_DATA);

											instance._onActivityStartSuccess(response);
										},
										failure: function(event, id, obj) {
											instance._onActivityStartFailure(obj);
										}
									}
								}
							);

							instance._ioActivity[ACTION_START] = ioActivity;
						}

						ioActivity.set('form', form.getDOM());
						ioActivity.set(STR_URI, form.attr(STR_ACTION));

						ioActivity.start();
					},

					_activityListSelector: '.activity-list'
				}
			}
		);

		Liferay.Portlet.TimeTracking = TimeTracking;
	},
	'',
	{
		requires: ['aui-datatable', 'aui-datatype', 'aui-pagination', 'datatable-mutable', 'datatable-sort', 'datatype-date', 'liferay-history-manager', 'liferay-portlet-url']
	}
);