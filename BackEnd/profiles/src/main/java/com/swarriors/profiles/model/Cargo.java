package com.swarriors.profiles.model;

import java.io.Serializable;
import java.util.Objects;

public class Cargo implements Serializable {


    private static final long serialVersionUID = 8729781493586207222L;

    private String cargo;
    private String periodo;

    public Cargo() {
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
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
        if (!(o instanceof Cargo)) return false;
        Cargo cargo1 = (Cargo) o;
        return Objects.equals(cargo, cargo1.cargo) && Objects.equals(periodo, cargo1.periodo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cargo, periodo);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cargo{");
        sb.append("cargo='").append(cargo).append('\'');
        sb.append(", periodo='").append(periodo).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
