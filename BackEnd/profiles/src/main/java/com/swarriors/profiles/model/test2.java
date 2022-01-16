package com.swarriors.profiles.model;

import java.util.List;
import java.util.Objects;

public class test2 {

    private String code;
    private String nombre;
    private List<String> lista;

    public test2(){}

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getLista() {
        return lista;
    }

    public void setLista(List<String> lista) {
        this.lista = lista;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof test2)) return false;
        test2 test2 = (test2) o;
        return Objects.equals(code, test2.code) && Objects.equals(nombre, test2.nombre) && Objects.equals(lista, test2.lista);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, nombre, lista);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("test2{");
        sb.append("code=").append(code);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", lista=").append(lista);
        sb.append('}');
        return sb.toString();
    }
}
