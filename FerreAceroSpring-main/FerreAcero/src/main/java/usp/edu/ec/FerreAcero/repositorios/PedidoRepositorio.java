package usp.edu.ec.FerreAcero.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import usp.edu.ec.FerreAcero.entidades.Pedido;


public interface PedidoRepositorio extends CrudRepository<Pedido, Integer> {

    @Query("select g  from Pedido g where g.id = :id")
    Pedido findPedidoById(int id);

    @Query("select g from Pedido  g where g.numero = :numero")
    Pedido findPedidoByNumero(int numero);

    @Query("select max(g.id) from Pedido g ")
    Integer findPedidoByMax();


}
