package usp.edu.ec.FerreAcero.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import usp.edu.ec.FerreAcero.entidades.Direccion;
import usp.edu.ec.FerreAcero.entidades.Persona;
import usp.edu.ec.FerreAcero.entidades.Sucursal;
import usp.edu.ec.FerreAcero.servicios.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DireccionControlador {

    private DireccionServicio direccionServicio;

    private PersonaServicio personaServicio;


    SucursalServicio sucursalServicio;

    @Autowired
    public void setSucursalServicio(SucursalServicio sucursalServicio) {
        this.sucursalServicio = sucursalServicio;
    }

    @Autowired
    public void setPersonaServicio(PersonaServicio personaServicio) {
        this.personaServicio = personaServicio;
    }
    @Autowired
    public void setDireccionServicio(DireccionServicio direccionServicio) {
        this.direccionServicio = direccionServicio;
    }

    @GetMapping("/Direcciones")
    public ResponseEntity<List<Direccion>> getAllDireccion(){

        List<Direccion> listadireccion=direccionServicio.findAll();

        return new ResponseEntity<>(listadireccion, HttpStatus.OK);
    }




    @GetMapping("distancias/{cedula}/{sucursal}")

    public String Distancia(@PathVariable String cedula, @PathVariable String sucursal){
        Optional<Persona> persona = Optional.ofNullable(personaServicio.ConsultaDatosP(cedula));
        Optional<Sucursal> sucursal1 = Optional.ofNullable(sucursalServicio.ConsultaDatosP(sucursal));
        Sucursal sucursal2 = sucursal1.orElseThrow(FormaPagoExeption::new);
        Persona persona1= persona.orElseThrow(FormaPagoExeption::new);
        Optional<Direccion> direccion = Optional.ofNullable(direccionServicio.ConsultaPer(persona1.getId()));
        Direccion dir= direccion.orElseThrow(FormaPagoExeption::new);
        String distancia="";


                distancia=new Gestion().CalcularDistancia(sucursal2,dir);








        return distancia;
    }

    @GetMapping("/envio/{cedula}/{sucursal}")

    public String PrecioEnvio(@PathVariable String cedula, @PathVariable String sucursal){



        Optional<Persona> persona = Optional.ofNullable(personaServicio.ConsultaDatosP(cedula));
        Optional<Sucursal> sucursal1 = Optional.ofNullable(sucursalServicio.ConsultaDatosP(sucursal));
        Sucursal sucursal2 = sucursal1.orElseThrow(FormaPagoExeption::new);
        Persona persona1= persona.orElseThrow(FormaPagoExeption::new);
        Optional<Direccion> direccion = Optional.ofNullable(direccionServicio.ConsultaPer(persona1.getId()));
        Direccion dir= direccion.orElseThrow(FormaPagoExeption::new);
        String distancia="";


        distancia=new Gestion().CalcularPrecioEnvio(sucursal2,dir);








        return distancia;
    }

}
