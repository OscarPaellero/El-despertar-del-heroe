import VILLANOS.*;
import java.util.Random;
import java.util.Scanner; 
 
public class Elecciones
{
    private static Random random = new Random();

// ---------------- LUCHAR Y RESCATAR AL HEROE (se usa en todas las rondas) ----------------
    // Si ganas el combate, el heroe del estadio se guarda en tu inventario de aliados
    private static boolean luchar(Scanner sc, Jugador jugadorTOP, Estadio estadio)
    {
        boolean ganado = Combate.pelear(jugadorTOP, estadio.getVillano(), sc);

        if (ganado) {
            jugadorTOP.getInventario().agregarAliado(estadio.getHeroe());
            System.out.println(" ");
            System.out.println("¡" + estadio.getHeroe().getNombre() + " ha sido liberado y se une a tu equipo!");
            System.out.println("Aliados: " + jugadorTOP.getInventario().getNumAliados());
            System.out.println(" ");
        }
        return ganado;
    }
 
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
            int eleccion = Juego.leerEntero(sc);
 
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
 
        return luchar(sc, jugadorTOP, elegido);
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
 
        return luchar(sc, jugadorTOP, estd0);
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
            int eleccion = Juego.leerEntero(sc);
 
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
 
        boolean ganado = luchar(sc, jugadorTOP, elegido);
 
        if (ganado) {
            jugadorTOP.getEscudo().reparar();
            System.out.println("Tu escudo ha sido reparado para el nivel internacional.");
        }
        return ganado;
    }
 
 
// ---------------- LAS PUERTAS DE LALIGA (hay que sacrificar a 2 aliados) ----------------
    public static void puertasDeLaLiga(Scanner sc, Jugador jugadorTOP)
    {
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("==================================");
        System.out.println("      LAS PUERTAS DE LALIGA");
        System.out.println("==================================");
        System.out.println("Ante ti se alzan las puertas que separan LaLiga del resto del mundo.");
        System.out.println("El aire pesa. A tu espalda, tus aliados guardan silencio.");
        System.out.println("Una figura inmovil te cierra el paso: Alehkshander Zeferhin, el dios que vigila estas puertas.");
        sc.nextLine();
        System.out.println(" ");
        System.out.println("Alehkshander Zeferhin: Detente, viajero. Nadie cruza estas puertas sin pagar su precio.");
        sc.nextLine();
        System.out.println(" ");
        System.out.println("Alehkshander Zeferhin: Para entrar en los torneos INTERNACIONALES, deberas entregarme la vida de DOS de los aliados que te acompañan.");
        sc.nextLine();
        System.out.println(" ");
        System.out.println(jugadorTOP.getNombre() + ": Debes de equivocarte. Yo no llevo a ningun aliado.");
        sc.nextLine();
        System.out.println(" ");
        System.out.println("Alehkshander Zeferhin: Mentirle a un dios es inutil. Conozco cada nombre que cargas contigo:");
        for (int i = 0; i < jugadorTOP.getInventario().getNumAliados(); i++) {
            System.out.print(" " + jugadorTOP.getInventario().getAliado(i).getNombre() + " , ");
        }
        sc.nextLine();
        System.out.println(" ");
        System.out.println("Alehkshander Zeferhin: Cada uno de ellos ha luchado a tu lado. Cada uno de ellos ha confiado en ti.");
        System.out.println("Alehkshander Zeferhin: Los dos que elijas desapareceran para siempre. No podras recuperarlos ni volver a usar su poder.");
        sc.nextLine();
        System.out.println(" ");
        System.out.println("Alehkshander Zeferhin: Elige bien, " + jugadorTOP.getNombre() + ". Esta decision te acompañara hasta el final.");
        sc.nextLine();
        System.out.println(" ");
 
        sacrificarAliado(sc, jugadorTOP, 1);
        sacrificarAliado(sc, jugadorTOP, 2);
 
        System.out.println(" ");
        // En el nivel internacional el arma mejora mas en cada victoria
        jugadorTOP.setSubidaArma(6);

        System.out.println("Las puertas se abren. Cruzas con " + jugadorTOP.getInventario().getNumAliados() + " aliados.");
        System.out.println("Pulsa ENTER para continuar...");
        sc.nextLine();
    }
 
    // Pide un aliado al jugador y lo elimina del inventario. Se llama una vez por cada sacrificio
    private static void sacrificarAliado(Scanner sc, Jugador jugadorTOP, int numero)
    {
        Inventario inv = jugadorTOP.getInventario();
        boolean sacrificado = false;
 
        while (!sacrificado) {
            System.out.println("Sacrificio " + numero + " de 2. ¿A quien sacrificas?");
            for (int i = 0; i < inv.getNumAliados(); i++) {
                System.out.println((i + 1) + ". " + inv.getAliado(i).getNombre());
            }
            System.out.print("Opcion: ");
            int eleccion = Juego.leerEntero(sc);
 
            int posicion = -1;
 
            switch (eleccion) {
                case 1:
                    posicion = 0;
                    break;
                case 2:
                    posicion = 1;
                    break;
                case 3:
                    posicion = 2;
                    break;
                case 4:
                    posicion = 3;
                    break;
                case 5:
                    posicion = 4;
                    break;
                default:
                    System.out.println("Opcion incorrecta. Elige del 1 al " + inv.getNumAliados() + ".");
                    break;
            }
 
            // Al sacrificar al segundo ya quedan menos aliados, por eso se comprueba que la posicion exista
            if (posicion >= 0 && posicion < inv.getNumAliados()) {
                System.out.println(" ");
                System.out.println(inv.getAliado(posicion).getNombre() + " ha sido sacrificado. No volveras a verlo.");
                System.out.println(" ");
                inv.quitarAliado(posicion);
                sacrificado = true;
            } else if (posicion >= 0) {
                System.out.println("Opcion incorrecta. Elige del 1 al " + inv.getNumAliados() + ".");
            }
        }
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
 
 
// ---------------- COMBATE DEL TRAIDOR (antes de Infantino) ----------------
    // Siempre es el mismo combate, solo cambia el nombre del aliado que te traiciona
    public static boolean rondaTraidor(Scanner sc, Jugador jugadorTOP)
    {
        Inventario inv = jugadorTOP.getInventario();
        String nombre = inv.quitarAliadoAlAzar(false).getNombre();

        System.out.println(" ");
        System.out.println("==================================");
        System.out.println("          LA SORPRESA");
        System.out.println("==================================");
        System.out.println(" -- Estás a un paso de la sede de la FIFA. El cielo es de un rojo oscuro y nadie dice una palabra -- ");
        System.out.println(" -- Hace tiempo que tus aliados caminan en silencio. Desde las puertas de LaLiga, algo se ha roto entre vosotros -- ");
        sc.nextLine();
        System.out.println(" ");
        System.out.println(" -- De pronto, " + nombre + " se detiene. Tiene la mirada clavada en el suelo -- ");
        System.out.println("'"+nombre.toUpperCase()+"'" + ": Llevo noches sin dormir. Una voz me habla en sueños.");
        sc.nextLine();
        System.out.println(" ");
        System.out.println("'"+nombre.toUpperCase()+"'" + ": Es Infantino. Dice que nadie tiene por qué sufrir, que nadie tiene por qué morir.");
        System.out.println("'"+nombre.toUpperCase()+"'" + ": Dice que en su mundo nadie envejece, nadie pierde y nadie es sacrificado.");
        sc.nextLine();
        System.out.println(" ");
        System.out.println("'"+jugadorTOP.getNombre().toUpperCase()+"'" + ": ¡ES UNA TRAMPA! Te está mintiendo.");
        sc.nextLine();
        System.out.println(" ");
        System.out.println("'"+nombre.toUpperCase()+"'" + ": ¿Mintiendo? Tú entregaste a dos de los nuestros para cruzar una puerta. Y no dudaste.");
        System.out.println("'"+nombre.toUpperCase()+"'" + ": Yo también puedo ser el siguiente. No pienso esperar a que me elijas.");
        sc.nextLine();
        System.out.println(" ");
        System.out.println("Los demás aliados retroceden. Nadie se atreve a respirar.");
        System.out.println("'"+nombre.toUpperCase()+"'" + ": Lo siento de verdad. Pero Infantino me ha prometido la libertad. Aquí acaba vuestro viaje.");
        sc.nextLine();
        System.out.println(" ");
        System.out.println(" -- "+ nombre + " desenvaina su arma y se lanza contra ti. Ya no es tu aliado. Te acaba de traicionar en el peor momento -- ");
        System.out.println("Pulsa ENTER para luchar...");
        sc.nextLine();

        // Fase 1: 120 de vida
        if (!Combate.pelearFase(jugadorTOP, new VillanoTraidor(nombre, 120), sc)) {
            return false;
        }

        jugadorTOP.curarEntreFases(15);
        System.out.println(" ");
        System.out.println(" -- " + nombre + " cae de rodillas, con la respiración rota. Levanta la vista hacia ti -- ");
        System.out.println("'"+nombre.toUpperCase()+"'" + ": ¿Por qué? Yo simplemente quería... no tener miedo.");
        sc.nextLine();
        System.out.println(" ");
        System.out.println(" -- Todo ha terminado... -- ");
        sc.nextLine();
        System.out.println(" -- Bueno, parece que todo ha terminado... -- ");
        System.out.println(" -- Algo no va bien: " + nombre + " sonríe -- ");
        sc.nextLine();
        System.out.println(" ");
        System.out.println(" -- Cuando bajáis la guardia, " + nombre + " agarra una roca enorme y la lanza con sus últimas fuerzas -- ");
        String muerto = inv.quitarAliadoAlAzar(true).getNombre();
        System.out.println("'"+muerto.toUpperCase()+"'" + ": ¿Eh? ¡Cuidado, la...!");
        System.out.println(" -- La roca golpea a " + muerto + " y lo mata en el acto -- ");
        sc.nextLine();
        System.out.println(" ");                                       // mayúsculas
        System.out.println("'"+jugadorTOP.getNombre().toUpperCase()+"'" + ": ¡NOOOOOOOO! ¡HIJO DE PUT*****************!");
        sc.nextLine();
        System.out.println(" ");
        System.out.println("'"+nombre.toUpperCase()+"'" + " se levanta, riendo entre dientes. Sus ojos brillan con un resplandor que no es suyo.");
        System.out.println("'"+nombre.toUpperCase()+"'" + ": Infantino tenía razón. Todos sois unos miserables. Él me ha dado una segunda oportunidad y... voy a acabar con todos vosotros.");
        sc.nextLine();
        
        System.out.println(" ");
        System.out.println(" -- Su vida ha AUMENTADO. El combate CONTINÚA -- ");
        sc.nextLine();

        // Fase 2: 200 de vida
        return Combate.pelear(jugadorTOP, new VillanoTraidor(nombre, 200), sc);
    }


// ---------------- RONDA FINAL: SEDE DE LA FIFA (3 fases) ----------------
    public static boolean rondaInfantino(Scanner sc, Jugador jugadorTOP)
    {
        Inventario inv = jugadorTOP.getInventario();
        int danoMin = 8;
        int danoMax = 24;

        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/");
        System.out.println(" ==/==/                                                            ==/==/");
        System.out.println(" ==/==/                        RONDA FINAL                         ==/==/");
        System.out.println(" ==/==/                                                            ==/==/");
        System.out.println(" ==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/");
        sc.nextLine();

        System.out.println(" -- Has llegado a la sede de la FIFA. Gianni Infantino te espera... -- ");
        System.out.println("Pulsa ENTER para continuar...");
        sc.nextLine();

        // ANTES DE LA PELEA: Infantino intenta justificarse
        System.out.println(" ");
        System.out.println(" -- Al fondo de una sala inmensa, sentado en un trono de trofeos, Gianni Infantino te mira sin moverse -- ");
        System.out.println("'INFANTINO': Por fin llegas, " + jugadorTOP.getNombre() + ". Te esperaba...");
        sc.nextLine();

        System.out.println(" ");
        System.out.println("'INFANTINO': Empuñas tu arma, ¿verdad? No hace falta. Primero escúchame. Solo te pido esa oportunidad.");
        sc.nextLine();

        System.out.println(" ");
        System.out.println("'INFANTINO': ¿Sabes por qué creé este mundo? Porque en el verdadero se estaba muriendo.");
        System.out.println("'INFANTINO': Lesiones graves en cada put* partido, estrellas que se quedan calvas a los 25, y el put*simpo 'Fútbol Champain'.");
        sc.nextLine();

        System.out.println(" ");
        System.out.println("'INFANTINO': Aquí nadie envejece. Nadie se lesiona de verdad. Nadie pierde un Mundial por un árbitro.");
        System.out.println("'INFANTINO': Aquí sus héroes viven para siempre. Yo no los encerré: yo los SALVÉ.");
        sc.nextLine();

        System.out.println(" ");
        System.out.println("'INFANTINO': Los villanos solo eran el precio. Alguien tenía que cuidar este mundo, y lo hice con mis manos.");
        System.out.println("'INFANTINO': Dime, " + jugadorTOP.getNombre() + ", ¿cuánto has perdido tú por llegar hasta aquí?");
        sc.nextLine();

        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" -- Tragas saliva. Sus palabras suenan raras... casi... razonables -- ");
        sc.nextLine();
        System.out.println(" ");
        System.out.println(" -- Cierras los ojos y recuerdas las puertas a las internacionales -- ");
        System.out.println(" -- Recuerdas a Alehkshander Zeferhin, el silencio de tus aliados y las dos vidas que entregaste para llegar hasta aquí -- ");
        sc.nextLine();
        System.out.println(" ");
        System.out.println(" -- ¿Y si de verdad eso tiene sentido? ¿Y si todo el dolor sirvió para algo? ¿Y si puedes parar de luchar? -- ");
        System.out.println(" -- Quizás, solo quizás, Infantino... ");
        sc.nextLine();
        System.out.print(" tiene razón --  ");
        sc.nextLine();
        System.out.println(" ");
        System.out.println("'INFANTINO': Únete a mí. Juntos haremos que nadie vuelva a sufrir. Nadie más tendrá que sacrificar a nadie.");
        System.out.println("'INFANTINO': Ven. Da un paso hacia mí.");
        sc.nextLine();
        System.out.println(" ");
        System.out.println(" -- Das un paso. Luego otro. Tus aliados te miran sin poder creerlo.");
        System.out.println(" -- Infantino sonríe y extiende la mano...");
        sc.nextLine();
        System.out.println(" ");
        System.out.println(" -- ...pero entonces piensas en los que se quedaron atrás. En cada nombre. En cada cara.");
        System.out.println(" -- No. Ninguna justificación vale la vida de los que han caído por ti.");
        sc.nextLine();
        System.out.println(" ");
        System.out.println("'"+jugadorTOP.getNombre().toUpperCase()+"'" + ": Eso no se llama salvarlos. Eso se llama robarles la vida.");
        System.out.println(" -- Y sin darle tiempo a reaccionar, le lanzas el primer golpe.");
        System.out.println("'INFANTINO': ¡MALDITO INGRATO! Si eso es lo que quieres... moriréis todos.");
        System.out.println(" -- Pulsa ENTER para luchar...");
        sc.nextLine();

        // FASE 1: 150 de vida, combate normal
        if (!Combate.pelearFase(jugadorTOP, new VillanoInfantino(150, danoMin, danoMax), sc)) {
            return false;
        }

        jugadorTOP.curarEntreFases(15);
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("¡HAS DERROTADO A GIANNI INFANTINO!");
        System.out.println("Pulsa ENTER para continuar...");
        sc.nextLine();
        System.out.println(" ");
        System.out.println(" -- Silencio. Un silencio que pesa sobre toda la sala -- ");
        System.out.println(" -- Entonces, una risa grave y lenta empieza a retumbar entre las paredes...");
        sc.nextLine();
        System.out.println(" ");
        System.out.println(" -- Tragas saliva y notas como si una bola de fuego estuviera recorriendo tu garganta en estos precisos momentos -- ");
        sc.nextLine();
        System.out.println(" ");
        System.out.println("'INFANTINO': ¿De verdad creías que me podrías derrotar?");
        System.out.println("'INFANTINO': Yo decido quién juega, quién gana y quién desaparece. Yo decido todo en este mundo que YO MISMO CREÉ.");
        sc.nextLine();
        System.out.println(" ");
        System.out.println(" -- Infantino se levanta. Su cuerpo crece, el suelo se agrieta y su sombra devora la sala entera -- ");
        sc.nextLine();

        Personaje caido = inv.quitarAliadoAlAzar(true);
        System.out.println(" ");
        System.out.println("'"+caido.getNombre().toUpperCase()+"'" + ": ¡HOSTIA! ¡Se está levantando otra vez!");
        System.out.println("'"+caido.getNombre().toUpperCase()+"'" + ": VEN AQUÍ, HIJO DE PUT*, TE VAMOS A HACER PICADILLO, CALVO CORRUP....");
        sc.nextLine();
        System.out.println(" ");
        System.out.println(" -- Infantino lo aplasta de un solo golpe. " + caido.getNombre() + " ya no volverá a luchar. Lo acaba de matar... -- ");
        System.out.println("'INFANTINO': Uno menos. Todavía me quedan ganas de jugar.");
        sc.nextLine();
        System.out.println(" ");
        System.out.println(" -- No sabes muy bien qué decir, pero sí sabes qué quieres hacerle a ese mamonazo -- ");
        System.out.println(" -- Con las fuerzas que te faltan, vas corriendo a matarlo");
        sc.nextLine();
        System.out.println(" ");
        System.out.println(" -- Pero antes de avanzar tan solo unos 10 miserables metros, te frenas en seco --");

        // FASE 2: 200 de vida, x1,5 de daño gracias a 2 villanos revividos
        String[] villanos = {"Peter Lim", "Juan Roig", "Martín Presa", "Joselu Mato", "Ángel Torres", "Fernando Llorente",
            "Goran Dorovic", "Del Nido Jr", "Lopera", "Jesús Gil", "Laporta", "Florentino Pérez", "Martín Palermo",
            "Gonzalo Higuaín", "Lewandowski", "Mbappé", "Van Persie", "Carlos Tevez", "Donnarumma", "Boateng", "Luis Suárez"};
        int a = random.nextInt(villanos.length);
        int b = random.nextInt(villanos.length);
        while (b == a) {
            b = random.nextInt(villanos.length);
        }

        System.out.println(" ");
        System.out.println(" -- Infantino alza los brazos y el aire se vuelve oscuro y pesado -- ");
        System.out.println("Infantino: Levantaos, mis viejos siervos. Esta vez no habrá PIEDAD -- ");
        sc.nextLine();
        System.out.println(" ");
        System.out.println(" -- De la nada, " + villanos[a] + " y " + villanos[b] + " vuelven a la vida, con los ojos en blanco, y se arrodillan ante su amo -- ");
        System.out.println(" -- Infantino absorbe su poder. Sus golpes ahora pesan x1,5 más -- ");
        System.out.println("'INFANTINO': Ahora comprendes lo que es el verdadero poder.");
        sc.nextLine();

        System.out.println(" ");
        System.out.println("'"+jugadorTOP.getNombre().toUpperCase()+"'" + ": Vamos..., NO ME JODAS...");
        System.out.println(" -- Te quedas quieto del terror, tan quieto como si estuvieras en un traje de fuerza --  ");

        if (!Combate.pelearFase(jugadorTOP, new VillanoInfantino(200, (int) (danoMin * 1.5), (int) (danoMax * 1.5)), sc)) {
            return false;
        }

        jugadorTOP.curarEntreFases(15);
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" -- ¡ESTA VEZ SÍ! ¡HAS DERROTADO A GIANNI INFANTINO! -- ");
        System.out.println("Pulsa ENTER para continuar...");
        sc.nextLine();
        System.out.println(" ");
        System.out.println("'"+jugadorTOP.getNombre().toUpperCase()+"'" + ": No... no no no no no no no..., ¡NO PUEDE SEEEEEER!");
        sc.nextLine();
        System.out.println(" ");
        System.out.println(" -- Pero Infantino no cae. Se agarra a la pared, se incorpora despacio y te clava la mirada -- ");
        System.out.println("'INFANTINO': Has cometido un error. Has hecho que me enfade.");
        sc.nextLine();

        Personaje caido2 = inv.quitarAliadoAlAzar(true);
        System.out.println(" ");
        System.out.println("'"+caido2.getNombre().toUpperCase()+"'" + ": No... no puede ser. ¡Si ya estaba en el suelo! ¡Corre, no te pares!");
        System.out.println("'"+caido2.getNombre().toUpperCase()+"'" + " se pone delante de ti: 'Yo lo entretengo. Tú acaba con él. ¡Hazlo por todos!'");
        sc.nextLine();
        System.out.println(" ");
        System.out.println(" -- Esta vez no hay aviso. Infantino se mueve tan rápido que ni lo ves -- ");
        System.out.println(" -- Atraviesa a " + caido2.getNombre() + " sin esfuerzo, y el eco del golpe te deja sordo -- ");
        sc.nextLine();
        System.out.println(" ");
        System.out.println("'"+jugadorTOP.getNombre().toUpperCase()+"'" + ": ¡NOOOOOOOOOOOOOOOOOOO!");
        System.out.println("'"+jugadorTOP.getNombre().toUpperCase()+"'" + ": ¡ME CAGO EN TODA TU GENERACIÓN, PAYO MI3RDAAAAAS! ¡TE VOY A MATAR, CHACHOOOOO!");
        System.out.println("'INFANTINO': ¿Estás seguro? Venga, a tomar por c*lo...");
        sc.nextLine();

        // FASE 3: 250 de vida, x2 de daño. Aquí sí da los premios del combate
        System.out.println(" ");
        System.out.println(" -- El cielo se rompe. Infantino lo da TODO y su poder se desborda: su daño se duplica, x2 -- ");
        System.out.println("'INFANTINO': ¡NO HAY NADIE POR ENCIMA DE MÍ! ¡ARRODÍLLATE ANTE MÍ!");
        sc.nextLine();

        if (!Combate.pelearFase(jugadorTOP, new VillanoInfantino(250, danoMin * 2, danoMax * 2), sc)) {
            return false;
        }

        // Último combate: suma los 100 puntos y guarda la vida para la bonificación final
        jugadorTOP.sumarPuntos();

        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" -- Infantino cae de rodillas. Su cuerpo tiembla y la corona de trofeos rueda por el suelo -- ");
        sc.nextLine();
        System.out.println(" ");
        System.out.println("'INFANTINO': No... no es posible... Yo lo creé todo... Yo soy el fútbol...");
        sc.nextLine();
        System.out.println(" ");
        System.out.println("'"+jugadorTOP.getNombre().toUpperCase()+"'" + ": No. El fútbol es de la gente. Nunca fue tuyo.");
        sc.nextLine();
        System.out.println(" ");
        System.out.println(" -- El suelo se rompe. Las paredes se deshacen como si fueran de papel -- ");
        System.out.println(" -- Los estadios, los carteles y los trofeos empiezan a desaparecer. El mundo que Infantino creó se está cayendo a pedazos -- ");
        sc.nextLine();
        System.out.println(" ");
        System.out.println(" -- Entre la luz y el polvo, ves a tus aliados que siguen en pie: --");
        for (int i = 0; i < inv.getNumAliados(); i++) {
            System.out.println("    - " + inv.getAliado(i).getNombre());
        }
        sc.nextLine();
        System.out.println(" ");
        System.out.println(" -- Pero no están todos. Piensas en " + caido.getNombre() + " y en " + caido2.getNombre() + ", que no han podido ver este momento -- ");
        System.out.println(" -- Y en cada nombre que se quedó atrás para que tú llegaras hasta aquí -- ");
        sc.nextLine();
        System.out.println(" ");
        System.out.println("'"+jugadorTOP.getNombre().toUpperCase()+"'" + ": Esto es por vosotros. Por todos.");
        sc.nextLine();
        System.out.println(" ");
        System.out.println(" -- Una luz blanca lo cubre todo -- ");
        System.out.println(" -- Y cuando se apaga, estás de vuelta en el campo de Mestalla, con el césped bajo los pies y la grada llena -- ");
        System.out.println(" -- Todo ha terminado. El mundo de Infantino ya no existe -- ");
        sc.nextLine();

        return true;
    }

}