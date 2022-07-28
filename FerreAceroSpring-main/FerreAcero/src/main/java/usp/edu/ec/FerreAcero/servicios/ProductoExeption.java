package usp.edu.ec.FerreAcero.servicios;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND,reason = "Producto no encontrada")
public class ProductoExeption extends RuntimeException{

    public ProductoExeption(){

    }
   public ProductoExeption(String message){super(message);}

}
