package usp.edu.ec.FerreAcero.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class CarritoDetalle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private double valor_unitario;
    private int cantidad;
     @OneToOne
     @JoinColumn
     private Producto producto;
     @ManyToOne
     @JoinColumn
     private Carrito carrito;

    public CarritoDetalle(int id, double valor_unitario, int cantidad, Producto producto, Carrito carrito) {
        this.id = id;
        this.valor_unitario = valor_unitario;
        this.cantidad = cantidad;
        this.producto = producto;
        this.carrito = carrito;
    }

    public CarritoDetalle() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarritoDetalle that = (CarritoDetalle) o;
        return id == that.id && Double.compare(that.valor_unitario, valor_unitario) == 0 && cantidad == that.cantidad && producto.equals(that.producto) && carrito.equals(that.carrito);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, valor_unitario, cantidad, producto, carrito);
    }

    @Override
    public String toString() {
        return "CarritoDetalle{" +
                "id=" + id +
                ", valor_unitaario=" + valor_unitario +
                ", cantidad=" + cantidad +
                ", producto=" + producto +
                ", carrito=" + carrito +
                '}';
    }
}
