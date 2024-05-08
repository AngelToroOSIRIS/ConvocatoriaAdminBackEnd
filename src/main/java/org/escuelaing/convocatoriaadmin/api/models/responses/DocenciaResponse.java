package org.escuelaing.convocatoriaadmin.api.models.responses;

public class DocenciaResponse {
    public String periodo;
    public Integer docprof;
    public String nom_asig;
    public Integer grupo;
    public Integer can_alum;
    public Integer can_gan;
    public Integer perdida;
    public Integer cancelaron;

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Integer getDocprof() {
        return docprof;
    }

    public void setDocprof(Integer docprof) {
        this.docprof = docprof;
    }

    public String getNom_asig() {
        return nom_asig;
    }

    public void setNom_asig(String nom_asig) {
        this.nom_asig = nom_asig;
    }

    public Integer getGrupo() {
        return grupo;
    }

    public void setGrupo(Integer grupo) {
        this.grupo = grupo;
    }

    public Integer getCan_alum() {
        return can_alum;
    }

    public void setCan_alum(Integer can_alum) {
        this.can_alum = can_alum;
    }

    public Integer getCan_gan() {
        return can_gan;
    }

    public void setCan_gan(Integer can_gan) {
        this.can_gan = can_gan;
    }

    public Integer getPerdida() {
        return perdida;
    }

    public void setPerdida(Integer perdida) {
        this.perdida = perdida;
    }

    public Integer getCancelaron() {
        return cancelaron;
    }

    public void setCancelaron(Integer cancelaron) {
        this.cancelaron = cancelaron;
    }
}
