<!DOCTYPE html>
<html>
<head>
</head>
<body>
<div id="update" align="center">
    <form action="/update" method="post" class="form-horizontal" role="form">
        <fieldset>
            <legend>信息</legend>
            <input type="hidden" value="1" name="id">
            <div class="form-group">
                <label class="col-md-3 control-label">用户id</label>
                <input  name="userid" type="number" placeholder="userid" autocomplete="off" spellcheck="false" dir="auto" style="position: relative; vertical-align: top; background-color: transparent;">
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label">电影id</label>
                <input  name="movieid" type="number" placeholder="movieid" autocomplete="off" spellcheck="false" dir="auto" style="position: relative; vertical-align: top; background-color: transparent;">
            </div>
            <div class="form-group">
                <label for="lastname" class="col-md-3 control-label">评分</label>
                <input  name="ratingvalue" type="text" value="" autocomplete="off" spellcheck="false" dir="auto" style="position: relative; vertical-align: top; background-color: transparent; margin-left: 10px">
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10" align="center">
                    <button type="submit" class="btn-success" >保存</button>
                </div>
            </div>
        </fieldset>
    </form>
</div>
</body>
</html>