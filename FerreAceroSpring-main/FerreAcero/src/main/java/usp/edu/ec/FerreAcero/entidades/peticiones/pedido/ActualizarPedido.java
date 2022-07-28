package usp.edu.ec.FerreAcero.entidades.peticiones.pedido;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ActualizarPedido {

    @JsonProperty
    private int id;
    @JsonProperty
    private int numero;

    @JsonProperty
    private String estado;

    @JsonProperty
    private double total;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
