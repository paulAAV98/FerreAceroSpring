package usp.edu.ec.FerreAcero.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int numero;

    private String estado;

    private double total;

    @ManyToOne
    @JoinColumn
    private Persona persona;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<PedidoDetalle> pedidoDetalle;




    @ManyToOne
    @JoinColumn
    private Carrito carrito;

    public Pedido() {
    }

    public Pedido(int id, int numero, String estado, double total, Persona persona, List<PedidoDetalle> pedidoDetalle, Carrito carrito) {
        this.id = id;
        this.numero = numero;
        this.estado = estado;
        this.total = total;
        this.persona = persona;
        this.pedidoDetalle = pedidoDetalle;
        this.carrito = carrito;
    }

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

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<PedidoDetalle> getPedidoDetalle() {
        return pedidoDetalle;
    }

    public void setPedidoDetalle(List<PedidoDetalle> pedidoDetalle) {
        this.pedidoDetalle = pedidoDetalle;
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
        Pedido pedido = (Pedido) o;
        return id == pedido.id && numero == pedido.numero && Double.compare(pedido.total, total) == 0 && estado.equals(pedido.estado) && persona.equals(pedido.persona) && pedidoDetalle.equals(pedido.pedidoDetalle) && carrito.equals(pedido.carrito);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numero, estado, total, persona, pedidoDetalle, carrito);
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", numero=" + numero +
                ", estado='" + estado + '\'' +
                ", total=" + total +
                ", persona=" + persona +
                ", pedidoDetalle=" + pedidoDetalle +
                ", carrito=" + carrito +
                '}';
    }



}
