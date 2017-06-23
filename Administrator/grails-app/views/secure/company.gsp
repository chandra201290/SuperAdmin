
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <asset:stylesheet src="stylesheet.css"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="Stylesheet.css">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>SUPER-ADMIN</title>
</head>
<body>
<div style="background-color: #008080; width:100%;height:1.5cm; padding-top: 10px; color:white" align="center">
    <h2 style="margin:0px">COMPANY</h2>
</div>
<div class="row">
    <div class="col-sm-3" style="background-color:lavender;"></div>
    <div class="col-sm-6" style="background-color:#e6ffff; border-radius: 20px; margin-top:20px; margin-bottom:20px">
        <p style="margin-top:0.5cm"><b>ABOUT THE COMPANY</b></p><hr>
        <g:form name="#" url="[controller:'company', action:'createCompany']" >
            <h4 class="comp">Company Name</h4>
            <input class="comp" type="text" name="companyName">
            <h4 class="comp">Company Address</h4>
            <input class="comp" type="text" name="companyAddress" >
            <h4 class="comp">Area</h4>
            <input class="comp" type="text" name="companyArea">
            <h4 class="comp">Company Descreption</h4>
            <textarea class="comp" cols="43" rows="3" name="companyDescription"></textarea>
            <h4 class="comp">Industry</h4>
            <input class="comp" type="text" name="industry">
            <h4 class="comp">Company Website</h4>
            <input class="comp" type="text" name="companyWebsite">
            <h4 class="comp">facebookPage</h4>
            <input class="comp" type="text" name="companyAddress">
            <h4 class="comp">Addition Information</h4>
            <input class="comp" type="text" name="info"><br><br><br>
            <input type="submit" value="Save" style="background-color:#008080 ;padding: 7px; border-radius:5px; width: 180px; color:black;margin-left: 6cm;  margin-bottom:0.5cm">
        </g:form>
    </div>
    <div class="col-sm-3" style="background-color:lavender;"></div>
</div>
</body>
</html>