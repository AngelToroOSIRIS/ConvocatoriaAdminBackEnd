package org.escuelaing.convocatoriaadmin.domain.entities.convocatorias;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "aspirante", schema = "odi")
public class AspiranteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String docid;
    private String tdoc;
    private String ap1;
    private String ap2;
    private String nom;
    private LocalDateTime fnac;
    private String ciunac;
    private String eciv;
    private String tpsan;
    private String frh;
    private String lmil;
    private String clase;
    private String dmil;
    private String dirres;
    private String telres;
    private String ciudad;
    private String cel;
    private String email;
    private LocalDateTime freg;
    private String perfil;
    private String gen;

    public String getDocid() {
        return docid;
    }

    public void setDocid(String docid) {
        this.docid = docid;
    }

    public String getTdoc() {
        return tdoc;
    }

    public void setTdoc(String tdoc) {
        this.tdoc = tdoc;
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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDateTime getFnac() {
        return fnac;
    }

    public void setFnac(LocalDateTime fnac) {
        this.fnac = fnac;
    }

    public String getCiunac() {
        return ciunac;
    }

    public void setCiunac(String ciunac) {
        this.ciunac = ciunac;
    }

    public String getEciv() {
        return eciv;
    }

    public void setEciv(String eciv) {
        this.eciv = eciv;
    }

    public String getTpsan() {
        return tpsan;
    }

    public void setTpsan(String tpsan) {
        this.tpsan = tpsan;
    }

    public String getFrh() {
        return frh;
    }

    public void setFrh(String frh) {
        this.frh = frh;
    }

    public String getLmil() {
        return lmil;
    }

    public void setLmil(String lmil) {
        this.lmil = lmil;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getDmil() {
        return dmil;
    }

    public void setDmil(String dmil) {
        this.dmil = dmil;
    }

    public String getDirres() {
        return dirres;
    }

    public void setDirres(String dirres) {
        this.dirres = dirres;
    }

    public String getTelres() {
        return telres;
    }

    public void setTelres(String telres) {
        this.telres = telres;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getFreg() {
        return freg;
    }

    public void setFreg(LocalDateTime freg) {
        this.freg = freg;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }
}
