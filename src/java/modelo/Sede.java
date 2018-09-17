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
public class Sede {

    private String codigo;

    public Sede(String codigo) {
        this.codigo = codigo;
    }

    public Sede() {
    }
    

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

}
