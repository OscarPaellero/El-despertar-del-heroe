import VILLANOS.*;
import java.util.Random;
import java.util.Scanner;
 
public class Combate
{
    private static Random random = new Random();

    // Combate completo: si ganas, te da los puntos, mejora tu arma y te cura
    public static boolean pelear(Jugador jugadorTOP, Personaje villano, Scanner sc)
    {
        if (!pelearFase(jugadorTOP, villano, sc)) {
            return false;
        }

        System.out.println(" ");
        System.out.println(" ");
        System.out.println("¡HAS DERROTADO AL MISMISIMO " + villano.getNombre() + "!, QUE LOCURA NIÑOOOOOOOOOOOO");
        int ganados = jugadorTOP.sumarPuntos();
        System.out.println("Has ganado " + ganados + " puntos. Total: " + jugadorTOP.getPuntos());

        // Cada combate ganado mejora tu arma
        jugadorTOP.getArma().subirDaño(jugadorTOP.getSubidaArma());
        System.out.println(jugadorTOP.getArma().getNombre() + " mejora y ahora hace " + jugadorTOP.getArma().getDaño() + " de daño.");
        System.out.println(" ");
        System.out.println("Pulsa ENTER para saber tus siguintes destinos");
            sc.nextLine();

        jugadorTOP.curarTrasCombate();
        return true;
    }

    // Solo los turnos del combate, sin premios. Los combates finales lo usan para cada fase
    public static boolean pelearFase(Jugador jugadorTOP, Personaje villano, Scanner sc)
    {
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("========================================================== ");
        System.out.println("¡Comienza el combate contra " + villano.getNombre() + "!");
        System.out.println("========================================================== ");
        int turno = 1;

        // Cada combate nuevo, todos los aliados recuperan su poder
        jugadorTOP.getInventario().reiniciarPoderes();
 
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
            return true;
        }

        System.out.println(" ");
        System.out.println(" ");
        System.out.println("===/====/===/===/===/===/===/===/====/===/===/===/===/===/ ");
        System.out.println(villano.getNombre() + " te ha derrotado... (Eres un poquito malo la verdad)");
        System.out.println(" ");
        return false;
    }
 
    public static void mostrarVidas(Jugador TOP, Personaje villano)
    {
        System.out.println(TOP.getNombre() + " (" + TOP.getPuntos() + " puntos): " + TOP.getVida() + " de vida");
        System.out.println(villano.getNombre() + ": " + villano.getVida() + " de vida");
        if (villano.getEscudo() != null) {
            if (villano.getEscudo().estaRoto()) {
                System.out.println("Escudo de " + villano.getNombre() + ": ROTO");
            } else {
                System.out.println("Escudo de " + villano.getNombre() + ": " + villano.getEscudo().getVida() + "/" + villano.getEscudo().getVidaMax());
            }
        }
    }
 
    // NUEVO: menu de 5 opciones. Devuelve true si este turno te defiendes con el escudo
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
            System.out.println("4. Usar el poder de un aliado (" + TOP.getInventario().getPoderesDisponibles() + " disponibles)");
            System.out.println("5. Salir del juego");
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
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println("|-------------------------------");
                    System.out.println("| Levantas el escudo y te preparas para el golpe.");
                    System.out.println("|-------------------------------");
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
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println("|-------------------------------");
                    System.out.println("| Te tomas una pocion y recuperas " + cura + " de vida.");
                    System.out.println("|-------------------------------");
                    return false;
                case 4:
                    // Sin aliados con poder tampoco vale y vuelve a pedir opcion
                    if (TOP.getInventario().getPoderesDisponibles() == 0) {
                        System.out.println("No tienes ningun aliado con el poder disponible.");
                        break;
                    }
                    // Si eliges "0. Volver" no se gasta el turno y vuelve al menu
                    if (poderAliado(TOP, villano, sc)) {
                        return false;
                    }
                    break;
                case 5:
                    System.out.println("Abandonas la aventura. Hasta la proxima, " + TOP.getNombre() + ".");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion incorrecta. Elige del 1 al 5.");
                    break;
            }
        }
    }

    // Deja elegir un aliado y su poder le quita vida al villano (atraviesa el escudo).
    // Devuelve true si se ha usado un poder y false si has vuelto atras
    public static boolean poderAliado(Jugador TOP, Personaje villano, Scanner sc)
    {
        Inventario inv = TOP.getInventario();

        while (true) {
            System.out.println(" ");
            System.out.println("Elige el aliado que usa su poder:");
            for (int i = 0; i < inv.getNumAliados(); i++) {
                Personaje aliado = inv.getAliado(i);
                if (inv.poderUsado(i)) {
                    System.out.println((i + 1) + ". " + aliado.getNombre() + " (poder ya usado)");
                } else {
                    System.out.println((i + 1) + ". " + aliado.getNombre() + " - " + aliado.getPoder().getNombre() + " (" + aliado.getPoder().getDaño() + " de daño)");
                }
            }
            System.out.println("0. Volver");
            System.out.print("Opcion: ");
            int eleccion = sc.nextInt();
            sc.nextLine();

            if (eleccion == 0) {
                return false;
            }
            if (eleccion < 1 || eleccion > inv.getNumAliados()) {
                System.out.println("Opcion incorrecta.");
            } else if (inv.poderUsado(eleccion - 1)) {
                System.out.println("Ese aliado ya ha usado su poder en este combate.");
            } else {
                Personaje aliado = inv.getAliado(eleccion - 1);
                int dano = aliado.getPoder().getDaño();

                villano.setVida(villano.getVida() - dano);
                inv.gastarPoder(eleccion - 1);

                System.out.println(" ");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println("|-------------------------------");
                System.out.println("| " + aliado.getNombre() + " usa " + aliado.getPoder().getNombre() + " y " + villano.getNombre() + " recibe " + dano + " de daño.");
                System.out.println("|-------------------------------");
                return true;
            }
        }
    }
 
    public static void ataqueJugador(Jugador TOP, Personaje villano)
    {
        int dano = TOP.getArma().getDaño();
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("|-------------------------------");

        if (villano.isDefendiendo()) {
            // Con escudo: el villano recibe el 10% del daño y el escudo el 15%
            int danoVillano = (int) Math.round(dano * 0.10);
            int danoEscudo = (int) Math.round(dano * 0.15);

            villano.setVida(villano.getVida() - danoVillano);
            villano.getEscudo().recibirDano(danoEscudo);
            villano.setDefendiendo(false);

            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("| Atacas con " + TOP.getArma().getNombre() + " pero " + villano.getNombre() + " se defiende con el escudo.");
            System.out.println("| " + villano.getNombre() + " recibe " + danoVillano + " de daño y el escudo " + danoEscudo + ".");
            if (villano.getEscudo().estaRoto()) {
                System.out.println("| ¡El escudo de " + villano.getNombre() + " se ha roto!");
            }
        } else {
            villano.setVida(villano.getVida() - dano);
            System.out.println("| Atacas con " + TOP.getArma().getNombre() + " y haces " + dano + " de daño.");
        }
    }

    // Cada turno elige al azar una accion. Si el villano no puede hacerla, prueba otra
    public static int accionVillano(Jugador TOP, Personaje villano)
    {
        int vidaJugador = TOP.getVida();

        for (int intentos = 0; intentos < 100; intentos++) {
            int tipo = random.nextInt(6) + 1;
            int dano = -1;

            if (tipo == 1) {
                dano = villano.turnoCombatiente(vidaJugador);
            }
            if (tipo == 2) {
                dano = villano.turnoTirador(vidaJugador);
            }
            if (tipo == 3) {
                dano = villano.turnoJinete(vidaJugador);
            }
            if (tipo == 4) {
                dano = villano.turnoSanador(vidaJugador);
            }
            if (tipo == 5) {
                dano = villano.turnoInvocador(vidaJugador);
            }
            if (tipo == 6) {
                dano = villano.turnoHechicero(vidaJugador);
            }

            if (dano >= 0) {
                return dano;
            }
        }

        System.out.println("| " + villano.getNombre() + " ataca con " + villano.getArma().getNombre());
        return villano.getDanoAtaque();
    }

    public static void ataqueVillano(Jugador TOP, Personaje villano, boolean bloqueando)
    {
        int dano = accionVillano(TOP, villano);

        if (dano > 0) {
            if (bloqueando) {
                // Con escudo: tu recibes el 10% del daño y el escudo el 15%
                int danoJugador = (int) Math.round(dano * 0.10);
                int danoEscudo = (int) Math.round(dano * 0.15);

                TOP.setVida(TOP.getVida() - danoJugador);
                TOP.getEscudo().recibirDano(danoEscudo);

                System.out.println("| Bloqueas el golpe. Recibes " + danoJugador + " de daño y el escudo " + danoEscudo + ".");
                if (TOP.getEscudo().estaRoto()) {
                    System.out.println("| ¡Tu escudo se ha roto!");
                }
            } else {
                TOP.setVida(TOP.getVida() - dano);
                System.out.println("| Recibes " + dano + " de daño.");
            }
        }
        System.out.println("|-------------------------------");
    }
}