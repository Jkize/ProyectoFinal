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
import modelo.Empleado;
import modelo.Operador;

/**
 *
 * @author Jhoan Saavedra
 */
public class DAO_Operador implements DAO<Operador> {

    private RandomAccessFile archivo;
    private Arbol_Archivo_IdString arbol;

    public DAO_Operador() throws FileNotFoundException {
        archivo = new RandomAccessFile("Empleado", "rw");
        arbol = new Arbol_Archivo_IdString("Empleado");
    }

    @Override
    public boolean crear(Operador operador) throws FileNotFoundException, IOException {
        archivo.seek(archivo.length());

        if ((new DAO_Sede()).buscar(operador.getSede().getCodigo()) != null) {
            if (operador.getCorreoPlanta().equals("")) {
                if (arbol.añadir(operador.getCorreo(), (int) archivo.length())) {
                    archivo.writeUTF(operador.getCorreo());
                    archivo.writeUTF(operador.getNombre());
                    archivo.writeUTF(operador.getContraseña());
                    archivo.writeUTF(operador.getCargo());
                    archivo.writeUTF("                                                         ".substring(0, 35));
                    archivo.writeUTF("                               ".substring(0, 8));
                    archivo.writeUTF("                               ".substring(0, 8));
                    archivo.writeInt(operador.getSede().getCodigo());
                    return true;
                }

            } else {
                if ((buscar(operador.getCorreoPlanta())) != null && arbol.añadir(operador.getCorreo(), (int) archivo.length())) {
                    archivo.writeUTF(operador.getCorreo());
                    archivo.writeUTF(operador.getNombre());
                    archivo.writeUTF(operador.getContraseña());
                    archivo.writeUTF(operador.getCargo());
                    archivo.writeUTF(operador.getCorreoPlanta());
                    archivo.writeUTF(operador.getFechaInicio());
                    archivo.writeUTF(operador.getFechaFin());
                    archivo.writeInt(operador.getSede().getCodigo());
                    return true;
                }
            }
        }
        return false;

    }

    @Override
    public Operador buscar(Object correo) throws FileNotFoundException, IOException {
        int pos = (int) arbol.getPosArchivo((String) correo);
        if (pos != -1) {
            archivo.seek(pos);
            Operador ope = new Operador(archivo.readUTF(), archivo.readUTF(), archivo.readUTF(), archivo.readUTF(), archivo.readUTF(), archivo.readUTF(), archivo.readUTF(), (new DAO_Sede()).buscar(archivo.readInt()));

            if (ope.getCargo().equals("Operador")) {
                return ope;
            } else {
                return null;
            }

        }

        return null;

    }

    @Override
    public boolean actualizar(Operador operador) throws FileNotFoundException, IOException {
        int pos = (int) arbol.getPosArchivo(operador.getCorreo());

        if (pos != -1 && (new DAO_Sede()).buscar(operador.getSede().getCodigo()) != null) {
            if (operador.getCorreoPlanta().equals("")) {
                archivo.writeUTF(operador.getCorreo());
                archivo.writeUTF(operador.getNombre());
                archivo.writeUTF(operador.getContraseña());
                archivo.writeUTF(operador.getCargo());
                archivo.writeUTF("                                                         ".substring(0, 35));
                archivo.writeUTF("                               ".substring(0, 8));
                archivo.writeUTF("                               ".substring(0, 8));
                archivo.writeInt(operador.getSede().getCodigo());
                return true;

            } else {

                if ((buscar(operador.getCorreoPlanta())) != null) {
                    archivo.writeUTF(operador.getCorreo());
                    archivo.writeUTF(operador.getNombre());
                    archivo.writeUTF(operador.getContraseña());
                    archivo.writeUTF(operador.getCargo());
                    archivo.writeUTF(operador.getCorreoPlanta());
                    archivo.writeUTF(operador.getFechaInicio());
                    archivo.writeUTF(operador.getFechaFin());
                    archivo.writeInt(operador.getSede().getCodigo());
                    return true;

                }
            }
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

}
