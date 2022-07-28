package usp.edu.ec.FerreAcero.entidades.peticiones.tarjeta;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ActualizarTarjeta {
    @JsonProperty
    private int id;
    @JsonProperty
    private String  NumeroTarjeta;
    @JsonProperty
    private String  tipoTarjeta;
    @JsonProperty
    private int CCV;
    @JsonProperty
    private String  FechaExp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroTarjeta() {
        return NumeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        NumeroTarjeta = numeroTarjeta;
    }

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    public int getCCV() {
        return CCV;
    }

    public void setCCV(int CCV) {
        this.CCV = CCV;
    }

    public String getFechaExp() {
        return FechaExp;
    }

    public void setFechaExp(String fechaExp) {
        FechaExp = fechaExp;
    }
}
