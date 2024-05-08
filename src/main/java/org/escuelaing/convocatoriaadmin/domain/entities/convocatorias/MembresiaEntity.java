package org.escuelaing.convocatoriaadmin.domain.entities.convocatorias;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "membrecias", schema = "odi")
public class MembresiaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idmem;
    private String idemp;
    private String org;
    private String tipm;
    private LocalDateTime fing;
    private LocalDateTime fret;
    private String cat;
    private String pais;
    private String blq;

    public Integer getIdmem() {
        return idmem;
    }

    public void setIdmem(Integer idmem) {
        this.idmem = idmem;
    }

    public String getIdemp() {
        return idemp;
    }

    public void setIdemp(String idemp) {
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

    public String getBlq() {
        return blq;
    }

    public void setBlq(String blq) {
        this.blq = blq;
    }
}
