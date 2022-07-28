package usp.edu.ec.FerreAcero.entidades;



import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class TarjetaCredito implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String  NumeroTarjeta;
    private String  tipoTarjeta;
    private int CCV;
    private String  FechaExp;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tarjetacredito", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<FormaPago> formapago;

    @ManyToOne
    @JoinColumn
    private Persona persona;

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

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

}



