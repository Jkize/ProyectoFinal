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
    private DAO_Empleado daoSuplente;
    private DAO_Sede daoSede;

    @Override
    public void init() throws ServletException {
        try {
            this.daoEmpleado = new DAO_Empleado();
            this.daoCoordinador = new DAO_Coordinador();
            this.daoSuplente = new DAO_Empleado();
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
        ArrayList<Empleado> empleados = this.daoEmpleado.obtenerEmpleados();
        request.setAttribute("empleados", empleados);
        request.setAttribute("sedes", sedes);
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
        String correo = request.getParameter("correo");
        String nombre = request.getParameter("nombre");
        String contrasena = request.getParameter("contrasena");
        String cargo = request.getParameter("cargo");
        String sede = (request.getParameter("sede") + "           ").substring(0, 15);
        String correoOperario = request.getParameter("correoOperario");
        String fechaInicio = request.getParameter("fechaInicio");
        String fechaFin = request.getParameter("fechaFin");

        if (request.getParameter("ingresar") != null) {

            if (correo != null && nombre != null && contrasena != null) {

                switch (cargo.trim()) {

                    case "Operador":
                        System.out.println("ENtra 3");
                        operador(correo, nombre, contrasena, cargo, sede, correoOperario, fechaInicio, fechaFin);
                        break;
                    case "Coordinador":
                        break;
                    case "Suplente":
                        suplente(correo, nombre, contrasena, cargo, correoOperario, fechaInicio, fechaFin);
                        break;
                }
            }
        }

        RequestDispatcher rq = request.getRequestDispatcher("empleados.jsp");
        ArrayList<Empleado> empleados = this.daoEmpleado.obtenerEmpleados();
        request.setAttribute("empleados", empleados);
        ArrayList<Sede> sedes = this.daoSede.obtenerSedes();
        request.setAttribute("sedes", sedes);
        rq.forward(request, response);

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

    private void operador(String correo, String nombre, String contraseña, String cargo, String sede, String correoOperario, String fechaInicio, String fechaFin) throws IOException {
        if (correoOperario != null) {
            this.daoOperador.crear(new Operador((correo + "                                     ").substring(0, 35),
                    (nombre + "                                     ").substring(0, 30),
                    (contraseña + "                                       ").substring(0, 15),
                    (cargo + "          ").substring(0, 11),
                    (correoOperario + "                                     ").substring(0, 35),
                    fechaInicio, fechaFin, new Sede(sede)));
        } else {
            this.daoOperador.crear(new Operador((correo + "                                     ").substring(0, 35),
                    (nombre + "                                        ").substring(0, 30),
                    (contraseña + "                 ").substring(0, 15),
                    (cargo + "          ").substring(0, 11),
                    ("                                                      ").substring(0, 35),
                    "                ".substring(10), "                ".substring(10), new Sede(sede)));

        }

    }

    private void suplente(String correo, String nombre, String contrasena, String cargo, String correoOperario, String fechaInicio, String fechaFin) throws IOException {

        if (correoOperario != null && fechaFin != null && fechaInicio != null) {
            this.daoSuplente.crear(new Suplente((correo + "                                     ").substring(0, 35),
                    (nombre + "                                                ").substring(0, 30),
                    (contrasena + "                                    ").substring(15),
                    (cargo + "    ").substring(0, 11),
                    this.daoOperador.buscar((correoOperario + "                                                   ").substring(0, 35)),
                    fechaInicio,
                    fechaFin));
        }

    }

    /**
     * this.daoOperador.crear(new Operador( (correo + " ").substring(0, 35),
     * (nombre + " ").substring(0, 30), (contraseña + " ").substring(0, 15),
     * (cargo + " ").substring(0, 10), (correoOperario + " ").substring(0, 35),
     * fechaInicio, fechaFin, this.daoSede.buscar(sede)));
     */
}
