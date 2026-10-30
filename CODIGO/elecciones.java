import java.util.Scanner;
 
public class elecciones
{
 
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
        estadio estd1 = new estadio("La Ceramica", personaje.villanoRoig, personaje.heroeSenna, "Villarreal CF");
        estadio estd2 = new estadio("RCDE Stadium", personaje.villanoJoselu, personaje.heroeJarque, "RCD Espanyol");
        estadio estd3= new estadio("Estadio de Vallecas", personaje.villanoPresa, personaje.heroePalazon, "Rayo Vallecano");
 
        estadio elegido = null;
 
        while (elegido == null) 
            {
            System.out.println("===== RONDA 1 =====");
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
 

}