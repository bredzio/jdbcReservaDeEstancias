
package estancias.persistencia;

import estancias.entidades.Casa;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


public class CasaDAO extends DAO{

    
    public List<Casa> obtenerCasas() throws Exception{
        try{
        String sql = "SELECT * FROM casas;";
        consultarBase(sql);
        
        List<Casa> casas = new ArrayList();
        
        Casa casa = null;
        
        while (resultado.next()){
            casa= new Casa();
            
            casa.setId_casa(resultado.getInt(1));
            casa.setCalle(resultado.getString(2));
            casa.setNumero(resultado.getInt(3));
            casa.setCodigo_postal(resultado.getString(4));
            casa.setCiudad(resultado.getString(5));
            casa.setPais(resultado.getString(6));
            casa.setFecha_desde(resultado.getDate(7));
            casa.setFcha_hasta(resultado.getDate(8));
            casa.setTiempo_minimo(resultado.getInt(9));
            casa.setTiempo_maximo(resultado.getInt(10));
            casa.setPrecio_habitacion(resultado.getDouble(11));
            casa.setTipo_vivienda(resultado.getString(12));
            
            casas.add(casa);
        }
        
        return casas;
    
    }catch(Exception e){
            System.out.println(e.getMessage());
            throw new Exception("Error al obtener casas");
        
    }finally{
            desconectarBase();
        }
      
    } 

    public List<Casa> obtenerCasasReinoUnido() throws Exception{
        try{
        String sql = "SELECT * FROM casas where pais='Reino Unido' and fecha_desde BETWEEN '2020-08-01' AND '2020-08-31';";
        consultarBase(sql);
        
        List<Casa> casas = new ArrayList();
        
        Casa casa = null;
        
        while (resultado.next()){
            casa= new Casa();
            
            casa.setId_casa(resultado.getInt(1));
            casa.setCalle(resultado.getString(2));
            casa.setNumero(resultado.getInt(3));
            casa.setCodigo_postal(resultado.getString(4));
            casa.setCiudad(resultado.getString(5));
            casa.setPais(resultado.getString(6));
            casa.setFecha_desde(resultado.getDate(7));
            casa.setFcha_hasta(resultado.getDate(8));
            casa.setTiempo_minimo(resultado.getInt(9));
            casa.setTiempo_maximo(resultado.getInt(10));
            casa.setPrecio_habitacion(resultado.getDouble(11));
            casa.setTipo_vivienda(resultado.getString(12));
            
            casas.add(casa);
        }
        
        return casas;
    
    }catch(Exception e){
            System.out.println(e.getMessage());
            throw new Exception("Error al obtener casas");
        
    }finally{
            desconectarBase();
        }
      
    } 

    public List<Casa> obtenerCasasPersonalizado(String fecha_start, Integer dias) throws Exception{
        try{
        String sql = "SELECT * FROM casas WHERE fecha_desde>'"+fecha_start+"' and tiempo_minimo<="+dias+" and tiempo_maximo>="+dias+";";
        consultarBase(sql);
        
        List<Casa> casas = new ArrayList();
        
        Casa casa = null;
        
        while (resultado.next()){
            casa= new Casa();
            
            casa.setId_casa(resultado.getInt(1));
            casa.setCalle(resultado.getString(2));
            casa.setNumero(resultado.getInt(3));
            casa.setCodigo_postal(resultado.getString(4));
            casa.setCiudad(resultado.getString(5));
            casa.setPais(resultado.getString(6));
            casa.setFecha_desde(resultado.getDate(7));
            casa.setFcha_hasta(resultado.getDate(8));
            casa.setTiempo_minimo(resultado.getInt(9));
            casa.setTiempo_maximo(resultado.getInt(10));
            casa.setPrecio_habitacion(resultado.getDouble(11));
            casa.setTipo_vivienda(resultado.getString(12));
            
            casas.add(casa);
        }
        
        return casas;
    
    }catch(Exception e){
            System.out.println(e.getMessage());
            throw new Exception("Error al obtener casas");
        
    }finally{
            desconectarBase();
        }
      
    } 
}
