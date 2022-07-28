package usp.edu.ec.FerreAcero.servicios;

import usp.edu.ec.FerreAcero.entidades.Persona;
import usp.edu.ec.FerreAcero.repositorios.PersonaRespositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServicio {
    @Autowired
    private PersonaRespositorio personaRespositorio;

    public List<Persona> findAll(){


        return (List<Persona>)personaRespositorio.findAll() ;
    }

    public String ConsultaDatos(int codigo){


        return (String) personaRespositorio.findPersonaByCodigo(codigo);
    }

    public Persona ConsultaDatosP(String cedula){


        return (Persona) personaRespositorio.findPersonaByCedula(cedula);
    }

    public void save(Persona persona){

        personaRespositorio.save(persona);


    }


    public Optional<Persona> findByCodigo(int codigo){



        return  (Optional<Persona>) personaRespositorio.findById(codigo);

    }


    public void delete(int id){personaRespositorio.deleteById(id);


    }
}
