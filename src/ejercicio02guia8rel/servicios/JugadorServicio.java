/*
 * Bienvenido, este es un mensaje auto-generado por Damian Dries
 * Damian Dries - JAVA DEV 
 * www.damiandries.com.ar
 */
package ejercicio02guia8rel.servicios;

import ejercicio02guia8rel.entidades.Jugador;
import ejercicio02guia8rel.entidades.Revolver;
import java.util.ArrayList;

/**
 *
 * @author Damian Dries - "www.damiandries.com.ar"
 */
public class JugadorServicio {
   
    //Creamos un jugador
    public Jugador crearJugador(int id) {
        String nombre = "Jugador " + id;
        boolean mojado = false;
        return new Jugador(id, nombre, mojado);

    }
    
    //Metodo que replica el disparo del revolver
    public void disparo(RevolverServicio r, Jugador j,Revolver re){
        
        r.llenarRevolver();
        System.out.println("Turno de "+j.getNombre()+"\n");
        
        if(r.mojar(j)){ 
            j.setMojado(true);  
        }
        
    }

}
