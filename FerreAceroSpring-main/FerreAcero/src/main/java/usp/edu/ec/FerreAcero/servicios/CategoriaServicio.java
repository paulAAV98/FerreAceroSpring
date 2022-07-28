package usp.edu.ec.FerreAcero.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usp.edu.ec.FerreAcero.entidades.Categoria;
import usp.edu.ec.FerreAcero.entidades.Persona;
import usp.edu.ec.FerreAcero.repositorios.CategoriaRepositorio;
import usp.edu.ec.FerreAcero.repositorios.PersonaRespositorio;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServicio {

    @Autowired
    CategoriaRepositorio categoriaRepositorio;

    public List<Categoria> findAll(){


        return (List<Categoria>) categoriaRepositorio.findAll() ;
    }

    public Categoria ConsultaDatosC(int id){


        return (Categoria) categoriaRepositorio.findCategoriaById(id);
    }

    public Categoria ConsultaDatosPC(String nombre){


        return (Categoria) categoriaRepositorio.findCategoriaByNombre(nombre);
    }




}
