
package estancias.servicios;

import estancias.entidades.Comentario;
import estancias.persistencia.ComentarioDAO;
import java.util.List;


public class ComentarioService {
    private ComentarioDAO comentarioDAO;
    
    public ComentarioService(){
        comentarioDAO=new ComentarioDAO();
    }
    
    public void imprimirCasas() throws Exception{
        
        try{
        List<Comentario> comentarios = comentarioDAO.obtenerComentarios();
        
        if(comentarios.isEmpty()){
            throw new Exception("No existen comentarios");
        } else{
            System.out.println("***Lista de Comentarios***");
            System.out.printf("%-15s%-25s%-25s\n","ID COMENTARIO","ID CASA","COMENTARIO");
            for(Comentario c: comentarios){
                System.out.println(""); 
                System.out.printf("%-15s%-25s%-25s\n",c.getId_comentario(),c.getCasa().getId_casa(),c.getComentario());

            }
        }   
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new Exception ("Error al imprimir la lista de casas"); 
                }
    }  
}
