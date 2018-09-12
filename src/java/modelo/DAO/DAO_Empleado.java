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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import modelo.Coordinador;
import modelo.Empleado;
import modelo.Operador;
import modelo.Suplente;

/**
 *
 * @author Jhoan Saavedra
 */
public class DAO_Empleado {

    private RandomAccessFile archivo;
    private Arbol_Archivo_IdString arbol;
    DAO_Coordinador daoCoordinador;
    DAO_Operador daoOperador;
    DAO_Suplente daoSuplente;

    public DAO_Empleado() throws FileNotFoundException {
        archivo = new RandomAccessFile("Empleado", "rw");
        arbol = new Arbol_Archivo_IdString("Empleado");
        daoCoordinador = new DAO_Coordinador();
        daoOperador = new DAO_Operador();
        daoSuplente = new DAO_Suplente();
    }

    public boolean crearCoordinador(Coordinador cordinador) throws IOException {
        return this.daoCoordinador.crear(cordinador);
    }

    public Coordinador buscarCoordinador(Object correo) throws IOException {
        return this.daoCoordinador.buscar(correo);
    }

    public boolean actualizarCoordinador(Coordinador coordinador) throws IOException {
        return this.daoCoordinador.actualizar(coordinador);
    }

    public boolean eliminarCoordinador(Object correo) throws IOException {
        return this.daoCoordinador.eliminar(correo);
    }

    public boolean crearOperador(Operador operador) throws IOException {
        return this.daoOperador.crear(operador);
    }

    public Operador buscarOperador(Object correo) throws IOException {
        return this.daoOperador.buscar(correo);
    }

    public boolean actualizarOperador(Operador operador) throws IOException {
        return this.daoOperador.actualizar(operador);
    }

    public boolean eliminarOperador(Object correo) throws IOException {
        return this.eliminarOperador(correo);
    }

    public boolean crearSuplente(Suplente suplente) throws IOException {
        return this.daoSuplente.crear(suplente);
    }

    public Suplente buscarSuplente(Object correo) throws IOException {
        return this.daoSuplente.buscar(correo);
    }

    public boolean actualizarSuplente(Suplente suplente) throws IOException {
        return this.daoSuplente.actualizar(suplente);
    }

    public boolean eliminarSuplente(Object correo) throws IOException {
        return this.eliminarSuplente(correo);
    }

    public ArrayList<Empleado> obtenerEmpleados() throws FileNotFoundException, IOException {
        ArrayList<Empleado> lista = new ArrayList<>();
        RandomAccessFile arbolArchivo = new RandomAccessFile("arbolEmpleado", "");
        int tam = (int) (arbolArchivo.length() / (37 + 12));
        for (int i = 0; i < tam; i++) {
            Operador op = buscarEmpleado(arbolArchivo.readUTF());
            if (op != null) {
                lista.add(op);
            }
        }
        return lista;
    }

    public Operador buscarEmpleado(Object correo) throws FileNotFoundException, IOException {
        int pos = (int) arbol.getPosArchivo((String) correo);
        if (pos != -1) {
            archivo.seek(pos);
            return new Operador(archivo.readUTF(), archivo.readUTF(), archivo.readUTF(), archivo.readUTF(), archivo.readUTF(), archivo.readUTF(), archivo.readUTF(), (new DAO_Sede()).buscar(archivo.readInt()));
        }

        return null;

    }

    /**
     * Validar usuario. "-1" Datos Incorrecto.0 es suplente pero no puede
     * logearse. 1-Coordinador. 2-Empleado. 3-Suplente
     *
     * @param correo
     * @param contraseña
     * @return
     */
    public int validarUsuario(String correo, String contraseña) throws IOException, ParseException {
        Operador ope = buscarEmpleado(correo);
        if (ope != null && ope.getContraseña().equals(contraseña + "                          ".substring(0, 15))) {

            if (ope.getCargo().equals("Coordinador")) {
                return 1;
            } else {
                if (ope.getCargo().equals("Operador")) {
                    return 2;

                } else {
                    SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
                    Date fechaInicio = formateador.parse(ope.getFechaInicio());
                    Date fechaFin = formateador.parse(ope.getFechaFin());
                    Date fechaActual = new Date();
                    if (fechaActual.after(fechaInicio) && fechaActual.before(fechaFin)) {
                        return 3;
                    } else {
                        return 0;
                    }
                }
            }

        }
        return -1;
    }

}
