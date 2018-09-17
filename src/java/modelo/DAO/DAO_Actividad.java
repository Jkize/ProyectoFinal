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
import modelo.*;
import modelo.DAO.*;

/**
 *
 * @author Jhoan Saavedra
 */
public class DAO_Actividad implements DAO<Actividad> {

    private RandomAccessFile archivo;
    private Arbol_Archivo_IdLong arbol;

    public DAO_Actividad() throws FileNotFoundException {
        archivo = new RandomAccessFile("Actividad", "rw");
        arbol = new Arbol_Archivo_IdLong("Actividad");
    }

    @Override
    public boolean crear(Actividad actividad) throws FileNotFoundException, IOException {
        archivo.seek(archivo.length());
        if (arbol.añadir(actividad.getCodigo(), (int) archivo.length())) {
            archivo.writeLong(actividad.getCodigo());
            archivo.writeUTF(actividad.getNombre());
            archivo.writeUTF(actividad.getDescripcion());
            archivo.writeInt(actividad.getEmpresa().getCodigo());
            archivo.writeInt(actividad.getCategoria().getCodigo());
            archivo.writeInt(actividad.getServidor().getCodigo());
            archivo.writeUTF(actividad.getEjecucion());
            archivo.writeInt(actividad.getIntervaloTiempo());
            archivo.writeUTF(actividad.getHoraInicio());
            archivo.writeInt(actividad.getNroVecesDia());             
            archivo.writeUTF(actividad.getFechaEspecifica());
            archivo.writeUTF(actividad.getDiasFestivos());
            archivo.writeUTF(actividad.getUrlManual());
            archivo.writeUTF(actividad.getUrlVideo());
            archivo.writeInt(actividad.getDuracionEstimada());

            return true;
        }

        return false;

    }

    @Override
    public Actividad buscar(Object codigo) throws FileNotFoundException, IOException {
        int pos = (int) arbol.getPosArchivo((long) codigo);
        if (pos != -1) {
            archivo.seek(pos);
            return new Actividad(archivo.readLong(), archivo.readUTF(), archivo.readUTF(), (new DAO_Empresa()).buscar(archivo.readInt()),
                    (new DAO_Categoria()).buscar(archivo.readInt()), (new DAO_Servidor()).buscar(archivo.readInt()),
                    archivo.readUTF(), archivo.readUTF(), archivo.readUTF(), archivo.readInt(),
                    archivo.readUTF(), archivo.readUTF(), archivo.readUTF(), archivo.readUTF(), archivo.readInt());
        }
        return null;

    }

    @Override
    public boolean actualizar(Actividad ob) throws FileNotFoundException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(Object codigo) throws FileNotFoundException, IOException {
        if (archivo.length() != 0 && arbol.eliminar((long) codigo)) {
            return true;
        }
        return false;
    }

}
