package usp.edu.ec.FerreAcero.servicios;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Carrito Detalle no encontrado")
public class UsuarioException extends RuntimeException {

    public UsuarioException(){

    }

    public UsuarioException(String message){super(message);}
}
