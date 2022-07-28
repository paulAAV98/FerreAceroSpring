package usp.edu.ec.FerreAcero.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usp.edu.ec.FerreAcero.entidades.Carrito;
import usp.edu.ec.FerreAcero.entidades.Persona;
import usp.edu.ec.FerreAcero.entidades.Usuario;
import usp.edu.ec.FerreAcero.repositorios.CarritoRepositorio;
import usp.edu.ec.FerreAcero.repositorios.UsuarioRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicio {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public List<Usuario> findAll(){

        return (List<Usuario>) usuarioRepositorio.findAll();
    }

    public Usuario consultaDatos(int id){

        return (Usuario) usuarioRepositorio.findUsuarioById(id);
    }

    public void save(Usuario usuario){
        usuarioRepositorio.save(usuario);


    }

    public Optional<Usuario> findById(int id){

        return (Optional<Usuario>) usuarioRepositorio.findById(id);
    }

    public void delete(int id){usuarioRepositorio.deleteById(id);


    }

    public Usuario iniSesion(String clave,String usuario){

        return  (Usuario)usuarioRepositorio.IniSesion(clave,usuario);
    }


    public Usuario findByIdPer(int persona_id) {
        return  usuarioRepositorio.VerPersona(persona_id);
    }
}
