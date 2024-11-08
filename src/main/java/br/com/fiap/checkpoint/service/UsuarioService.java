package br.com.fiap.checkpoint.service;

import br.com.fiap.checkpoint.model.Role;
import br.com.fiap.checkpoint.model.Usuario;
import br.com.fiap.checkpoint.repository.RoleRepository;
import br.com.fiap.checkpoint.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void save(String username, String password, Set<String> roles) {
        Set<Role> roleSet = new HashSet<>();
        for (String nome : roles) {
            Role role = roleRepository.findByName(nome);
            if (role != null) roleSet.add(role);
        }
        Usuario usuario = new Usuario(username, passwordEncoder.encode(password), roleSet);
        usuarioRepository.save(usuario);
    }
}
