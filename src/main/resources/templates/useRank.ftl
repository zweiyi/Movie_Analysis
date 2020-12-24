<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>useRank</title>
    <script type="text/css">
    </script>
</head>
<body>


<div  align="center" style="height: 200px">
    <form action="/insertUser" method="post">
        <a href="/insertUser" style="text-decoration: none">
            <button  type="submit">增加</button>
        </a>
        <input  name="userid" type="number" placeholder="userid" autocomplete="off" spellcheck="false" dir="auto" style="position: relative; vertical-align: top; background-color: transparent;">
        <input  name="movieid" type="number" placeholder="movieid" autocomplete="off" spellcheck="false" dir="auto" style="position: relative; vertical-align: top; background-color: transparent;">
        <input  name="rating"  type="text" placeholder="1,1.5,2,2.5....5" autocomplete="off" spellcheck="false" dir="auto" style="position: relative; vertical-align: top; background-color: transparent;">
        <input  name="tag"  type="text" placeholder="tag" autocomplete="off" spellcheck="false" dir="auto" style="position: relative; vertical-align: top; background-color: transparent;">
    </form>

    <a href="/updateht" style="text-decoration: none; margin-left: 50px">
        <button type="submit">修改</button>
    </a>
    <a href="/delete" style="text-decoration: none; margin-left: 50px">
        <button type="submit">删除</button>
    </a>



</div>



<div class="container">
    <table border="1" align="left">
        <tr>
            <td>电影名称</td>
            <td>电影评级</td>
        </tr>
        <#list movieMsgList! as movieMsg>
            <tr>
                <td>${movieMsg.title}</td>
                <td>${movieMsg.rank}</td>
            </tr>
        </#list>
    </table>

    <table border="1" align="center">
        <tr>
            <td>电影序号</td>
            <td>用户号</td>
            <td>用户评论tag</td>
        </tr>
        <#list tagsList! as tl>
            <tr>
                <td>${tl.movieId}</td>
                <td>${tl.userId}</td>
                <td>${tl.tag}</td>
            </tr>
        </#list>
    </table>

<#--    <table border="1" align="right">-->
<#--        <tr>-->
<#--            <td>电影序号</td>-->
<#--            <td>用户号</td>-->
<#--            <td>评分</td>-->
<#--        </tr>-->
<#--        <#list ratingsList! as rat>-->
<#--            <tr>-->
<#--                <td>${rat.movieId}</td>-->
<#--                <td>${rat.userId}</td>-->
<#--                <td>${rat.rating}</td>-->
<#--            </tr>-->
<#--        </#list>-->
<#--    </table>-->
</div>
</body>
</html>