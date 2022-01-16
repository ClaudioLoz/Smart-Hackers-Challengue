package com.swarriors.profiles.model;

import java.io.Serializable;
import java.util.Objects;

public class Educacion implements Serializable {

    private static final long serialVersionUID = 7348225020991864730L;
    private String centroEducativo;
    private String grado;
    private String periodo;

    public Educacion() {
    }

    public String getCentroEducativo() {
        return centroEducativo;
    }

    public void setCentroEducativo(String centroEducativo) {
        this.centroEducativo = centroEducativo;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Educacion)) return false;
        Educacion educacion = (Educacion) o;
        return Objects.equals(centroEducativo, educacion.centroEducativo) && Objects.equals(grado, educacion.grado) && Objects.equals(periodo, educacion.periodo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(centroEducativo, grado, periodo);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Educacion{");
        sb.append("centroEducativo='").append(centroEducativo).append('\'');
        sb.append(", grado='").append(grado).append('\'');
        sb.append(", periodo='").append(periodo).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
