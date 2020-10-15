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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 *
 * @author ADMIN
 */
public class NewServlet extends HttpServlet {

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
        
        String id=request.getParameter("mid");
        String name=request.getParameter("mname");
        String address=request.getParameter("madd");
        String phone=request.getParameter("mph");
        String age=request.getParameter("memage");
        String password=request.getParameter("mword");
        String fees=request.getParameter("memfees");
         InitialContext i=null;
         DataSource d=null;
        Connection c=null;
        Statement s=null;
        ResultSet r=null;
        try {
         i=new InitialContext();
             d=  (DataSource)  i.lookup("jdbc/myData");
        
             c=    d.getConnection();
    
           
            
  PreparedStatement stat=c.prepareStatement("insert into Admin1.MEMBER(MEMBER_ID,MEM_NAME,ADDRESS,PH_NO,AGE,PASSWORD,MEMBER_FEES)values(?,?,?,?,?,?,?)");
stat.setString(1,id);
stat.setString(2,name);
stat.setString(3,address);
stat.setString(4,phone);
stat.setString(5,age);
stat.setString(6,password);
stat.setString(7,fees);
stat.executeUpdate();
        }
         catch (Exception e)
        {
            
            System.out.print(e.getMessage());
            
            
        }
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>One record added "  + "</h1>");
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
