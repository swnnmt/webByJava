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
import java.util.List;
import model.Brand;
import model.Cartegory;
import model.Product;
import model.Product_detail;

/**
 *
 * @author mactu
 */
public class product_front extends HttpServlet {
   
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
            out.println("<title>Servlet product_front</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet product_front at " + request.getContextPath () + "</h1>");
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
        String cartegory_id_raw= request.getParameter("cartegory_id");
        String brand_id_raw = request.getParameter("brand_id");
        String product_id_raw= request.getParameter("product_id");
        cartegoryDAO c =new  cartegoryDAO();
        List <Cartegory> list= c.showAll();     
        request.setAttribute("list", list);
        List <Brand> list_brand= c.showAll_Brand();
        request.setAttribute("list_brand", list_brand);
        int cartegory_id, brand_id,product_id;
        try {
            cartegory_id= Integer.parseInt(cartegory_id_raw);
            brand_id=Integer.parseInt(brand_id_raw);
            product_id=Integer.parseInt(product_id_raw);
            Cartegory cartegory = c.getCartegoryById(cartegory_id);
            Brand brand=c.getBrandById(brand_id);
            Product product = c.ShowProductByProductId(product_id);
            Product_detail product_detail= c.showProducts_detailbyProductId(product_id);
            List<Product> list_product_relate= c.ShowProductsTop5CartegoryIdAndBrandId(cartegory_id, brand_id, product_id);
            request.setAttribute("cartegory",cartegory);
            request.setAttribute("brand", brand);
            request.setAttribute("product", product);
            request.setAttribute("product_detail", product_detail);
             request.setAttribute("list_product_relate", list_product_relate);
        } catch (Exception e) {
        }
        request.getRequestDispatcher("Front/product.jsp").forward(request, response);
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
