package usp.edu.ec.FerreAcero.servicios;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "Pedido no encontrado")
public class PedidoException extends RuntimeException{

    public PedidoException(){
    }

    public PedidoException(String message){super(message);}

}
