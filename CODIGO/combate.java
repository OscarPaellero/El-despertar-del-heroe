import java.util.Scanner;
 
public class Combate
{
    public static boolean pelear(Jugador jugadorTOP, Personaje villano, Scanner sc)
    {
        System.out.println(" ");
        System.out.println("========================================================== ");
        System.out.println("¡Comienza el combate contra " + villano.getNombre() + "!");
        System.out.println("========================================================== ");
        int turno = 1;
 
        while (jugadorTOP.getVida() > 0 && villano.getVida() > 0) {
            System.out.println(" ");
            System.out.println("--- TURNO " + turno + " ---");
            mostrarVidas(jugadorTOP, villano);
 
            boolean bloqueando = turnoJugador(jugadorTOP, villano, sc);
 
            // Si el villano ya ha muerto con tu golpe, no contraataca
            if (villano.getVida() > 0) {
                // Le paso si estas bloqueando para que calcule el daño
                ataqueVillano(jugadorTOP, villano, bloqueando);
            }
 
            turno++;
        }
 
        if (villano.getVida() <= 0) {
            System.out.println(" ");
            System.out.println("¡HAS DERROTADO AL MISMISIMO " + villano.getNombre() + "!, QUE LOCURA NIÑOOOOOOOOOOOO");
            System.out.println(" ");
            System.out.println("Pulsa ENTER para saber tus siguintes destinos");
                sc.nextLine();
 
            jugadorTOP.setVida(100 + 10);
            return true;
        }
 
        System.out.println(" ");
        System.out.println("===/====/===/===/===/===/===/===/====/===/===/===/===/===/ ");
        System.out.println(villano.getNombre() + " te ha derrotado... (Eres un poquito malo la verdad)");
        System.out.println(" ");
        return false;
    }
 
    public static void mostrarVidas(Jugador TOP, Personaje villano)
    {
        System.out.println(TOP.getNombre() + ": " + TOP.getVida() + " de vida");
        System.out.println(villano.getNombre() + ": " + villano.getVida() + " de vida");
    }
 
    // NUEVO: menu de 3 opciones. Devuelve true si este turno te defiendes con el escudo
    public static boolean turnoJugador(Jugador TOP, Personaje villano, Scanner sc)
    {
        // Se repite hasta que elijas una accion valida
        while (true) {
            System.out.println(" ");
            System.out.println("¿Que quieres hacer?");
            System.out.println("1. Atacar");
            if (TOP.getEscudo().estaRoto()) {
                System.out.println("2. Defenderse con el escudo (ROTO)");
            } else {
                System.out.println("2. Defenderse con el escudo (" + TOP.getEscudo().getVida() + "/" + TOP.getEscudo().getVidaMax() + ")");
            }
            System.out.println("3. Tomar pocion de curacion (quedan " + TOP.getInventario().getPociones() + ")");
            System.out.print("Opcion: ");
            int eleccion = sc.nextInt();
            sc.nextLine();
 
            switch (eleccion) {
                case 1:
                    ataqueJugador(TOP, villano);
                    return false;
                case 2:
                    // Con el escudo roto no vale: el break vuelve a pedir opcion
                    if (TOP.getEscudo().estaRoto()) {
                        System.out.println("Tu escudo esta roto, no puedes usarlo hasta despues de la ronda final de LaLiga.");
                        break;
                    }
                    System.out.println("|-------------------------------");
                    System.out.println("| Levantas el escudo y te preparas para el golpe.");
                    return true;
                case 3:
                    // Sin pociones tampoco vale y vuelve a pedir opcion
                    if (!TOP.getInventario().tienePociones()) {
                        System.out.println("No te quedan pociones.");
                        break;
                    }
                    // Gasta la pocion del inventario y suma la vida que cura
                    int cura = TOP.getInventario().usarPocion();
                    TOP.setVida(TOP.getVida() + cura);
                    System.out.println("|-------------------------------");
                    System.out.println("| Te tomas una pocion y recuperas " + cura + " de vida.");
                    return false;
                default:
                    System.out.println("Opcion incorrecta. Elige del 1 al 3.");
                    break;
            }
        }
    }
 
    public static void ataqueJugador(Jugador TOP, Personaje villano)
    {
        int dano = TOP.getArma().getDaño();
 
        villano.setVida(villano.getVida() - dano);
        System.out.println("|-------------------------------");
        System.out.println("| Atacas con " + TOP.getArma().getNombre() + " y haces " + dano + " de daño.");
    }
 
    // Ahora recibe "bloqueando" para saber si te defiendes
    public static void ataqueVillano(Jugador TOP, Personaje villano, boolean bloqueando)
    {
        int dano = villano.getArma().getDaño();
 
        if (bloqueando) {
            // Con escudo: tu recibes el 10% del daño y el escudo el 15%
            int danoJugador = (int) Math.round(dano * 0.10);
            int danoEscudo = (int) Math.round(dano * 0.15);
 
            TOP.setVida(TOP.getVida() - danoJugador);
            TOP.getEscudo().recibirDano(danoEscudo);
 
            System.out.println("| " + villano.getNombre() + " te ataca con " + villano.getArma().getNombre() + " y bloqueas el golpe.");
            System.out.println("| Recibes " + danoJugador + " de daño y el escudo " + danoEscudo + ".");
            if (TOP.getEscudo().estaRoto()) {
                System.out.println("| ¡Tu escudo se ha roto!");
            }
        } else {
            // Sin escudo: el golpe entero, como antes
            TOP.setVida(TOP.getVida() - dano);
            System.out.println("| " + villano.getNombre() + " te ataca con " + villano.getArma().getNombre() + " y te hace " + dano + " de daño.");
        }
        System.out.println("|-------------------------------");
    }
}