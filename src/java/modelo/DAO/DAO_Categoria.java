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
import modelo.Categoria;
import modelo.Sede;

/**
 *
 * @author Jhoan Saavedra
 */
public class DAO_Categoria implements DAO<Categoria> {

    private RandomAccessFile archivo;
    private Arbol_Archivo_IdLong arbol;

    public DAO_Categoria() throws FileNotFoundException {
        archivo = new RandomAccessFile("Categoria", "rw");
        arbol = new Arbol_Archivo_IdLong("Categoria");
    }

    @Override
    public boolean crear(Categoria categoria) throws FileNotFoundException, IOException {
        archivo.seek(archivo.length());

        if (arbol.añadir(categoria.getCodigo(), (int) archivo.length())) {
            archivo.writeInt(categoria.getCodigo());
            archivo.writeUTF(categoria.getNombre());
            return true;
        }

        return false;
    }

    @Override
    public Categoria buscar(Object codigo) throws FileNotFoundException, IOException {
        int pos = (int) arbol.getPosArchivo((int) codigo);
        if (pos != -1) {
            archivo.seek(pos);
            return new Categoria(archivo.readInt(), archivo.readUTF());
        }
        return null;

    }

    @Override
    public boolean actualizar(Categoria categoria) throws FileNotFoundException, IOException {
        int pos = (int) arbol.getPosArchivo(categoria.getCodigo());
        if (pos != -1) {
            archivo.writeInt(categoria.getCodigo());
            archivo.writeUTF(categoria.getNombre());
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

    
     public ArrayList<Categoria> obtenerCategorias() throws FileNotFoundException, IOException {
        ArrayList<Categoria> lista = new ArrayList<>();
        RandomAccessFile arbol = new RandomAccessFile("arbolCategoria", "rw");
        int tam = (int) (arbol.length() / (8 + 12));
        for (int i = 0; i < tam; i++) {
           Categoria categoria = buscar((int) arbol.readLong());
            arbol.skipBytes(12);
            if (categoria != null) {
                lista.add(categoria);
            }
        }
        return lista;
    }
    
}
