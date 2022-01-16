package com.swarriors.profiles.dto;

import com.swarriors.profiles.model.Certificacion;
import com.swarriors.profiles.model.Educacion;
import com.swarriors.profiles.model.Experiencia;
import com.swarriors.profiles.model.Voluntariado;

import java.io.Serializable;
import java.util.List;

public class PerfilDto implements Serializable {

    private static final long serialVersionUID = -4680051891102253320L;

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
    public String toString() {
        final StringBuilder sb = new StringBuilder("PerfilDto{");
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
