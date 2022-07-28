package usp.edu.ec.FerreAcero.servicios;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usp.edu.ec.FerreAcero.entidades.Pedido;
import usp.edu.ec.FerreAcero.entidades.PedidoDetalle;
import usp.edu.ec.FerreAcero.repositorios.PedidoDetalleRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoDetalleServicio {

    @Autowired
    private PedidoDetalleRepositorio pedidoDetalleRepositorio;

    @Autowired
    private ProductoServicio productoServicio;

    public List<PedidoDetalle> findAll(){

        return (List<PedidoDetalle>) pedidoDetalleRepositorio.findAll();

    }

    public PedidoDetalle ConsultaDatos(int id){

        return (PedidoDetalle) pedidoDetalleRepositorio.findPedidoDetalleById(id);

    }

    public void save(PedidoDetalle pedidoDetalle){

        pedidoDetalleRepositorio.save(pedidoDetalle);

    }

    public Optional<PedidoDetalle> findById(int id){

        return (Optional<PedidoDetalle>) pedidoDetalleRepositorio.findById(id);
    }

    public void delete(int id){

        pedidoDetalleRepositorio.deleteById(id);

    }

}
