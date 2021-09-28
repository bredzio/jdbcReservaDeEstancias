
package estancias.persistencia;

import estancias.entidades.Casa;
import estancias.entidades.Familia;
import java.util.ArrayList;
import java.util.List;


public class FamiliaDAO extends DAO{
    
    
    public List<Familia> obtenerFamilias() throws Exception{
        try{
        String sql = "SELECT * FROM familias f Inner Join casas c on  f.id_casa_familia=c.id_casa;";
        consultarBase(sql);
        
        List<Familia> familias = new ArrayList();
        
        Familia familia = null;
        Casa casa =null;
        
        while (resultado.next()){
            familia= new Familia();
            casa = new Casa();
            
            casa.setId_casa(resultado.getInt(8));
            casa.setCalle(resultado.getString(9));
            casa.setNumero(resultado.getInt(10));
            casa.setCodigo_postal(resultado.getString(11));
            casa.setCiudad(resultado.getString(12));
            casa.setPais(resultado.getString(13));
            casa.setFecha_desde(resultado.getDate(14));
            casa.setFcha_hasta(resultado.getDate(15));
            casa.setTiempo_minimo(resultado.getInt(16));
            casa.setTiempo_maximo(resultado.getInt(17));
            casa.setPrecio_habitacion(resultado.getDouble(18));
            casa.setTipo_vivienda(resultado.getString(19));
           
            
            familia.setId(resultado.getInt(1));
            familia.setNombre(resultado.getString(2));
            familia.setEdad_minima(resultado.getInt(3));
            familia.setEdad_maxima(resultado.getInt(4));
            familia.setNum_hijos(resultado.getInt(5));
            familia.setEmail(resultado.getString(6));
            familia.setCasa(casa);
            
            familias.add(familia);
        }
        
        return familias;
    
    }catch(Exception e){
            System.out.println(e.getMessage());
            throw new Exception("Error al obtener familias");
        
    }finally{
            desconectarBase();
        }
      
    }
}