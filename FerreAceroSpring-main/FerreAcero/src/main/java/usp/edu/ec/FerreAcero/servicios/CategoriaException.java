package usp.edu.ec.FerreAcero.servicios;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "Categoria no encontrado")
public class CategoriaException extends RuntimeException {

    public CategoriaException(){

    }

    public CategoriaException(String message){super(message);}
}
