import java.util.Scanner; 
 
public class elecciones
{
 
// ---------------- ELEGIR ENTRE 3 ESTADIOS (se usa en todas las rondas) ----------------
    private static boolean rondaDe3(Scanner sc, jugador jugadorTOP, String titulo, estadio estd1, estadio estd2, estadio estd3)
    {
        estadio elegido = null;
 
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
 
        return combate.pelear(jugadorTOP, elegido.getVillano(), sc);
    }
 
 
// ===/====/===/===/===/===/=== NIVEL: LA LIGA ESPAÑOLA ===/====/===/===/===/===/===
 
// ---------------- RONDA INICIAL ----------------
    public static boolean rondaInicial(Scanner sc, jugador jugadorTOP)
    {
        estadio estd0 = new estadio("Mestalla", personaje.villanoLim, personaje.heroeVilla, "Valencia CF");
 
        System.out.println("===== RONDA INICIAL =====");
        estd0.presentar();
        System.out.println("Pulsa ENTER para luchar...");
        sc.nextLine();
 
        return combate.pelear(jugadorTOP, estd0.getVillano(), sc);
    }
 
 
// ---------------- RONDA 1 ----------------
    public static boolean ronda1(Scanner sc, jugador jugadorTOP)
    {
        estadio estd1 = new estadio("Estadio de la Ceramica", personaje.villanoRoig, personaje.heroeSenna, "Villarreal CF");
        estadio estd2 = new estadio("Estadio de Vallecas", personaje.villanoPresa, personaje.heroePalazon, "Rayo Vallecano");
        estadio estd3 = new estadio("RCDE Stadium", personaje.villanoJoselu, personaje.heroeJarque, "RCD Espanyol");
 
        return rondaDe3(sc, jugadorTOP, "RONDA 1", estd1, estd2, estd3);
    }
 
 
// ---------------- RONDA 2 ----------------
    public static boolean ronda2(Scanner sc, jugador jugadorTOP)
    {
        estadio estd1 = new estadio("Coliseum", personaje.villanoTorres, personaje.heroeBordalas, "Getafe CF");
        estadio estd2 = new estadio("San Mames", personaje.villanoLlorente, personaje.heroeMuniain, "Athletic Club");
        estadio estd3 = new estadio("Balaidos", personaje.villanoDorovic, personaje.heroeAspas, "RC Celta de Vigo");
 
        return rondaDe3(sc, jugadorTOP, "RONDA 2", estd1, estd2, estd3);
    }
 
 
// ---------------- RONDA 3 ----------------
    public static boolean ronda3(Scanner sc, jugador jugadorTOP)
    {
        estadio estd1 = new estadio("Ramon Sanchez-Pizjuan", personaje.villanoDelNido, personaje.heroeNavas, "Sevilla FC");
        estadio estd2 = new estadio("Benito Villamarin", personaje.villanoLopera, personaje.heroeJoaquin, "Real Betis");
        estadio estd3 = new estadio("Metropolitano", personaje.villanoGil, personaje.heroeGriezmann, "Atletico de Madrid");
 
        return rondaDe3(sc, jugadorTOP, "RONDA 3", estd1, estd2, estd3);
    }
 
 
// ---------------- RONDA FINAL LALIGA (Barcelona o Madrid) ----------------
    public static boolean rondaFinalLaLiga(Scanner sc, jugador jugadorTOP)
    {
        estadio estd1 = new estadio("Camp Nou", personaje.villanoLaporta, personaje.heroeMessi, "FC Barcelona");
        estadio estd2 = new estadio("Santiago Bernabeu", personaje.villanoFlorentino, personaje.heroeCristiano, "Real Madrid");
        estadio elegido = null;
 
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
 
        return combate.pelear(jugadorTOP, elegido.getVillano(), sc);
    }
 
 
// ===/====/===/===/===/===/=== NIVEL: INTERNACIONALES ===/====/===/===/===/===/===
 
// ---------------- INTERNACIONAL RONDA 1 ----------------
    public static boolean rondaInter1(Scanner sc, jugador jugadorTOP)
    {
        estadio estd1 = new estadio("La Bombonera", personaje.villanoPalermo, personaje.heroeRiquelme, "Boca Juniors");
        estadio estd2 = new estadio("El Monumental", personaje.villanoHiguain, personaje.heroeFrancescoli, "River Plate");
        estadio estd3 = new estadio("Signal Iduna Park", personaje.villanoLewandowski, personaje.heroeReus, "Borussia Dortmund");
 
        return rondaDe3(sc, jugadorTOP, "INTERNACIONAL - RONDA 1", estd1, estd2, estd3);
    }
 
 
// ---------------- INTERNACIONAL RONDA 2 ----------------
    public static boolean rondaInter2(Scanner sc, jugador jugadorTOP)
    {
        estadio estd1 = new estadio("Parque de los Principes", personaje.villanoMbappe, personaje.heroeZlatan, "Paris Saint-Germain");
        estadio estd2 = new estadio("Emirates Stadium", personaje.villanoVanPersie, personaje.heroeHenry, "Arsenal");
        estadio estd3 = new estadio("Old Trafford", personaje.villanoTevez, personaje.heroeStam, "Manchester United");
 
        return rondaDe3(sc, jugadorTOP, "INTERNACIONAL - RONDA 2", estd1, estd2, estd3);
    }
 
 
// ---------------- INTERNACIONAL RONDA 3 ----------------
    public static boolean rondaInter3(Scanner sc, jugador jugadorTOP)
    {
        estadio estd1 = new estadio("San Siro", personaje.villanoDonnarumma, personaje.heroeMaldini, "AC Milan");
        estadio estd2 = new estadio("Allianz Arena", personaje.villanoBoateng, personaje.heroeBeckenbauer, "Bayern Munich");
        estadio estd3 = new estadio("Anfield", personaje.villanoSuarez, personaje.heroeWenger, "Liverpool FC");
 
        return rondaDe3(sc, jugadorTOP, "INTERNACIONAL - RONDA 3", estd1, estd2, estd3);
    }
 
 
// ---------------- RONDA FINAL: SEDE DE LA FIFA ----------------
    public static boolean rondaInfantino(Scanner sc, jugador jugadorTOP)
    {
        System.out.println("===== RONDA FINAL =====");
        System.out.println("Has llegado a la sede de la FIFA. Gianni Infantonico te espera...");
        System.out.println("Pulsa ENTER para luchar...");
        sc.nextLine();
 
        return combate.pelear(jugadorTOP, personaje.villanoInfantonico, sc);
    }
 
}
 