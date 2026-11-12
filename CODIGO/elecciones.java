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
        jugadorTOP.setSubidaArma(4);

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
            int eleccion = sc.nextInt();
            sc.nextLine();
 
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
        System.out.println(" -- Estas a un paso de la sede de la FIFA. El cielo es de un rojo oscuro y nadie dice una palabra -- ");
        System.out.println(" -- Hace tiempo que tus aliados caminan en silencio. Desde las puertas de LaLiga, algo se ha roto entre vosotros -- ");
        sc.nextLine();
        System.out.println(" ");
        System.out.println(" -- De pronto, " + nombre + " se detiene. Tiene la mirada clavada en el suelo -- ");
        System.out.println("'"+nombre.toUpperCase()+"'" + ": Llevo noches sin dormir. Una voz me habla en sueños.");
        sc.nextLine();
        System.out.println(" ");
        System.out.println("'"+nombre.toUpperCase()+"'" + ": Es Infantino. Dice que nadie tiene por que sufrir, que nadie tiene por que morir.");
        System.out.println("'"+nombre.toUpperCase()+"'" + ": Dice que en su mundo nadie envejece, nadie pierde y nadie es sacrificado.");
        sc.nextLine();
        System.out.println(" ");
        System.out.println("'"+jugadorTOP.getNombre().toUpperCase()+"'" + ": ¡ES UNA TRAMPA!, Te esta mintiendo");
        sc.nextLine();
        System.out.println(" ");
        System.out.println("'"+nombre.toUpperCase()+"'" + ": ¿Mintiendo? Tu entregaste a dos de los nuestros para cruzar una puerta. Y no dudaste.");
        System.out.println("'"+nombre.toUpperCase()+"'" + ": Yo tambien puedo ser el siguiente. No pienso esperar a que me elijas.");
        sc.nextLine();
        System.out.println(" ");
        System.out.println("Los demas aliados retroceden. Nadie se atreve a respirar.");
        System.out.println("'"+nombre.toUpperCase()+"'" + ": Lo siento de verdad. Pero Infantino me ha prometido la libertad. Aqui acaba vuestro viaje.");
        sc.nextLine();
        System.out.println(" ");
        System.out.println(" -- "+ nombre + " desenvaina su arma y se lanza contra ti. Ya no es tu aliado. Te acab de traicinionar en el peor momento");
        System.out.println("Pulsa ENTER para luchar...");
        sc.nextLine();

        // Fase 1: 100 de vida
        if (!Combate.pelearFase(jugadorTOP, new VillanoTraidor(nombre, 100), sc)) {
            return false;
        }

        System.out.println(" ");
        System.out.println(" -- " + nombre + " cae de rodillas, con la respiracion rota. Levanta la vista hacia ti -- ");
        System.out.println("'"+nombre.toUpperCase()+"'" + ": ¿Por que? Yo simplemente queria... no tener miedo.");
        sc.nextLine();
        System.out.println(" ");
        System.out.println(" -- Todo ha terminado... -- ");
        sc.nextLine();
        System.out.println("Bueno, parece que todo ha terminado... ");
        System.out.println(" -- Algo no va bien: " + nombre + " sonrie -- ");
        sc.nextLine();
        System.out.println(" ");
        System.out.println(" -- Cuando bajais la guardia, " + nombre + " agarra una roca enorme y la lanza con sus ultimas fuerzas -- ");
        String muerto = inv.quitarAliadoAlAzar(true).getNombre();
        System.out.println("'"+muerto+"'" + ": ¿Eh? ¡Cuidado, la...!");
        System.out.println(" -- La roca golpea a " + muerto + " y lo mata en el acto -- ");
        sc.nextLine();
        System.out.println(" ");                                       // mayusuculas
        System.out.println("'"+jugadorTOP.getNombre().toUpperCase()+"'" + ": ¡NOOOOOOOO! ¡HIJO DE PUT*****************!");
        sc.nextLine();
        System.out.println(" ");
        System.out.println("'"+nombre.toUpperCase()+"'" + " se levanta, riendo entre dientes. Sus ojos brillan con un resplandor que no es suyo.");
        System.out.println("'"+nombre.toUpperCase()+"'" + ": Infantino tenia razon. Todos sois unos miserable, el me ha dado una seguna oportunidad, y...voy a acabar con todos vosotros.");
        System.out.println(" ");
        System.out.println(" -- Su vida ha AUMENTADO. El combate CONTINUA -- ");
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
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("===== RONDA FINAL =====");
        System.out.println(" -- Has llegado a la sede de la FIFA. Gianni Infantino te espera... -- ");
        System.out.println("Pulsa ENTER para continuar...");
        sc.nextLine();

        // ANTES DE LA PELEA: Infantino intenta justificarse
        System.out.println(" ");
        System.out.println(" -- Al fondo de una sala inmensa, sentado en un trono de trofeos, Gianni Infantino te mira sin moverse -- ");
        System.out.println("'INFANTINO': Por fin llegas, " + jugadorTOP.getNombre() + ". Te esperaba...");
        sc.nextLine();
        System.out.println(" ");
        System.out.println("'INFANTINO': Empuñas tu arma, ¿verdad? No hace falta. Primero escuchame. Solo te pido esa oportunidad.");
        sc.nextLine();
        System.out.println(" ");
        System.out.println("'INFANTINO': ¿Sabes por que cree este mundo? Porque en el verdadero se estaba muriendo.");
        System.out.println("'INFANTINO': Lesiones graves en cada put* partido, estrellas que se quedan calvos alos 25, y el put*simpo 'Futbol Champain', que los nuevos, ");
        sc.nextLine();
        System.out.println(" ");
        System.out.println("'INFANTINO': Aqui nadie envejece. Nadie se lesiona de verdad. Nadie pierde un Mundial por un arbitro.");
        System.out.println("'INFANTINO': Aqui sus heroes viven para siempre. Yo no los encerre: yo los SALVE.");
        sc.nextLine();
        System.out.println(" ");
        System.out.println("'INFANTINO': Los villanos solo eran el precio. Alguien tenia que cuidar este mundo, y lo hice con mis manos.");
        System.out.println("'INFANTINO': Dime, " + jugadorTOP.getNombre() + ", ¿cuanto has perdido tu por llegar hasta aqui?");
        sc.nextLine();

        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" -- Tragas saliva. Sus palabras suenan raras... casi... razonables -- ");
        sc.nextLine();
        System.out.println(" ");
        System.out.println(" -- Cierras los ojos y recuerdas las puertas a las intenacionales --");
        System.out.println(" -- Recuerdas a Alehkshander Zeferhin, el silencio de tus aliados y las dos vidas que entregaste para llegar hasta aqui -- ");
        sc.nextLine();
        System.out.println(" ");
        System.out.println(" -- ¿Y si de verdad eso tiene sentido? ¿Y si todo el dolor sirvio para algo? ¿Y si puedes parar de luchar? -- ");
        System.out.print(" -- Quizas, solo quizas, Infantino... ");
        sc.nextLine();
        System.out.println(" tiene razon --  ");
        sc.nextLine();
        System.out.println(" ");
        System.out.println("'INFANTINO': Unete a mi. Juntos haremos que nadie vuelva a sufrir. Nadie mas tendra que sacrificar a nadie.");
        System.out.println("'INFANTINO': Ven. Da un paso hacia mi.");
        sc.nextLine();
        System.out.println(" ");
        System.out.println(" -- Das un paso. Luego otro. Tus aliados te miran sin poder creerlo.");
        System.out.println(" -- Infantino sonrie y extiende la mano...");
        sc.nextLine();
        System.out.println(" ");
        System.out.println(" -- ...pero entonces piensas en los que se quedaron atras. En cada nombre. En cada cara.");
        System.out.println(" -- No. Ninguna justificacion vale la vida de los que han caido por ti.");
        sc.nextLine();
        System.out.println(" ");
        System.out.println("'"+jugadorTOP.getNombre().toUpperCase()+"'" + ": Eso no se llama salvarlos. Eso se llama robarles la vida.");
        System.out.println(" -- Y sin darle tiempo a reaccionar, le lanzas el primer golpe.");
        System.out.println("'INFANTINO': ¡MALDITO INGRATO! Si eso es lo que quieres... morireis todos.");
        System.out.println(" -- Pulsa ENTER para luchar...");
        sc.nextLine();

        // FASE 1: 150 de vida, combate normal
        if (!Combate.pelearFase(jugadorTOP, new VillanoInfantino(150, danoMin, danoMax), sc)) {
            return false;
        }

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
        System.out.println(" -- Tragas saliba y notas como si una bola de fuego estubiera reorriendo tu garganta en estos precisos moemntos -- ");
        sc.nextLine();
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" -- Empiezas a rezar para que no sea lo que tu crees, y de repente se escucha lo que nunca querrias imaginar -- ");
        sc.nextLine();
        System.out.println(" ");
        System.out.println("'INFANTINO': ¿De verdad creias que me podrias derrotar?");
        System.out.println("'INFANTINO': Yo decido quien juega, quien gana y quien desaparece. Yo decido todo en este mundo que YO MISMO CREE.");
        sc.nextLine();
        System.out.println(" ");
        System.out.println(" -- Infantino se levanta. Su cuerpo crece, el suelo se agrieta y su sombra devora la sala entera -- ");
        sc.nextLine();

        Personaje caido = inv.quitarAliadoAlAzar(true);
        System.out.println(" ");
        System.out.println("'"+caido.getNombre().toUpperCase()+"'" + ": ¡HOSTIA! ¡Se esta levantando otra vez!");
        System.out.println("'"+caido.getNombre().toUpperCase()+"'" + ": VEN AQUI HIJO DE PUT*, TE VAMOS A HACER PICADILLO, CALVO CORRUP....");
        sc.nextLine();
        System.out.println(" ");
        System.out.println(" -- Infantino lo aplasta de un solo golpe. " + caido.getNombre() + " ya no volvera a luchar. Lo acaba de matar... -- ");
        System.out.println("'INFANTINO': Uno menos. Todavia me quedan ganas de jugar.");
        sc.nextLine();
        System.out.println(" ");
        System.out.println(" -- No sabes muy bien que decir, pero si sabes que quieres hacerle a ese mamonazo -- ");
        System.out.println(" -- Con las fuerzas que te faltan, vas corriendo a matarlo");
        sc.nextLine();
        System.out.println(" ");
        System.out.println(" -- Pero antes de avanzar tan solo unos 10 miseros metros, te frenas en seco  --");

        // FASE 2: 200 de vida, x1,5 de daño gracias a 2 villanos revividos
        String[] villanos = {"Peter Lim", "Juan Roig", "Martin Presa", "Joselu Mato", "Angel Torres", "Fernando Llorente",
            "Goran Dorovic", "Del Nido Jr", "Lopera", "Jesus Gil", "Laporta", "Florentino Perez", "Martin Palermo",
            "Gonzalo Higuain", "Lewandowski", "Mbappe", "Van Persie", "Carlos Tevez", "Donnarumma", "Boateng", "Luis Suarez"};
        int a = random.nextInt(villanos.length);
        int b = random.nextInt(villanos.length);
        while (b == a) {
            b = random.nextInt(villanos.length);
        }

        System.out.println(" ");
        System.out.println(" -- Infantino alza los brazos y el aire se vuelve oscuro y pesado -- ");
        System.out.println("Infantino: Levantaos, mis viejos siervos. Esta vez no habra PIEDAD -- ");
        sc.nextLine();
        System.out.println(" ");
        System.out.println(" -- De la nada, " + villanos[a] + " y " + villanos[b] + " vuelven a la vida, con los ojos en blanco, y se arrodillan ante su amo -- ");
        System.out.println(" -- Infantino absorbe su poder. Sus golpes ahora pesan x1,5 mas -- ");
        System.out.println("'INFANTINO': Ahora comprendes lo que es el verdadero poder.");
        sc.nextLine();

        System.out.println(" ");
        System.out.println("'"+jugadorTOP.getNombre().toUpperCase()+"'" + "Vamos..., NO ME JODAS...");
        System.out.println(" -- Te quedas quieto del terror, tan quieto como si estubieras en un traje de fuerza --  ");

        if (!Combate.pelearFase(jugadorTOP, new VillanoInfantino(200, (int) (danoMin * 1.5), (int) (danoMax * 1.5)), sc)) {
            return false;
        }

        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" -- ¡ESTA VEZ SI! ¡HAS DERROTADO A GIANNI INFANTINO! -- ");
        System.out.println("Pulsa ENTER para continuar...");
        sc.nextLine();
        System.out.println(" ");
        System.out.println("'"+jugadorTOP.getNombre().toUpperCase()+"'" + "No... no no no no no no no..., NO PUEDE SEEEEEER !");
        sc.nextLine();
        System.out.println(" ");
        System.out.println(" -- Pero Infantino no cae. Se agarra a la pared, se incorpora despacio y te clava la mirada -- ");
        System.out.println(" -- Infantino: Has cometido un error. Has hecho que me enfade -- ");
        sc.nextLine();

        Personaje caido2 = inv.quitarAliadoAlAzar(true);
        System.out.println(" ");
        System.out.println("'"+caido2.getNombre().toUpperCase()+"'" + ": No... no puede ser. ¡Si ya estaba en el suelo! ¡Corre, no te pares!");
        System.out.println("'"+caido2.getNombre().toUpperCase()+"'" + " se pone delante de ti: 'Yo lo entretengo. Tu acaba con el. ¡Hazlo por todos!'");
        sc.nextLine();
        System.out.println(" ");
        System.out.println(" -- Esta vez no hay aviso. Infantino se mueve tan rapido que ni lo ves -- ");
        System.out.println(" -- Atraviesa a " + caido2.getNombre() + " sin esfuerzo, y el eco del golpe te deja sordo -- ");
        sc.nextLine();
        System.out.println(" ");
        System.out.println("'"+jugadorTOP.getNombre().toUpperCase()+"'" + ": ¡NOOOOOOOOOOOOOOOOOOO!");
        System.out.println("'"+jugadorTOP.getNombre().toUpperCase()+"'" + ": ¡ME CAGO EN TODA LA FAMILIA DE INFANTINO! ¡TE VOY A DESTROZAR!");
        System.out.println("'INFANTINO': Se acabaron los juegos.");
        sc.nextLine();

        // FASE 3: 250 de vida, x2 de daño. Aqui si da los premios del combate
        System.out.println(" ");
        System.out.println(" -- El cielo se rompe. Infantino lo da TODO y su poder se desborda: su daño se duplica, x2 -- ");
        System.out.println("'INFANTINO': ¡NO HAY NADIE POR ENCIMA DE MI! ¡ARRODILLATE ANTE LA FIFA!");
        sc.nextLine();

        return Combate.pelear(jugadorTOP, new VillanoInfantino(250, danoMin * 2, danoMax * 2), sc);
    }

}