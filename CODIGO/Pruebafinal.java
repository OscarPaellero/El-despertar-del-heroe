import VILLANOS.*;
import java.util.Scanner;

public class Pruebafinal
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Jugador jugadorTOP = new Jugador("Prueba");

        // Aliados de prueba (6, como llegarias antes del traidor)
        Inventario inv = jugadorTOP.getInventario();
        inv.agregarAliado(Personaje.heroeVilla);
        inv.agregarAliado(Personaje.heroeMessi);
        inv.agregarAliado(Personaje.heroeCristiano);
        inv.agregarAliado(Personaje.heroeSenna);
        inv.agregarAliado(Personaje.heroeAspas);
        inv.agregarAliado(Personaje.heroeGriezmann);

        // Para que los combates duren poco y no pierdas mientras pruebas el guion
        jugadorTOP.getArma().subirDaño(500);
        jugadorTOP.setVida(1000);

        // Deja solo la parte que quieras probar:
        // Elecciones.puertasDeLaLiga(sc, jugadorTOP);
        Elecciones.rondaTraidor(sc, jugadorTOP);
        Elecciones.rondaInfantino(sc, jugadorTOP);
    }
}