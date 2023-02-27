package UFLA.avancada.FabricaBiscoito.infra.exceptions;

public class DuplicatedEntityException extends RuntimeException{
    public DuplicatedEntityException(String msg) {
        super(msg);
    }
}
