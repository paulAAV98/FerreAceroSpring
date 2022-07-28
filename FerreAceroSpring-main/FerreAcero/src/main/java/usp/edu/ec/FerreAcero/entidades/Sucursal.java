package usp.edu.ec.FerreAcero.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
@Entity
public class Sucursal implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombre;
    private String latitud;
    private String longitud;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "sucursal",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Producto> productos;

    public Sucursal() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Sucursal(int id, String nombre, String latitud, String longitud, List<Producto> productos) {
        this.id = id;
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
        this.productos = productos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sucursal)) return false;
        Sucursal sucursal = (Sucursal) o;
        return id == sucursal.id && Objects.equals(nombre, sucursal.nombre) && Objects.equals(latitud, sucursal.latitud) && Objects.equals(longitud, sucursal.longitud) && Objects.equals(productos, sucursal.productos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, latitud, longitud, productos);
    }

    @Override
    public String toString() {
        return "Sucursal{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", latitud='" + latitud + '\'' +
                ", longitud='" + longitud + '\'' +
                '}';
    }
}
