package usp.edu.ec.FerreAcero.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import usp.edu.ec.FerreAcero.entidades.FormaPago;
import usp.edu.ec.FerreAcero.entidades.Persona;
import usp.edu.ec.FerreAcero.entidades.TarjetaCredito;
import usp.edu.ec.FerreAcero.entidades.peticiones.formapago.ActualizarFormaPago;
import usp.edu.ec.FerreAcero.entidades.peticiones.formapago.Crear_FormaPago;
import usp.edu.ec.FerreAcero.servicios.FormaPagoExeption;
import usp.edu.ec.FerreAcero.servicios.FormaPagoServicio;
import usp.edu.ec.FerreAcero.servicios.PersonaServicio;
import usp.edu.ec.FerreAcero.servicios.TarjetaServicio;

import java.util.List;
import java.util.Optional;

@RestController
public class FormaPagoControlador {

    private FormaPagoServicio formapagoServicio;
    private PersonaServicio personaServicio;
    private TarjetaServicio tarjetaServicio;
    @Autowired
    public void setFormaPagoServicio(FormaPagoServicio formapagoServicio) {

        this.formapagoServicio = formapagoServicio;
    }
    @Autowired
    public void setPersonaServicio(PersonaServicio personaServicio) {
        this.personaServicio = personaServicio;
    }
    @Autowired
    public void setTarjetaServicio(TarjetaServicio tarjetaServicio) {
        this.tarjetaServicio = tarjetaServicio;
    }

    @GetMapping("/formaspago")
    public ResponseEntity<List<FormaPago>> getAllFormaPago(){

        List<FormaPago> listaFormaPago=formapagoServicio.findAll();

        return new ResponseEntity<List<FormaPago>>(listaFormaPago, HttpStatus.OK);

    }

    @GetMapping("{codigo}/tipo")

    public ResponseEntity<String> Consulta (@PathVariable int codigo){
        String tipo = formapagoServicio.ConsultaDatos(codigo);

        return new ResponseEntity<String>(tipo,HttpStatus.OK);

    }

    @GetMapping("/formapago/{tipo}")

    public ResponseEntity<FormaPago> getFormaPago (@PathVariable String tipo) throws FormaPagoExeption {
        Optional<FormaPago> formapago = Optional.ofNullable(formapagoServicio.ConsultaDatosF(tipo));
        FormaPago formapago1=formapago.orElseThrow(FormaPagoExeption::new);

        return new ResponseEntity<FormaPago>(formapago1,HttpStatus.OK);

    }
    @PostMapping("/formapago/create")
    public ResponseEntity<FormaPago> createFormaPago (@RequestBody Crear_FormaPago crear_formapago){
        Optional<Persona> persona = personaServicio.findByCodigo(crear_formapago.getPersona_id());
        if (persona.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        Optional<TarjetaCredito> tarjetacredito = tarjetaServicio.findByCodigo(crear_formapago.getTarjetacredito_id());
        if (tarjetacredito.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        FormaPago formapago = new FormaPago();
        formapago.setTipo(crear_formapago.getTipo());
        formapago.setPersona(persona.get());
        formapago.setTarjetacredito(tarjetacredito.get());
        formapagoServicio.save(formapago);

        return ResponseEntity.ok(formapago);
    }

    @PutMapping("/formapago/update")
    public ResponseEntity<String>updateFormaPago(@RequestBody ActualizarFormaPago actualizarFormaPago) {

        Optional<FormaPago> formapagoOptional = formapagoServicio.findByCodigo(actualizarFormaPago.getId());

        if (formapagoOptional.isEmpty()) {


            return ResponseEntity.badRequest().build();


        }

        FormaPago formapagof=formapagoOptional.get();
        formapagof.setId(actualizarFormaPago.getId());
        formapagof.setTipo(actualizarFormaPago.getTipo());
        formapagoServicio.save(formapagof);

        return ResponseEntity.ok("FormaPago Actulizada");
    }

    @DeleteMapping("/formapago/delete/{id}")

    public ResponseEntity<String>deleteformapago(@PathVariable int id){

        formapagoServicio.delete(id);

        return ResponseEntity.ok("FormaPago Eliminada");

    }
}