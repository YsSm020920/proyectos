
package documentos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class revista implements Serializable{
    
    private ArrayList<CLibro> listarevista;
    
    //mandar a llamar a mis archivos
    private ArchivoL objarchivo = new ArchivoL();
    
    
    public revista {
        //voy a inicializar los dos objetos privados
        listarevista = new ArrayList<>();
        //sobrecargar el objeto
        listarevista = objarchivo.leer();
    }
    
    //ya viene el CRUD
    
    public void agregarLibro(){
        Scanner entrada = new Scanner(System.in);
        char resp = 's';
        
        while(resp == 's'){
            
            
            CLibro objlibro = new CLibro();
            objlibro.aceptaDatos();
            
            listarevista.add(objlibro);
            System.out.println("Revista agregada");
            System.out.println("¿Desea agregar otra revista? (s/n)");
            resp = entrada.next().charAt(0);
        }
    }
    
    public void consultaGral(){
       
        if(listarevista.isEmpty()){
            System.out.println("No hay revistas registradas");
        }else{
            System.out.println("Las revistas son:\n");
           
            for(int i = 0; i<listarevista.size(); i++){
               
                System.out.println("revista: " + listarevista.get(i).getNombre()+ "\n"
                                 + "Editor: " + listarevista.get(i).getAutor()+ "\n"
                                 + "Editorial: " + listarevista.get(i).getEditorial()+ "\n"
                                 + "Precio: " + listarevista.get(i).getPrecio()+ "\n");
              
            }
            
        }
    }
    

    
    
    private int traePosicion(String nombreBuscar){
        int pos = 0;
        boolean existe = false;
        
    
        for(int i = 0; i < listarevista.size(); i++){
            if(nombreBuscar.equals(listarevista.get(i).getNombre())){
                pos = i;
                existe = true;
            }else{
                System.out.println("revista no encontrada");
            }
        }
        if(!existe){
            System.out.println("No existe el registro de dicha revista");
            pos = -1;
        }
        return pos;
    }

    public int buscar(){
        int posBuscando = 0;
        String nombreBusca;
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Ingresa el nombre la revista a buscar");
        nombreBusca = entrada.nextLine();
    
        posBuscando = traePosicion(nombreBusca);
        
        //mando imprimir
        
        System.out.println("Nombre: " + listarevista.get(posBuscando).getNombre());
        System.out.println("Editorial: " + lista.get(posBuscando).getEditorial());
        System.out.println("Precio: " + listarevista.get(posBuscando).getPrecio());
        System.out.println("Editor: " + listarevista.get(posBuscando).getEditor());
        System.out.println("ID: " + listarevista.get(posBuscando));
        
        return posBuscando;
    }
    
    //vamos a borrar
    
    public void borrar(){
        Scanner entrada = new Scanner(System.in);
        String revistaBorrar;
        int posBorrar;
        
    
        if(listarevista.isEmpty()){
            System.out.println("No hay revistas registradas");
        }else{
           
            System.out.println("Eleccion para borrar");
            posBorrar = buscar();
           
            if(posBorrar < listarevista.size()){
                listarevista.remove(posBorrar);
                System.out.println("Revista Borrada correctamente");
            }
        }
    }
    
    //modificar
    
    public void modificar(){
        int posModificar = 0;
        int resMods = 0;
        String nombreModificar;
        String opcion = "s";
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Ingresa el nombre la revista modificar");
        nombreModificar = entrada.nextLine();
        
        //necesito un bucle para repita el proceso
        while("s".equals(opcion)){
            posModificar = traePosicion(nombreModificar);
            //verificando que la lista no este vacia
            if(posModificar <= 0);
            
            //cuando no esta vacia
                System.out.println("¿Que dato es el que deseas modificar?");
                System.out.println("1.- Editor");
                System.out.println("2.- Editorial");
                System.out.println("3.- Precio");
                
                resMods = entrada.nextInt();
                
                switch (resMods) {
                    case 1 -> {
                        System.out.println("El Editor es: ");
                        System.out.println(listarevista.get(posModificar).getAutor() + "\n");
                        System.out.println("Ingresa el nuevo Editor: ");
                       
                        listarevista.get(posModificar).setAutor(entrada.next());
                        System.out.println("El dato a sido modificado");
                      
                        System.out.println("Editor: " + listarevista.get(posModificar).getAutor());
                }
                        
                    case 2 -> {
                        System.out.println("El editorial es: ");
                        System.out.println(listarevista.get(posModificar).getEditorial()+ "\n");
                        System.out.println("Ingresa la nueva editorial: ");
                        //tengo que enviar el nuevo dato
                        listarevista.get(posModificar).setEditorial(entrada.next());
                        System.out.println("El dato a sido modificado");
                        //el nuevo dato es
                        System.out.println("Editorial: " + listarevista.get(posModificar).getEditorial());
                }
                        
                    case 3 -> {
                        System.out.println("El precio: ");
                        System.out.println(listarevista.get(posModificar).getPrecio()+ "\n");
                        System.out.println("Ingresa el nuevo precio: ");
                        //tengo que enviar el nuevo dato
                        listarevista.get(posModificar).setPrecio(entrada.nextFloat());
                        System.out.println("El dato a sido modificado");
                        //el nuevo dato es
                        System.out.println("Precio: " + listarevista.get(posModificar).getPrecio());
                }
                    
                }
                
                System.out.println("¿Quieres cambiar mas datos?");
                opcion = entrada.nextLine();
            
        }
    }

    public ArrayList<CLibro> getListarevista() {
        return listarevista;
    }

    public void setListarevista(ArrayList<CLibro> listarevista) {
        this.listarevista = listarevista;
    }

    public ArchivoL getObjarchivo() {
        return objarchivo;
    }

    public void setObjarchivo(ArchivoL objarchivo) {
        this.objarchivo = objarchivo;
    }
    
    //el metodo que se encarga de grabar los datos
    public void grabar(){
        getObjarchivo().serializar(listarevista);
    }

    void agregarrevista() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
    

