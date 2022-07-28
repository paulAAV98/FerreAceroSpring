package usp.edu.ec.FerreAcero.servicios;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usp.edu.ec.FerreAcero.entidades.FormaPago;
import usp.edu.ec.FerreAcero.repositorios.FormaPagoRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class FormaPagoServicio {
    @Autowired
    private FormaPagoRepositorio formapagoRepositorio;

    public List<FormaPago> findAll(){


        return (List<FormaPago>)formapagoRepositorio.findAll() ;
    }

    public String ConsultaDatos(int codigo){


        return (String) formapagoRepositorio.findFormaPagoByCodigo(codigo);
    }

    public FormaPago ConsultaDatosF(String tipo){
        return (FormaPago) formapagoRepositorio.findFormaPagoByTipo(tipo);
    }

    public void save(FormaPago formapago){

        formapagoRepositorio.save(formapago);
    }

    public Optional<FormaPago> findByCodigo(int codigo){
        return  (Optional<FormaPago>) formapagoRepositorio.findById(codigo);

    }

    public void delete(int id){formapagoRepositorio.deleteById(id);


    }
}
