package org.escuelaing.convocatoriaadmin.api.models.request;

public class RequestNewAspirante {
    public String nom;
    public String ap1;
    public String ap2;
    public String docid;
    public String email;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAp1() {
        return ap1;
    }

    public void setAp1(String ap1) {
        this.ap1 = ap1;
    }

    public String getAp2() {
        return ap2;
    }

    public void setAp2(String ap2) {
        this.ap2 = ap2;
    }

    public String getDocid() {
        return docid;
    }

    public void setDocid(String docid) {
        this.docid = docid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RequestNewAspirante(String nom, String ap1, String ap2, String docid, String email) {
        this.nom = nom;
        this.ap1 = ap1;
        this.ap2 = ap2;
        this.docid = docid;
        this.email = email;
    }
}
