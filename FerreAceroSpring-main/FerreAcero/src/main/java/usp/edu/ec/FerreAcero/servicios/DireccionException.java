package usp.edu.ec.FerreAcero.servicios;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Direccion no encontrado")
public class DireccionException extends RuntimeException {

    public DireccionException(){

    }

    public DireccionException(String message){super(message);}
}
