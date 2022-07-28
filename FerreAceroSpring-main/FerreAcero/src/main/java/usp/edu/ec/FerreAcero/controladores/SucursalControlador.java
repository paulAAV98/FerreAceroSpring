package usp.edu.ec.FerreAcero.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import usp.edu.ec.FerreAcero.entidades.FormaPago;
import usp.edu.ec.FerreAcero.entidades.Persona;

import usp.edu.ec.FerreAcero.entidades.Producto;


import usp.edu.ec.FerreAcero.entidades.Sucursal;
import usp.edu.ec.FerreAcero.servicios.FormaPagoExeption;
import usp.edu.ec.FerreAcero.servicios.ProductoServicio;
import usp.edu.ec.FerreAcero.servicios.SucursalException;
import usp.edu.ec.FerreAcero.servicios.SucursalServicio;

import java.util.List;
import java.util.Optional;



@CrossOrigin(origins = "*",  maxAge=3600, methods= {RequestMethod.GET,RequestMethod.POST})


@RestController
public class SucursalControlador {

    private SucursalServicio sucursalServicio;
    private ProductoServicio productoServicio;

    @Autowired
    public void setProductoServicio(ProductoServicio productoServicio) {
        this.productoServicio = productoServicio;
    }


    @Autowired
    public void setSucursalServicio(SucursalServicio sucursalServicio) {
        this.sucursalServicio = sucursalServicio;
    }


    @GetMapping("/sucursales")
    public ResponseEntity<List<Sucursal>> getAllSucursal() {

        List<Sucursal> listaSucursal = sucursalServicio.findAll();

        return new ResponseEntity<List<Sucursal>>(listaSucursal, HttpStatus.OK);

    }

    @GetMapping("/sucursal/Lista")
    public ResponseEntity<List<String>> getAllCategoria() {

        List<String> listaCategoria = new Gestion().sucurNombre(sucursalServicio.findAll());

        return new ResponseEntity<List<String>>(listaCategoria, HttpStatus.OK);

    }

    @GetMapping("sucursal/{nombreSu}")

    public ResponseEntity<List<String>> getSucursalProducto(@PathVariable String nombreSu) throws SucursalException {
        Optional<Sucursal> sucursal1 = Optional.ofNullable(sucursalServicio.ConsultaDatosP(nombreSu));
        Sucursal sucursal2 = sucursal1.orElseThrow(FormaPagoExeption::new);
        List<String> listaProducto = new Gestion().sucurProducto(sucursal2, productoServicio.findAll());

        return new ResponseEntity<List<String>>(listaProducto, HttpStatus.OK);
    }



    @GetMapping("sucursal/producto911/{nombreSu}")

    public ResponseEntity<List<Producto>> getSucursalProducto911(@PathVariable String nombreSu) throws SucursalException {


        Optional<Sucursal> sucursal1 = Optional.ofNullable(sucursalServicio.ConsultaDatosP(nombreSu));
        Sucursal sucursal2 = sucursal1.orElseThrow(FormaPagoExeption::new);
        List<Producto> listaProducto = new Gestion().sucurProducto911(sucursal2, productoServicio.findAll());
        return new ResponseEntity<List<Producto>>(listaProducto, HttpStatus.OK);
    }
}

