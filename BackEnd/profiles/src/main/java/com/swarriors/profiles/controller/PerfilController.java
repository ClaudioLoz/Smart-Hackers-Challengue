package com.swarriors.profiles.controller;

import com.swarriors.profiles.model.Perfil;
import com.swarriors.profiles.model.URL;
import com.swarriors.profiles.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/perfil")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/crearPerfil")
    public Perfil crearPeril(@RequestBody URL url) throws InterruptedException {
        return perfilService.crearPerfil(url);
    }
}
