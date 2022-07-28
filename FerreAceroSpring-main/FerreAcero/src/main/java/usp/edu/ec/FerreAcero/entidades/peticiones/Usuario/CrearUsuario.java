package usp.edu.ec.FerreAcero.entidades.peticiones.Usuario;

import com.fasterxml.jackson.annotation.JsonProperty;
import usp.edu.ec.FerreAcero.entidades.Persona;



public class CrearUsuario {
     @JsonProperty
    private String usuario;
    @JsonProperty
    private String clave;
    @JsonProperty
    private int persona_id;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setPersona_id(int persona_id) {
        this.persona_id = persona_id;
    }

    public int getPersona_id() {
        return persona_id;
    }
}
