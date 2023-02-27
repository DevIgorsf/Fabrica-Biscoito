package UFLA.avancada.FabricaBiscoito.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NullObjectException extends RuntimeException{

    public NullObjectException(String message) {
        super(message);
    }

}
