package usp.edu.ec.FerreAcero.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usp.edu.ec.FerreAcero.entidades.Persona;
import usp.edu.ec.FerreAcero.entidades.Sucursal;
import usp.edu.ec.FerreAcero.repositorios.SucursalRepositorio;

import java.util.List;

@Service
public class SucursalServicio {

    @Autowired
    private SucursalRepositorio sucursalRepositorio;

    public List<Sucursal> findAll(){

        return (List<Sucursal>)sucursalRepositorio.findAll() ;
    }

    public Sucursal ConsultaDatosP(String nombre){
        return (Sucursal) sucursalRepositorio.findProductoBySucursal(nombre);
    }
}
