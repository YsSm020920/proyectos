
package documentos;

/**
 *
 * @author Yisell
 */

    
 import java.util.*;
import java.io.*;

import java.io.Serializable;

import java.io.Serializable;

public class ListaLibros implements Serializable{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //CRUD
        Scanner leer = new Scanner(System.in);
    
        revista objlista = new revista();
        
        int opcion;
        
        do{ 
            
            System.out.println("Elija la opcion deseada");
            System.out.println("1.- Agregar un nuevo revista");
            System.out.println("2.- Consultar revista");
            System.out.println("3.- Consultar todos los revista");
            System.out.println("4.- Borrar un revista");
            System.out.println("5.- Modificar un revista");
            System.out.println("6.- Salir");
            
            opcion = leer.nextInt();
            
            switch (opcion) {
                case 1:
                    objlista.agregarrevista();
                    
                    break;
                case 2:
                    objlista.buscar();
                    
                    break;    
                case 3:
                    objlista.consultaGral();
                    
                    break;
                case 4:
                    objlista.borrar();
                    
                    break;
                case 5:
                    objlista.modificar();
                    
                    break;
                case 6:
                    System.out.println("Se genera el archivo al salir");
                    objlista.grabar();
                    break;
                default:
                    System.out.println("Error");
            }
        
        }while((opcion>=1) && (opcion<6));
        
    }
    
}

