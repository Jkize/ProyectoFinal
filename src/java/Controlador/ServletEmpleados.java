/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.DAO.*;
import modelo.*;

/**
 *
 * @author kathe
 */
public class ServletEmpleados extends HttpServlet {

    private DAO_Empleado daoEmpleado;
    private DAO_Operador daoOperador;
    private DAO_Coordinador daoCoordinador;
    private DAO_Suplente daoSuplente;
    private DAO_Sede daoSede;

    @Override
    public void init() throws ServletException {
        try {
            this.daoEmpleado = new DAO_Empleado();
            this.daoCoordinador = new DAO_Coordinador();
            this.daoSuplente = new DAO_Suplente();
            this.daoOperador = new DAO_Operador();
            this.daoSede = new DAO_Sede();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ServletEmpleados.class.getName()).log(Level.SEVERE, null, ex);
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
        RequestDispatcher rq = request.getRequestDispatcher("empleados.jsp");
        ArrayList<Sede> sedes = this.daoSede.obtenerSedes();
        request.setAttribute("sedes", sedes);
        System.out.println("Entraaaa "+sedes.size());
        rq.forward(request, response);

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
