package usp.edu.ec.FerreAcero.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import usp.edu.ec.FerreAcero.entidades.Carrito;
import usp.edu.ec.FerreAcero.entidades.FormaPago;
import usp.edu.ec.FerreAcero.entidades.Persona;
import usp.edu.ec.FerreAcero.entidades.Producto;
import usp.edu.ec.FerreAcero.entidades.TarjetaCredito;
import usp.edu.ec.FerreAcero.repositorios.PersonaRespositorio;
import usp.edu.ec.FerreAcero.repositorios.TarjetaRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class TarjetaServicio {
    @Autowired

    private TarjetaRepositorio tarjetaRepositorio;

    public List<TarjetaCredito> findAll(){

        return (List<TarjetaCredito>)tarjetaRepositorio.findAll() ;
    }

    public TarjetaCredito consultaDatos(String numeroTarjeta){

        return (TarjetaCredito) tarjetaRepositorio.findTarjetaCreditoByNumeroTarjeta(numeroTarjeta);
    }

    public TarjetaCredito consultaDatosTarjeta(String numeroTarjeta){

        return (TarjetaCredito) tarjetaRepositorio.findTarjetaCreditoByNumeroTarjeta(numeroTarjeta);
    }

    public void save(TarjetaCredito TarjetaCredito){

        tarjetaRepositorio.save(TarjetaCredito);
    }



    public TarjetaCredito findByNumeroTarjeta (String numeroTarjeta){

        return (TarjetaCredito) tarjetaRepositorio.findTarjetaCreditoByNumeroTarjeta(numeroTarjeta);

    }

    public Optional<TarjetaCredito> findById(int id){

        return  (Optional<TarjetaCredito>) tarjetaRepositorio.findById(id);

    }


    public void delete(int id) {
        tarjetaRepositorio.deleteById(id);

    }

    public Optional<TarjetaCredito> findByCodigo(int codigo) {
        return (Optional<TarjetaCredito>) tarjetaRepositorio.findById(codigo);
    }

}


