package usp.edu.ec.FerreAcero.entidades.peticiones.pedidodetalle;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ActualizarPedidoDetalle {

    @JsonProperty
    private int id;

    @JsonProperty
    private int cantidad;

    @JsonProperty
    private double subtotal;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }


}
