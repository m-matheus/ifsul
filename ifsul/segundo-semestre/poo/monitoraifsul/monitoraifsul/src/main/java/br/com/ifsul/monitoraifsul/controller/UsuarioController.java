package br.com.ifsul.monitoraifsul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifsul.monitoraifsul.service.UsuarioService;
import br.com.ifsul.monitoraifsul.entity.Usuario;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/cadastrar")
    public Usuario cadastrarUsuario(@RequestBody Usuario usuario) {
        // Aqui você pode adicionar lógica de validação, por exemplo, verificar se o email já está em uso.
        return usuarioService.cadastrarUsuario(usuario);
    }

    // Outros métodos do controlador conforme necessário

}