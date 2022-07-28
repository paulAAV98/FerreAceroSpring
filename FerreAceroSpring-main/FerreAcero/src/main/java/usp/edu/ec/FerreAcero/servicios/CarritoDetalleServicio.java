package usp.edu.ec.FerreAcero.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usp.edu.ec.FerreAcero.entidades.CarritoDetalle;
import usp.edu.ec.FerreAcero.repositorios.CarritoDetalleRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class CarritoDetalleServicio {

    @Autowired
    private CarritoDetalleRepositorio carritoDetalleRepositorio;

    public List<CarritoDetalle> findAll(){
        return (List<CarritoDetalle>) carritoDetalleRepositorio.findAll();
    }

    public CarritoDetalle consultaDatos(int id){
        return (CarritoDetalle) carritoDetalleRepositorio.findCarritoDetalleById(id);
    }

    public void save(CarritoDetalle carritoDetalle){

        carritoDetalleRepositorio.save(carritoDetalle);
    }

    public Optional<CarritoDetalle> findById(int id){

        return (Optional<CarritoDetalle>) carritoDetalleRepositorio.findById(id);
    }


    public void delete(int id){
        carritoDetalleRepositorio.deleteById(id);
    }

}
