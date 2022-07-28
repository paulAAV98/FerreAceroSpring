package usp.edu.ec.FerreAcero.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.util.List;

import java.io.Serializable;

import java.util.List;

import java.io.Serializable;

import java.util.List;
import java.io.Serializable;

import java.util.Objects;

@Entity
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String  nombre;
    private String apellido;

    private String cedula;

    private String email;
    private String telefono;

    private String tipo;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "persona", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<TarjetaCredito> tarjetaCredito;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "persona", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<FormaPago> formapago;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "persona", cascade = CascadeType.ALL)
    @JsonIgnore
    private Usuario usuario;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "persona",cascade = CascadeType.ALL)

    private List<Direccion>direcciones;


    public List<Direccion> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }



    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    public List<TarjetaCredito> getTarjetaCredito() {
        return tarjetaCredito;
    }


    public void setTarjetaCredito(List<TarjetaCredito> tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }

    public List<FormaPago> getFormapago() {
        return formapago;
    }

    public void setFormapago(List<FormaPago> formapago) {
        this.formapago = formapago;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Persona(){
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persona)) return false;
        Persona persona = (Persona) o;
        return id == persona.id && Objects.equals(nombre, persona.nombre) && Objects.equals(apellido, persona.apellido) && Objects.equals(cedula, persona.cedula)  && Objects.equals(email, persona.email) && Objects.equals(telefono, persona.telefono) && Objects.equals(tipo, persona.tipo) && Objects.equals(tarjetaCredito, persona.tarjetaCredito) && Objects.equals(formapago, persona.formapago) && Objects.equals(usuario, persona.usuario) && Objects.equals(direcciones, persona.direcciones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellido, cedula, email, telefono, tipo, tarjetaCredito, formapago, usuario, direcciones);
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +

                ", cedula='" + cedula + '\'' +

                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }


    public Persona(int id, String nombre, String apellido, String cedula, String direccion, String email, String telefono, String tipo, List<TarjetaCredito> tarjetaCredito, List<FormaPago> formapago, Usuario usuario, List<Direccion> direcciones) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;

        this.email = email;
        this.telefono = telefono;
        this.tipo = tipo;
        this.tarjetaCredito = tarjetaCredito;
        this.formapago = formapago;
        this.usuario = usuario;
        this.direcciones = direcciones;
    }




}
