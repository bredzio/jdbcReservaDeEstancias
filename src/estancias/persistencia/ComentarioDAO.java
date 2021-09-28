
package estancias.persistencia;

import estancias.entidades.Casa;
import estancias.entidades.Comentario;
import java.util.ArrayList;
import java.util.List;


public class ComentarioDAO extends DAO{
    public List<Comentario> obtenerComentarios() throws Exception{
        try{
        /// Poner Inner Join
        String sql = "SELECT * FROM comentarios com Inner Join casas cas on com.id_casa=cas.id_casa;";
        consultarBase(sql);
        
        List<Comentario> comentarios = new ArrayList();
        
        Comentario comentario = null;
        Casa casa =null;
        while (resultado.next()){
            comentario= new Comentario();
            casa=new Casa();
            
            casa.setId_casa(resultado.getInt(4));
            casa.setCalle(resultado.getString(5));
            casa.setNumero(resultado.getInt(6));
            casa.setCodigo_postal(resultado.getString(7));
            casa.setCiudad(resultado.getString(8));
            casa.setPais(resultado.getString(9));
            casa.setFecha_desde(resultado.getDate(10));
            casa.setFcha_hasta(resultado.getDate(11));
            casa.setTiempo_minimo(resultado.getInt(12));
            casa.setTiempo_maximo(resultado.getInt(13));
            casa.setPrecio_habitacion(resultado.getDouble(14));
            casa.setTipo_vivienda(resultado.getString(15));
            
            comentario.setId_comentario(resultado.getInt(1));
            comentario.setCasa(casa);
            comentario.setComentario(resultado.getString(3));
            
            comentarios.add(comentario);
        }
        
        return comentarios;
    
    }catch(Exception e){
            System.out.println(e.getMessage());
            throw new Exception("Error al obtener comentarios");
        
    }finally{
            desconectarBase();
        }
      
    }     
}
