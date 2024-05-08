package org.escuelaing.convocatoriaadmin.api.models.responses;

import java.time.LocalDateTime;

public class EstudiosResponse {
    public Integer getIdestud() {
        return idestud;
    }

    public void setIdestud(Integer idestud) {
        this.idestud = idestud;
    }

    public String getNom_est() {
        return nom_est;
    }

    public void setNom_est(String nom_est) {
        this.nom_est = nom_est;
    }

    public String getNom_ins() {
        return nom_ins;
    }

    public void setNom_ins(String nom_ins) {
        this.nom_ins = nom_ins;
    }

    public String getFgra() {
        return fgra;
    }

    public void setFgra(String fgra) {
        this.fgra = fgra;
    }

    public String getDes_est() {
        return des_est;
    }

    public void setDes_est(String des_est) {
        this.des_est = des_est;
    }

    public String getBlq() {
        return blq;
    }

    public void setBlq(String blq) {
        this.blq = blq;
    }

    public String getNro_tar() {
        return nro_tar;
    }

    public void setNro_tar(String nro_tar) {
        this.nro_tar = nro_tar;
    }

    private Integer idestud;
    private String nom_est;
    private String nom_ins;
    private String fgra;
    private String des_est;
    private String blq;
    private String nro_tar;
}
