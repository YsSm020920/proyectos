
package src;

import java.util.ArrayList;

public class ControladorPersona {
    
    
    public ArrayList<persona> listaPersona = new ArrayList<persona>();
   
    public void agregarPersona(persona p){
        
        listaPersona.add(p);
    }
    
    
    public persona buscarPersona(int id){
      
        persona encontrada = new persona();
       
        for(persona p : listaPersona){
            
            if(id == p.getId()){
                encontrada = p;
            }else{
                System.out.println("No existe el registro");
            }
        }
        return encontrada;
    }
    
    //actualizar los datos de la persona
    public void actualizarPersona(persona actualizada){
        persona actualizar = buscarPersona(actualizada.getId());
        
        listaPersona.remove(actualizar);
        
        //lo volvemos a meter
        listaPersona.add(actualizada);
    }
    
   
    public void eliminarPersona(persona eliminar){
        listaPersona.remove(eliminar);
    }

    public ArrayList<Persona> mostrarPersonas(){
        return listaPersona;
    }
    
    
    
}
    

