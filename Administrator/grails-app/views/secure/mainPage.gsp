<%@ page import="com.admin.Company" %>

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
    <h2 style="margin:0px">SUPER-ADMIN</h2>
</div>
<div class="row">
    <div class="col-sm-2" style="background-color:lavender;"></div>
    <div class="col-sm-8" style="background-color:#e6ffff; border-radius: 20px; margin-top:20px; margin-bottom:20px">
        <h3 style="margin-top:0.5cm" align="center"><b>COMPANIES</b></h3><hr>

        <table border=0 style="margin: 20px;margin-right: 20px">

            <%if(companyName!=null){
                for(int i=0;i<companyName.size();i++){
                    com.admin.Company comp=(Company)companyName.get(i)
            %>

            <tr>
                <td align="center" style="padding-right: 20px;padding-top: 10px; padding-bottom: 10px">
                    <p style="margin-bottom: 0px; padding-right: 20px;color: #333333"><%=comp.getCompanyName()%></p>
                </td>
                <td valign="middle">
                    <p style="margin-bottom: 0px; padding-right: 20px;color: #333333"><%=comp.getCompanyAddress()%></p>
                </td>
                <td>
                    <p style="margin-bottom: 0px; padding-right: 20px;color: #333333"><%=comp.getCompanyArea()%></p>
                </td>
                %{--<td align="center">
                    <form>
                        <input type="submit" value="Remove" style="width:120%;margin-bottom: 0px;padding-left: 10px;padding-right: 10px;border-radius: 5px">
                    </form>
                </td>--}%
            </tr>
            <%} }%>

        </table>


        <g:form name="#" url="[controller:'secure', action:'comp']">
            <input type="submit" value="ADD">
        </g:form>
        <g:form name="#" url="[controller:'secure', action:'company']">
            <input type="submit" value="MODITY">
        </g:form>
        <g:form name="#" url="[controller:'secure', action:'company']">
            <input type="submit" value="REMOVE">
        </g:form>
    </div>
    <div class="col-sm-2" style="background-color:lavender;"></div>
</div>
</body>
</html>