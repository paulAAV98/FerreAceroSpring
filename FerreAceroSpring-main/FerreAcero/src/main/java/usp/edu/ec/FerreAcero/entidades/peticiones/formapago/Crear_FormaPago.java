package usp.edu.ec.FerreAcero.entidades.peticiones.formapago;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Crear_FormaPago {

    @JsonProperty
    private String tipo;

    @JsonProperty
    private int persona_id;

    @JsonProperty
    private int tarjetacredito_id;
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public int getPersona_id() {
        return persona_id;
    }

    public void setPersona_id(int persona_id) {
        this.persona_id = persona_id;
    }

    public int getTarjetacredito_id() {
        return tarjetacredito_id;
    }

    public void setTarjetacredito_id(int tarjetacredito_id) {
        this.tarjetacredito_id = tarjetacredito_id;
    }
}
