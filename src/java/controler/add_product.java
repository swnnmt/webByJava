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
import model.Product;

/**
 *
 * @author mactu
 */
public class add_product extends HttpServlet {
   
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
            out.println("<title>Servlet add_product</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet add_product at " + request.getContextPath () + "</h1>");
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
            String cartegory_id_raw= request.getParameter("cartegory_id");
            String product_name= request.getParameter("product_name");
            int cartegory_id;
            try {
                cartegory_id=Integer.parseInt(cartegory_id_raw);
                List <Brand> listBrand = c.getBrandByCartegoryId(cartegory_id);
                Cartegory cartegory = c.getCartegoryById(cartegory_id);
                request.setAttribute("product_name", product_name);
                request.setAttribute("cartegory", cartegory);
                request.setAttribute("list_brand", listBrand);
            } catch (Exception e) {

            }
            request.getRequestDispatcher("product_add.jsp").forward(request, response);
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
             String product_name = request.getParameter("product_name");
        String cartegory_id_raw = request.getParameter("cartegory_id");
        String brand_id_raw = request.getParameter("brand_id");
        String product_quantity_raw = request.getParameter("product_quantity");
        String product_price_raw = request.getParameter("product_price");
        String product_price_sale_raw = request.getParameter("product_price_sale");
        String product_desc = request.getParameter("product_desc");
        String product_img = request.getParameter("product_img");
        int cartegory_id, brand_id ,product_quantity;
        double product_price,product_price_sale;
        cartegoryDAO dtb = new cartegoryDAO();
        try {
            cartegory_id=Integer.parseInt(cartegory_id_raw);
            brand_id=Integer.parseInt(brand_id_raw);
            product_quantity=Integer.parseInt(product_quantity_raw);
            product_price=Double.parseDouble(product_price_raw);
            product_price_sale=Double.parseDouble(product_price_sale_raw);
            Product product = new Product(product_quantity, product_name, cartegory_id, brand_id, product_price, product_price_sale, product_img, product_desc);
            dtb.insertProduct(product);
            response.sendRedirect("list_product");
        } catch (Exception e) {
            request.setAttribute("err", "err:");
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
