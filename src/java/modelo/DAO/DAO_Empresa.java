/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.DAO;

import Estructura.Arbol_Archivo_IdLong;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList; 
import modelo.Empresa;
import modelo.Sede;

/**
 *
 * @author Jhoan Saavedra
 */
public class DAO_Empresa implements DAO<Empresa> {

    private RandomAccessFile archivo;
    private Arbol_Archivo_IdLong arbol;

    public DAO_Empresa() throws FileNotFoundException {
        archivo = new RandomAccessFile("Empresa", "rw");
        arbol = new Arbol_Archivo_IdLong("Empresa");
    }

    @Override
    public boolean crear(Empresa empresa) throws FileNotFoundException, IOException {
        archivo.seek(archivo.length());

        if (arbol.añadir(empresa.getCodigo(), (int) archivo.length())) {
            archivo.writeInt(empresa.getCodigo());
            archivo.writeUTF(empresa.getNombre());
            archivo.writeUTF(empresa.getSede().getCodigo());
            return true;
        }

        return false;

    }

    @Override
    public Empresa buscar(Object codigo) throws FileNotFoundException, IOException {         
        int pos = (int) arbol.getPosArchivo((int)codigo);
        if (pos != -1) {
            archivo.seek(pos);
            return new Empresa(archivo.readInt(), archivo.readUTF(), new Sede(archivo.readUTF()));
        }
        return null;
    }

    @Override
    public boolean actualizar(Empresa empresa) throws FileNotFoundException, IOException {
        int pos = (int) arbol.getPosArchivo(empresa.getCodigo());
        if (pos != -1) {
            archivo.writeInt(empresa.getCodigo());
            archivo.writeUTF(empresa.getNombre());
            archivo.writeUTF(empresa.getSede().getCodigo());
            return true;
        }
        return false;
    }

    @Override
    public boolean eliminar(Object codigo) throws FileNotFoundException, IOException {
        if (archivo.length() != 0 && arbol.eliminar((int) codigo)) {
            return true;
        }
        return false;
    }

    public ArrayList<Empresa> obtenerEmpresas() throws FileNotFoundException, IOException {
        ArrayList<Empresa> lista = new ArrayList<>();
        RandomAccessFile arbol = new RandomAccessFile("arbolEmpresa", "rw");
        int tam = (int) (arbol.length() / (8 + 12));
        for (int i = 0; i < tam; i++) {
            Empresa empresa = buscar((int) arbol.readLong());
            arbol.skipBytes(12);
            if (empresa != null) {
                lista.add(empresa);
            }
        }
        return lista;
    }

}
