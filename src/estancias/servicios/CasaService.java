
package estancias.servicios;

import estancias.entidades.Casa;
import estancias.persistencia.CasaDAO;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;


public class CasaService {
    private CasaDAO casaDAO;

    public CasaService(){
        casaDAO=new CasaDAO();
    }
    Scanner leer = new Scanner(System.in);
    public void imprimirCasas() throws Exception{
        
        try{
        List<Casa> casas = casaDAO.obtenerCasas();
        
        if(casas.isEmpty()){
            throw new Exception("No existen casas");
        } else{
            System.out.println("***Lista de Casas***");
            System.out.printf("%-15s%-25s%-25s%-25s%-25s%-25s%-25s%-25s%-25s%-25s%-25s%-25s\n","ID CASA","CALLE","NÚMERO","CODIGO POSTAL","CIUDAD", "PAIS", "FECHA DESDE", "FECHA HASTA", "TIEMPO MINIMO", "TIEMPO MAXIMO","PRECIO HABITACION", "TIPO VIVIENDA");
            for(Casa c: casas){
                System.out.println(""); 
                System.out.printf("%-15s%-25s%-25s%-25s%-25s%-25s%-25s%-25s%-25s%-25s%-25s%-25s\n",c.getId_casa(),c.getCalle(),c.getNumero(),c.getCodigo_postal(),c.getCiudad(),c.getPais(),c.getFecha_desde(),c.getFcha_hasta(),c.getTiempo_minimo(),c.getTiempo_maximo(),c.getPrecio_habitacion(),c.getTipo_vivienda());

            }
        }   
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new Exception ("Error al imprimir la lista de casas"); 
                }
    }  
    
    public void casasDisponiblesReinoUnido() throws Exception{
        
        try{
        List<Casa> casas = casaDAO.obtenerCasasReinoUnido();
        
        if(casas.isEmpty()){
            throw new Exception("No existen casas");
        } else{
            System.out.println("***Lista de Casas***");
            System.out.printf("%-15s%-25s%-25s%-25s%-25s%-25s%-25s%-25s%-25s%-25s%-25s%-25s\n","ID CASA","CALLE","NÚMERO","CODIGO POSTAL","CIUDAD", "PAIS", "FECHA DESDE", "FECHA HASTA", "TIEMPO MINIMO", "TIEMPO MAXIMO","PRECIO HABITACION", "TIPO VIVIENDA");
            for(Casa c: casas){
                System.out.println(""); 
                System.out.printf("%-15s%-25s%-25s%-25s%-25s%-25s%-25s%-25s%-25s%-25s%-25s%-25s\n",c.getId_casa(),c.getCalle(),c.getNumero(),c.getCodigo_postal(),c.getCiudad(),c.getPais(),c.getFecha_desde(),c.getFcha_hasta(),c.getTiempo_minimo(),c.getTiempo_maximo(),c.getPrecio_habitacion(),c.getTipo_vivienda());
            }
        }
        
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new Exception ("Error al imprimir la lista de casas"); 
                }
    }
    
    public void casasDisponiblesPersonalizado() throws Exception{
        System.out.print("Ingrese la fecha de llegada (AAAA-MM-DD):");
        String fecha_start=leer.next();
        System.out.print("Ingrese la cantidad de días:");
        Integer dias = leer.nextInt();
        
        try{ 
        List<Casa> casas = casaDAO.obtenerCasasPersonalizado(fecha_start, dias);
        
        if(casas.isEmpty()){
            throw new Exception("No existen casas");
        } else{
            System.out.println("***Lista de Casas***");
            System.out.printf("%-15s%-25s%-25s%-25s%-25s%-25s%-25s%-25s%-25s%-25s%-25s%-25s\n","ID CASA","CALLE","NÚMERO","CODIGO POSTAL","CIUDAD", "PAIS", "FECHA DESDE", "FECHA HASTA", "TIEMPO MINIMO", "TIEMPO MAXIMO","PRECIO HABITACION", "TIPO VIVIENDA");
            for(Casa c: casas){
                System.out.println(""); 
                System.out.printf("%-15s%-25s%-25s%-25s%-25s%-25s%-25s%-25s%-25s%-25s%-25s%-25s\n",c.getId_casa(),c.getCalle(),c.getNumero(),c.getCodigo_postal(),c.getCiudad(),c.getPais(),c.getFecha_desde(),c.getFcha_hasta(),c.getTiempo_minimo(),c.getTiempo_maximo(),c.getPrecio_habitacion(),c.getTipo_vivienda());
            }
        }
        
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new Exception ("Error al imprimir la lista de casas"); 
                }
    } 
    



}

    