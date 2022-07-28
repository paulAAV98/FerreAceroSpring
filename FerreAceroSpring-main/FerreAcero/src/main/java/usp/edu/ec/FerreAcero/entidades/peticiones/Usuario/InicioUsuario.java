package usp.edu.ec.FerreAcero.entidades.peticiones.Usuario;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InicioUsuario {

    @JsonProperty
    private  String usuario;
    @JsonProperty
    private String contraseña;


    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getUsuario() {
        return usuario;
    }
}
