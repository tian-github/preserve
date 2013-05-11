<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ include file="/resource/jsp/tag.jsp" %>
<%
	String PRESERVE_THEME = "default";//所属皮肤
	request.setAttribute("PRESERVE_THEME", PRESERVE_THEME);
	String PRESERVE_CONTEXTPATH = request.getContextPath() + "/";//根路径
	request.setAttribute("PRESERVE_CONTEXTPATH", PRESERVE_CONTEXTPATH);
	String PRESERVE_PARAMETER_RESPATH = PRESERVE_CONTEXTPATH
			+ "resource/";//资源文件路径
	request.setAttribute("PRESERVE_PARAMETER_RESPATH",
			PRESERVE_PARAMETER_RESPATH);
	String PRESERVE_PARAMETER_STYLEPATH = PRESERVE_PARAMETER_RESPATH
			+ "theme/" + PRESERVE_THEME + "/";//皮肤包文件路径
	request.setAttribute("PRESERVE_PARAMETER_STYLEPATH",
			PRESERVE_PARAMETER_STYLEPATH);
%>
<script>
	var PRESERVE = {
		version : "v1.0",
		contextPath : "${PRESERVE_CONTEXTPATH}",
		resPath : "${PRESERVE_PARAMETER_RESPATH}",
		stylePath : "${PRESERVE_PARAMETER_STYLEPATH}",
		toString : function() {
			return this.version;
		}
	};
</script>