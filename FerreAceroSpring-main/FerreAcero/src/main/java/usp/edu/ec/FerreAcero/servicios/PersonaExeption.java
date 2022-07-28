package usp.edu.ec.FerreAcero.servicios;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND,reason = "Persona no encontrada")
public class PersonaExeption  extends RuntimeException{

    public PersonaExeption(){

    }
   public PersonaExeption(String message){super(message);}

}
