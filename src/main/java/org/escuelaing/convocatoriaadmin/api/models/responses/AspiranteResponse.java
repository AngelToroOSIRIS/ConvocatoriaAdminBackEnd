package org.escuelaing.convocatoriaadmin.api.models.responses;

public class AspiranteResponse {
    public String nombre;
    public String estado;
    public String obs;
    public String fecha;
    public Integer docid;

    public Integer getDocid() {
        return docid;
    }

    public void setDocid(Integer docid) {
        this.docid = docid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}
