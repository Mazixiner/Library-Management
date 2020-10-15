<%-- 
    Document   : BookIssue1
    Created on : 22 Sep, 2017, 3:18:06 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            body{
                background_color:#FFEBCD;
            }
            .autostyle2{
                color:blue;
                font-size:25px;
                text-align:center;
            }
            </style>
    </head>
    <body bgcolor="#FFEBCD">
       <center> <form action="IssueJsp.jsp">
            <table>
                <TR class="äutostyle2">
                    <TD colspan="9">BOOK DETAILS</TD></TR>
                <TR>
                    <TD WIDTH="100%" COLSPAN="4">
                       </TD>
                         </TR>
                           <TR>
               <TD>Book Id :</TD>
               <TD><input type="text" name="bid" value="<%=request.getAttribute("bid")  %>">
                   </TD>
                     </TR>
               <TR>
                   <TD>Book name:</TD>
                   <TD><input type="text" name="bname" value="<%=request.getAttribute("bname")%>">
                    </TD>
                      </TR>
               <TR>
                   <TD>Book Type:</TD>
                  <TD><input type="text" name="btype" value="<%=request.getAttribute("btype")%>" >
                    </TD>
                      </TR>
               <TR>
                   <TD>Author:</TD>
                  <TD><input  name="bauthor" value="<%=request.getAttribute("bauthor")%>">
                    </TD>
                      </TR>
              
     <TR>
        <TD>
           <input type="Submit"  Value="ÏSSUE"> 
                                 </TD>
                               </TR>
                                  
                                           
            
           </table>
        </form>
           </center>
    </body>
    
</html>