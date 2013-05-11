~~function() {

	var Portlet = function() {
		var PORTLET_URL = PRESERVE.contextPath + 'ajax/portlet', DATA_PORTLET = "data-portlet", DATA_PARAM = "data-param";

		var options = [], portlets = $('div[' + DATA_PORTLET + ']');
		// 为div绑定对象
		portlets.each(function(index, item) {
			var portlet = $(item), key = portlet.attr(DATA_PORTLET);
			options[index] = {};
			options[index]['key'] = key;
			options[index]['data'] = [];
		});
		window.ko_portlet = new PRESERVE.tmpl(options);
		ko.applyBindings(ko_portlet);

		// 请求后台更新绑定数据
		portlets
				.each(function(index, item) {
					var portlet = $(item), param = JSON.parse(portlet
							.attr(DATA_PARAM));
					var data = {};
					if (param && param.preserve) {
						data = param.preserve;
					}
					jQuery.post(PORTLET_URL, data, function(data, textStatus,
							xhr) {
						if (data) {
							ko_portlet.addOptions(portlet.attr(DATA_PORTLET),
									data);
						}
					});
				});
	};

	var Tmpl = function(eOptions) {
		var self = this;
		var options = {
		// key : '',
		// data : []
		};
		jQuery.extend(options, eOptions);

		// 初始化
		this.init = function(options) {
			self.bindOptions(options);
		};

		// 更新模板数据
		this.addOptions = function(key, data) {
			for ( var d in data) {
				this[key].push(data[d]);
			}
		};
		// 绑定数据
		this.bindOptions = function(options) {
			for ( var i in options) {
				this[options[i].key] = ko.observableArray(options[i].data);
			}
		};

		self.init(options);
	};
	PRESERVE.tmpl = Tmpl;
	PRESERVE.portlet = Portlet;
}();

$(function() {
	new PRESERVE.portlet();
});