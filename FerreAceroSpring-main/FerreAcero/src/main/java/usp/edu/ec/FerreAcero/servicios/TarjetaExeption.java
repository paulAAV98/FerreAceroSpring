package usp.edu.ec.FerreAcero.servicios;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND,reason = "Tarjeta No Existe")
public class TarjetaExeption extends RuntimeException{

    public TarjetaExeption(){

    }
    public TarjetaExeption(String message){super(message);}

}
