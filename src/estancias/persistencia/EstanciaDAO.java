
package estancias.persistencia;

import estancias.entidades.Casa;
import estancias.entidades.Cliente;
import estancias.entidades.Estancia;
import java.util.ArrayList;
import java.util.List;


public class EstanciaDAO extends DAO{
   public void guardarEstancia(Estancia estancia) throws Exception{
        try{
        String plantilla="INSERT INTO estancias (id_estancia,id_cliente,id_casa,nombre_huesped,fecha_desde,fecha_hasta) " + "VALUES(%d,%d,%d,'%s','%s','%s');";
        String sql = String.format(plantilla, estancia.getId_estancia(),estancia.getId_cliente(),estancia.getId_casa(),estancia.getNombre_huesped(),estancia.getFecha_desde(),estancia.getFecha_hasta());
        
        insertarModificarEliminar(sql);
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new Exception ("Error al guardar la estancia");
        }
    }
    
    public void modificarEstancia (Estancia estancia) throws Exception{
        try{
        String plantilla="UPDATE estancias SET id_estancia = %d, id_cliente=%d, id_casa=%d, nombre_huesped='%s', fecha_desde='%s', fecha_hasta='%s';";
        
        String sql=String.format(plantilla, estancia.getId_cliente().getId_cliente(),estancia.getId_casa().getId_casa(),estancia.getNombre_huesped(),estancia.getFecha_desde(), estancia.getFecha_hasta());

        insertarModificarEliminar(sql);
  
            
        }catch(Exception e){
            System.out.println(e.getMessage());
            throw new Exception ("Error al modificar la estancia");
        }   
    }
    
    public List<Estancia> obtenerEstancias() throws Exception{
        try{
        /// Poner Inner Join
        String sql = "SELECT * FROM estancias e Inner Join casas c on  e.id_casa=c.id_casa Inner Join clientes cl on cl.id_cliente=e.id_cliente;";
        consultarBase(sql);
        
        List<Estancia> estancias = new ArrayList();
        
        Estancia estancia = null;
        Casa casa =null;
        Cliente cliente = null;
        
        while (resultado.next()){
            estancia= new Estancia();
            casa = new Casa();
            cliente = new Cliente();
            
            cliente.setId_cliente(resultado.getInt(19));
            cliente.setNombre(resultado.getString(20));
            cliente.setCalle(resultado.getString(21));
            cliente.setNumero(resultado.getInt(22));
            cliente.setCodigo_postal(resultado.getInt(23));
            cliente.setCiudad(resultado.getString(24));
            cliente.setPais(resultado.getString(25));
            cliente.setEmail(resultado.getString(26));
            
            casa.setId_casa(resultado.getInt(7));
            casa.setCalle(resultado.getString(8));
            casa.setNumero(resultado.getInt(9));
            casa.setCodigo_postal(resultado.getString(10));
            casa.setCiudad(resultado.getString(11));
            casa.setPais(resultado.getString(12));
            casa.setFecha_desde(resultado.getDate(13));
            casa.setFcha_hasta(resultado.getDate(14));
            casa.setTiempo_minimo(resultado.getInt(15));
            casa.setTiempo_maximo(resultado.getInt(16));
            casa.setPrecio_habitacion(resultado.getDouble(17));
            casa.setTipo_vivienda(resultado.getString(18));
            
            estancia.setId_estancia(resultado.getInt(1));
            estancia.setId_cliente(cliente);
            estancia.setId_casa(casa);
            estancia.setNombre_huesped(resultado.getString(4));
            estancia.setFecha_desde(resultado.getDate(5));
            estancia.setFecha_hasta(resultado.getDate(6));
            
            estancias.add(estancia);
        }
        
        return estancias;
    
    }catch(Exception e){
            System.out.println(e.getMessage());
            throw new Exception("Error al obtener estancias");
        
    }finally{
            desconectarBase();
        }
      
    } 
    
        public List<Estancia> clienteQueRealizaronEstancia() throws Exception{
        try{
        /// Poner Inner Join
        String sql = "SELECT * FROM estancias e Inner Join casas c on  e.id_casa=c.id_casa Inner Join clientes cl on cl.id_cliente=e.id_cliente;";
        consultarBase(sql);
        
        List<Estancia> estancias = new ArrayList();
        
        Estancia estancia = null;
        Casa casa =null;
        Cliente cliente = null;
        
        while (resultado.next()){
            estancia= new Estancia();
            casa = new Casa();
            cliente = new Cliente();
            
            cliente.setId_cliente(resultado.getInt(19));
            cliente.setNombre(resultado.getString(20));
            cliente.setCalle(resultado.getString(21));
            cliente.setNumero(resultado.getInt(22));
            cliente.setCodigo_postal(resultado.getInt(23));
            cliente.setCiudad(resultado.getString(24));
            cliente.setPais(resultado.getString(25));
            cliente.setEmail(resultado.getString(26));
            
            casa.setId_casa(resultado.getInt(7));
            casa.setCalle(resultado.getString(8));
            casa.setNumero(resultado.getInt(9));
            casa.setCodigo_postal(resultado.getString(10));
            casa.setCiudad(resultado.getString(11));
            casa.setPais(resultado.getString(12));
            casa.setFecha_desde(resultado.getDate(13));
            casa.setFcha_hasta(resultado.getDate(14));
            casa.setTiempo_minimo(resultado.getInt(15));
            casa.setTiempo_maximo(resultado.getInt(16));
            casa.setPrecio_habitacion(resultado.getDouble(17));
            casa.setTipo_vivienda(resultado.getString(18));
            
            estancia.setId_estancia(resultado.getInt(1));
            estancia.setId_cliente(cliente);
            estancia.setId_casa(casa);
            estancia.setNombre_huesped(resultado.getString(4));
            estancia.setFecha_desde(resultado.getDate(5));
            estancia.setFecha_hasta(resultado.getDate(6));
            
            estancias.add(estancia);
        }
        
        return estancias;
    
    }catch(Exception e){
            System.out.println(e.getMessage());
            throw new Exception("Error al obtener estancias");
        
    }finally{
            desconectarBase();
        }
      
    }  
 
}
