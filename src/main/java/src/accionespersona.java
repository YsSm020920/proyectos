/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

/**
 *
 * @author Yisell
 */
public class accionespersona {
    
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author demon
 */
public class AccionesPersona {
    
    //sirven principalmente para realizar un CRUD
    
    /*
    vamos a necesitar un objeto capaz de ser dinamico
    para poder almacenar diferentes tipos de variables
    que pertenecen al objeto de persona
    
    ArrayList
    */
    public ArrayList<Persona> listaPersonas = 
            new ArrayList<Persona>();
    
    //los metodos del crud
    
    //listar a las personas
    public ArrayList<Persona> mostrarPersonas(){
        return listaPersonas;
    }
    
    //metodo para agregar persona
    public void agregarPersona(Persona p){
        listaPersonas.add(p);
    }
    
    //como voy a buscar a una persona
    public Persona buscarPersona(int id){
        //necesito mi instancia de persona
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
    
    
    //ahi hacen los metodos de busqueda por nombre y appat
    
    
    
}
    
}
