/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.BrandDAO;
import dal.CategoryDAO;
import dal.ProductDAO;
import entity.Brand;
import entity.Category;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import entity.Product;
import java.util.List;

/**
 *
 * @author Saka289
 */
@WebServlet(name = "UpdateSever", urlPatterns = {"/update"})
public class UpdateSever extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateSever</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateSever at " + request.getContextPath() + "</h1>");
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
        String id_raw = request.getParameter("id");
        BrandDAO b = new BrandDAO();
        CategoryDAO c = new CategoryDAO();
        List<Brand> brands = b.getAll();
        List<Category> categories = c.getAll();
        request.setAttribute("categories", categories);
        request.setAttribute("brands", brands);
        int id;
        ProductDAO cdb = new ProductDAO();
        try {
            id = Integer.parseInt(id_raw);
            Product pro = cdb.getProductById(id);
            request.setAttribute("product", pro);
            request.getRequestDispatcher("update.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println(e);
        }
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
        request.setCharacterEncoding("UTF-8");
        //Lay du lieu tu form
        int id = Integer.parseInt(request.getParameter("id"));
        int category_id = Integer.parseInt(request.getParameter("category_id"));
        String title = request.getParameter("title");
        String describe = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int discount = Integer.parseInt(request.getParameter("discount"));
        int status = Integer.parseInt(request.getParameter("status"));
        int brand_id = Integer.parseInt(request.getParameter("brand_id"));
        String image = request.getParameter("image");
        ProductDAO cdb = new ProductDAO();
        
        try {
            ProductDAO dao = new ProductDAO();
//            Product cNew = new Product(id, category_id, image, price, quantity, discount, describe, status, brand_id, image);
            dao.updateProduct(id, category_id, title, price, quantity, discount, describe, status, brand_id, image);            
            response.sendRedirect("crud");
        } catch (Exception e) {
            System.out.println(e);
        }
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
