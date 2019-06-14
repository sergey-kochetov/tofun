<#include "./floatingButtonAdd.ftl">
<#macro main css=[]>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="/css/materialize.min.css?ver=1" media="screen,projection"/>
    <link type="text/css" rel="stylesheet" href="/css/post.css?ver=1"/>
    <script
            src="https://code.jquery.com/jquery-3.4.1.min.js"
            integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
            crossorigin="anonymous"></script>
    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<body>
<nav>
    <div class="nav-wrapper green darken-3">
        <a href="/issue" class="brand-logo" style="margin-left: 20px">CozyPark</a>
        <ul id="nav-mobile" class="right hide-on-med-and-down">
            <#--<#if user??>-->
            <#--<li hidden><a href="/issue">Мой профиль</a></li>-->
            <#--<#else>-->
            <li><a href="/reg">Sign up</a></li>
            <li><a href="/login">Sign in</a></li>
            <#--</#if>-->
        </ul>
    </div>
</nav>
<div class="container">

    <#nested>
</div>
<#if issues??>
<@floatingButtonAdd list=issues href="/issue" title="Жалоба" text="Вы можете добавить ее нажав на эту кнопку"/>
<#else>
<div class="fixed-action-btn">
    <a class="btn-floating btn-large green darken-3" href="/issue">
        <i class="large material-icons">add</i>
    </a>
</div>
</#if>

<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/js/materialize.min.js"></script>

</body>
</html>
</#macro>