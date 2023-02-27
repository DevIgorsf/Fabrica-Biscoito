package UFLA.avancada.FabricaBiscoito.infra.exceptions;

public class CustomAuthenticationException extends RuntimeException{
    public CustomAuthenticationException(String message) {
        super(message);
    }

}
