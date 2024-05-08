package org.escuelaing.convocatoriaadmin.api.models.responses;

public class PublicacionesResponse {
    private Integer idpub;
    private String tipo;
    private String titulo;
    private String titmay;
    private String area;
    private String fec;
    private String edic;
    private String edit;
    private String ciudad;
    private String pais;

    public Integer getIdpub() {
        return idpub;
    }

    public void setIdpub(Integer idpub) {
        this.idpub = idpub;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitmay() {
        return titmay;
    }

    public void setTitmay(String titmay) {
        this.titmay = titmay;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getFec() {
        return fec;
    }

    public void setFec(String fec) {
        this.fec = fec;
    }

    public String getEdic() {
        return edic;
    }

    public void setEdic(String edic) {
        this.edic = edic;
    }

    public String getEdit() {
        return edit;
    }

    public void setEdit(String edit) {
        this.edit = edit;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
