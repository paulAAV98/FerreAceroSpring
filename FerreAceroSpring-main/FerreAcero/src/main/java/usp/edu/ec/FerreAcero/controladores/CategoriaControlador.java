package usp.edu.ec.FerreAcero.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import usp.edu.ec.FerreAcero.entidades.Categoria;
import usp.edu.ec.FerreAcero.entidades.Producto;
import usp.edu.ec.FerreAcero.entidades.Sucursal;
import usp.edu.ec.FerreAcero.servicios.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class CategoriaControlador {

    private CategoriaServicio categoriaServicio;
    private ProductoServicio productoServicio;
    @Autowired
    public void setProductoServicio(ProductoServicio productoServicio) {
        this.productoServicio = productoServicio;
    }

    @Autowired
    public void setCategoriaServicio(CategoriaServicio categoriaServicio) {
        this.categoriaServicio = categoriaServicio;
    }

    @GetMapping("/categoriaLista")
    public ResponseEntity<List<String>> getAllCategoria(){

        List<String> listaCategoria= new Gestion().categoriaNombre(categoriaServicio.findAll());

        return new ResponseEntity<List<String>>(listaCategoria, HttpStatus.OK);

    }

    @GetMapping("categoriaLista/pro/{nombreCa}")

    public ResponseEntity<List<String>> getCategoriaProducto(@PathVariable String nombreCa) throws CategoriaException {
        Optional<Categoria> sucursal1 = Optional.ofNullable(categoriaServicio.ConsultaDatosPC(nombreCa));
        Categoria sucursal2 = sucursal1.orElseThrow(FormaPagoExeption::new);
        List<String> listaProducto= new Gestion().productoCate(sucursal2,productoServicio.findAll());

        return new ResponseEntity<List<String>>(listaProducto, HttpStatus.OK);
    }


    @GetMapping("categoria/categoria911/{nombreCa2}")

    public ResponseEntity<List<Producto>> getCategoriaProducto2(@PathVariable String nombreCa2) throws CategoriaException {


        Optional<Categoria> sucursal1 = Optional.ofNullable(categoriaServicio.ConsultaDatosPC(nombreCa2));
        Categoria sucursal2 = sucursal1.orElseThrow(FormaPagoExeption::new);
        List<Producto> listaProductoc= new Gestion().productoCate911(sucursal2,productoServicio.findAll());
        return new ResponseEntity<List<Producto>>(listaProductoc, HttpStatus.OK);
    }





}