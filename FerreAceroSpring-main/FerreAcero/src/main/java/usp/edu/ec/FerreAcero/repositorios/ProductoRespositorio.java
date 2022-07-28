package usp.edu.ec.FerreAcero.repositorios;

import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import usp.edu.ec.FerreAcero.entidades.Producto;
import usp.edu.ec.FerreAcero.entidades.Sucursal;

public interface ProductoRespositorio extends CrudRepository<Producto, Integer> {
    @Query("Select p from Producto p where p.id= :id")
    Producto findProductoByCodigo(int id);



    @Query("Select p from Producto p where p.nombre= :nombre")
    Producto findProductoByNombre(String nombre);

    @Query("Select p from Producto p where p.sucursal.id = :sucursalId")
    Producto findProductoBySucursalId(int sucursalId);


    /*@Query("Delete from Producto p where p.id= :id")
    Producto deletePersonaByCedula(int id);*/
}
