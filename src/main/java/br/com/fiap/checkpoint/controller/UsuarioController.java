package br.com.fiap.checkpoint.controller;

import br.com.fiap.checkpoint.model.dto.UsuarioDto;
import br.com.fiap.checkpoint.service.UsuarioService;
import br.com.fiap.checkpoint.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("registrar")
    public String cadastrar(Model model) {
        model.addAttribute("usuario", new UsuarioDto());
        model.addAttribute("roles", roleRepository.findAll());
        return "usuario/cadastro";
    }

    @PostMapping("cadastrar")
    public String cadastrar(@Valid UsuarioDto userForm, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("roles", roleRepository.findAll());
            return "usuario/cadastro";
        }
        usuarioService.save(userForm.getUsername(), userForm.getPassword(), userForm.getRoles());
        return "redirect:/login";
    }
}
