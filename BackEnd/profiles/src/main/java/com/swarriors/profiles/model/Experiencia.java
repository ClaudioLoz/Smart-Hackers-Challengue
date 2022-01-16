package com.swarriors.profiles.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Experiencia implements Serializable {

    private static final long serialVersionUID = -2295960147323678860L;
    private List<Cargo> cargo;
    private String compania;

    public Experiencia() {
    }

    public List<Cargo> getCargo() {
        return cargo;
    }

    public void setCargo(List<Cargo> cargo) {
        this.cargo = cargo;
    }

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Experiencia)) return false;
        Experiencia that = (Experiencia) o;
        return Objects.equals(cargo, that.cargo) && Objects.equals(compania, that.compania);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cargo, compania);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Experiencia{");
        sb.append("cargo=").append(cargo);
        sb.append(", compania='").append(compania).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
