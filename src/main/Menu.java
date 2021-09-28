
package main;

import estancias.servicios.CasaService;
import estancias.servicios.ClienteService;
import estancias.servicios.EstanciaService;
import estancias.servicios.FamiliaService;
import java.util.Scanner;


public class Menu {
    
    private Menu menu;
    
    public void ejecutarMenu(){
    CasaService casaService = new CasaService();
    FamiliaService familiaService = new FamiliaService();
    ClienteService clienteService = new ClienteService();
    EstanciaService estanciaService = new EstanciaService();
    
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    Integer opcion=0;
    try{
        do {
            System.out.println("***MENU***");
            System.out.println("1.Listar aquellas familias que tienen al menos 3 hijos, y con edad máxima inferior a 10 años");
            System.out.println("2.Buscar y listar las casas disponibles para el periodo comprendido entre el 1 de agosto de 2020 y el 31 de agosto de 2020 en Reino Unido.");
            System.out.println("3.Encuentra todas aquellas familias cuya dirección de mail sea de Hotmail");
            System.out.println("4.Consulta la BD para que te devuelva aquellas casas disponibles a partir de una fecha dada y un número de días específico");
            System.out.println("5.Listar los datos de todos los clientes que en algún momento realizaron una estancia y la descripción de la casa donde la realizaron");
            System.out.println("6.Listar todas las estancias que han sido reservadas por un cliente, mostrar el nombre, país y ciudad del cliente y además la información de la casa que reservó. La que reemplazaría a la anterior");
            System.out.println("7.Debido a la devaluación de la libra esterlina con respecto al euro se desea incrementar el precio por día en un 5% de todas las casas del Reino Unido. Mostar los precios actualizados");
            System.out.println("8.Obtener el número de casas que existen para cada uno de los países diferentes");
            System.out.println("9.Busca y listar aquellas casas del Reino Unido de las que se ha dicho de ellas (comentarios) que están ‘limpias’");
            System.out.println("10.Insertar nuevos datos en la tabla estancias verificando la disponibilidad de las fechas");
            System.out.println("11.Salir");
            System.out.print("Seleccione una opción:");
            opcion=leer.nextInt();  
            switch (opcion) {
                case 1:
                    familiaService.Familias3hijos();
                    break;
                case 2:
                    casaService.casasDisponiblesReinoUnido();
                    break;
                case 3:
                    familiaService.FamiliasHotmail();
                    break;
                case 4:
                    casaService.casasDisponiblesPersonalizado();
                    break;
                case 5:
                    estanciaService.clienteQueRealizaronEstancia();
                    break;
                default:
                    System.out.println("Seleccionó una opción incorrecta");
                    break;
            }
            } while (opcion != 11);
    }catch(Exception e){    
        leer.nextLine();
        System.out.println(e.getMessage());
    }
    
    }
}
