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
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 *
 * @author ADMIN
 */
public class bookServlet extends HttpServlet {
    private Object response;
    private Object request;

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
         String bookid=request.getParameter("bid");
        String bookname=request.getParameter("bname");
        String bktype=request.getParameter("btype");
        String bkauth=request.getParameter("author");
        String trid=request.getParameter("trid");
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
    
       
            
  PreparedStatement stat=c.prepareStatement("insert into Admin1.BOOKS(BOOK_ID,BOOK_NAME,TYPE,AUTH_NAME,TR_ID)values(?,?,?,?,?)");
stat.setString(1,bookid);
stat.setString(2,bookname);
stat.setString(3,bktype);
stat.setString(4,bkauth);
stat.setString(5,trid);
stat.executeUpdate();
        }
        catch(NamingException | SQLException e)
        {
            e.getMessage();
        }
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BookServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Book entered in the book table "  + "</h1>");
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
