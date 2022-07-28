package usp.edu.ec.FerreAcero.repositorios;

import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import usp.edu.ec.FerreAcero.entidades.Carrito;
import usp.edu.ec.FerreAcero.entidades.Persona;

public interface CarritoRepositorio extends CrudRepository<Carrito, Integer> {

    @Query("Select c from Carrito c where c.id = :id")
    Carrito findCarritoById(int id);

    @Query("Select c from Carrito c where c.numero = :numero")
    Carrito findCarritoByNumero(int numero);


}
