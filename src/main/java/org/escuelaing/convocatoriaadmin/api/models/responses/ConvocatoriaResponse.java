package org.escuelaing.convocatoriaadmin.api.models.responses;

import java.time.LocalDateTime;

public class ConvocatoriaResponse {
    private Integer idcon;

    public Integer getIdcon() {
        return idcon;
    }

    public void setIdcon(Integer idcon) {
        this.idcon = idcon;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescon() {
        return descon;
    }

    public void setDescon(String descon) {
        this.descon = descon;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getFini() {
        return fini;
    }

    public void setFini(String fini) {
        this.fini = fini;
    }

    public String getFfin() {
        return ffin;
    }

    public void setFfin(String ffin) {
        this.ffin = ffin;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getAsig() {
        return asig;
    }

    public void setAsig(Integer asig) {
        this.asig = asig;
    }

    public String getPeracad() {
        return peracad;
    }

    public void setPeracad(String peracad) {
        this.peracad = peracad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getIdadm() {
        return idadm;
    }

    public void setIdadm(Integer idadm) {
        this.idadm = idadm;
    }

    public Integer getDirunidad() {
        return dirunidad;
    }

    public void setDirunidad(Integer dirunidad) {
        this.dirunidad = dirunidad;
    }

    private String nombre;
    private String descon;
    private String unidad;
    private String fini;
    private String ffin;
    private String tipo;
    private Integer asig;
    private String peracad;
    private String estado;
    private Integer idadm;
    private Integer dirunidad;
}
