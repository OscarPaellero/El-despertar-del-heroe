import VILLANOS.*;
import java.util.Scanner;

// Prueba el final seguido: combate del traidor, combate de Infantino, final y postcreditos
public class PruebaFinal
{
    // true: jugador casi invencible para leer todo el guion. false: stats reales
    static final boolean INVENCIBLE = true;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nombre del jugador: ");
        Jugador jugadorTOP = new Jugador(sc.nextLine());
        Inventario inv = jugadorTOP.getInventario();

        // Los 6 aliados que tendrias al llegar al final
        inv.agregarAliado(Personaje.heroeVilla);
        inv.agregarAliado(Personaje.heroeMessi);
        inv.agregarAliado(Personaje.heroeCristiano);
        inv.agregarAliado(Personaje.heroeSenna);
        inv.agregarAliado(Personaje.heroeAspas);
        inv.agregarAliado(Personaje.heroeGriezmann);

        // Estado al llegar al traidor: 8 enemigos derrotados, arma 38 y vida 180
        for (int i = 0; i < 8; i++) {
            jugadorTOP.sumarPuntos();
        }
        jugadorTOP.setSubidaArma(6);
        jugadorTOP.getArma().subirDaño(28);
        jugadorTOP.curarTrasCombate();

        if (INVENCIBLE) {
            jugadorTOP.getArma().subirDaño(500);
            jugadorTOP.setVida(1000);
        }

        // 1. Combate sorpresa del traidor
        boolean ganado = Elecciones.rondaTraidor(sc, jugadorTOP);

        // 2. Combate final contra Infantino
        if (ganado) {
            ganado = Elecciones.rondaInfantino(sc, jugadorTOP);
        }

        // 3. Final del juego, creditos y postcreditos
        if (ganado) {
            Juego.finDelJuego(sc, jugadorTOP);
        } else {
            System.out.println("GAME OVER. Fin de la prueba.");
        }
    }
}