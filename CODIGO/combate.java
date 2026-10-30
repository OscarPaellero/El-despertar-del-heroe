import java.util.Scanner;

public class combate extends elecciones
{
    public static boolean pelear(jugador jugadorTOP, personaje villano, Scanner sc)
    {
        System.out.println(" ");
        System.out.println("========================================================== ");
        System.out.println("¡Comienza el combate contra " + villano.getNombre() + "!");
        System.out.println("========================================================== ");
        // inicializo los turnos con el primer turno (obviamente)
        int turno = 1;
                
        // Se repite mientras los dos sigan vivos, esto lo hagao gracias al && (a la vez [los 2 vivos])
        // En cuanto uno llegue a 0 de vida, el while termina ( >0 )
        while (jugadorTOP.getVida() > 0 && villano.getVida() > 0) {
            System.out.println(" ");
            System.out.println("--- TURNO " + turno + " ---");
            mostrarVidas(jugadorTOP, villano);
            
            System.out.println("Pulsa 'ENTER' para atacar...");
            sc.nextLine();

            ataqueJugador(jugadorTOP, villano);

            // Si el villano ya ha muerto con tu golpe, no contraataca
            if (villano.getVida() > 0) {
                ataqueVillano(jugadorTOP, villano);
            }

            turno++;
        }

        // En esta parte ya se ha terminaod el while, por lo que alguien ha muerto
        // Si es el villano el que ha muerto, he ganado, poe lo que recupero la vida y se devuelve el true
        if (villano.getVida() <= 0) {
            System.out.println(" ");
            System.out.println("¡HAS DERROTADO AL MISMISIMO " + villano.getNombre() + "!, QUE LOCURA NIÑOOOOOOOOOOOO");
            System.out.println(" ");
            System.out.println("Pulsa ENTER para saber tus siguintes destinos");
                sc.nextLine();
            
            // Aqui se le devuelva la vida al ajugador (y le sumo 10)
            jugadorTOP.setVida(100 +10);
            return true;
        }
        // El heroe te ha matado
        System.out.println(" ");
        System.out.println("===/====/===/===/===/===/===/===/====/===/===/===/===/===/ ");
        System.out.println(villano.getNombre() + " te ha derrotado... (Eres un poquito malo la verdad)");
        System.out.println(" ");
        return false;
    }

    private static void mostrarVidas(jugador TOP, personaje villano)
    {
        System.out.println(TOP.getNombre() + ": " + TOP.getVida() + " de vida");
        System.out.println(villano.getNombre() + ": " + villano.getVida() + " de vida");
    }

    // AQUI ATACA EL JUGADOR
    private static void ataqueJugador(jugador TOP, personaje villano)
    {
        // Saca el daño de tu arma (de juagador a arma, y de arma a daño) y lo guarda en el daño
        int dano = TOP.getArma().getDaño();

        // A la vida del villano le resta ese daño y guarda el resultado
        villano.setVida(villano.getVida() - dano);
        System.out.println("|-------------------------------");
        System.out.println("| Atacas con " + TOP.getArma().getNombre() + " y haces " + dano + " de daño.");
    }

    // AQUI ATACA EL VILLANO
    private static void ataqueVillano(jugador TOP, personaje villano)
    {
        int dano = villano.getArma().getDaño();
        TOP.setVida(TOP.getVida() - dano);
        System.out.println("| " +villano.getNombre() + " te ataca con " + villano.getArma().getNombre() + " y te hace " + dano + " de daño.");
        System.out.println("|-------------------------------");
    }
}