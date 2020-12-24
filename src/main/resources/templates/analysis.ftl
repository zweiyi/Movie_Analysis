<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>电影特征分析</title>

</head>
<body style="margin: 0;">
<div align="left" style="width: 300px;margin: 0;float: right">
    <table border="1">
        <tr>
            <td>频繁项集</td>
        </tr>
        <#assign keys = frequentMap? keys/>
        <#list keys as key>
            <tr>
                <td>
                <#list key as keyitem>${keyitem}</#list>
                </td>
            </tr>
        </#list>
    </table>
</div>

<div align="right" style="width: 400px; float:left;">
    <table border="1">
        <tr>
            <td>关联规则</td>
            <td>置信度</td>
        </tr>
        <#list relationMap? keys as key>
            <tr>
                <td>${key}</td>
                <td>${relationMap["${key}"]}</td>
            </tr>
        </#list>
    </table>
</div>
</body>
</html>