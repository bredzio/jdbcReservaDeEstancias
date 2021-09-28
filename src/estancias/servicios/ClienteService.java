
package estancias.servicios;

import estancias.entidades.Cliente;
import estancias.persistencia.ClienteDAO;
import java.util.List;


public class ClienteService {
    private ClienteDAO clienteDAO;
    
    public ClienteService(){
        clienteDAO=new ClienteDAO();
    }
    
    public void crearCliente(Integer id_cliente, String nombre, 
            String calle, Integer numero, Integer codigo_postal, 
            String ciudad, String pais, String email) throws Exception{
        try{
            if (id_cliente == null){
                throw new Exception("Debe ingresar un id");
            }
            
            if(nombre==null||nombre.trim().isEmpty()){
                throw new Exception("Debe ingresar un nombre");
            }
            
            if(calle==null || calle.trim().isEmpty()){
                throw new Exception("Debe ingresar la calle");
            }
            
            if(numero==null){
                throw new Exception("Debe ingresar el número de calle");
            }
            
            if(codigo_postal==null){
                throw new Exception("Debe ingresar el codigo postal");
            }
            
            if(ciudad==null || ciudad.trim().isEmpty()){
                throw new Exception("Debe ingresar la ciudad");
            }
            
            if(pais==null || pais.trim().isEmpty()){
                throw new Exception("Debe ingresar el país");
            }
            
            if(email==null || email.trim().isEmpty()){
                throw new Exception("Debe ingresar un email");
            }
            
            Cliente cliente = new Cliente();
            
            cliente.setId_cliente(id_cliente);
            cliente.setNombre(nombre);
            cliente.setCalle(calle);
            cliente.setNumero(numero);
            cliente.setCodigo_postal(codigo_postal);
            cliente.setCiudad(ciudad);
            cliente.setPais(pais);
            cliente.setEmail(email);
            
            clienteDAO.guardarCliente(cliente);
            
        }catch(Exception e){
            System.out.println(e.getMessage());
            throw new Exception ("Error al crear el cliente");
        }
    }
    
        public void imprimirClientes() throws Exception{
        try{
        List<Cliente> clientes = clienteDAO.obtenerClientes();
        
        if(clientes.isEmpty()){
            throw new Exception("No existen clientes");
        } else{
            System.out.println("***Lista de Clientes***");
            System.out.printf("%-15s%-25s%-25s%-15s%-25s%-25s%-25s%-25s\n","ID CLIENTE","NOMBRE","CALLE","NÚMERO","CODIGO POSTAL", "CIUDAD","PAIS","EMAIL");
            for(Cliente c: clientes){
                System.out.println(""); 
                System.out.printf("%-15s%-25s%-25s%-15s%-25s%-25s%-25s%-25s\n",c.getId_cliente(),c.getNombre(),c.getCalle(),c.getNumero(),c.getCodigo_postal(),c.getCiudad(),c.getPais(),c.getEmail());

            }
        }   
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new Exception ("Error al imprimir la lista de familias"); 
                }
    }
        
    
    
}
