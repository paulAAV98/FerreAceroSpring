package usp.edu.ec.FerreAcero.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "FormaPago")
public class FormaPago implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String tipo;

    @ManyToOne
    @JoinColumn
    private TarjetaCredito tarjetacredito;

    @ManyToOne
    @JoinColumn
    private Persona persona;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public TarjetaCredito getTarjetacredito() {
        return tarjetacredito;
    }

    public void setTarjetacredito(TarjetaCredito tarjetacredito) {
        this.tarjetacredito = tarjetacredito;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public FormaPago(int id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }
    public FormaPago(){
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FormaPago formaPago = (FormaPago) o;
        return id == formaPago.id && Objects.equals(tipo, formaPago.tipo) && Objects.equals(tarjetacredito, formaPago.tarjetacredito) && Objects.equals(persona, formaPago.persona);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tipo, tarjetacredito, persona);
    }

    @Override
    public String toString() {
        return "FormaPago{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", tarjetacredito=" + tarjetacredito +
                ", persona=" + persona +
                '}';
    }
}