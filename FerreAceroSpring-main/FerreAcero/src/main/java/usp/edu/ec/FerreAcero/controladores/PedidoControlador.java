package usp.edu.ec.FerreAcero.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import usp.edu.ec.FerreAcero.entidades.*;
import usp.edu.ec.FerreAcero.entidades.peticiones.pedido.ActualizarPedido;
import usp.edu.ec.FerreAcero.entidades.peticiones.pedido.CrearPedido;
import usp.edu.ec.FerreAcero.servicios.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PedidoControlador {

   Gestion ges;




    private PedidoServicio pedidoServicio;

    private PersonaServicio personaServicio;


    private CarritoServicio carritoServicio;

    private PedidoDetalleServicio pedidoDetalleServicio;

    private List<PedidoDetalle> pedidoDetalleList;

    @Autowired
    public void setPedidoServicio(PedidoServicio pedidoServicio) {
        this.pedidoServicio = pedidoServicio;

    }



    @Autowired
    public void setPersonaServicio(PersonaServicio personaServicio) {
        this.personaServicio = personaServicio;
    }

    @Autowired
    public void setCarritoServicio(CarritoServicio carritoServicio) {
        this.carritoServicio = carritoServicio;
    }

    @Autowired
    public void setPedidoDetalleServicio(PedidoDetalleServicio pedidoDetalleServicio) {
        this.pedidoDetalleServicio = pedidoDetalleServicio;
    }


    @GetMapping("/pedidos")
    public ResponseEntity<List<Pedido>> getAllPedido(){

        List<Pedido> listaPedido=pedidoServicio.findAll();

        return new ResponseEntity<List<Pedido>>(listaPedido, HttpStatus.OK);

    }

    @GetMapping("/pedido/{numero}")

    public ResponseEntity<Pedido> getPedido(@PathVariable int numero) throws PedidoException{
        Optional<Pedido> pedido = Optional.ofNullable(pedidoServicio.ConsultaDatosPedido(numero));
        Pedido pedido1 = pedido.orElseThrow(PedidoException::new);

        return new ResponseEntity<Pedido>(pedido1, HttpStatus.OK);

    }


    @PostMapping("/pedido/crear")
    public ResponseEntity<Pedido> crearPedido(@RequestBody CrearPedido crearPedido){

        Optional<Persona> persona = personaServicio.findByCodigo(crearPedido.getPersona_id());

        if(persona.isEmpty()){

            return ResponseEntity.badRequest().build();

        }

        Optional<Carrito> carrito = carritoServicio.findById(crearPedido.getCarrito_id());

        if(carrito.isEmpty()){
            return ResponseEntity.badRequest().build();
        }


        Pedido pedido = new Pedido();
        pedido.setNumero(crearPedido.getNumero());
        pedido.setEstado(crearPedido.getEstado());
        pedido.setTotal(23.45);
        pedido.setPersona(persona.get());
        pedido.setCarrito(carrito.get());

        pedidoServicio.save(pedido);

        return ResponseEntity.ok(pedido);


    }

    @PutMapping("/pedido/editar")
    public ResponseEntity<String>editarPedido(@RequestBody ActualizarPedido actualizarPedido){
        Optional<Pedido> pedidoOptional = pedidoServicio.findById(actualizarPedido.getId());

        if(pedidoOptional.isEmpty()){
            return ResponseEntity.badRequest().build();
        }

        Pedido pedidof=pedidoOptional.get();
        pedidof.setId(actualizarPedido.getId());
        pedidof.setNumero(actualizarPedido.getNumero());
        pedidof.setEstado(actualizarPedido.getEstado());
        pedidof.setTotal(actualizarPedido.getTotal());
        pedidoServicio.save(pedidof);

        return ResponseEntity.ok("Pedido Actualizado");
    }

    @DeleteMapping("/pedido/delete/{id}")
    public ResponseEntity<String>deletePedido(@PathVariable int id){
        pedidoServicio.delete(id);
        return ResponseEntity.ok("Pedido Eliminado");
    }

    public void Resx(Gestion ges){
    this.ges=ges;



    }

    @GetMapping("/pedido/prueba")

    public ResponseEntity<String> getPrueba() throws PedidoException{

       String pro=String.valueOf(ges.getId_persona());

        return new ResponseEntity<String>(pro, HttpStatus.OK);

    }

    @GetMapping("pedido/ped/{nombreEstado}")

    public ResponseEntity<List<Pedido>> getPedidoEstado(@PathVariable String nombreEstado) throws PedidoException {

        List<Pedido> listaProducto= new Gestion().PedidoEstado(nombreEstado,pedidoServicio.findAll());

        return new ResponseEntity<List<Pedido>>(listaProducto, HttpStatus.OK);
    }


}
