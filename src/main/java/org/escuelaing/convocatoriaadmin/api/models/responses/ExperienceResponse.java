package org.escuelaing.convocatoriaadmin.api.models.responses;

public class ExperienceResponse {
    public Integer idhis;
    public String nomorg;
    public String periodo;
    public String nombre_cargo;
    public String tipo_cargo;
    public String fini;
    public String ffin;

    public Integer getIdhis() {
        return idhis;
    }

    public void setIdhis(Integer idhis) {
        this.idhis = idhis;
    }

    public String getNomorg() {
        return nomorg;
    }

    public void setNomorg(String nomorg) {
        this.nomorg = nomorg;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getNombre_cargo() {
        return nombre_cargo;
    }

    public void setNombre_cargo(String nombre_cargo) {
        this.nombre_cargo = nombre_cargo;
    }

    public String getTipo_cargo() {
        return tipo_cargo;
    }

    public void setTipo_cargo(String tipo_cargo) {
        this.tipo_cargo = tipo_cargo;
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
}
