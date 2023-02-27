package UFLA.avancada.FabricaBiscoito.infra.security;

import lombok.ToString;

@ToString
public class TokenDTO {
    private final String token;
    private final String nome;
    private final String role;

    public TokenDTO(String token, String nome, String role) {
        this.token = token;
        this.nome = nome;
        this.role = role;
    }
}

