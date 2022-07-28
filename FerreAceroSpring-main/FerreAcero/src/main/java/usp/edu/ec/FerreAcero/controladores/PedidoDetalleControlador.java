package usp.edu.ec.FerreAcero.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import usp.edu.ec.FerreAcero.entidades.*;
import usp.edu.ec.FerreAcero.entidades.peticiones.Usuario.ActualizarUsuario;
import usp.edu.ec.FerreAcero.entidades.peticiones.pedido.ActualizarPedido;
import usp.edu.ec.FerreAcero.entidades.peticiones.pedidodetalle.ActualizarPedidoDetalle;
import usp.edu.ec.FerreAcero.entidades.peticiones.pedidodetalle.CrearPedidoDetalle;
import usp.edu.ec.FerreAcero.servicios.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class PedidoDetalleControlador {
    Gestion ges;

    private PedidoDetalleServicio pedidoDetalleServicio;

    private ProductoServicio productoServicio;


    private PedidoServicio pedidoServicio;

    private PersonaServicio personaServicio;


    private List<PedidoDetalle> pedidoDetalleList=new ArrayList<>();



    @Autowired
    public void setPedidoDetalleServicio(PedidoDetalleServicio pedidoDetalleServicio) {
        this.pedidoDetalleServicio = pedidoDetalleServicio;

    }
    @Autowired
    public void setPersonaServicio(PersonaServicio personaServicio) {
        this.personaServicio = personaServicio;
    }

    @Autowired
    public void setProductoServicio(ProductoServicio productoServicio) {
        this.productoServicio = productoServicio;
    }


    @Autowired
    public void setPedidoServicio(PedidoServicio pedidoServicio) {
        this.pedidoServicio = pedidoServicio;
    }


    @GetMapping("/pedidodetalles")
    public ResponseEntity<List<PedidoDetalle>> getAllPedidoDetalle(){

        List<PedidoDetalle> listaPedidodetalle=pedidoDetalleServicio.findAll();

        return new ResponseEntity<List<PedidoDetalle>>(listaPedidodetalle, HttpStatus.OK);

    }

int cont=1;
    int pe_id=0;
    @PostMapping("/pedidoadd/pox/crear")
    public ResponseEntity<String> crearPedidoDetalle(@RequestBody CrearPedidoDetalle crearPedidoDetalle){
       Optional<Producto> producto = productoServicio.findByCodigo(crearPedidoDetalle.getProducto_id());
       Producto producto1 = producto.orElseThrow(PedidoException::new);
       if(producto.isEmpty()){
           return ResponseEntity.badRequest().build();
       }
        Optional<Persona> persona = personaServicio.findByCodigo(ges.getId_persona());
        Persona persona1=persona.orElseThrow(ProductoExeption::new);
        if(persona.isEmpty()){

            return ResponseEntity.badRequest().build();
        }


       pedidoDetalleList = new Gestion().agregarProductos(pedidoDetalleList, producto1, crearPedidoDetalle.getCantidad());

      Carrito car=new Carrito();
      car.setId(1);


        //---------------------------------------------------------------------------------------------------------------//
        Pedido pedido1 = new Pedido();
        if(cont==1){
            pedido1.setId(pedidoServicio.findByPedidoMax()+1);
            pedido1.setNumero(100);
            pedido1.setPersona(persona1);
            pedido1.setTotal(new Gestion().Total(pedidoDetalleList));
            pedido1.setEstado("Activo");
            pedido1.setCarrito(car);
            pe_id=pedido1.getId();
            cont++;
            pedidoServicio.save(pedido1);
        }else{

             pedido1.setId(pe_id);
            ActualizarPedido acp=new ActualizarPedido();
            acp.setId(pe_id);
            //acp.setTotal(ped);

            Optional<Pedido> pedidoO = pedidoServicio.findById(acp.getId());

            if(pedidoO.isEmpty()){
                return ResponseEntity.badRequest().build();
            }

            Pedido pedidon=pedidoO.get();
            pedidon.setTotal(new Gestion().Total(pedidoDetalleList));


            pedidoServicio.save(pedidon);




        }

        //----------agregar------------------//

        PedidoDetalle pd=new PedidoDetalle();

        pd.setPedido(pedido1);
        pd.setCantidad(crearPedidoDetalle.getCantidad());
        pd.setSubtotal(new Gestion().CalcularSubTotal(crearPedidoDetalle.getCantidad(), producto1.getPrecio()));
        pd.setProducto(producto1);

        //-------------------------------------//




        pedidoDetalleServicio.save(pd);


       return ResponseEntity.ok("Pedido Agregado");







    }

    @PutMapping("/pedidodetalle/editar")
    public ResponseEntity<String>editarPedidoDetalle(@RequestBody ActualizarPedidoDetalle actualizarPedidoDetalle){
        Optional<PedidoDetalle> pedidoDetalleOptional = pedidoDetalleServicio.findById(actualizarPedidoDetalle.getId());

        if (pedidoDetalleOptional.isEmpty()){

            return ResponseEntity.badRequest().build();
        }

        PedidoDetalle pedidoDetalle1=pedidoDetalleOptional.get();

        pedidoDetalle1.setCantidad(actualizarPedidoDetalle.getCantidad());
        pedidoDetalle1.setId(actualizarPedidoDetalle.getId());
        pedidoDetalle1.setSubtotal(actualizarPedidoDetalle.getSubtotal());
        pedidoDetalleServicio.save(pedidoDetalle1);

        return ResponseEntity.ok("Pedido detalle Actualizado");

    }

    @DeleteMapping("/pedidodetalle/delete/{id}")

    public ResponseEntity<String>deletePedidoDetalle(@PathVariable int id){

        pedidoDetalleServicio.delete(id);

        return ResponseEntity.ok("Pedido Detalle Eliminado");

    }

    public void Resx(Gestion ges){
        this.ges=ges;

        System.out.println(ges.getId_persona());



    }



}
