package usp.edu.ec.FerreAcero.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import usp.edu.ec.FerreAcero.entidades.Persona;
import usp.edu.ec.FerreAcero.entidades.TarjetaCredito;

public interface TarjetaRepositorio extends CrudRepository<TarjetaCredito, Integer> {

    @Query("Select t from TarjetaCredito t where t.id= :id")
    TarjetaCredito findTarjetaCreditoById(int id);


    @Query("Select t from TarjetaCredito t where t.NumeroTarjeta= :numeroTarjeta")
    TarjetaCredito findTarjetaCreditoByNumeroTarjeta(String numeroTarjeta);











}
