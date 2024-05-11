/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controler;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;
import dal.cartegoryDAO;
import jakarta.servlet.http.HttpSession;
import model.Account;
import model.Product_detail;

/**
 *
 * @author mactu
 */
public class add_product_detail extends HttpServlet {
   
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
            out.println("<title>Servlet add_product_detail</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet add_product_detail at " + request.getContextPath () + "</h1>");
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
            String product_id_raw = request.getParameter("product_id");
        int product_id;
        cartegoryDAO c = new cartegoryDAO();
        try {
            product_id= Integer.parseInt(product_id_raw);
            Product product = c.ShowProductByProductId(product_id);
            request.setAttribute("product", product);
            request.getRequestDispatcher("product_detail_add.jsp").forward(request, response);
        } catch (Exception e) {
        }
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
       String product_id_raw = request.getParameter("product_id");
       String product_img_desc_1 = request.getParameter("product_img_desc_1");
       String product_img_desc_2 = request.getParameter("product_img_desc_2");
       String product_img_desc_3 = request.getParameter("product_img_desc_3");
       String product_img_desc_4 = request.getParameter("product_img_desc_4");
       String product_color = request.getParameter("product_color");
       String product_intro= request.getParameter("product_intro");
       String product_prever = request.getParameter("product_prever");
       cartegoryDAO insert = new cartegoryDAO();
       int product_id;
        try {
            product_id= Integer.parseInt(product_id_raw);
            
            Product_detail product_detail = new Product_detail(product_id, product_img_desc_1, product_img_desc_2, product_img_desc_3, product_img_desc_4, product_color, product_intro, product_prever);
            insert.insertProduct_detail(product_detail);
            response.sendRedirect("list_product_detail");
        } catch (Exception e) {
            request.setAttribute("err", e);
            request.getRequestDispatcher("check.jsp").forward(request, response);
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
