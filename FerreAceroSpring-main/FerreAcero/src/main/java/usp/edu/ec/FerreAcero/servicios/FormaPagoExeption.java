package usp.edu.ec.FerreAcero.servicios;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND,reason = "FormaPago no encontrada")
public class FormaPagoExeption extends RuntimeException{

    public FormaPagoExeption(){

    }
   public FormaPagoExeption(String message){super(message);}

}
