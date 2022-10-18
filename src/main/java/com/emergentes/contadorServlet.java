
package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "contadorServlet", urlPatterns = {"/contadorServlet"})
public class contadorServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int contador=0;
        Cookie[] cukis= request.getCookies();
        
        if(cukis!=null){
            for(Cookie c :cukis){
                if(c.getName().equals("Visitas")){
                    contador=Integer.parseInt(c.getValue());
                }
            }
        }
        contador++;
        Cookie c=new Cookie("Visitas",Integer.toString(contador));
        c.setMaxAge(30);
        response.addCookie(c);
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("Visitante N°"+contador);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }



}
