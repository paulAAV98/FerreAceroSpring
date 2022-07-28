package usp.edu.ec.FerreAcero.controladores;


import org.springframework.beans.factory.annotation.Autowired;
import usp.edu.ec.FerreAcero.entidades.*;
import usp.edu.ec.FerreAcero.servicios.PedidoServicio;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Gestion {

    private PedidoServicio pedidoServicio;

    @Autowired
    public void setPedidoServicio(PedidoServicio pedidoServicio) {
        this.pedidoServicio = pedidoServicio;

    }


    public int id_persona;
    public int id_pedido;

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public List<TarjetaCredito> listatajetas(List<TarjetaCredito> tarjetaCreditos, String cedula) {

        List<TarjetaCredito> listatajetas = new ArrayList<>();


        for (int i = 0; i < tarjetaCreditos.size(); i++) {

            if (tarjetaCreditos.get(i).getPersona().getCedula().equals(cedula)) {
                TarjetaCredito tar = new TarjetaCredito();

                tar.setId(tarjetaCreditos.get(i).getId());
                tar.setCCV(tarjetaCreditos.get(i).getCCV());
                tar.setFechaExp(tarjetaCreditos.get(i).getFechaExp());
                tar.setNumeroTarjeta(tarjetaCreditos.get(i).getNumeroTarjeta());
                tar.setTipoTarjeta(tarjetaCreditos.get(i).getTipoTarjeta());
                tar.setPersona(tarjetaCreditos.get(i).getPersona());

                listatajetas.add(tar);


            }
        }
        return listatajetas;
    }


    public List<String> sucurNombre(List<Sucursal> listas) {
        List<String> nombres = new ArrayList<>();
        for (int i = 0; i < listas.size(); i++) {
            nombres.add(listas.get(i).getNombre());
        }

        return nombres;
    }


    public List<String> categoriaNombre(List<Categoria> listasC) {
        List<String> nombresC = new ArrayList<>();
        for (int i = 0; i < listasC.size(); i++) {
            nombresC.add(listasC.get(i).getNombre());
        }

        return nombresC;
    }


    public List<String> sucurProducto(Sucursal sucursal, List<Producto> listasP) {
        List<String> nombresP = new ArrayList<>();

        for (int i = 0; i < listasP.size(); i++) {
            if (sucursal.getId() == listasP.get(i).getSucursal().getId()) {

                nombresP.add(listasP.get(i).getNombre());
            }

        }

        return nombresP;
    }



    public  List<String> productoCate (Categoria categoria,List<Producto> listasPC){

        List<String> nombresPC = new ArrayList<>();

        for (int i = 0; i < listasPC.size(); i++) {
            if (categoria.getId() == listasPC.get(i).getCategoria().getId()) {

                nombresPC.add(listasPC.get(i).getNombre());
            }

        }

        return nombresPC;
    }


    public  List<Producto> productoCate911 (Categoria categoria,List<Producto> listasPC){
        List<Producto> nombresPC = new ArrayList<>();

        for (int i=0; i < listasPC.size();i++){
            if (categoria.getId()==listasPC.get(i).getCategoria().getId()){

                Producto p2 = new Producto();

                p2.setNombre(listasPC.get(i).getNombre());
                p2.setMarca(listasPC.get(i).getMarca());
                p2.setPrecio(listasPC.get(i).getPrecio());

                nombresPC.add(p2);

            }

        }

        return nombresPC;
    }

    public String CalcularDistancia(Sucursal sucursal2, Direccion dir) {

        double latS = Double.parseDouble(sucursal2.getLatitud());
        double lonS = Double.parseDouble(sucursal2.getLongitud());

        double latD = dir.getLatitud();
        double lonD = dir.getLongitud();

        double R = 6378;

        double c = (Math.PI) / 180;

        double d=2*R*Math.asin(Math.sqrt(Math.pow(Math.sin(c*(latD-latS)/2),2)+Math.cos(c*latS)*Math.cos(c*latD)*Math.pow(Math.sin(c*(lonD-lonS)/2),2)));
        String dis=String.valueOf((d/10000)).concat(" KM");

        return dis;

    }





    public  List<Producto> sucurProducto911 (Sucursal sucursal,List<Producto> listasP2){
        List<Producto> nombresP2 = new ArrayList<>();

        for (int i=0; i < listasP2.size();i++){
            if (sucursal.getId()==listasP2.get(i).getSucursal().getId()){
                Producto p1 = new Producto();

                p1.setNombre(listasP2.get(i).getNombre());
                p1.setMarca(listasP2.get(i).getMarca());
                p1.setPrecio(listasP2.get(i).getPrecio());

                nombresP2.add(p1);


            }

        }

        return nombresP2;
    }


    public String CalcularPrecioEnvio(Sucursal sucursal2, Direccion dir) {

        double latS = Double.parseDouble(sucursal2.getLatitud());
        double lonS = Double.parseDouble(sucursal2.getLongitud());

        double latD = dir.getLatitud();
        double lonD = dir.getLongitud();

        double R = 6378;

        double c = (Math.PI) / 180;

        double d = 2 * R * Math.asin(Math.sqrt(Math.pow(Math.sin(c * (latD - latS) / 2), 2) + Math.cos(c * latS) * Math.cos(c * latD) * Math.pow(Math.sin(c * (lonD - lonS) / 2), 2)));

        double envio = 0;
        String dis = String.valueOf(d).concat(" KM");

        if((d/1000) < 1 ){
            envio = 0.70;

        } else if((d/1000) > 1 && (d/1000) <= 3){
            envio = 1.20;

        }else if((d/1000) > 3 && (d/1000) <= 5) {
            envio = 1.80;
        }

        else if((d/1000) > 5 && (d/1000) <= 8) {
            envio = 2.10;
        }

        else if((d/1000) > 8 && (d/1000) <= 10) {
            envio = 2.50;
        }
        return String.valueOf(envio);
    }

    public String IdCliente(Persona persona){

        int IdPersona = persona.getId();

        return String.valueOf(IdPersona);
    }





    public List<PedidoDetalle> agregarProductos(List<PedidoDetalle> pedidoDetalleList, Producto producto1, int cantidad) {

        PedidoDetalle pedidoDetalle = new PedidoDetalle();
        pedidoDetalle.setProducto(producto1);
        pedidoDetalle.setCantidad(cantidad);
        pedidoDetalle.setSubtotal(CalcularSubTotal(cantidad, producto1.getPrecio()));
        pedidoDetalleList.add(pedidoDetalle);
        return pedidoDetalleList;

    }

    public List<Pedido> agregarPedidosDetalles(List<Pedido> pedidoList, List<PedidoDetalle> pedidoDetalleList ){
        List<Pedido> pedidoList1 = new ArrayList<>();
        for (int i=0; i < pedidoDetalleList.size();i++){
            if (pedidoList.get(i).getId()==pedidoDetalleList.get(i).getPedido().getId()){
                Pedido pedido = new Pedido();
                pedido.setNumero(pedidoList.get(i).getNumero());
                pedido.setEstado(pedidoList.get(i).getEstado());
                pedido.setTotal(Total(pedidoDetalleList));
                pedido.setPersona(pedidoList.get(i).getPersona());


                pedidoList.add(pedido);


            }

        }

        return pedidoList;
    }

    public double CalcularSubTotal(int cantidad, double precio) {


        return cantidad * precio;
    }

    public double Total(List<PedidoDetalle> pedidoDetalleList) {

        double total = 0;

        for(int i = 0 ; i<pedidoDetalleList.size(); i++){

            total = total + pedidoDetalleList.get(i).getSubtotal();
        }

        return total;

    }

    /*
    public int IdAlto(){


        pedidoServicio.findAll();

        return id;
    }

    public List<Pedido> recuperarPedidos(){

        return
    }
    */

    public  List<Pedido> PedidoEstado ( String pedido ,List<Pedido> listasPC){

        List<Pedido> nombresPC = new ArrayList<>();

        for (int i = 0; i < listasPC.size(); i++) {
            if (pedido.equals(listasPC.get(i).getEstado())){

                Pedido ped= new Pedido();
                ped.setNumero(listasPC.get(i).getNumero());
                ped.setEstado(listasPC.get(i).getEstado());
                ped.setPersona(listasPC.get(i).getPersona());
                ped.setTotal(listasPC.get(i).getTotal());

                nombresPC.add(listasPC.get(i));


            }

        }

        return nombresPC;
    }
}


