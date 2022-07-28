package usp.edu.ec.FerreAcero.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import usp.edu.ec.FerreAcero.entidades.FormaPago;

public interface FormaPagoRepositorio extends CrudRepository<FormaPago, Integer> {
    @Query("Select f.tipo,f.id from FormaPago f where f.id= :id")
    String findFormaPagoByCodigo(int id);

    @Query("Select f from FormaPago f where f.tipo= :tipo")
    FormaPago findFormaPagoByTipo(String tipo);

    @Query("Delete from FormaPago f where f.id= :id")
    FormaPago deleteFormaPagoByTipo(int id);
}
