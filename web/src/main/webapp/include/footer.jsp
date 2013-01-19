<%@ page language="java"%>
<%@ page import="gov.hhs.onc.dcdt.web.startup.VersionInfo" %>
<%@ page session="false"%>
<hr/>
<div class="container">
	<strong>
		If you have any questions about the tool, please check out our<a href="http://code.google.com/p/direct-certificate-discovery-tool/wiki/Frequently_Asked_Questions" class="oncfaq"> FAQ page</a> or
		post a question to the tool's community <a href="mailto:directtesttool@googlegroups.com" class="mail" >discussion group</a>.
	</strong>
	<br/><br/>
	<div id="version">
		Version: <%= VersionInfo.getVersion() %>
		(SVN: <%= VersionInfo.getSvnHeadUrl() %>, rev=<%= VersionInfo.getSvnRevision() %>, date=<%= VersionInfo.getSvnDate() %>)
	</div>
</div>
<br/>

<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="javascripts/jquery.popupWindow.js"></script>

<script type="text/javascript"> 
$('.oncfaq').popupWindow({ 
windowURL:'http://code.google.com/p/direct-certificate-discovery-tool/wiki/Frequently_Asked_Questions', 
windowName:'onc',
height:500, 
width:800, 
top:50, 
left:50,
scrollbars:1

}); 
</script>