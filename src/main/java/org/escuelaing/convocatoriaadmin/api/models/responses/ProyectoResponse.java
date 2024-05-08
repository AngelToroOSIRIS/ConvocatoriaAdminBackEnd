package org.escuelaing.convocatoriaadmin.api.models.responses;

public class ProyectoResponse {
    private Integer idpro;
    private String tipp;
    private String titp;
    private String fini;
    private String ffin;
    private String blq;

    public Integer getIdpro() {
        return idpro;
    }

    public void setIdpro(Integer idpro) {
        this.idpro = idpro;
    }

    public String getTipp() {
        return tipp;
    }

    public void setTipp(String tipp) {
        this.tipp = tipp;
    }

    public String getTitp() {
        return titp;
    }

    public void setTitp(String titp) {
        this.titp = titp;
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

    public String getBlq() {
        return blq;
    }

    public void setBlq(String blq) {
        this.blq = blq;
    }
}
