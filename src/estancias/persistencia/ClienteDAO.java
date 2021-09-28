
package estancias.persistencia;

import estancias.entidades.Cliente;
import java.util.ArrayList;
import java.util.List;


public class ClienteDAO extends DAO{
    
    public void guardarCliente(Cliente cliente) throws Exception{
        try{
        String plantilla="INSERT INTO clientes (id_cliente,nombre,calle,numero,codigo_postal,ciudad,pais,email) " + "VALUES(%d,'%s','%s',%d,%d,'%s','%s');";
        String sql = String.format(plantilla, cliente.getId_cliente(),cliente.getNombre(),cliente.getCalle(),cliente.getNumero(),cliente.getCodigo_postal(), cliente.getCiudad(), cliente.getPais(), cliente.getEmail());
        
        insertarModificarEliminar(sql);
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new Exception ("Error al guardar el cliente");
        }
    }
    
    public void modificarCliente (Cliente cliente) throws Exception{
        try{
        String plantilla="UPDATE clientes SET id_cliente = %d, nombre='%s', calle='%s', numero=%d, codigo_postal=%d, ciudad='%s', pais='%s', email='%s';";
        
        String sql=String.format(plantilla, cliente.getId_cliente(), cliente.getNombre(),cliente.getCalle(), cliente.getNumero(),cliente.getCodigo_postal(), cliente.getCiudad(), cliente.getPais(), cliente.getEmail());

        insertarModificarEliminar(sql);
  
            
        }catch(Exception e){
            System.out.println(e.getMessage());
            throw new Exception ("Error al modificar la familia");
        }   
    }
    
    public List<Cliente> obtenerClientes() throws Exception{
        try{
        String sql = "SELECT * FROM clientes;";
        consultarBase(sql);
        
        List<Cliente> clientes = new ArrayList();
        
        Cliente cliente = null;
        
        while (resultado.next()){
            cliente= new Cliente();
            
            cliente.setId_cliente(resultado.getInt(1));
            cliente.setNombre(resultado.getString(2));
            cliente.setCalle(resultado.getString(3));
            cliente.setNumero(resultado.getInt(4));
            cliente.setCodigo_postal(resultado.getInt(5));
            cliente.setCiudad(resultado.getString(6));
            cliente.setPais(resultado.getString(7));
            cliente.setEmail(resultado.getString(8));
            
            clientes.add(cliente);
        }
        
        return clientes;
    
    }catch(Exception e){
            System.out.println(e.getMessage());
            throw new Exception("Error al obtener clientes");
        
    }finally{
            desconectarBase();
        }
      
    }   
    
        
    
    
    
}
