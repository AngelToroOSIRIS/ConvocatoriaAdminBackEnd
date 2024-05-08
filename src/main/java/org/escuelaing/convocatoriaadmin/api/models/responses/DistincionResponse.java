package org.escuelaing.convocatoriaadmin.api.models.responses;

public class DistincionResponse {
    private Integer iddis;
    private String nombre;
    private String instit;
    private String pais;
    private String anio;
    private String razon;
    private String blq;

    public Integer getIddis() {
        return iddis;
    }

    public void setIddis(Integer iddis) {
        this.iddis = iddis;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInstit() {
        return instit;
    }

    public void setInstit(String instit) {
        this.instit = instit;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    public String getBlq() {
        return blq;
    }

    public void setBlq(String blq) {
        this.blq = blq;
    }
}
