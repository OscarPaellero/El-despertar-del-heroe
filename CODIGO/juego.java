import java.util.Scanner;
 
public class Juego
{
 
public static void main(String[] args) 
{
    Scanner sc = new Scanner(System.in);
    int opcion;
 
        System.out.println("==================================");
        System.out.println("     EL DESPERTAR DEL HEROE");
        System.out.println("         FOOTBALL EDITION");
        System.out.println("==================================");
        
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Estas a punto de adentrarte en un mundo lleno de increibles famosos, mas concretamente de futbolistas,");
        System.out.println("A si que si no sabes ni quien es Isi Palazon, porfavor, salte de aqui, gracias :) ");
        System.out.println("Pero antes de todo estaria bien saber por que te vas pelear contra gente del mundo del futbol ¿no?");
        System.out.println("");
 
 
        System.out.println("QUIERES SABER COMO HEMOS LLEGADO HASTA AQUI?");
        System.out.println("Si es que si, pulsa enter para continuar con la historia...");
            sc.nextLine();
        
        
        System.out.println("");
        System.out.println("Para ello nos remonatmos al 28 de julio de 2026.");
        System.out.println("Los diarios The Times y Financial Times desatan una exclusiva mundial al revelar el proyecto secreto de Gianni Infantino: ");
        System.out.println("Vender el 20% de los derechos del Mundial a inversores privados estadounidenses por 4.200 millones de dólares.");
        System.out.println("");
        System.out.println("La reaccion es fulminante. La UEFA estalla indignada ante el plan oculto y amenaza con un boicot total a la competición.");
        System.out.println("Tras cuatro dias de maxima tension y acusado de recibir millonarios sobresueldos opacos para su vida de lujo en Miami, Infantino se queda completamente solo.");
        System.out.println("");
        System.out.println("Por lo qu el 1 de agosto, el presidente capitula, pide disculpas y cancela definitivamente su plan secreto.");
        System.out.println("");
        System.out.println("Pero un mancha quedo inmborrable en la memoria de Infantino");
        System.out.println("Asi que en uno de los arrebatos que le suelen dar a lo millonariso calvos que controlan empresas, decicico hacer una locura....");
        System.out.println("");
 
        System.out.println("Segimos conla historia?");
        System.out.println("Pulsa enter para continuar con la historia...");
            sc.nextLine();
 
        System.out.println("");
        System.out.println("Decidio contactar con un de lso cientificos mas brillantes de nuestar era moderna: Hugh Hard");
        System.out.println("Junto a este, creo un mundo de futbol, donde atrapo a avariso futbolistas, dandoles un rol de heroes o de villanso segun el club");
        System.out.println("");
        System.out.println("Tu mision sera ir avanzando club por club, hasta llegar a Infantino, al cual te tendras que enfrentar, para destruir este mundo para siempre");
 
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
 
    opcion = sc.nextInt();
    sc.nextLine();
 
        switch (opcion) 
        {
            case 1:
                System.out.println(" ");
                System.out.println(" ");
                System.out.print("¿Como te llamas amigo mio? ");
                    Jugador jugadorTOP = new Jugador(sc.nextLine());
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
                    // NIVEL 2: INTERNACIONALES
                    if (villanoDerrotado) {
                        System.out.println("Has superado las rondas nacionales...");
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
                        System.out.println("GAME OVER. Fin del juego.");
                        System.out.println("===/====/===/===/===/===/===/===/====/===/===/===/===/===/");
                        System.out.println("Puntuacion final: " + jugadorTOP.getPuntos());
                        opcion = 4;
                    }
                break;
 
            case 2:
                System.out.println(" ");
                System.out.println("El ranking aun no lo tengo");
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
                System.out.println("1. Comenzaras tu aventura en Mestalla, el historico estadio del Valencia CF, donde se iniciara tu mision.");
                System.out.println(" ");
                System.out.println("2. Tendras que superar 3 rondas nacionales. En cada ronda encontraras 3 estadios de LaLiga y deberas elegir uno para continuar tu aventura.");
                System.out.println(" ");
                System.out.println("3. En cada estadio te enfrentaras a un villano del club que habra secuestrado a uno de sus heroes historicos.");
                System.out.println(" ");
                System.out.println("4. Si consigues derrotar al villano, liberaras al heroe y se unira a tu equipo como aliado para las siguientes batallas.");
                System.out.println(" ");
                System.out.println("5. Cuando superes las rondas nacionales, viajaras por los grandes estadios internacionales para enfrentarte a nuevos enemigos y conseguir aliados legendarios.");
                System.out.println(" ");
                System.out.println("6. Tu mision final sera enfrentarte a Infantino, para poder destruir este mundo que nunca deberia de haber sido creado.");
                System.out.println(" ");
                System.out.println("==================================");
 
                break;
            case 4:
                System.out.println("Gracias por jugar. ¡Hasta pronto!");
                break;
            
            default:
                System.out.println("Opcion incorrecta. Elige del 1 al 4.");
                break;
        }
    } while (opcion != 4);
}

    // Final del juego: puntos totales, creditos y escena despues de los creditos
    public static void finDelJuego(Scanner sc, Jugador jugadorTOP)
    {
        int puntosCombates = jugadorTOP.getPuntos();
        int bonus = jugadorTOP.sumarVidaFinal();

        System.out.println(" ");
        System.out.println(" ");
        System.out.println("========================================================");
        System.out.println("          ¡HAS DESTRUIDO EL MUNDO DE FUTBOL!");
        System.out.println("               Enhorabuena, campeon.");
        System.out.println("========================================================");
        sc.nextLine();

        System.out.println(" ");
        System.out.println("========== PUNTUACION FINAL ==========");
        System.out.println("Jugador: " + jugadorTOP.getNombre());
        System.out.println("Puntos por enemigos derrotados: " + puntosCombates);
        System.out.println("Bonificacion por vida restante: " + bonus);
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
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("                      ~ C R E D I T O S ~");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("     Heroe ........................ " + jugadorTOP.getNombre());
        System.out.println(" ");
        System.out.println("     Guion ........................ Óscar Rodrigo Breso");
        System.out.println("     Programacion de codigo ....... Óscar Rodrigo Breso");
        System.out.println("     Director del juego ........... Óscar Rodrigo Breso");
        System.out.println("     Diseño de personajes ......... Óscar Rodrigo Breso");
        System.out.println("     Diseño de niveles ............ Óscar Rodrigo Breso");
        System.out.println("     Diseño de combates ........... Óscar Rodrigo Breso");
        System.out.println("     Arte ASCII ................... Óscar Rodrigo Breso");
        System.out.println("     Pruebas y testeo ............. Óscar Rodrigo Breso");
        System.out.println("     Productor ejecutivo .......... Óscar Rodrigo Breso");
        System.out.println("     Entrenador de basket ......... Óscar Rodrigo Breso");
        System.out.println(" ");
        System.out.println("     Villano final ................ Gianni Infantino (a su pesar)");
        System.out.println("     Cientifico loco .............. Hugh Hard");
        System.out.println(" ");
        System.out.println("  ------------------------------------------------------------");
        System.out.println("     En memoria de los aliados que nunca volveran a luchar.");
        System.out.println("  ------------------------------------------------------------");
        System.out.println(" ");
        System.out.println("                      Gracias por jugar.");
        System.out.println(" ");
        System.out.println("  ==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/==/");

        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("--------- ESCENA POSTCREDITOS ---------");
        sc.nextLine();

        System.out.println(" ");
        System.out.println(" -- Un bunker, a kilometros bajo tierra. Una camara encendida sobre una mesa. Hugh Hard, el cientifico loco, se graba a si mismo -- ");
        sc.nextLine();


        System.out.println(" ");
        System.out.println("'HUGH HARD': Dia 23, sin incidentes. El ritmo cardiaco esta estable.");
        sc.nextLine();

        System.out.println(" ");
        System.out.println("'HUGH HARD': Los niveles de aire son mas bajos que ayer, pero siguen dentro de lo que puedo controlar.");
        sc.nextLine();

        System.out.println(" ");
        System.out.println("'HUGH HARD': Aún sigo sin temblores. Sin perdida de memoria.");
        sc.nextLine();

        System.out.println(" ");
        System.out.println("'HUGH HARD': Hace tres semanas que no abro esa puerta. A veces hay gente arriba. Los oigo caminar.");
        System.out.println("'HUGH HARD': No tienen ni idea de lo que hay debajo de sus pies.");
        sc.nextLine();

        System.out.println(" ");
        System.out.println("'HUGH HARD': He hecho todas las pruebas que conozco. Desde que cayo el mundo de Infantino, algo de la maquina se quedo dentro de mi.");
        System.out.println("'HUGH HARD': Mi ADN no solo muta: se adapta. Responde al estres.");
        System.out.println("'HUGH HARD': Y no se que pasara el dia en que no pueda decirle que no.");
        sc.nextLine();

        System.out.println(" ");
        System.out.println("'HUGH HARD': Si alguien del laboratorio encuentra esta grabacion, no bajeis. No intenteis rescatarme.");
        System.out.println("'HUGH HARD': Porque si vuelvo a cambiar... no se si me acordare de quienes sois.");
        sc.nextLine();

        System.out.println(" ");
        System.out.println(" -- La imagen se llena de interferencias. La luz parpadea -- ");
        System.out.println("'HUGH HARD': La señal se esta degradando. Pero si soy sincero no se muy bien a qu ese deb eel fallo.");
        sc.nextLine();

        System.out.println(" ");
        System.out.println("'HUGH HARD': Eso es lo que nadie te cuenta sobre volverte peligroso.");
        System.out.println("'HUGH HARD': No tienes miedo de morir... sino de sobrevivir lo suficiente para ver lo que has hecho.");
        sc.nextLine();

        System.out.println(" ");
        System.out.println("'HUGH HARD': Pienso en la primera vez. Todos me dicen que no fui yo. Que solo obedecia a Infantino.");
        System.out.println("'HUGH HARD': Pero cientificamente, esa explicacion no funciona.");
        sc.nextLine();

        System.out.println(" ");
        System.out.println("'HUGH HARD': ¿Pero porque parpadea tanto la luz?");
        System.out.println("'HUGH HARD': Si esta seman aha ido perfectamenet el sistema electrico, bueno da igual, sigo...");
        sc.nextLine();

        System.out.println(" ");
        System.out.println("'HUGH HARD': La maquina salio de mis manos, de mis ideas, de mi ambicion.");
        sc.nextLine();

        System.out.println(" ");
        System.out.println("'HUGH HARD': Entonces... ¿donde acaba ella? ¿Y donde empiezo yo?");
        sc.nextLine();

        System.out.println(" ");
        System.out.println(" -- Un golpe seco. Un brillo naranja se extiende por el suelo del bunker, un brillo como si de una invocacion paranormal -- ");
        sc.nextLine();

        System.out.println(" ");
        System.out.println(" -- Entre el humo, se escuha una voz oscudra, una voz mucho más imponenete de lo que nos podemos imaginar -- ");
        System.out.println(" -- Una voz atemorizante, una voz a simple viste mucha mas poderosa que Infantino, este dice:-- ");
        sc.nextLine();

        System.out.println(" ");
        System.out.println("'ADAM SILVER': Cuanto tiempo sin verle, DR. Hard");
        sc.nextLine();

        System.out.println(" ");
        System.out.println("'HUGH HARD': ¿Perdone...?, ¿Le..., le conozco? ¿¡ Quien es usted y que hace aqui !?");
        sc.nextLine();

        System.out.println(" ");
        System.out.println("'ADAM SILVER': Me llamo Adam Silver, y he venido a reclutarlo");
        sc.nextLine();

        System.out.println(" ");
        System.out.println(" -- Se ve como se lleva a la fuerza al DR. Hugh Hard, por el msimo portal donde entro ese misterioso hombre -- ");
        sc.nextLine();

        System.out.println(" ");
        System.out.println(" -- Se cierra el portal, y la sala se queda en total silencio, un sileancio, aterrador por lo que ocurrir,... -- ");
        System.out.println(" -- Pero, es un silencio más aterrador de cara al... futuro -- ");
        sc.nextLine();
        
        System.out.println(" ");
        System.out.println("La camara se gira hacia abajo, y en el el suelo, donde se hallaba el portal ya cerrado, hay un logo, marcado con fuego naranja");
        System.out.println("Un logo similar, como si fuera una pelota de Ba...");  
        sc.nextLine();



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