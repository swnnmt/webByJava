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
import dal.cartegoryDAO;
import java.util.List;
import model.Statistical_product;
import model.Statistical_customer;
import model.Product;

/**
 *
 * @author mactu
 */
public class shop_statistical extends HttpServlet {
   
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
            out.println("<title>Servlet shop_statistical</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet shop_statistical at " + request.getContextPath () + "</h1>");
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
        cartegoryDAO c= new cartegoryDAO();
      //best product
        Statistical_product best_product= c.showBestProduct();
        Product name_best_product=c.ShowProductByProductId(best_product.getProduct_id());
        request.setAttribute("name_best",name_best_product);
        request.setAttribute("best", best_product);
      // top 3 best product
        List <Statistical_product> top3_best_product= c.getTop3BestProduct();
        request.setAttribute("top3bestproduct", top3_best_product);
      // least product
        Statistical_product leat_product= c.showleastProduct();
        Product name_leat_product=c.ShowProductByProductId(leat_product.getProduct_id());
         request.setAttribute("name_leat",name_leat_product);
        request.setAttribute("leat", leat_product);
      // top 3 least product
        List <Statistical_product> top3_least_product= c.getTop3LeastProduct();
        request.setAttribute("top3leastproduct", top3_least_product);
      // best customer
        Statistical_customer best_customer=c.showBestCustomer();
        request.setAttribute("bestcustomer", best_customer);
      // top 3 best customer
      List <Statistical_customer> top3_best_customer= c.getTop3BestCustomer();
        request.setAttribute("top3bestcustomer", top3_best_customer);
        request.getRequestDispatcher("statistical.jsp").forward(request, response);
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
        processRequest(request, response);
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
