package usp.edu.ec.FerreAcero.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import usp.edu.ec.FerreAcero.entidades.PedidoDetalle;

public interface PedidoDetalleRepositorio extends CrudRepository<PedidoDetalle, Integer> {

    @Query("select h from PedidoDetalle h where h.id = :id")
    PedidoDetalle findPedidoDetalleById(int id);


}
