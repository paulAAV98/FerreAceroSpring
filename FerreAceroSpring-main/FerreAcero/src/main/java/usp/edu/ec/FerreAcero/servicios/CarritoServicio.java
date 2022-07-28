package usp.edu.ec.FerreAcero.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usp.edu.ec.FerreAcero.entidades.Carrito;
import usp.edu.ec.FerreAcero.repositorios.CarritoRepositorio;

import java.util.List;
import java.util.Optional;
@Service
public class CarritoServicio {

    @Autowired
    private CarritoRepositorio carritoRepositorio;

    public List<Carrito> findAll(){

        return (List<Carrito>) carritoRepositorio.findAll();
    }

    public Carrito consultaDatos(int id){

        return (Carrito) carritoRepositorio.findCarritoById(id);
    }

    public Carrito consultaDatosCarrito(int numero){

        return (Carrito) carritoRepositorio.findCarritoByNumero(numero);
    }

    public void save(Carrito carrito){

        carritoRepositorio.save(carrito);
    }

    public Optional<Carrito> findById(int id){

        return (Optional<Carrito>) carritoRepositorio.findById(id);
    }

    public void delete(int id) {
        carritoRepositorio.deleteById(id);

    }

}
