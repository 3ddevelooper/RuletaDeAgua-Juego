/*
 * Bienvenido, este es un mensaje auto-generado por Damian Dries
 * Damian Dries - JAVA DEV 
 * www.damiandries.com.ar
 */
package ejercicio02guia8rel.servicios;

import ejercicio02guia8rel.entidades.Jugador;
import ejercicio02guia8rel.entidades.Revolver;

/**
 *
 * @author Damian Dries - "www.damiandries.com.ar"
 */
public class RevolverServicio {

    
    public Revolver llenarRevolver() {
        int numa = (int) (Math.random() * 6)+1;
        int numb = (int) (Math.random() * 6)+1;
        return new Revolver(numa, numb);
    }
    
    private final Revolver r = llenarRevolver();
    
    public boolean mojar(Jugador j){
       
        if(r.getPosicionActual()==r.getPosicionAgua()){
            //Se muere el jugador, termina el juego
            System.out.println(toString() + "\nDispara......\nEl " + j.getNombre() + " se ha mojado.....☻\n");
            System.out.println("El juego ha terminado\n");
            j.setMojado(true);
            System.exit(0);
            return true;
            
        }else{
           System.out.println(toString() + "\nDispara......\nEl " + j.getNombre() + " se ha salvado.....☺\n");
           siguienteChorro();
           return false;
           
        
        }
        
    }
    
    public void siguienteChorro(){
       
       int num = r.getPosicionActual();
        if (r.getPosicionActual()==6){
           r.setPosicionActual(1);
        }else{
           r.setPosicionActual(num+1);
        }
    
    }
    
    @Override
    public String toString(){
        return "Posición Actual: "+r.getPosicionActual()+"   Posición del Agua: "+r.getPosicionAgua();
    }
    
    
}
