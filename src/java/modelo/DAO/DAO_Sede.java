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
import modelo.Sede;

/**
 *
 * @author Jhoan Saavedra
 */
public class DAO_Sede implements DAO<Sede> {

    private RandomAccessFile archivo;
    private Arbol_Archivo_IdString arbol;

    public DAO_Sede() throws FileNotFoundException {
        archivo = new RandomAccessFile("Sede", "rw");
        arbol = new Arbol_Archivo_IdString("Sede");
    }

    @Override
    public boolean crear(Sede sede) throws FileNotFoundException, IOException {
        archivo.seek(archivo.length());

        if (arbol.añadir(sede.getCodigo(), (int) archivo.length())) {
            archivo.writeUTF(sede.getCodigo());
            return true;
        }

        return false;
    }

    @Override
    public Sede buscar(Object sede) throws FileNotFoundException, IOException {
        int pos = (int) arbol.getPosArchivo((String) sede);
        if (pos != -1) {
            archivo.seek(pos);
            return new Sede(archivo.readUTF());
        }
        return null;

    }

    @Override
    public boolean actualizar(Sede ob) throws FileNotFoundException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(Object id) throws FileNotFoundException, IOException {
        if (archivo.length() != 0 && arbol.eliminar((String) id)) {
            return true;
        }
        return false;

    }

    public ArrayList<Sede> obtenerSedes() throws FileNotFoundException, IOException {
       
        ArrayList<Sede> sedes = new ArrayList<>();
        RandomAccessFile archivoArbol = new RandomAccessFile("arbolSede", "rw");
        
        int tam = (int) (archivoArbol.length() / (8 + 12));       
        for (int i = 0; i < tam; i++) {            
            Sede sed = buscar((String) archivoArbol.readUTF());
            archivoArbol.skipBytes(12);
            if (sed != null) {
                sedes.add(sed);
            }
        }
       
        return sedes;
    }

    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        DAO_Sede daoSede=new DAO_Sede();
        daoSede.crear(new Sede("Calle 100                    ".substring(0,15)));
        daoSede.crear(new Sede("Celta                          ".substring(0,15)));
        for(Sede sede: daoSede.obtenerSedes() ){
            System.out.println(sede.getCodigo().length());
        }
    }
}
