
package estancias.servicios;

import estancias.entidades.Cliente;
import estancias.entidades.Estancia;
import estancias.persistencia.EstanciaDAO;
import java.util.List;


public class EstanciaService {
   private EstanciaDAO estanciaDAO;
    
    public EstanciaService(){
        estanciaDAO=new EstanciaDAO();
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
            
            //clienteDAO.guardarCliente(cliente);
            
        }catch(Exception e){
            System.out.println(e.getMessage());
            throw new Exception ("Error al crear el cliente");
        }
    }
    
        public void imprimirEstancias() throws Exception{
        try{
        List<Estancia> estancias = estanciaDAO.obtenerEstancias();
        
        if(estancias.isEmpty()){
            throw new Exception("No existen estancias");
        } else{
            System.out.println("***Lista de Estancias***");
            System.out.printf("%-15s%-25s%-25s%-25s%-25s%-25s\n","ID ESTANCIA","ID CLIENTE","ID CASA","NOMBRE HUESPED","FECHA DESDE", "FECHA HASTA");
            for(Estancia e: estancias){
                System.out.println(""); 
                System.out.printf("%-15s%-25s%-25s%-25s%-25s%-25s\n",e.getId_estancia(),e.getId_cliente().getId_cliente(),e.getId_casa().getId_casa(),e.getNombre_huesped(),e.getFecha_desde(),e.getFecha_hasta());

            }
        }   
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new Exception ("Error al imprimir la lista de estancias"); 
                }
    }  
        
        public void clienteQueRealizaronEstancia() throws Exception{
        
        try{
        List<Estancia> estancias = estanciaDAO.clienteQueRealizaronEstancia();
        
        if(estancias.isEmpty()){
            throw new Exception("No existen estancias");
        } else{
            System.out.println("***Lista de Estancias***");
            System.out.printf("%-15s%-25s%-25s%-25s%-25s%-25s%-25s%-25s%-25s%-25s%-25s\n","ID CLIENTE","NOMBRE","CALLE","NUMERO","CODIGO POSTAL", "CIUDAD","PAIS","EMAIL","ID CASA","PRECIO HABITACION","TIPO VIVIENDA");
            for(Estancia e: estancias){
                System.out.println(""); 
                System.out.printf("%-15s%-25s%-25s%-25s%-25s%-25s%-25s%-25s%-25s%-25s%-25s\n",e.getId_cliente().getId_cliente(),e.getId_cliente().getNombre(),e.getId_cliente().getCalle(),e.getId_cliente().getNumero(),e.getId_cliente().getCodigo_postal(),e.getId_cliente().getCiudad(),e.getId_cliente().getPais(),e.getId_cliente().getEmail(),e.getId_casa().getId_casa(),e.getId_casa().getPrecio_habitacion(),e.getId_casa().getTipo_vivienda());

            }
        }   
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new Exception ("Error al imprimir la lista de estancias"); 
                }
    }  
}
