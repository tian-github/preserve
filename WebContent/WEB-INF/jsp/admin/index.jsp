<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ include file="/resource/jsp/common_top.jsp"%>
<link rel="stylesheet/less" type="text/css" href="${PRESERVE_PARAMETER_STYLEPATH }admin/index.css" />
<script type="text/javascript" src="${PRESERVE_PARAMETER_RESPATH }js/lib/less.js"></script>
<body>
</head>
<body>

	<div>
		<img alt="img" src="${PRESERVE_PARAMETER_STYLEPATH }admin/img/default.jpg" class="background_img">
	</div>
	<div class="admin-panel clearfix">
		<div class="slidebar">
			<div class="logo">
				<a href=""></a>
			</div>
			<ul>
				<li><a href="">dashboard</a></li>
				<li><a href="">posts</a></li>
				<li><a href="">media</a></li>
				<li><a href="">pages</a></li>
				<li><a href="">links</a></li>
				<li><a href="">comments</a></li>
				<li><a href="">widgets</a></li>
				<li><a href="">plugins</a></li>
				<li><a href="">users</a></li>
				<li><a href="">tools</a></li>
				<li><a href="">settings</a></li>
			</ul>
		</div>
		<div class="main">
			<iframe src="${ PRESERVE_CONTEXTPATH}redirect/jsp?p_jsp=admin/admin" width="100%" height="690px" ></iframe>
		</div>
	</div>
</body>
<%@ include file="/resource/jsp/common_foot.jsp"%>