package com.formulariogabriela.app.controlador;

import com.formulariogabriela.app.entidades.FormularioEntities;
import com.formulariogabriela.app.repositorio.FormularioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FormularioController {

    @Autowired
    private FormularioRepository formularioRepository;

    @GetMapping("/")
    public String mostrarInicio() {
        return "index";
    }

    @GetMapping("/formulario")
    public String mostrarFormulario(Model model) {
        model.addAttribute("formulario", new FormularioEntities());
        model.addAttribute("lista", formularioRepository.findAll());
        return "formulario";
    }

    @PostMapping("/formulario/guardar")
    public String guardarFormulario(@ModelAttribute FormularioEntities formulario) {
        formularioRepository.save(formulario);
        return "redirect:/guardar";
    }

    @GetMapping("/formulario/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        formularioRepository.deleteById(id);
        return "redirect:/guardar";
    }

    @GetMapping("/formulario/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        FormularioEntities formulario = formularioRepository.findById(id).orElse(null);
        model.addAttribute("formulario", formulario);
        model.addAttribute("lista", formularioRepository.findAll());
        return "formulario";
    }

    @GetMapping("/guardar")
    public String mostrarGuardados(Model model) {
        model.addAttribute("lista", formularioRepository.findAll());
        return "guardar";
    }

    @GetMapping("/acerca")
    public String mostrarAcerca() {
        return "acerca";
    }
}