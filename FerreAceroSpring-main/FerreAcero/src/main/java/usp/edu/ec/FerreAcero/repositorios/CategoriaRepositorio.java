package usp.edu.ec.FerreAcero.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import usp.edu.ec.FerreAcero.entidades.Categoria;
import usp.edu.ec.FerreAcero.entidades.Persona;


public interface CategoriaRepositorio extends CrudRepository<Categoria, Integer> {
@Query("Select c from Categoria c where c.id= :id")
    Categoria findCategoriaById(int id);

@Query("Select c from Categoria c where c.nombre= :nombre")
    Categoria findCategoriaByNombre(String nombre);

@Query("Delete from Categoria c where c.id= :id")
    Categoria deleteCategoriaById(int id);

}
