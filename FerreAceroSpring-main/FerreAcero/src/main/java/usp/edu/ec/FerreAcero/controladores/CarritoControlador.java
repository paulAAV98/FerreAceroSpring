package usp.edu.ec.FerreAcero.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import usp.edu.ec.FerreAcero.entidades.Carrito;
import usp.edu.ec.FerreAcero.entidades.Persona;
import usp.edu.ec.FerreAcero.entidades.peticiones.carrito.ActualizarCarrito;
import usp.edu.ec.FerreAcero.entidades.peticiones.carrito.CrearCarrito;
import usp.edu.ec.FerreAcero.servicios.CarritoException;
import usp.edu.ec.FerreAcero.servicios.CarritoServicio;
import usp.edu.ec.FerreAcero.servicios.PersonaServicio;

import java.util.List;
import java.util.Optional;

@RestController
public class CarritoControlador {

    private CarritoServicio carritoServicio;

    private PersonaServicio personaServicio;

    @Autowired
    public void setCarritoServicio(CarritoServicio carritoServicio) {
        this.carritoServicio = carritoServicio;
    }

    @Autowired
    public void setPersonaServicio(PersonaServicio personaServicio) {
        this.personaServicio = personaServicio;
    }

    @GetMapping("/carritos")
    public ResponseEntity<List<Carrito>> getAllCarrito() {

        List<Carrito> listaCarrito = carritoServicio.findAll();


        return new ResponseEntity<List<Carrito>>(listaCarrito, HttpStatus.OK);
    }


    @GetMapping("/carrito/{numero}")

    public ResponseEntity<Carrito> getCarrito(@PathVariable int numero) throws CarritoException {
        Optional<Carrito> carrito = Optional.ofNullable(carritoServicio.consultaDatosCarrito(numero));
        Carrito carrito1 = carrito.orElseThrow(CarritoException::new);

        return new ResponseEntity<Carrito>(carrito1, HttpStatus.OK);
    }

    @PostMapping("/carrito/create")
    public ResponseEntity<Carrito> crearPersona(@RequestBody CrearCarrito crearCarrito) {
        Optional<Persona> persona = personaServicio.findByCodigo(crearCarrito.getPersona_id());
        if (persona.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        Carrito carrito = new Carrito();
        carrito.setNumero(crearCarrito.getNumero());
        carrito.setFecha(crearCarrito.getFecha());
        carrito.setPersona(persona.get());
        carritoServicio.save(carrito);

        return ResponseEntity.ok(carrito);

    }

    @PutMapping("/carrito/editar")
    public ResponseEntity<String> editarCarrito(@RequestBody ActualizarCarrito actualizarCarrito) {
        Optional<Carrito> carritoOptional = carritoServicio.findById(actualizarCarrito.getId());

        if (carritoOptional.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        Carrito carritof = carritoOptional.get();
        carritof.setId(actualizarCarrito.getId());
        carritof.setNumero(actualizarCarrito.getNumero());
        carritof.setFecha(actualizarCarrito.getFecha());
        carritof.setSubtotal(actualizarCarrito.getSubtotal());
        carritof.setTotal(actualizarCarrito.getTotal());
        carritoServicio.save(carritof);

        return ResponseEntity.ok("Carrito Actualizado");
    }

    @DeleteMapping("/carrito/delete/{id}")
    public ResponseEntity<String> deleteCarrito(@PathVariable int id) {
        carritoServicio.delete(id);
        return ResponseEntity.ok("Carro Eliminado");
    }
}

