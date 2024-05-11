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
import model.Product_done;
import dal.cartegoryDAO;
import java.util.List;
import model.Brand;
import model.Product;

/**
 *
 * @author mactu
 */
public class product_done extends HttpServlet {
   
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
            out.println("<title>Servlet product_done</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet product_done at " + request.getContextPath () + "</h1>");
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
         cartegoryDAO c =new  cartegoryDAO();
        List <Product_done> list_oder = c.getAllProductDone();
        if(list_oder==null){
         request.getRequestDispatcher("check.jsp").forward(request, response);
        }
        request.setAttribute("list", list_oder);
        request.getRequestDispatcher("oder_list.jsp").forward(request, response);
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
        String name_custom = request.getParameter("name_custom");
        String phone_number = request.getParameter("phone_number");
        String province = request.getParameter("province");
        String districts = request.getParameter("districts");
        String address = request.getParameter("address");
        String username = request.getParameter("username");
        String product_id_raw = request.getParameter("product_id");
        String product_size = request.getParameter("product_size");
        String product_quantity_raw = request.getParameter("product_quantity");
        String product_done_price_raw = request.getParameter("product_done_price");
        int product_id, product_quantity;
        double product_done_price;
        try {
            product_done_price= Double.parseDouble(product_done_price_raw);
            product_id= Integer.parseInt(product_id_raw);
            product_quantity= Integer.parseInt(product_quantity_raw);
            
            Product_done product_done = new Product_done(username, product_size, name_custom, phone_number, province, districts, address, product_id, product_quantity, product_done_price);
            cartegoryDAO c = new cartegoryDAO();
            Product product_raw = c.ShowProductByProductId(product_id);
           int quantity_update= product_raw.getProduct_quantity()-product_quantity;
            c.update_quantity(product_id, quantity_update );
            c.insertDoneProduct(product_done);
            Product product =c.ShowProductByProductId(product_id);
            request.setAttribute("submited", product);
        } catch (Exception e) {
            request.setAttribute("err", "0");
        }
        request.getRequestDispatcher("Front/delivery.jsp").forward(request, response);
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
