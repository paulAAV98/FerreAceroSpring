package usp.edu.ec.FerreAcero.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import usp.edu.ec.FerreAcero.entidades.Persona;
import usp.edu.ec.FerreAcero.entidades.TarjetaCredito;
import usp.edu.ec.FerreAcero.entidades.peticiones.persona.ActualizarPersona;
import usp.edu.ec.FerreAcero.entidades.peticiones.persona.Crear_Persona;
import usp.edu.ec.FerreAcero.entidades.peticiones.tarjeta.ActualizarTarjeta;
import usp.edu.ec.FerreAcero.entidades.peticiones.tarjeta.CrearTarjeta;
import usp.edu.ec.FerreAcero.servicios.PersonaExeption;
import usp.edu.ec.FerreAcero.servicios.PersonaServicio;
import usp.edu.ec.FerreAcero.servicios.TarjetaExeption;
import usp.edu.ec.FerreAcero.servicios.TarjetaServicio;

import java.util.List;
import java.util.Optional;


@RestController
public class TarjetaControlador {
    private TarjetaServicio tarjetaServicio;
    private PersonaServicio personaServicio;
    @Autowired
    public void setPersonaServicio(PersonaServicio personaServicio) {
        this.personaServicio = personaServicio;
    }

    @Autowired
    public void setTarjetaServicio(TarjetaServicio tarjetaServicio) {
        this.tarjetaServicio = tarjetaServicio;
    }

    @GetMapping("/TarjetaCredito")
    public ResponseEntity<List<TarjetaCredito>> getAllTarjeta(){

        List<TarjetaCredito> listaTarjeta=tarjetaServicio.findAll();

        return new ResponseEntity<List<TarjetaCredito>>(listaTarjeta, HttpStatus.OK);
    }



    @GetMapping("/TarjetaCredito/numero/{cedula}")
    public ResponseEntity<List<TarjetaCredito>> getAllTarjetaNumero(@PathVariable String cedula){

        List<TarjetaCredito> listaTarjeta=new Gestion().listatajetas(tarjetaServicio.findAll(),cedula);


        return new ResponseEntity<List<TarjetaCredito>>(listaTarjeta, HttpStatus.OK);
    }
/*
    @GetMapping("{TarjetaCredito}/numeroTarjeta")

    public ResponseEntity<String> Consulta (@PathVariable String numeroTarjeta){
        String numeroTarjeta = tarjetaServicio.consultaDatos(numeroTarjeta);

        return new ResponseEntity<String>(numeroTarjeta,HttpStatus.OK);

    }*/

    @GetMapping("/TarjetaCredito/{numeroTarjeta}")

    public ResponseEntity<TarjetaCredito> getTarjetaCredito (@PathVariable String numeroTarjeta) throws TarjetaExeption {
        Optional<TarjetaCredito> TarjetaCredito = Optional.ofNullable(tarjetaServicio.consultaDatosTarjeta(numeroTarjeta));
        TarjetaCredito tarjeta1=TarjetaCredito.orElseThrow(TarjetaExeption::new);

        return new ResponseEntity<TarjetaCredito>(tarjeta1,HttpStatus.OK);

    }



    @PostMapping("/TarjetaCredito/create")
    public ResponseEntity<TarjetaCredito> createTarjetaCredito (@RequestBody CrearTarjeta crearTarjeta){
        //para llamar a la persona y saber que exite alv
        Optional<Persona>persona=personaServicio.findByCodigo(crearTarjeta.getPersonaId());
        if (persona.isEmpty()){return ResponseEntity.badRequest().build();}

        TarjetaCredito tarjeta = new TarjetaCredito();
       // tarjeta.setId(crearTarjeta.get());
        tarjeta.setNumeroTarjeta(crearTarjeta.getNumeroTarjeta());
        tarjeta.setTipoTarjeta(crearTarjeta.getTipoTarjeta());
        tarjeta.setCCV(crearTarjeta.getCCV());
        tarjeta.setFechaExp(crearTarjeta.getFechaExp());
        tarjeta.setPersona(persona.get());

        tarjetaServicio.save(tarjeta);

        return ResponseEntity.ok(tarjeta);
    }




   /* @GetMapping("/persona/{cedula}")

    public ResponseEntity<Persona> getPersona (@PathVariable String cedula)  {
        Persona persona = personaServicio.ConsultaDatosP(cedula);

        return new ResponseEntity<Persona>(persona,HttpStatus.OK);

    }*/

    @PutMapping("/TarjetaCredito/update")
    public ResponseEntity<String>updateTarjetaCredito(@RequestBody ActualizarTarjeta actualizarTarjeta) {

        Optional<TarjetaCredito> TarjetaCreditoOptional = tarjetaServicio.findById(actualizarTarjeta.getId());

        if (TarjetaCreditoOptional.isEmpty()) {


            return ResponseEntity.badRequest().build();


        }

        TarjetaCredito tarjetae=TarjetaCreditoOptional.get();

        tarjetae.setId(actualizarTarjeta.getId());
        tarjetae.setTipoTarjeta(actualizarTarjeta.getTipoTarjeta());
        tarjetae.setNumeroTarjeta(actualizarTarjeta.getNumeroTarjeta());
        tarjetae.setCCV(actualizarTarjeta.getCCV());
        tarjetae.setFechaExp(actualizarTarjeta.getFechaExp());

        tarjetaServicio.save(tarjetae);

        return ResponseEntity.ok("Tarjeta  Actualizada Correctamente");
    }

    @DeleteMapping("/TarjetaCredito/delete/{id}")

    public ResponseEntity<String>deleteTarjeta(@PathVariable int id){

        tarjetaServicio.delete(id);

        return ResponseEntity.ok("Tarjeta Eliminada Correctamente");


    }


}

