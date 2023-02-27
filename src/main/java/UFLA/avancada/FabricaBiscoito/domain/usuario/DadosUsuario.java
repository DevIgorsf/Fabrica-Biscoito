package UFLA.avancada.FabricaBiscoito.domain.usuario;

public record DadosUsuario(Long id,String nome, Role role, String login) {
    public DadosUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getRole(), usuario.getLogin());
    }
}
