package usp.edu.ec.FerreAcero.entidades;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String usuario;
    private String clave;
    @OneToOne
    @JoinColumn
    private Persona persona;


    public int getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getClave() {
        return clave;
    }

    public Persona getPersona() {
        return persona;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        Usuario usuario1 = (Usuario) o;
        return id == usuario1.id && usuario.equals(usuario1.usuario) && clave.equals(usuario1.clave) && persona.equals(usuario1.persona);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, usuario, clave, persona);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", usuario='" + usuario + '\'' +
                ", clave='" + clave + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
