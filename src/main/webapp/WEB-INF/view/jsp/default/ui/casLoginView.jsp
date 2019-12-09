<!DOCTYPE html>
<%@ page pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>统一身份认证中心</title>
<spring:theme code="standard.custom.css.file" var="customCssFile" />
<link rel="stylesheet" href="<c:url value="${customCssFile}" />" />
<link rel="icon" href="<c:url value="/favicon.ico" />"
	type="image/x-icon" />
<!--[if lt IE 9]>
    <script src="js/html5shiv.js" type="text/javascript"></script>
  <![endif]-->

<!-- 页面基本设置禁止随意更改 -->
<!-- 基础CSS类库可随意更改 -->
<link rel="stylesheet" type="text/css" href="css/less.css">
<link rel="stylesheet" type="text/css" href="css/basic.css">
<!--[if IE 8]>
<link rel="stylesheet" type="text/css" href="css/ie8.css">
<![endif]-->
<!--[if gte IE 9]> 
<link rel="stylesheet" type="text/css" href="css/ie.css"> 
<![endif]-->
<script type="text/javascript">
// 如果在框架或在对话框中，则弹出提示并跳转到首页
if (window.frames.length != parent.frames.length) {
　　alert('未登录或登录超时。请重新登录，谢谢！');
	top.location = "${ctx}";
}
</script>
</head>
<body>
	<div class="wrapper" style="background-color: white;">
		<div class="login-top">
			<header>
		        <h1 style="padding-left: 140px;font-weight: 900;">&nbsp;</h1>
	      	</header>
			<div style="background-color: white;">
				<div style="float:right;margin-top: -34px;width: 260px;font-size: 12px;">
					<span>返回首页</span> <span>|</span> <span>登录帮助</span> <span>
				</div>
			</div>
			<div class="login-topBg">
				<div class="login-topBg1">
					<div class="login-topStyle">
						<form:form method="post" commandName="${commandName}" htmlEscape="true">
							<div class="login-topStyle3" id="loginStyle" style="margin-top: 135px;">
								<h3>用户登录</h3>
								<div class="ui-form-item loginUsername">
									<input type="username" name="username" maxlength="25" autocomplete="off" placeholder="请输入用户名">
								</div>
								<div class="ui-form-item loginPassword">
									<input type="password" name="password" maxlength="25" autocomplete="off" placeholder="请输入密码">
								</div>
								<div class="ui-form-item loginUsername">
									<input type="username" name="authcode" autocomplete="off" style="width: 120px;" maxlength="5" placeholder="请输入验证码">
									<img src="captcha.jpg" onclick="javascript:this.src=this.src+'?'" style="margin-left:0px; height:35px; width: 90px;cursor:pointer; vertical-align:middle;">
								</div>
								
								<!-- <div class="login_reme">
									<input type="checkbox"> 
									<a class="reme1">记住账号</a> 
									<a class="reme2" href="javascript:void(0)">忘记密码?</a>
								</div> -->
								<input type="hidden" name="lt" value="${loginTicket}" /> 
								<input type="hidden" name="execution" value="${flowExecutionKey}" /> 
								<input type="hidden" name="_eventId" value="submit" /> 
								<input class="btnStyle btn-register" name="submit" accesskey="l" value="<spring:message code="screen.welcome.button.login" />" tabindex="4" type="submit" />
								<div class="login_reme">
									<form:errors path="*" id="msg" cssClass="errors" element="div" htmlEscape="false" />
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
		<div class="loginCen" style="margin-top: 115px;">
			<div class="login-center">
				<div class="loginCenter-moudle">
					<div class="loginCenter-moudleLeft" style="margin-right: 60px;">&nbsp;</div>
					<div class="loginCenter-moudleRight" style="  width: 1067px;">
						<!--第一个-->
						<a class="loginCenter-mStyle loginCenter-moudle1" id="moudleRemove" style=" display:block;width: 340px;"> 
							<span class="moudle-img">
								<img src="images/login_bg_01.png">
							</span> 
							<span class="moudle-text"> 
								<span class="moudle-text1" style="font-family:'微软雅黑'"> 一站式身份认证 </span> 
								<span class="moudle-text2" style="font-family:'微软雅黑'">One stop authentication</span> 
							</span> 
						</a>
						<!--第二个-->
						<a class="loginCenter-mStyle loginCenter-moudle2" style=" display:block; width: 357px;" id="moudleRemove2"> 
							<span class="moudle-img">
								<img src="images/login_bg_02.png">
							</span> 
							<span class="moudle-text"> 
								<span class="moudle-text1" style="font-family:'微软雅黑'"> 精细化数据管理 </span> 
								<span class="moudle-text2" style="font-family:'微软雅黑'">Fine data management</span> 
							</span> 
						</a>
						<!--第三个-->
						<a class="loginCenter-mStyle loginCenter-moudle3" style=" display:block;" id="moudleRemove3"> 
							<span class="moudle-img">
								<img src="images/login_bg_03.png">
							</span> 
							<span class="moudle-text"> 
								<span class="moudle-text">
									<span class="moudle-text1" style="font-family:'微软雅黑'"> 高效率通关服务 </span> 
									<span class="moudle-text2" style="font-family:'微软雅黑'">Efficient customs clearance service</span> 
								</span> 
							</span> 
						</a>
					</div>
				</div>
			</div>
		</div>
		<div class="footer">
			<span class="footerText">
				Copyright © 2017-2022 美华系统
			</span>
		</div>
	</div>
</body>
</html>