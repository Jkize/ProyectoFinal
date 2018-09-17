/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.DAO;

import Estructura.Arbol_Archivo_IdString;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import modelo.Empleado;
import modelo.Sede;

/**
 *
 * @author Jhoan Saavedra
 */
public class DAO_Empleado implements DAO<Empleado> {

    private RandomAccessFile archivo;
    private Arbol_Archivo_IdString arbol;

    public DAO_Empleado() throws FileNotFoundException {
        archivo = new RandomAccessFile("Empleado", "rw");
        arbol = new Arbol_Archivo_IdString("Empleado");
    }

    @Override
    public boolean crear(Empleado empleado) throws FileNotFoundException, IOException {
        archivo.seek(archivo.length());

        if (arbol.añadir(empleado.getCorreo(), (int) archivo.length())) {
            archivo.writeUTF(empleado.getCorreo());
            archivo.writeUTF(empleado.getNombre());
            archivo.writeUTF(empleado.getContraseña());
            archivo.writeUTF(empleado.getCargo());
            archivo.writeUTF(empleado.getEmpleado().getCorreo());
            archivo.writeUTF(empleado.getFechaInicio());
            archivo.writeUTF(empleado.getFechaFin());
            archivo.writeUTF(empleado.getSede().getCodigo());
            return true;
        }
        return false;

    }

    @Override
    public Empleado buscar(Object correo) throws FileNotFoundException, IOException {
        int pos = (int) arbol.getPosArchivo((String) correo);
        if (pos != -1) {
            archivo.seek(pos);
            Empleado empleado = new Empleado(archivo.readUTF(), archivo.readUTF(), archivo.readUTF(), archivo.readUTF());
            String correoPlanta = archivo.readUTF();
            Empleado plata = new Empleado();
            plata.setCorreo(correoPlanta);
            empleado.setCorreo(correoPlanta);
            empleado.setFechaInicio(archivo.readUTF());
            empleado.setFechaFin(archivo.readUTF());
            empleado.setSede(new Sede(archivo.readUTF()));
            return empleado;
        }

        return null;

    }

    @Override
    public boolean actualizar(Empleado empleado) throws FileNotFoundException, IOException {
        int pos = (int) arbol.getPosArchivo(empleado.getCorreo());
        if (pos != -1) {
            archivo.writeUTF(empleado.getCorreo());
            archivo.writeUTF(empleado.getNombre());
            archivo.writeUTF(empleado.getContraseña());
            archivo.writeUTF(empleado.getCargo());
            archivo.writeUTF(empleado.getEmpleado().getCorreo());
            archivo.writeUTF(empleado.getFechaInicio());
            archivo.writeUTF(empleado.getFechaFin());
            archivo.writeUTF(empleado.getSede().getCodigo());
            return true;
        }
        return false;

    }

    @Override
    public boolean eliminar(Object correo) throws FileNotFoundException, IOException {
        if (archivo.length() != 0 && arbol.eliminar((String) correo)) {
            return true;
        }
        return false;

    }
    
    public ArrayList<Empleado> obtenerEmpleados() throws FileNotFoundException, IOException{
       ArrayList<Empleado> empleados=new ArrayList<>();
       RandomAccessFile  archivo = new RandomAccessFile("arbolEmpleado", "rw");
       int num=(int)(archivo.length())/(27+12);
       for(int i=0; i<num; i++){
           Empleado empleado=buscar(archivo.readUTF());
           if(empleado!=null && !(empleado.getCargo().trim()).equals("Coordinador"))
               empleados.add(empleado);
           
           archivo.skipBytes(12);
       }
             
       return empleados;
    }

}
