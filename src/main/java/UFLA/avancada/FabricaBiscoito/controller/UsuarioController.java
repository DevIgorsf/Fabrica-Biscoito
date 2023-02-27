package UFLA.avancada.FabricaBiscoito.controller;

import UFLA.avancada.FabricaBiscoito.domain.usuario.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarUsuario (@RequestBody @Valid DadosCadastroUsuario dados) {
        Usuario usuario = new Usuario(dados);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        usuario.setSenha(encoder.encode(usuario.getPassword()));
        usuario.setRole(Role.Client);
        usuarioRepository.save(usuario);
        DadosUsuario dadosUsuario = new DadosUsuario(usuario);

        return ResponseEntity.status(HttpStatus.CREATED).body(dadosUsuario);
    }
}
