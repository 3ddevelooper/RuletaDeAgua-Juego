/*
 * Bienvenido, este es un mensaje auto-generado por Damian Dries
 * Damian Dries - JAVA DEV 
 * www.damiandries.com.ar
 */
package ejercicio02guia8rel.servicios;

import ejercicio02guia8rel.entidades.Juego;
import ejercicio02guia8rel.entidades.Jugador;
import ejercicio02guia8rel.entidades.Revolver;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Damian Dries - "www.damiandries.com.ar"
 */
public class JuegoServicio {

    Juego juego = llenarJuego();
    

    //Construcctor del juego 
    private Juego llenarJuego() {
        RevolverServicio rs = new RevolverServicio();
        ArrayList<Jugador> jugadores = crearJugadores();
        Revolver revolver = rs.llenarRevolver();
        return new Juego(jugadores, revolver);
    }

    //Crea la lista de jugadores
    private ArrayList<Jugador> crearJugadores() {

        JugadorServicio js = new JugadorServicio();
        ArrayList<Jugador> jugadores = new ArrayList<>();

        Scanner read = new Scanner(System.in);
        System.out.println("Ingrese el numuero de jugadores, debe ser entre 1 y 6");

        int numJugadores = read.nextInt();

        if (!(numJugadores >= 1 && numJugadores <= 6)) {
            System.out.println("Ingreso "+numJugadores+" y excede al rango, por lo tanto la cantidad de jugadores sera de 6");
            numJugadores = 6;
        }
        
        for (int i = 0; i < numJugadores; i++) {
            jugadores.add(js.crearJugador(i + 1));
        }
        return jugadores;
    }

    //Finalizador del juego cuando algun jugador es mojado
    private boolean finJuego() {

        for (int i = 0; i < juego.getJugadores().size(); i++) {
            if (juego.getJugadores().get(i).getMojado()) {
                //Acabo el juego
                return true;
            }
        }
        return false; //No termina el juego
    }

    //Realiza una ronda (si muere algun jugador, los siguientes no participan)
    private void rondaV2() {

        JugadorServicio js = new JugadorServicio();
        RevolverServicio rs = new RevolverServicio();
        

        for (int i = 0; i < juego.getJugadores().size(); i++) {
            //El jugador se dispara
            js.disparo(rs, juego.getJugadores().get(i), juego.getRevolver());
        }

    }


    //Inicia el juego - modificador publico para acceder desde el main
    public void Jugar() {
        while (!finJuego()) {
            rondaV2();
        }
    }

}
