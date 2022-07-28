package usp.edu.ec.FerreAcero.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Carrito implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int numero;
    private Date fecha;
    private double total;
    private double subtotal;
    @ManyToOne
    @JoinColumn
    private Persona persona;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "carrito",cascade = CascadeType.ALL)
     private List<Pedido> pedido;


    public Carrito(int id, int numero, Date fecha, double total, double subtotal, Persona persona) {
        this.id = id;
        this.numero = numero;
        this.fecha = fecha;
        this.total = total;
        this.subtotal = subtotal;
        this.persona = persona;
    }

    public Carrito() {
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carrito carrito = (Carrito) o;
        return id == carrito.id && numero == carrito.numero && Double.compare(carrito.total, total) == 0 && Double.compare(carrito.subtotal, subtotal) == 0 && fecha.equals(carrito.fecha) && persona.equals(carrito.persona);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numero, fecha, total, subtotal, persona);
    }

    @Override
    public String toString() {
        return "Carrito{" +
                "id=" + id +
                ", numero=" + numero +
                ", fecha=" + fecha +
                ", total=" + total +
                ", subtotal=" + subtotal +
                ", persona=" + persona +
                '}';
    }
}

