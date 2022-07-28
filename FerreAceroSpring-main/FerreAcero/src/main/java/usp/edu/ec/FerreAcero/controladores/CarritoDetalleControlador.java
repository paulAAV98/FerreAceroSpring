package usp.edu.ec.FerreAcero.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import usp.edu.ec.FerreAcero.entidades.Carrito;
import usp.edu.ec.FerreAcero.entidades.CarritoDetalle;
import usp.edu.ec.FerreAcero.entidades.Producto;
import usp.edu.ec.FerreAcero.entidades.peticiones.carritodetalle.ActualizarCarritoDetalle;
import usp.edu.ec.FerreAcero.entidades.peticiones.carritodetalle.CrearCarritoDetalle;
import usp.edu.ec.FerreAcero.servicios.CarritoDetalleServicio;
import usp.edu.ec.FerreAcero.servicios.CarritoServicio;
import usp.edu.ec.FerreAcero.servicios.ProductoServicio;

import java.util.List;
import java.util.Optional;

@RestController
public class CarritoDetalleControlador {

    private CarritoDetalleServicio carritoDetalleServicio;

    private ProductoServicio productoServicio;

    private CarritoServicio carritoServicio;

    @Autowired
    public void setCarritoDetalleServicio(CarritoDetalleServicio carritoDetalleServicio){

        this.carritoDetalleServicio = carritoDetalleServicio;
    }

    @Autowired
    public void setProductoServicio(ProductoServicio productoServicio) {
        this.productoServicio = productoServicio;
    }
    @Autowired
    public void setCarritoServicio(CarritoServicio carritoServicio) {
        this.carritoServicio = carritoServicio;
    }

    @GetMapping("/carritodetalles")
    public ResponseEntity<List<CarritoDetalle>> getAllCarritoDetalle(){

        List<CarritoDetalle> listaCarritoDetalle = carritoDetalleServicio.findAll();

        return new ResponseEntity<List<CarritoDetalle>>(listaCarritoDetalle, HttpStatus.OK);
    }

    @PostMapping("/carritodetalle/create")
    public ResponseEntity<CarritoDetalle> crearCarritoDetalle(@RequestBody CrearCarritoDetalle crearCarritoDetalle){
        Optional<Producto> producto = productoServicio.findByCodigo(crearCarritoDetalle.getProducto_id());
        if(producto.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        Optional<Carrito> carrito = carritoServicio.findById(crearCarritoDetalle.getCarrito_id());
        if(carrito.isEmpty()){
            return ResponseEntity.badRequest().build();
        }

        CarritoDetalle carritoDetalle = new CarritoDetalle();
        carritoDetalle.setValor_unitario(crearCarritoDetalle.getValor_unitario());
        carritoDetalle.setCantidad(crearCarritoDetalle.getCantidad());
        carritoDetalle.setProducto(producto.get());
        carritoDetalle.setCarrito(carrito.get());

        carritoDetalleServicio.save(carritoDetalle);

        return ResponseEntity.ok(carritoDetalle);
    }

    @PutMapping("/carritodetalle/editar")
    public ResponseEntity<String>editarCarritoDetalle(@RequestBody ActualizarCarritoDetalle actualizarCarritoDetalle){
        Optional<CarritoDetalle> carritoDetalleOptional = carritoDetalleServicio.findById(actualizarCarritoDetalle.getId());

        if(carritoDetalleOptional.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        CarritoDetalle carritoDetallef=carritoDetalleOptional.get();
        carritoDetallef.setId(actualizarCarritoDetalle.getId());
        carritoDetallef.setValor_unitario(actualizarCarritoDetalle.getValor_unitario());
        carritoDetallef.setCantidad(actualizarCarritoDetalle.getCantidad());
        carritoDetalleServicio.save(carritoDetallef);

        return ResponseEntity.ok("Carrito Detalle Actualizado");
    }

    @DeleteMapping("/carritodetalle/delete/{id}")
    public ResponseEntity<String>eliminarCarritoDetalle(@PathVariable int id){
        carritoDetalleServicio.delete(id);
        return ResponseEntity.ok("Carro Detalle Eliminado");
    }


}
