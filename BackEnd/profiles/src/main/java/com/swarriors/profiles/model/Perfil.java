package com.swarriors.profiles.model;

import java.util.List;
import java.util.Objects;

public class Perfil {

    private String nombre;
    private String trabajoActual;
    private String ciudad;
    private String linkLinkedin;
    private List<Experiencia> experiencias;
    private List<Educacion> educacion;
    private List<Voluntariado> voluntariado;
    private List<Certificacion> certificaciones;
    private List<String> skills;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTrabajoActual() {
        return trabajoActual;
    }

    public void setTrabajoActual(String trabajoActual) {
        this.trabajoActual = trabajoActual;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getLinkLinkedin() {
        return linkLinkedin;
    }

    public void setLinkLinkedin(String linkLinkedin) {
        this.linkLinkedin = linkLinkedin;
    }

    public List<Experiencia> getExperiencias() {
        return experiencias;
    }

    public void setExperiencias(List<Experiencia> experiencias) {
        this.experiencias = experiencias;
    }

    public List<Educacion> getEducacion() {
        return educacion;
    }

    public void setEducacion(List<Educacion> educacion) {
        this.educacion = educacion;
    }

    public List<Voluntariado> getVoluntariado() {
        return voluntariado;
    }

    public void setVoluntariado(List<Voluntariado> voluntariado) {
        this.voluntariado = voluntariado;
    }

    public List<Certificacion> getCertificaciones() {
        return certificaciones;
    }

    public void setCertificaciones(List<Certificacion> certificaciones) {
        this.certificaciones = certificaciones;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Perfil)) return false;
        Perfil perfil = (Perfil) o;
        return Objects.equals(nombre, perfil.nombre) && Objects.equals(trabajoActual, perfil.trabajoActual) && Objects.equals(ciudad, perfil.ciudad) && Objects.equals(linkLinkedin, perfil.linkLinkedin) && Objects.equals(experiencias, perfil.experiencias) && Objects.equals(educacion, perfil.educacion) && Objects.equals(voluntariado, perfil.voluntariado) && Objects.equals(certificaciones, perfil.certificaciones) && Objects.equals(skills, perfil.skills);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, trabajoActual, ciudad, linkLinkedin, experiencias, educacion, voluntariado, certificaciones, skills);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Perfil{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", trabajoActual='").append(trabajoActual).append('\'');
        sb.append(", ciudad='").append(ciudad).append('\'');
        sb.append(", linkLinkedin='").append(linkLinkedin).append('\'');
        sb.append(", experiencias=").append(experiencias);
        sb.append(", educacion=").append(educacion);
        sb.append(", voluntariado=").append(voluntariado);
        sb.append(", certificaciones=").append(certificaciones);
        sb.append(", skills=").append(skills);
        sb.append('}');
        return sb.toString();
    }
}
