import java.util.Scanner;
 
public class Juego
{
 
public static void main(String[] args) 
{
    Scanner sc = new Scanner(System.in);
    int opcion;

    // Ranking: dos arrays paralelos que se cargan desde el XML al arrancar
    String[] nombresRanking = new String[Ranking.MAX_JUGADORES];
    int[] puntosRanking = new int[Ranking.MAX_JUGADORES];
    int contadorRanking = Ranking.cargarRanking(Ranking.RUTA_XML, nombresRanking, puntosRanking);

    boolean xmlCorrecto = contadorRanking != -1;
    if (!xmlCorrecto) 
        {
        System.out.println("Se juega con el ranking vacio y no se guardara hasta que se corrija el XML.");
        contadorRanking = 0;
    } else 
        {
            // Por si el XML se ha cambiado a mano, la web se pone al dia al arrancar
            Ranking.generarHTML(Ranking.RUTA_XML);
        }

        System.out.println("==================================");
        System.out.println("     EL DESPERTAR DEL HEROE");
        System.out.println("         FOOTBALL EDITION");
        System.out.println("==================================");
        
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Estás a punto de adentrarte en un mundo lleno de increíbles famosos, más concretamente de futbolistas.");
        System.out.println("Así que si no sabes ni quién es Isi Palazón, por favor, sal de aquí, gracias :) ");
        System.out.println("Pero antes de nada estaría bien saber por qué te vas a pelear contra gente del mundo del fútbol, ¿no?");
        System.out.println("");
 
 
        System.out.println("¿QUIERES SABER CÓMO HEMOS LLEGADO HASTA AQUÍ?");
        System.out.println("Si es que sí, pulsa enter para continuar con la historia...");
            sc.nextLine();
        
        
        System.out.println("");
        System.out.println("Para ello nos remontamos al 28 de julio de 2026.");
        System.out.println("Los diarios The Times y Financial Times desatan una exclusiva mundial al revelar el proyecto secreto de Gianni Infantino: ");
        System.out.println("vender el 20% de los derechos del Mundial a inversores privados estadounidenses por 4.200 millones de dólares.");
        System.out.println("");
        System.out.println("La reacción es fulminante. La UEFA estalla indignada ante el plan oculto y amenaza con un boicot total a la competición.");
        System.out.println("Tras cuatro días de máxima tensión y acusado de recibir millonarios sobresueldos opacos para su vida de lujo en Miami, Infantino se queda completamente solo.");
        System.out.println("");
        System.out.println("Por lo que el 1 de agosto, el presidente capitula, pide disculpas y cancela definitivamente su plan secreto.");
        System.out.println("");
        System.out.println("Pero una mancha quedó imborrable en la memoria de Infantino.");
        System.out.println("Así que, en uno de los arrebatos que les suelen dar a los millonarios calvos que controlan empresas, decidió hacer una locura....");
        System.out.println("");
 
        System.out.println("¿Seguimos con la historia?");
        System.out.println("Pulsa enter para continuar con la historia...");
            sc.nextLine();
 
        System.out.println("");
        System.out.println("Decidió contactar con uno de los científicos más brillantes de nuestra era moderna: Hugh Hard.");
        System.out.println("Junto a este, creó un mundo de fútbol, donde atrapó a varios futbolistas, dándoles un rol de héroes o de villanos según el club.");
        System.out.println("");
        System.out.println("Tu misión será ir avanzando club por club, hasta llegar a Infantino, al cual te tendrás que enfrentar, para destruir este mundo para siempre.");
 
        System.out.println("Pulsa Enter para continuar...");
        sc.nextLine();
 
    do 
    {
        System.out.println(" ");
        System.out.println("========== MENU PRINCIPAL ==========");
        System.out.println("1. Nueva partida");
        System.out.println("2. Consultar ranking");
        System.out.println("3. Ver normas");
        System.out.println("4. Salir del juego");
        System.out.print("Elige una opcion: ");        
 
    opcion = leerEntero(sc);
 
        switch (opcion) 
        {
            case 1:
                System.out.println(" ");
                System.out.println(" ");
                // El nombre no puede estar vacio ni ser solo espacios
                String nombre = "";
                while (nombre.trim().isEmpty()) {
                    System.out.print("¿Como te llamas amigo mio? ");
                    nombre = sc.nextLine();
                    if (nombre.trim().isEmpty()) {
                        System.out.println("El nombre no puede estar vacio.");
                    }
                }
                    Jugador jugadorTOP = new Jugador(nombre.trim());
                    jugadorTOP.mostrarEstado();
 
                System.out.println(" ");
                System.out.println("INICIANDO NUEVA PARTIDA...");
                System.out.println("Pulsa ENTER para comenzar la aventura");
                    sc.nextLine();
 

                // NIVEL 1: LALIGA
                    boolean villanoDerrotado = Elecciones.rondaInicial(sc, jugadorTOP);
 
                    if (villanoDerrotado) {
                        villanoDerrotado = Elecciones.ronda1(sc, jugadorTOP);
                    }
                    if (villanoDerrotado) {
                        villanoDerrotado = Elecciones.ronda2(sc, jugadorTOP);
                    }
                    if (villanoDerrotado) {
                        villanoDerrotado = Elecciones.ronda3(sc, jugadorTOP);
                    }
                    if (villanoDerrotado) {
                        villanoDerrotado = Elecciones.rondaFinalLaLiga(sc, jugadorTOP);
                    }
                    if (villanoDerrotado) {
                        System.out.println("Has superado las rondas nacionales...");
                        

                // NIVEL 2: INTERNACIONALES        
                        Elecciones.puertasDeLaLiga(sc, jugadorTOP);
                        villanoDerrotado = Elecciones.rondaInter1(sc, jugadorTOP);
                    }
                    if (villanoDerrotado) {
                        villanoDerrotado = Elecciones.rondaInter2(sc, jugadorTOP);
                    }
                    if (villanoDerrotado) {
                        villanoDerrotado = Elecciones.rondaInter3(sc, jugadorTOP);
                    }


                // FINAL
                    if (villanoDerrotado) {
                        villanoDerrotado = Elecciones.rondaTraidor(sc, jugadorTOP);
                    }
                    if (villanoDerrotado) {
                        villanoDerrotado = Elecciones.rondaInfantino(sc, jugadorTOP);
                    }
                    if (villanoDerrotado) {
                        finDelJuego(sc, jugadorTOP);
                    } else {
                        if (jugadorTOP.haAbandonado()) {
                            System.out.println("Has abandonado la aventura.");
                        } else {
                            System.out.println("GAME OVER. Fin del juego.");
                        }
                        System.out.println("===/====/===/===/===/===/===/===/====/===/===/===/===/===/");
                        System.out.println("Puntuacion final: " + jugadorTOP.getPuntos());
                    }

                // Toda partida terminada (victoria, derrota o abandono) entra como candidata
                    contadorRanking = Ranking.registrarPartida(nombresRanking, puntosRanking, contadorRanking,
                                                               jugadorTOP.getNombre(), jugadorTOP.getPuntos(), xmlCorrecto);
                break;

            case 2:
                System.out.println(" ");
                Ranking.mostrarRanking(nombresRanking, puntosRanking, contadorRanking);
                System.out.println(" ");
                break;
 
            case 3:
                 System.out.println(" ");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println("==================================");
                System.out.println("         NORMAS DEL JUEGO         ");
                System.out.println("==================================");
                System.out.println(" ");
                System.out.println("1. Comenzarás tu aventura en Mestalla, el histórico estadio del Valencia CF, donde se iniciará tu misión.");
                System.out.println(" ");
                System.out.println("2. Tendrás que superar 3 rondas nacionales. En cada ronda encontrarás 3 estadios de LaLiga y deberás elegir uno para continuar tu aventura.");
                System.out.println(" ");
                System.out.println("3. En cada estadio te enfrentarás a un villano del club que habrá secuestrado a uno de sus héroes históricos.");
                System.out.println(" ");
                System.out.println("4. Si consigues derrotar al villano, liberarás al héroe y se unirá a tu equipo como aliado para las siguientes batallas.");
                System.out.println(" ");
                System.out.println("5. Cuando superes las rondas nacionales, viajarás por los grandes estadios internacionales para enfrentarte a nuevos enemigos y conseguir aliados legendarios.");
                System.out.println(" ");
                System.out.println("6. Tu misión final será enfrentarte a Infantino para poder destruir este mundo que nunca debería haber sido creado.");
                System.out.println(" ");
                System.out.println("==================================");
 
                break;
            case 4:
                System.out.println("Gracias por jugar. ¡Hasta pronto!");
                break;
            
            default:
                System.out.println("Opción incorrecta. Elige del 1 al 4.");
                break;
        }
    } while (opcion != 4);
}

    // Lee un numero sin que el programa se cierre si se escriben letras
    public static int leerEntero(Scanner sc)
    {
        while (!sc.hasNextInt()) {
            System.out.print("Eso no és un numero. Escribe un numero: ");
            sc.nextLine();
        }
        int numero = sc.nextInt();
        sc.nextLine();
        return numero;
    }

    // Final del juego: puntos totales, creditos y escena despues de los creditos
    public static void finDelJuego(Scanner sc, Jugador jugadorTOP)
    {
        int puntosCombates = jugadorTOP.getPuntos();
        int bonus = jugadorTOP.sumarVidaFinal();

        System.out.println(" ");
        System.out.println(" ");
        System.out.println("========================================================");
        System.out.println("          ¡HAS DESTRUIDO EL MUNDO DEL FÚTBOL!");
        System.out.println("               Enhorabuena, campeón.");
        System.out.println("========================================================");
        sc.nextLine();

        System.out.println(" ");
        System.out.println("========== PUNTUACIÓN FINAL ==========");
        System.out.println("Jugador: " + jugadorTOP.getNombre());
        System.out.println("Puntos por enemigos derrotados: " + puntosCombates);
        System.out.println("Bonificación por vida restante: " + bonus);
        System.out.println("--------------------------------------");
        System.out.println("TOTAL: " + jugadorTOP.getPuntos() + " puntos");
        System.out.println("======================================");
        sc.nextLine();

        System.out.println(" ");
        System.out.println("  ==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/");
        System.out.println("  ==/==/                                              ==/==/");
        System.out.println("  ==/==/                    F I N                     ==/==/");
        System.out.println("  ==/==/                                              ==/==/");
        System.out.println("  ==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/");
        sc.nextLine();

        System.out.println(" ");
        System.out.println(" ");
        System.out.println("                      ~ C R É D I T O S ~");
        sc.nextLine();

        System.out.println(" ");
        System.out.println("     Héroe ........................ " + jugadorTOP.getNombre());
        sc.nextLine();
        System.out.println("     Guion ........................ Óscar Rodrigo Breso");
        System.out.println("     Programación de código ....... Óscar Rodrigo Breso");
        System.out.println("     Director del juego ........... Óscar Rodrigo Breso");
        System.out.println("     Diseño de personajes ......... Óscar Rodrigo Breso");
        System.out.println("     Diseño de niveles ............ Óscar Rodrigo Breso");
        System.out.println("     Diseño de combates ........... Óscar Rodrigo Breso");
        System.out.println("     Arte ASCII ................... Óscar Rodrigo Breso");
        System.out.println("     Pruebas y testeo ............. Óscar Rodrigo Breso");
        System.out.println("     Productor ejecutivo .......... Óscar Rodrigo Breso");
        System.out.println("     Entrenador de basket ......... Óscar Rodrigo Breso");
        sc.nextLine();
        System.out.println("     Villano final ................ Gianni Infantino (a su pesar)");
        System.out.println("     Científico loco .............. Hugh Hard");
        sc.nextLine();
        System.out.println("  ------------------------------------------------------------");
        System.out.println("     En memoria de los aliados que nunca volverán a luchar.");
        System.out.println("  ------------------------------------------------------------");
        sc.nextLine();
        System.out.println("  ==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/");
        System.out.println(" ");
        System.out.println("                      Gracias por jugar.");
        System.out.println(" ");
        System.out.println("  ==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/");
        System.out.println(" ");
        sc.nextLine();
        sc.nextLine();
        sc.nextLine();
        sc.nextLine();
        sc.nextLine();

        System.out.println(" ");
        System.out.println(" ");
        System.out.println("--------- ESCENA POSTCRÉDITOS ---------");
        sc.nextLine();

        System.out.println(" ");
        System.out.println(" -- Un búnker, a kilómetros bajo tierra. Una cámara encendida sobre una mesa. Hugh Hard, el científico loco, se graba a sí mismo -- ");
        sc.nextLine();

        System.out.println("'HUGH HARD': Día 23, sin incidentes. El ritmo cardíaco está estable.");
        sc.nextLine();

        System.out.println("'HUGH HARD': Los niveles de aire son más bajos que ayer, pero siguen dentro de lo que puedo controlar.");
        sc.nextLine();

        System.out.println("'HUGH HARD': Aún sigo sin temblores. Sin pérdida de memoria.");
        sc.nextLine();

        System.out.println("'HUGH HARD': Hace tres semanas que no abro esa puerta. A veces hay gente arriba. Los oigo caminar.");
        System.out.println("'HUGH HARD': No tienen ni idea de lo que hay debajo de sus pies.");
        sc.nextLine();

        System.out.println("'HUGH HARD': He hecho todas las pruebas que conozco. Desde que cayó el mundo de Infantino, algo de la máquina se quedó dentro de mí.");
        System.out.println("'HUGH HARD': Mi ADN no solo muta: se adapta. Responde al estrés.");
        System.out.println("'HUGH HARD': Y no sé qué pasará el día en que no pueda decirle que no.");
        sc.nextLine();

        System.out.println("'HUGH HARD': Si alguien del laboratorio encuentra esta grabación, no bajéis. No intentéis rescatarme.");
        System.out.println("'HUGH HARD': Porque si vuelvo a cambiar... no sé si me acordaré de quienes sois.");
        sc.nextLine();

        System.out.println(" -- La imagen se llena de interferencias. La luz parpadea -- ");
        System.out.println("'HUGH HARD': La señal se está degradando. Pero, si soy sincero, no sé muy bien a qué se debe el fallo.");
        sc.nextLine();

        System.out.println("'HUGH HARD': Eso es lo que nadie te cuenta sobre volverte peligroso.");
        System.out.println("'HUGH HARD': No tienes miedo de morir... sino de sobrevivir lo suficiente para ver lo que has hecho.");
        sc.nextLine();

        System.out.println("'HUGH HARD': Pienso en la primera vez. Todos me dicen que no fui yo. Que solo obedecía a Infantino.");
        System.out.println("'HUGH HARD': Pero, científicamente, esa explicación no funciona.");
        sc.nextLine();

        System.out.println("'HUGH HARD': ¿Pero por qué parpadea tanto la luz?");
        System.out.println("'HUGH HARD': Si esta semana ha ido perfectamente el sistema eléctrico... bueno, da igual, sigo...");
        sc.nextLine();

        System.out.println("'HUGH HARD': La máquina salió de mis manos, de mis ideas, de mi ambición.");
        sc.nextLine();

        System.out.println("'HUGH HARD': Entonces... ¿dónde acaba ella? ¿Y dónde empiezo yo?");
        sc.nextLine();

        System.out.println(" -- Un golpe seco. Un brillo naranja se extiende por el suelo del búnker, un brillo como el de una invocación paranormal -- ");
        sc.nextLine();

        System.out.println(" -- Entre el humo, se escucha una voz oscura, una voz mucho más imponente de lo que nos podemos imaginar -- ");
        System.out.println(" -- Una voz atemorizante, una voz a simple vista mucho más poderosa que Infantino. Esta dice: -- ");
        sc.nextLine();

        System.out.println("'ADAM SILVER': Cuánto tiempo sin verle, Dr. Hard.");
        sc.nextLine();

        System.out.println("'HUGH HARD': ¿Perdone...? ¿Le... le conozco? ¿¡Quién es usted y qué hace aquí!?");
        sc.nextLine();

        System.out.println("'ADAM SILVER': Me llamo Adam Silver, y he venido a reclutarlo.");
        sc.nextLine();

        System.out.println(" -- Se ve cómo se llevan a la fuerza al Dr. Hugh Hard por el mismo portal por donde entró ese misterioso hombre -- ");
        sc.nextLine();

        System.out.println(" -- Se cierra el portal y la sala se queda en total silencio, un silencio aterrador por lo que ocurrirá... -- ");
        System.out.println(" -- Pero es un silencio más aterrador de cara al... futuro -- ");
        sc.nextLine();
        
        System.out.println("La cámara se gira hacia abajo y, en el suelo, donde se hallaba el portal ya cerrado, hay un logo marcado con fuego naranja.");
        System.out.println("Un logo similar, como si fuera una pelota de Ba...");  
        sc.nextLine();

        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/");
        System.out.println(" ==/==/                                                         ==/==/");
        System.out.println(" ==/==/               EL DR HUGH HARD VOLVERA EN...             ==/==/");
        System.out.println(" ==/==/                                                         ==/==/");
        System.out.println(" ==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/");
        sc.nextLine();

        System.out.println(" ");
        System.out.println("  ==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/====/==");
        System.out.println(" ");
        System.out.println("  @@@@@   @         @@@@    @@@@@    @@@@   @@@@    @@@@@   @@@@    @@@@@    @@@    @@@@");
        System.out.println("  @       @         @   @   @       @       @   @   @       @   @     @     @   @   @   @");
        System.out.println("  @@@@    @         @   @   @@@@     @@@    @@@@    @@@@    @@@@      @     @@@@@   @@@@");
        System.out.println("  @       @         @   @   @           @   @       @       @  @      @     @   @   @  @");
        System.out.println("  @@@@@   @@@@@     @@@@    @@@@@   @@@@    @       @@@@@   @   @     @     @   @   @   @");
        System.out.println(" ");
        System.out.println("           @@@@    @@@@@   @         @   @   @@@@@   @@@@     @@@    @@@@@");
        System.out.println("           @   @   @       @         @   @   @       @   @   @   @   @");
        System.out.println("           @   @   @@@@    @         @@@@@   @@@@    @@@@    @   @   @@@@");
        System.out.println("           @   @   @       @         @   @   @       @  @    @   @   @");
        System.out.println("           @@@@    @@@@@   @@@@@     @   @   @@@@@   @   @    @@@    @@@@@");
        System.out.println(" ");
        System.out.println("                            @@@@    @@@@@          @@@");
        System.out.println("                            @   @     @           @   @");
        System.out.println("                            @@@@      @             @@");
        System.out.println("                            @         @            @");
        System.out.println("                            @         @     @     @@@@@");
        System.out.println(" ");
        System.out.println("  ==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/====/==");
        sc.nextLine();



        System.out.println(" ");
        System.out.println("  ==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==");
        System.out.println(" ");
        System.out.println("                   @@@@     @@@     @@@@   @   @   @@@@@   @@@@@");
        System.out.println("                   @   @   @   @   @       @  @    @         @");
        System.out.println("                   @@@@    @@@@@    @@@    @@@     @@@@      @");
        System.out.println("                   @   @   @   @       @   @  @    @         @");
        System.out.println("                   @@@@    @   @   @@@@    @   @   @@@@@     @");
        System.out.println(" ");  
        System.out.println("                @@@@@   @@@@    @@@@@   @@@@@   @@@@@    @@@    @   @");
        System.out.println("                @       @   @     @       @       @     @   @   @@  @");
        System.out.println("                @@@@    @   @     @       @       @     @   @   @ @ @");
        System.out.println("                @       @   @     @       @       @     @   @   @  @@");
        System.out.println("                @@@@@   @@@@    @@@@@     @     @@@@@    @@@    @   @");
        System.out.println(" "); 
        System.out.println("  ==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==");
        sc.nextLine();
    }
}