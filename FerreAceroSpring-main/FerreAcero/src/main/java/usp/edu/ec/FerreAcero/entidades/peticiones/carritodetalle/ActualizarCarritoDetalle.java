package usp.edu.ec.FerreAcero.entidades.peticiones.carritodetalle;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ActualizarCarritoDetalle {

    @JsonProperty
    private int id;
    @JsonProperty
    private double valor_unitario;
    @JsonProperty
    private int cantidad;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor_unitario() {
        return valor_unitario;
    }

    public void setValor_unitaario(double valor_unitario) {
        this.valor_unitario = valor_unitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
