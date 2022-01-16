package com.swarriors.profiles.model;

import java.io.Serializable;
import java.util.Objects;

public class Certificacion implements Serializable {

    private static final long serialVersionUID = -7288449908887622835L;
    private String nombre;
    private String organizacion;
    private String fechaEmision;
    private String idCredencial;

    public Certificacion() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getIdCredencial() {
        return idCredencial;
    }

    public void setIdCredencial(String idCredencial) {
        this.idCredencial = idCredencial;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Certificacion)) return false;
        Certificacion that = (Certificacion) o;
        return Objects.equals(nombre, that.nombre) && Objects.equals(organizacion, that.organizacion) && Objects.equals(fechaEmision, that.fechaEmision) && Objects.equals(idCredencial, that.idCredencial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, organizacion, fechaEmision, idCredencial);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Certificacion{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", organizacion='").append(organizacion).append('\'');
        sb.append(", fechaEmision='").append(fechaEmision).append('\'');
        sb.append(", idCredencial='").append(idCredencial).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
