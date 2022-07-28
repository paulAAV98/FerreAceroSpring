package usp.edu.ec.FerreAcero.entidades.peticiones.carrito;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class CrearCarrito {

    @JsonProperty
    private int numero;
    @JsonProperty
    private Date fecha;
    @JsonProperty
    private double subtotal;
    @JsonProperty
    private double total;
    @JsonProperty
    private int persona_id;

    @JsonProperty
    private int pedido_id;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getPersona_id() {
        return persona_id;
    }

    public void setPersona_id(int persona_id) {
        this.persona_id = persona_id;
    }

    public int getPedido_id() {
        return pedido_id;
    }

    public void setPedido_id(int pedido_id) {
        this.pedido_id = pedido_id;
    }
}
