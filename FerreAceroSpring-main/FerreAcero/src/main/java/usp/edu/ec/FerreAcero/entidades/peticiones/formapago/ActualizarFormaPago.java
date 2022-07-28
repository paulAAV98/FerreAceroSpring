package usp.edu.ec.FerreAcero.entidades.peticiones.formapago;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ActualizarFormaPago {
    @JsonProperty
    private int id;

    @JsonProperty
    private String tipo;



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
}

