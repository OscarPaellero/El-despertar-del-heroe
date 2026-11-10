import VILLANOS.*;
import java.util.Scanner; 
 
public class Elecciones
{
 
// ---------------- ELEGIR ENTRE 3 ESTADIOS (se usa en todas las rondas) ----------------
    private static boolean rondaDe3(Scanner sc, Jugador jugadorTOP, String titulo, Estadio estd1, Estadio estd2, Estadio estd3)
    {
        Estadio elegido = null;
 
        while (elegido == null) 
        {
            System.out.println("===== " + titulo + " =====");
            System.out.println("Elige un estadio:");
            System.out.println("1. " + estd1.getEstadio());
            System.out.println("2. " + estd2.getEstadio());
            System.out.println("3. " + estd3.getEstadio());
            System.out.print("Opcion: ");
            int eleccion = sc.nextInt();
            sc.nextLine();
 
            switch (eleccion) 
            {
                case 1:
                    elegido = estd1;
                    break;
                case 2:
                    elegido = estd2;
                    break;
                case 3:
                    elegido = estd3;
                    break;
                default:
                    System.out.println("Opcion incorrecta. Elige del 1 al 3.");
                    break;
            }
        }
 
        elegido.presentar();
        System.out.println("Pulsa ENTER para luchar...");
        sc.nextLine();
 
        return Combate.pelear(jugadorTOP, elegido.getVillano(), sc);
    }
 
 
// ===/====/===/===/===/===/=== NIVEL: LA LIGA ESPAÑOLA ===/====/===/===/===/===/===
 
// ---------------- RONDA INICIAL ----------------
    public static boolean rondaInicial(Scanner sc, Jugador jugadorTOP)
    {
        Estadio estd0 = new Estadio("Mestalla", new VillanoLim(), Personaje.heroeVilla, "Valencia CF");
 
        System.out.println("===== RONDA INICIAL =====");
        estd0.presentar();
        System.out.println("Pulsa ENTER para luchar...");
        sc.nextLine();
 
        return Combate.pelear(jugadorTOP, estd0.getVillano(), sc);
    }
 
 
// ---------------- RONDA 1 ----------------
    public static boolean ronda1(Scanner sc, Jugador jugadorTOP)
    {
        Estadio estd1 = new Estadio("Estadio de la Ceramica", new VillanoRoig(), Personaje.heroeSenna, "Villarreal CF");
        Estadio estd2 = new Estadio("Estadio de Vallecas", new VillanoPresa(), Personaje.heroePalazon, "Rayo Vallecano");
        Estadio estd3 = new Estadio("RCDE Stadium", new VillanoJoselu(), Personaje.heroeJarque, "RCD Espanyol");
 
        return rondaDe3(sc, jugadorTOP, "RONDA 1", estd1, estd2, estd3);
    }
 
 
// ---------------- RONDA 2 ----------------
    public static boolean ronda2(Scanner sc, Jugador jugadorTOP)
    {
        Estadio estd1 = new Estadio("Coliseum", new VillanoTorres(), Personaje.heroeBordalas, "Getafe CF");
        Estadio estd2 = new Estadio("San Mames", new VillanoLlorente(), Personaje.heroeMuniain, "Athletic Club");
        Estadio estd3 = new Estadio("Balaidos", new VillanoDorovic(), Personaje.heroeAspas, "RC Celta de Vigo");
 
        return rondaDe3(sc, jugadorTOP, "RONDA 2", estd1, estd2, estd3);
    }
 
 
// ---------------- RONDA 3 ----------------
    public static boolean ronda3(Scanner sc, Jugador jugadorTOP)
    {
        Estadio estd1 = new Estadio("Ramon Sanchez-Pizjuan", new VillanoDelNido(), Personaje.heroeNavas, "Sevilla FC");
        Estadio estd2 = new Estadio("Benito Villamarin", new VillanoLopera(), Personaje.heroeJoaquin, "Real Betis");
        Estadio estd3 = new Estadio("Metropolitano", new VillanoGil(), Personaje.heroeGriezmann, "Atletico de Madrid");
 
        return rondaDe3(sc, jugadorTOP, "RONDA 3", estd1, estd2, estd3);
    }
 
 
// ---------------- RONDA FINAL LALIGA (Barcelona o Madrid) ----------------
    public static boolean rondaFinalLaLiga(Scanner sc, Jugador jugadorTOP)
    {
        Estadio estd1 = new Estadio("Camp Nou", new VillanoLaporta(), Personaje.heroeMessi, "FC Barcelona");
        Estadio estd2 = new Estadio("Santiago Bernabeu", new VillanoFlorentino(), Personaje.heroeCristiano, "Real Madrid");
        Estadio elegido = null;
 
        while (elegido == null) 
        {
            System.out.println("===== RONDA FINAL DE LALIGA =====");
            System.out.println("Elige un estadio:");
            System.out.println("1. " + estd1.getEstadio());
            System.out.println("2. " + estd2.getEstadio());
            System.out.print("Opcion: ");
            int eleccion = sc.nextInt();
            sc.nextLine();
 
            switch (eleccion) 
            {
                case 1:
                    elegido = estd1;
                    break;
                case 2:
                    elegido = estd2;
                    break;
                default:
                    System.out.println("Opcion incorrecta. Elige 1 o 2.");
                    break;
            }
        }
 
        elegido.presentar();
        System.out.println("Pulsa ENTER para luchar...");
        sc.nextLine();
 
        boolean ganado = Combate.pelear(jugadorTOP, elegido.getVillano(), sc);
 
        if (ganado) {
            jugadorTOP.getEscudo().reparar();
            System.out.println("Tu escudo ha sido reparado para el nivel internacional.");
        }
        return ganado;
    }
 
 
// ===/====/===/===/===/===/=== NIVEL: INTERNACIONALES ===/====/===/===/===/===/===
 
// ---------------- INTERNACIONAL RONDA 1 ----------------
    public static boolean rondaInter1(Scanner sc, Jugador jugadorTOP)
    {
        Estadio estd1 = new Estadio("La Bombonera", new VillanoPalermo(), Personaje.heroeRiquelme, "Boca Juniors");
        Estadio estd2 = new Estadio("El Monumental", new VillanoHiguain(), Personaje.heroeFrancescoli, "River Plate");
        Estadio estd3 = new Estadio("Signal Iduna Park", new VillanoLewandowski(), Personaje.heroeReus, "Borussia Dortmund");
 
        return rondaDe3(sc, jugadorTOP, "INTERNACIONAL - RONDA 1", estd1, estd2, estd3);
    }
 
 
// ---------------- INTERNACIONAL RONDA 2 ----------------
    public static boolean rondaInter2(Scanner sc, Jugador jugadorTOP)
    {
        Estadio estd1 = new Estadio("Parque de los Principes", new VillanoMbappe(), Personaje.heroeZlatan, "Paris Saint-Germain");
        Estadio estd2 = new Estadio("Emirates Stadium", new VillanoVanPersie(), Personaje.heroeHenry, "Arsenal");
        Estadio estd3 = new Estadio("Old Trafford", new VillanoTevez(), Personaje.heroeStam, "Manchester United");
 
        return rondaDe3(sc, jugadorTOP, "INTERNACIONAL - RONDA 2", estd1, estd2, estd3);
    }
 
 
// ---------------- INTERNACIONAL RONDA 3 ----------------
    public static boolean rondaInter3(Scanner sc, Jugador jugadorTOP)
    {
        Estadio estd1 = new Estadio("San Siro", new VillanoDonnarumma(), Personaje.heroeMaldini, "AC Milan");
        Estadio estd2 = new Estadio("Allianz Arena", new VillanoBoateng(), Personaje.heroeBeckenbauer, "Bayern Munich");
        Estadio estd3 = new Estadio("Anfield", new VillanoSuarez(), Personaje.heroeWenger, "Liverpool FC");
 
        return rondaDe3(sc, jugadorTOP, "INTERNACIONAL - RONDA 3", estd1, estd2, estd3);
    }
 
 
// ---------------- RONDA FINAL: SEDE DE LA FIFA ----------------
    public static boolean rondaInfantino(Scanner sc, Jugador jugadorTOP)
    {
        System.out.println("===== RONDA FINAL =====");
        System.out.println("Has llegado a la sede de la FIFA. Gianni Infantonico te espera...");
        System.out.println("Pulsa ENTER para luchar...");
        sc.nextLine();
 
        return Combate.pelear(jugadorTOP, new VillanoInfantino(), sc);
    }
 
}