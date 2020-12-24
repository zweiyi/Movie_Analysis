<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>movies</title>
</head>
<body>
<div class="container">
    <table border="1">
        <tr>
            <td>电影名称</td>
        </tr>
        <#list kindMovies as kM>
            <tr>
                <td>${kM}</td>
            </tr>

        </#list>
    </table>
</div>
</body>
</html>