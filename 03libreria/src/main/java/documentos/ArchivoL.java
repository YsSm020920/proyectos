
package documentos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;


public class ArchivoL implements Serializable {
    
    ArrayList<CLibro> listarecuperada = new ArrayList<CLibro>();
    
    //aqui es donde tenemos el manejor de archivos por separado
    public ArrayList<CLibro> leer(){
        try{
            
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("libro.txt"))) {
                listarecuperada = (ArrayList<CLibro>)in.readObject();
            }
        
        }catch(IOException | ClassNotFoundException e){
            System.out.println("Esperando ..... " + e.getMessage());
        
        }
        return listarecuperada;
    }
    
    void serializar(ArrayList<CLibro> listaseriar){
        try{
            FileOutputStream out = new FileOutputStream("libro.txt");
            try (ObjectOutputStream objout = new ObjectOutputStream(out)) {
                objout.writeObject(listaseriar);
            }
        
        }catch(IOException e){
            System.out.println("Error ... "+ e.getMessage());
        
        }
    }

    void serializar(ArrayList<CLibro> listarevista) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}