package usp.edu.ec.FerreAcero.entidades.peticiones.carritodetalle;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CrearCarritoDetalle {

    @JsonProperty
    private double valor_unitario;
    @JsonProperty
    private int cantidad;
    @JsonProperty
    private int producto_id;
    @JsonProperty
    private int carrito_id;


    public double getValor_unitario() {
        return valor_unitario;
    }

    public void setValor_unitario(double valor_unitario) {
        this.valor_unitario = valor_unitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(int producto_id) {
        this.producto_id = producto_id;
    }

    public int getCarrito_id() {
        return carrito_id;
    }

    public void setCarrito_id(int carrito_id) {
        this.carrito_id = carrito_id;
    }

}
