<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/resource/jsp/common_top.jsp"%>
<body>
	<div data-bind='template:{foreach:dataSource1}' 
		data-portlet="dataSource1"
		style="background: blue;"
		data-param='{"preserve":{"p_bean":"testService","type":1}}'>
		<div data-bind='text:name'></div>
	</div>
	
	<div data-bind="template:{ name: 'person-template1', foreach: dataSource2}" 
		data-portlet="dataSource2"
		style="background: red;"
		data-param='{"preserve":{"p_bean":"testService","type":2}}'>
	</div>

	<div data-bind="template:{ name: 'person-template2', data: {name:'test'}, afterRender:test}" >
	</div>
</body>

<script type="text/html" id="person-template1">
	<div data-bind='text:name'></div>
</script>

<script type="text/html" id="person-template2">
	<div data-bind='text:name'></div>
</script>

<script>
function test(){console.log('test');}
</script>
</html>

