
package estancias.servicios;

import estancias.entidades.Familia;
import estancias.persistencia.FamiliaDAO;
import java.util.List;

public class FamiliaService {
    private FamiliaDAO familiaDAO;
    
    public FamiliaService(){
        familiaDAO = new FamiliaDAO();
    }
    
    
    
    public void imprimirFamilias() throws Exception{
        try{
        List<Familia> familias = familiaDAO.obtenerFamilias();
        
        if(familias.isEmpty()){
            throw new Exception("No existen familias");
        } else{
            System.out.println("***Lista de Familias***");
            System.out.printf("%-15s%-15s%-15s%-15s%-25s%-25s%-15s\n","ID FAMILIA","NOMBRE","EDAD MINIMA","EDAD MAXIMA","CANTIDAD DE HIJOS", "EMAIL","ID CASA FAMILIA");
            for(Familia f: familias){
                System.out.println(""); 
                System.out.printf("%-15s%-15s%-15s%-15s%-25s%-25s%-15s\n",f.getId(),f.getNombre(),f.getEdad_minima(),f.getEdad_maxima(),f.getNum_hijos(), f.getEmail(),f.getCasa().getId_casa());

            }
        }   
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new Exception ("Error al imprimir la lista de familias"); 
                }
    }
    
    
    public void Familias3hijos() throws Exception{
        try{
        List<Familia> familias = familiaDAO.obtenerFamilias();
        
        if(familias.isEmpty()){
            throw new Exception("No existen familias");
        } else{
            System.out.println("***Lista de Familias***");
            System.out.printf("%-15s%-15s%-15s%-15s%-25s%-25s%-15s\n","ID FAMILIA","NOMBRE","EDAD MINIMA","EDAD MAXIMA","CANTIDAD DE HIJOS", "EMAIL","ID CASA FAMILIA");
            for(Familia f: familias){
                if(f.getNum_hijos()>=3 && f.getEdad_maxima()<10){
                    System.out.println(""); 
                    System.out.printf("%-15s%-15s%-15s%-15s%-25s%-25s%-15s\n",f.getId(),f.getNombre(),f.getEdad_minima(),f.getEdad_maxima(),f.getNum_hijos(), f.getEmail(),f.getCasa().getId_casa());
  
                }
            }
        }   
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new Exception ("Error al imprimir la lista de familias"); 
                }
    }
    
        public void FamiliasHotmail() throws Exception{
        try{
        List<Familia> familias = familiaDAO.obtenerFamilias();
        
        if(familias.isEmpty()){
            throw new Exception("No existen familias");
        } else{
            System.out.println("***Lista de Familias***");
            System.out.printf("%-15s%-15s%-15s%-15s%-25s%-25s%-15s\n","ID FAMILIA","NOMBRE","EDAD MINIMA","EDAD MAXIMA","CANTIDAD DE HIJOS", "EMAIL","ID CASA FAMILIA");
            for(Familia f: familias){
                if(f.getEmail().contains("hotmail")){
                    System.out.println(""); 
                    System.out.printf("%-15s%-15s%-15s%-15s%-25s%-25s%-15s\n",f.getId(),f.getNombre(),f.getEdad_minima(),f.getEdad_maxima(),f.getNum_hijos(), f.getEmail(),f.getCasa().getId_casa());
  
                }
            }
        }   
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new Exception ("Error al imprimir la lista de familias"); 
                }
    }
    
    
    
}
