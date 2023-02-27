package UFLA.avancada.FabricaBiscoito.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class HttpMessageNotReadableException extends RuntimeException {
    public HttpMessageNotReadableException(String msg) {
        super(msg);
    }
}
