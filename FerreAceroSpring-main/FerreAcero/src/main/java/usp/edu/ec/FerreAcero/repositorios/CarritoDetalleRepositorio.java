package usp.edu.ec.FerreAcero.repositorios;

import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import usp.edu.ec.FerreAcero.entidades.CarritoDetalle;

public interface CarritoDetalleRepositorio extends CrudRepository<CarritoDetalle, Integer> {

    @Query("select d from CarritoDetalle d where d.id = :id")
    CarritoDetalle findCarritoDetalleById(int id);



}
