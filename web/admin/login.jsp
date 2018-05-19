<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sign Up Login</title>
    <link rel="stylesheet" href="../assets/css/style.css">
</head>

<body>

<div class="cotn_principal">
    <div class="cont_centrar">
        <div class="cont_login">
            <div class="cont_info_log_sign_up">
                <div class="col_md_login">
                    <div class="cont_ba_opcitiy">
                        <h2>登陆</h2>
                        <p>我们必须拿我们所有的，<br>去换我们所没有的。</p>
                        <button class="btn_login" onmouseover="cambiar_login()">登陆</button>
                    </div>
                </div>
                <div class="col_md_sign_up">
                    <div class="cont_ba_opcitiy">
                        <h2>注册</h2>
                        <p>想的多一定没做的多有效，<br>然而不想想一定没什么效果。</p>
                        <button class="btn_sign_up" onmouseover="cambiar_sign_up()">注册</button>
                    </div>
                </div>
            </div>
            <div class="cont_back_info">
                <div class="cont_img_back_grey"><img src="../courseImg/po.jpg" alt=""/></div>
            </div>
            <div class="cont_forms">
                <form action="index.jsp" method="post">
                    <div class="cont_img_back_"><img src="../courseImg/po.jpg" alt=""/></div>
                    <div class="cont_form_login"><a style="float: right;" href="#"
                                                    onmouseover="ocultar_login_sign_up()">X</a>
                        <h2>登陆</h2>
                        <input type="text" placeholder="Email" name="studentId"/>
                        <input type="password" placeholder="Password" name="password"/>
                        <input type="submit" class="btn_login" value="登陆" style="text-align:center;">
                    </div>
                </form>
                <form action="register.action" method="post">
                    <div class="cont_form_sign_up"><a style="float: right;" href="#"
                                                      onmouseover="ocultar_login_sign_up()">X</a>
                        <h2>注册</h2>
                        <input type="text" placeholder="UserName" name="studentName"/>
                        <input type="text" placeholder="User" name="studentId"/>
                        <input type="password" placeholder="Password" name="password"/>
                        <input type="text" placeholder="Email" name="email"/>
                        <button class="btn_sign_up" onClick="cambiar_sign_up()">注册</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<script src="../assets/js/index.js"></script>
<div style="text-align:center;">

</div>
</body>
</html>
