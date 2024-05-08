package org.escuelaing.convocatoriaadmin.api.models.request;

public class RequestUpdateConvocatoria {
     public String nombre;
    public String descon;
    public String cod_emp;
    public String unidad;
    public String fini;
    public String ffin;
    public String tipo;
    public String peracad;
    public String idadm;
    public String dirunidad;

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
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

    public String getCod_emp() {
        return cod_emp;
    }

    public void setCod_emp(String cod_emp) {
        this.cod_emp = cod_emp;
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

    public String getPeracad() {
        return peracad;
    }

    public void setPeracad(String periodo) {
        this.peracad = periodo;
    }

    public String getIdadm() {
        return idadm;
    }

    public void setIdadm(String idadm) {
        this.idadm = idadm;
    }

    public String getDirunidad() {
        return dirunidad;
    }

    public void setDirunidad(String dirunidad) {
        this.dirunidad = dirunidad;
    }


    public RequestUpdateConvocatoria(String nombre, String descon, String unidad, String cod_emp, String fini, String ffin, String tipo, String peracad, String idadm, String dirunidad) {
        this.nombre = nombre;
        this.descon = descon;
        this.fini = fini;
        this.ffin = ffin;
        this.tipo = tipo;
        this.cod_emp = cod_emp;
        this.unidad = unidad;
        this.peracad = peracad;
        this.idadm = idadm;
        this.dirunidad = dirunidad;
    }
}
