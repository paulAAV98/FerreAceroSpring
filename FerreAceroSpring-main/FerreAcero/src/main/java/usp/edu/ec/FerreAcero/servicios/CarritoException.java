package usp.edu.ec.FerreAcero.servicios;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import usp.edu.ec.FerreAcero.entidades.Carrito;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "Carrito no encontrado")
public class CarritoException extends RuntimeException {

    public CarritoException(){

    }

    public CarritoException(String message){super(message);}
}
