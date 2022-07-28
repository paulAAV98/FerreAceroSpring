package usp.edu.ec.FerreAcero.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import usp.edu.ec.FerreAcero.entidades.Producto;
import usp.edu.ec.FerreAcero.entidades.Sucursal;

public interface SucursalRepositorio extends CrudRepository<Sucursal, Integer> {

    @Query("Select s from Sucursal s where s.id= :id")
    Sucursal findSucursalByCodigo(int id);

    @Query("Select s from Sucursal s where s.nombre = :nombre")
    Sucursal findProductoBySucursal(String nombre);
}
