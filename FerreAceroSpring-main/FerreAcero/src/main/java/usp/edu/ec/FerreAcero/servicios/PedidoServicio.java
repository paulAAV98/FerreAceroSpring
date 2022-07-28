package usp.edu.ec.FerreAcero.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usp.edu.ec.FerreAcero.entidades.Pedido;
import usp.edu.ec.FerreAcero.repositorios.PedidoRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServicio {

    @Autowired
    private PedidoRepositorio pedidoRepositorio;

    public List<Pedido> findAll(){

        return (List<Pedido>) pedidoRepositorio.findAll();
    }

    public int  findByPedidoMax(){

        return pedidoRepositorio.findPedidoByMax();
    }

    public Pedido ConsultaDatos(int id){

        return (Pedido) pedidoRepositorio.findPedidoById(id);
    }

    public Pedido ConsultaDatosPedido(int numero){

        return (Pedido) pedidoRepositorio.findPedidoByNumero(numero);
    }

    public void save(Pedido pedido){
        pedidoRepositorio.save(pedido);
    }

    public Optional<Pedido> findById(int id){

        return (Optional<Pedido>) pedidoRepositorio.findById(id);

    }

    public void delete(int id){
        pedidoRepositorio.deleteById(id);
    }

}
