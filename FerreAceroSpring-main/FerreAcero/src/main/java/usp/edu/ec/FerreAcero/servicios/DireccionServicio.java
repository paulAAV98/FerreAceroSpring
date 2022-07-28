package usp.edu.ec.FerreAcero.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usp.edu.ec.FerreAcero.entidades.Direccion;
import usp.edu.ec.FerreAcero.entidades.Usuario;
import usp.edu.ec.FerreAcero.repositorios.DireccionRepositorio;
import usp.edu.ec.FerreAcero.repositorios.UsuarioRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class DireccionServicio {

    @Autowired
    private DireccionRepositorio direccionRepositorio;

    public List<Direccion> findAll(){

        return (List<Direccion>) direccionRepositorio.findAll();
    }

    public Direccion consultaDatos(int id){

        return (Direccion) direccionRepositorio.findDireccionById(id);
    }

    public void save(Direccion direccion){direccionRepositorio.save(direccion);


    }

    public Optional<Direccion> findById(int id){

        return (Optional<Direccion>) direccionRepositorio.findById(id);
    }

    public void delete(int id){direccionRepositorio.deleteById(id);


    }

    public Direccion ConsultaPer(int id){

        return (Direccion) direccionRepositorio.findByIdPer(id);
    }



}
