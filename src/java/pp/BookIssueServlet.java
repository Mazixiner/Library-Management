/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 *
 * @author ADMIN
 */
public class BookIssueServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         String bname=request.getParameter("bname");
         bname=bname.trim();
        
        
        InitialContext i=null;
         DataSource d=null;
        Connection c=null;
        Statement s=null;
        ResultSet r=null;
        try 
       {
            i=new InitialContext();
             d=  (DataSource)  i.lookup("jdbc/myData");
        
             c=    d.getConnection();
    
       
            
Statement stat=c.createStatement();
           

ResultSet res=stat.executeQuery("select BOOK_ID,BOOK_NAME,TYPE,AUTH_NAME from Admin1.BOOKS");
while(res.next())
{
     String name=res.getString(2).trim();
    if(bname.equals(name))
    {
        request.setAttribute("bid", res.getString(1));
        request.setAttribute("bname", res.getString(2));
        request.setAttribute("btype", res.getString(3));
        request.setAttribute("bauthor", res.getString(4));
        
        RequestDispatcher rd=request.getRequestDispatcher("BookIssue1.jsp");
        rd.forward(request, response);
        
        break;
        
    }
    


}
}
catch(Exception x)
{
System.out.println("error encountered while entering data into Database" +x);
}

        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BookIssueServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>This Book Have been issued to the member "  + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
