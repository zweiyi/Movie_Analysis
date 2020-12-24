<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>电影</title>
</head>
<body>
<div align="center">
    <h1>电影评级</h1>
</div>


<form action="/kindMovie" method="post">
    <input class="typeahead tt-input" name="genre" type="text" placeholder="类型名查询" autocomplete="off" spellcheck="false" dir="auto" style="position: relative; vertical-align: top; background-color: transparent;">
    <a href="/kindMovie">
        <button class="btn btn-default" type="submit">查询</button>
    </a>
</form>


<div class="left-nav">
    <ul class="nav-left-active">
        <li class="active">
            <a href="hello">
                <span class="nav-item-title">电影信息</span>
            </a>
        </li>
        <li class="">
            <a href="/useRank">
                <span class="nav-item-title">用户评级</span>
            </a>
        </li>
        <li class=" ">
            <a href="/analysis">
                <span class="nav-item-title">电影特征分析</span>
            </a>
        </li>

    </ul>
</div>
<div class="container">
    <table border="1" align="center">
        <tr>
            <td>电影名</td>
            <td>电影类型</td>
        </tr>
        <#list movies! as movie>
            <tr>
                <td>${movie.title!}</td>
                <td>${movie.genres!}</td>
            </tr>
        </#list>
    </table>

<#--    <table border="1" align="right">-->
<#--        <tr>-->
<#--            <td>评分</td>-->
<#--        </tr>-->
<#--        <#list movieRating as mR>-->
<#--                <#list mR?keys as item>-->
<#--                    <tr>-->
<#--                        <td>-->
<#--                            ${mR[item]}-->
<#--                        </td>-->
<#--                    </tr>-->
<#--                </#list>-->
<#--        </#list>-->
<#--    </table>-->
</div>
</body>
</html>