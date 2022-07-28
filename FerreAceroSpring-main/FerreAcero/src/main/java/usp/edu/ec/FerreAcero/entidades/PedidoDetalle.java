package usp.edu.ec.FerreAcero.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class PedidoDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int cantidad;


    private double subtotal;


    @OneToOne
    @JoinColumn
    private Producto producto;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Pedido pedido;


    public PedidoDetalle() {
    }

    public PedidoDetalle(int id, int cantidad, double subtotal, Producto producto, Pedido pedido, CarritoDetalle carritoDetalle) {
        this.id = id;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.producto = producto;
        this.pedido = pedido;
    }

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

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PedidoDetalle that = (PedidoDetalle) o;
        return id == that.id && cantidad == that.cantidad && Double.compare(that.subtotal, subtotal) == 0 && producto.equals(that.producto) && pedido.equals(that.pedido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cantidad, subtotal, producto, pedido);
    }

    @Override
    public String toString() {
        return "PedidoDetalle{" +
                "id=" + id +
                ", cantidad=" + cantidad +
                ", subtotal=" + subtotal +
                ", producto=" + producto +
                ", pedido=" + pedido +
                '}';
    }
}
