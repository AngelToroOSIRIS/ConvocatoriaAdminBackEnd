package org.escuelaing.convocatoriaadmin.api.models.responses;

import java.time.LocalDateTime;

public class MembresiaResponse {
    public Integer idmem;

    public Integer idemp;
    public String org;
    public String tipm;
    public LocalDateTime fing;
    public LocalDateTime fret;
    public String cat;
    public String pais;

    public Integer getIdmem() {
        return idmem;
    }

    public void setIdmem(Integer idmem) {
        this.idmem = idmem;
    }

    public Integer getIdemp() {
        return idemp;
    }

    public void setIdemp(Integer idemp) {
        this.idemp = idemp;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getTipm() {
        return tipm;
    }

    public void setTipm(String tipm) {
        this.tipm = tipm;
    }

    public LocalDateTime getFing() {
        return fing;
    }

    public void setFing(LocalDateTime fing) {
        this.fing = fing;
    }

    public LocalDateTime getFret() {
        return fret;
    }

    public void setFret(LocalDateTime fret) {
        this.fret = fret;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
