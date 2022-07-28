package usp.edu.ec.FerreAcero.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import usp.edu.ec.FerreAcero.entidades.Direccion;
import usp.edu.ec.FerreAcero.entidades.Usuario;

public interface DireccionRepositorio extends CrudRepository<Direccion, Integer> {

    @Query("select d from Direccion d where d.id = :id")
    Direccion findDireccionById(int id);



    @Query("select d from Direccion d where d.persona.id = :id")
    Direccion  findByIdPer(int id);





}
