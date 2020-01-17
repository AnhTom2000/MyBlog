<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

</head>

<body>
<#if Session.get("article_List")?exists>
    ${Session.get("article_List")}
</#if>
</body>

</html>