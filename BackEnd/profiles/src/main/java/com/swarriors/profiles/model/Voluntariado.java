package com.swarriors.profiles.model;

import java.io.Serializable;
import java.util.Objects;

public class Voluntariado implements Serializable {

    private static final long serialVersionUID = 310050191620891979L;
    private String rol;
    private String organizacion;
    private String periodo;
    private String causa;

    public Voluntariado() {
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Voluntariado)) return false;
        Voluntariado that = (Voluntariado) o;
        return Objects.equals(rol, that.rol) && Objects.equals(organizacion, that.organizacion) && Objects.equals(periodo, that.periodo) && Objects.equals(causa, that.causa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rol, organizacion, periodo, causa);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Voluntariado{");
        sb.append("rol='").append(rol).append('\'');
        sb.append(", organizacion='").append(organizacion).append('\'');
        sb.append(", periodo='").append(periodo).append('\'');
        sb.append(", causa='").append(causa).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
