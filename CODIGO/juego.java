import java.util.Scanner;
import java.util.Random;


public class juego 
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
        System.out.println("A si que si no sabes ni quien es Isi PAlazon, porfavor, salte de aqui, gracias :) ");
        System.out.println("Pero antes de todo estaria bien saber de el por que te vas pelear contra gente del mudno dle futbol ¿no?");
        System.out.println("");


        System.out.println("QUIERES SABER COMO HEMOS LLEGADO HASTA AQUI?");
        System.out.println("Si es que si, pulsa enter para continuar con la historia...");
            sc.nextLine();
        
        
        System.out.println("");
        System.out.println("Paar ello nos remonatmos al 28 de julio de 2026.");
        System.out.println("Los diarios The Times y Financial Times desatan un terremoto mundial al revelar el proyecto secreto de Gianni Infantino: ");
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

    do {
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
                System.out.print("¿Como te llamas amigo mio? ");
                    jugador jugadorTOP = new jugador(sc.nextLine());
                    jugadorTOP.mostrarEstado();
              
                System.out.println("Iniciando nueva partida...");
                break;

            case 2:
                System.out.println("El ranking aun no lo tengo");
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
} 
