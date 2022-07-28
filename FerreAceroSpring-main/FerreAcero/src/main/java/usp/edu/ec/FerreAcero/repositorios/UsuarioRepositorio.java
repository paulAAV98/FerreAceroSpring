package usp.edu.ec.FerreAcero.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import usp.edu.ec.FerreAcero.entidades.CarritoDetalle;
import usp.edu.ec.FerreAcero.entidades.Usuario;

public interface UsuarioRepositorio extends CrudRepository<Usuario, Integer> {

    @Query("select d from Usuario d where d.id = :id")
    Usuario findUsuarioById(int id);


    @Query("select d from Usuario d where d.clave = :clave and d.usuario=:usuario")
    Usuario IniSesion(String clave,String usuario);

    @Query("select d from Usuario d where d.persona.id = :persona_id")
    Usuario VerPersona(int persona_id);
}
