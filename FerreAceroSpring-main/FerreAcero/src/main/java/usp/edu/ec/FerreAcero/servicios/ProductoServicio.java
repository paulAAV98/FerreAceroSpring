package usp.edu.ec.FerreAcero.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usp.edu.ec.FerreAcero.entidades.Persona;
import usp.edu.ec.FerreAcero.entidades.Producto;
import usp.edu.ec.FerreAcero.entidades.Sucursal;
import usp.edu.ec.FerreAcero.repositorios.PersonaRespositorio;
import usp.edu.ec.FerreAcero.repositorios.ProductoRespositorio;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicio {
    @Autowired
    private ProductoRespositorio productoRespositorio;

    public List<Producto> findAll(){


        return (List<Producto>)productoRespositorio.findAll();
    }

    public Producto ConsultaDatos(int codigo){


        return (Producto) productoRespositorio.findProductoByCodigo(codigo);
    }

    public Producto ConsultaDatosP(String nombre){


        return (Producto) productoRespositorio.findProductoByNombre(nombre);
    }



    public Producto ConsultaP(int productoId){
        return (Producto) productoRespositorio.findProductoBySucursalId(productoId);
    }



    public void save(Producto producto){

        productoRespositorio.save(producto);


    }


    public Optional<Producto> findByCodigo(int codigo){



        return  (Optional<Producto>) productoRespositorio.findById(codigo);

    }


    public void delete(int id){productoRespositorio.deleteById(id);


    }
}
