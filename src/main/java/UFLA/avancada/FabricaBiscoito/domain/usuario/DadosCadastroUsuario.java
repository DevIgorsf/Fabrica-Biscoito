package UFLA.avancada.FabricaBiscoito.domain.usuario;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record DadosCadastroUsuario(
        @NotBlank(message = "Campo obrigatório")
        String nome,
        @NotBlank(message = "Campo obrigatório")
        String login,
        @NotBlank(message = "Campo obrigatório")
        @Length(min = 6, max = 12 , message = "Senha deve ter entre 6 e 12 caracteres")
        String senha) {
}
