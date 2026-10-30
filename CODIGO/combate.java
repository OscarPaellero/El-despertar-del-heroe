import java.util.Scanner;

public class combate extends juego
{
    public static boolean pelear(jugador jugadorTOP, personaje villano, Scanner sc)
    {
        System.out.println("\n¡Comienza el combate contra " + villano.getNombre() + "!");
        int turno = 1;

        while (jugadorTOP.getVida() > 0 && villano.getVida() > 0) {
            System.out.println("\n--- Turno " + turno + " ---");
            mostrarVidas(jugadorTOP, villano);
            System.out.println("Pulsa enter para atacar...");
            sc.nextLine();

            ataqueJugador(jugadorTOP, villano);

            if (villano.getVida() > 0) {
                ataqueVillano(jugadorTOP, villano);
            }

            turno++;
        }

        if (villano.getVida() <= 0) {
            System.out.println("\n¡Has derrotado a " + villano.getNombre() + "!");
            jugadorTOP.setVida(100);
            return true;
        }

        System.out.println("\n" + villano.getNombre() + " te ha derrotado...");
        return false;
    }

    private static void mostrarVidas(jugador j, personaje villano)
    {
        System.out.println(j.getNombre() + ": " + j.getVida() + " de vida");
        System.out.println(villano.getNombre() + ": " + villano.getVida() + " de vida");
    }

    private static void ataqueJugador(jugador j, personaje villano)
    {
        int dano = j.getArma().getDaño();
        villano.setVida(villano.getVida() - dano);
        System.out.println("Atacas con " + j.getArma().getNombre() + " y haces " + dano + " de daño.");
    }

    private static void ataqueVillano(jugador j, personaje villano)
    {
        int dano = villano.getArma().getDaño();
        j.setVida(j.getVida() - dano);
        System.out.println(villano.getNombre() + " te ataca con " + villano.getArma().getNombre() + " y te hace " + dano + " de daño.");
    }
}