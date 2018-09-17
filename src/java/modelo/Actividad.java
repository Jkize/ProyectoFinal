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
public class Actividad {

    private Long codigo;
    private String nombre;
    private String descripcion;
    private Empresa empresa;
    private Categoria categoria;
    private Servidor servidor;
    private String ejecucion;
    private Integer IntervaloTiempo;
    private String fechaEspecifica;
    private String horaInicio;
    private Integer NroVecesDia;
    private boolean diasFestivos;
    private String urlManual;
    private String urlVideo;
    private Integer duracionEstimada;

    public String getFechaEspecifica() {
        return fechaEspecifica;
    }

    public void setFechaEspecifica(String fechaEspecifica) {
        this.fechaEspecifica = fechaEspecifica;
    }

    public Actividad() {
    }

    public Actividad(Long codigo, String nombre, String descripcion, Empresa empresa, Categoria categoria, Servidor servidor, String ejecucion, int IntervaloTiempo, String horaInicio, Integer NroVecesDia, String fechaEspecifica, boolean diasFestivos, String urlManual, String urlVideo, Integer duracionEstimada) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.empresa = empresa;
        this.categoria = categoria;
        this.servidor = servidor;
        this.ejecucion = ejecucion;
        this.IntervaloTiempo = IntervaloTiempo;
        this.horaInicio = horaInicio;
        this.NroVecesDia = NroVecesDia;
        this.diasFestivos = diasFestivos;
        this.urlManual = urlManual;
        this.urlVideo = urlVideo;
        this.duracionEstimada = duracionEstimada;
        this.fechaEspecifica = fechaEspecifica;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Servidor getServidor() {
        return servidor;
    }

    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }

    public String getEjecucion() {
        return ejecucion;
    }

    public void setEjecucion(String ejecucion) {
        this.ejecucion = ejecucion;
    }

    public Integer getIntervaloTiempo() {
        return IntervaloTiempo;
    }

    public void setIntervaloTiempo(int IntervaloTiempo) {
        this.IntervaloTiempo = IntervaloTiempo;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Integer getNroVecesDia() {
        return NroVecesDia;
    }

    public void setNroVecesDia(Integer NroVecesDia) {
        this.NroVecesDia = NroVecesDia;
    }

    public boolean getDiasFestivos() {
        return diasFestivos;
    }

    public void setDiasFestivos(boolean diasFestivos) {
        this.diasFestivos = diasFestivos;
    }

    public String getUrlManual() {
        return urlManual;
    }

    public void setUrlManual(String urlManual) {
        this.urlManual = urlManual;
    }

    public String getUrlVideo() {
        return urlVideo;
    }

    public void setUrlVideo(String urlVideo) {
        this.urlVideo = urlVideo;
    }

    public Integer getDuracionEstimada() {
        return duracionEstimada;
    }

    public void setDuracionEstimada(Integer duracionEstimada) {
        this.duracionEstimada = duracionEstimada;
    }

}
