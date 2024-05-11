/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controler;

import dal.cartegoryDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Account;
import model.Cartegory;
import model.Brand;

/**
 *
 * @author mactu
 */
public class add_brand extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet add_brand</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet add_brand at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session= request.getSession();
         Account account = (Account)session.getAttribute("account_login");
         if(account==null){
           request.getRequestDispatcher("login/login.jsp").forward(request, response);
         }
         else{
         if(account.getRole()!=1){
          request.getRequestDispatcher("login/login.jsp").forward(request, response);
         }
         else{
           cartegoryDAO c =new  cartegoryDAO();
            List <Cartegory> list= c.getAll();
            request.setAttribute("list", list);
            request.getRequestDispatcher("brand_add.jsp").forward(request, response);
         }
         }
        
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
      String cartegory_id_raw= request.getParameter("cartegory_id");
      String brand_name= request.getParameter("brand_name");
      
      int cartegory_id;
        cartegoryDAO dtb = new cartegoryDAO();
        try {
            cartegory_id= Integer.parseInt(cartegory_id_raw);
            Brand insert_brand = new Brand(cartegory_id, brand_name);
            dtb.insertBrand(insert_brand);
             response.sendRedirect("list_brand");
        } catch (Exception e) {
        }
            
        
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
