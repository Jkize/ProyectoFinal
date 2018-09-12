/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Jhoan Saavedra
 */
public class Operador extends Empleado {

    private String correoPlanta;
    private String FechaInicio;
    private String FechaFin;

    public Operador() {
    }

    public Operador( String correo, String nombre, String contraseña, String cargo, String correoPlanta, String FechaInicio, String FechaFin, Sede sede) {
        super(correo, nombre, contraseña, cargo, sede);
        this.correoPlanta = correoPlanta;
        this.FechaInicio = FechaInicio;
        this.FechaFin = FechaFin;
    }
     
    public String getCorreoPlanta() {
        return correoPlanta;
    }

    public void setCorreoPlanta(String correoPlanta) {
        this.correoPlanta = correoPlanta;
    }

    public String getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(String FechaInicio) {
        this.FechaInicio = FechaInicio;
    }

    public String getFechaFin() {
        return FechaFin;
    }

    public void setFechaFin(String FechaFin) {
        this.FechaFin = FechaFin;
    }

}
