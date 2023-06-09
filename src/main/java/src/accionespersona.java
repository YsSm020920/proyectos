
package src;



    
import java.util.ArrayList;


public class accionespersona {
    
public ArrayList<Persona> listaPersonas = 
            new ArrayList<Persona>();
    
    public ArrayList<Persona> mostrarPersonas(){
        return listaPersonas;
    }
    
    public void agregarPersona(Persona p){
        listaPersonas.add(p);
    }
    
    
    public Persona buscarPersona(int id){
       
        Persona encontrada = new Persona();
        for(Persona p : listaPersonas){
            if(id == p.getId()){
                encontrada = p;
            }else{
                System.out.println("Persona no encontrada");
            }
        }
        return encontrada;
    }
    
    //actualizar a la persona
    public void actualizarPersona(Persona actualizada){
        //primero debo de buscarla
        Persona actualizar = buscarPersona(actualizada.getId());
        //primero borro lo que existe
        listaPersonas.remove(actualizar);
        //agrego lo nuevo
        listaPersonas.add(actualizar);
    }
    
    public void eliminarPersona(Persona eliminar){
        listaPersonas.remove(eliminar);
    }
   
    
    
    
}
    