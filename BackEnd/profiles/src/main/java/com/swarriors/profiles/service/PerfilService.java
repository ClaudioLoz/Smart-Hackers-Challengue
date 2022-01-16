package com.swarriors.profiles.service;

import com.swarriors.profiles.dto.PerfilDto;
import com.swarriors.profiles.model.Perfil;
import com.swarriors.profiles.model.URL;
import com.swarriors.profiles.model.test;

import javax.xml.xpath.XPathExpressionException;

public interface PerfilService{

    Perfil crearPerfil(URL url) throws InterruptedException;
}
