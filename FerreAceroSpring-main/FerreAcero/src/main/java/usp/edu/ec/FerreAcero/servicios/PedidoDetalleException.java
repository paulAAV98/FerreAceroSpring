package usp.edu.ec.FerreAcero.servicios;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Pedido Detalle no encontrado")
public class PedidoDetalleException extends RuntimeException {

    public PedidoDetalleException(){

    }

    public PedidoDetalleException(String message){super(message);}

}
