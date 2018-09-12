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
import modelo.Coordinador;
import modelo.Operador;

/**
 *
 * @author Jhoan Saavedra
 */
public class DAO_Coordinador implements DAO<Coordinador> {

    private RandomAccessFile archivo;
    private Arbol_Archivo_IdString arbol;

    public DAO_Coordinador() throws FileNotFoundException {
        archivo = new RandomAccessFile("Empleado", "rw");
        arbol = new Arbol_Archivo_IdString("Empleado");
    }

    @Override
    public boolean crear(Coordinador coordinador) throws FileNotFoundException, IOException {
        archivo.seek(archivo.length());
        if (arbol.añadir(coordinador.getCorreo(), (int) archivo.length())) {
            archivo.writeUTF(coordinador.getCorreo());
            archivo.writeUTF(coordinador.getNombre());
            archivo.writeUTF(coordinador.getContraseña());
            archivo.writeUTF(coordinador.getCargo());
            archivo.writeUTF("                                        ".substring(0, 35));
            archivo.writeUTF("                                       ".substring(0, 10));
            archivo.writeUTF("                                        ".substring(0, 10));
            archivo.writeUTF("                              ".substring(0, 15));
            return true;
        }
        return false;

    }

    @Override
    public Coordinador buscar(Object correo) throws FileNotFoundException, IOException {
        int pos = (int) arbol.getPosArchivo((String) correo);
        if (pos != -1) {
            archivo.seek(pos);
            Coordinador cod = new Coordinador(archivo.readUTF(), archivo.readUTF(), archivo.readUTF(), archivo.readUTF());
            if (cod.getCargo().equals("Coordinador")) {
                return cod;
            }
        }
        return null;

    }

    @Override
    public boolean actualizar(Coordinador coordinador) throws FileNotFoundException, IOException {
        int pos = (int) arbol.getPosArchivo(coordinador.getCorreo());
        if (pos != -1) {
            archivo.seek(pos);
            archivo.writeUTF(coordinador.getCorreo());
            archivo.writeUTF(coordinador.getNombre());
            archivo.writeUTF(coordinador.getContraseña());
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

    public static void main(String[] args) throws FileNotFoundException, IOException {
        DAO_Coordinador cor = new DAO_Coordinador();
        DAO_Empleado emp = new DAO_Empleado();
        cor.crear(new Coordinador("coordinador@gmail.com                     ".substring(0, 35), "Cordinador FULL HD                          ".substring(0, 30), "root                     ".substring(0, 15), "Coordinador        ".substring(0, 11)));
        Coordinador cors = cor.buscar("coordinador@gmail.com                     ".substring(0, 35));
        System.out.println(cors.getContraseña());

    }
}
