package usp.edu.ec.FerreAcero.repositorios;

import usp.edu.ec.FerreAcero.entidades.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PersonaRespositorio extends CrudRepository<Persona, Integer> {
    @Query("Select p.nombre,p.id from Persona p where p.id= :id")
    String findPersonaByCodigo(int id);


    @Query("Select p from Persona p where p.cedula= :cedula")
    Persona findPersonaByCedula(String cedula);


    @Query("Delete from Persona p where p.id= :id")
    Persona deletePersonaByCedula(int id);





}
