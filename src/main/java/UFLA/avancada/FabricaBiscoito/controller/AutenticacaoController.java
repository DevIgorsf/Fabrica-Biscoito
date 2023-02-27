package UFLA.avancada.FabricaBiscoito.controller;

import UFLA.avancada.FabricaBiscoito.infra.security.DadosTokenJWT;
import UFLA.avancada.FabricaBiscoito.infra.security.TokenService;
import UFLA.avancada.FabricaBiscoito.domain.usuario.DadosAutenticacao;
import UFLA.avancada.FabricaBiscoito.domain.usuario.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = manager.authenticate(authenticationToken);

        Usuario usuario = (Usuario) authentication.getPrincipal();



        var tokenJWT = tokenService.gerarToken(usuario);

        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT, usuario.getNome(), usuario.getRole().toString()));
    }

}
