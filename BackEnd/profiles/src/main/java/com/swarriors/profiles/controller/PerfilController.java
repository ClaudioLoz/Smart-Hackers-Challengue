package com.swarriors.profiles.controller;

import com.swarriors.profiles.model.test;
import com.swarriors.profiles.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/perfil")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    @PostMapping(value = "/test")
    public String test(@RequestBody test num) {
        return perfilService.test(num);
    }


}
