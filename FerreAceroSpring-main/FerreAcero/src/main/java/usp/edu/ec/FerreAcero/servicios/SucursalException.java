package usp.edu.ec.FerreAcero.servicios;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import usp.edu.ec.FerreAcero.entidades.Sucursal;

@ResponseStatus(code= HttpStatus.NOT_FOUND,reason = "Producto no encontrada")
public class SucursalException extends RuntimeException{

    public SucursalException(){

    }
    public SucursalException(String message){super(message);}
}
