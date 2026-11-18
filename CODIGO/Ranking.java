import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

// Solo para generar el HTML con el XSLT
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class Ranking {

    public static final int MAX_JUGADORES = 10;
    public static final String RUTA_XML = elegirRutaXML();
    public static final String RUTA_DTD = "ranking.dtd";

    // Funciona tanto si se ejecuta desde la carpeta del proyecto como desde CODIGO
    public static String elegirRutaXML() {
        if (new File("../XML").isDirectory() && !new File("XML").isDirectory()) {
            return "../XML/ranking.xml";
        }
        return "XML/ranking.xml";
    }

    // Carga el XML en los arrays leyendo linea a linea. Devuelve cuantos jugadores ha cargado o -1 si hay un error
    public static int cargarRanking(String ruta, String[] nombres, int[] puntos) {

        File archivo = new File(ruta);

        if (!archivo.exists()) {
            System.out.println("No existe " + ruta + ". Se empieza con el ranking vacío.");
            return 0;
        }

        int cargados = 0;
        int jugadores = 0;
        String nombre = null;

        try {
            Scanner lector = new Scanner(archivo, "UTF-8");

            while (lector.hasNextLine()) {
                String linea = lector.nextLine().trim();

                if (linea.startsWith("<nombre>")) {
                    nombre = sacarTexto(linea);

                } else if (linea.startsWith("<puntos>")) {
                    jugadores++;
                    String textoPuntos = sacarTexto(linea);

                    if (jugadores > MAX_JUGADORES) {
                        System.out.println("Error: el ranking tiene más de " + MAX_JUGADORES + " jugadores.");
                        lector.close();
                        return -1;
                    }
                    if (nombre == null || nombre.isEmpty()) {
                        System.out.println("Error: el jugador " + jugadores + " no tiene nombre.");
                        lector.close();
                        return -1;
                    }
                    if (!esNumeroValido(textoPuntos)) {
                        System.out.println("Error: los puntos del jugador " + jugadores + " no son un número válido.");
                        lector.close();
                        return -1;
                    }

                    int pts = Integer.parseInt(textoPuntos);
                    int posicion = buscarPuesto(puntos, cargados, pts);
                    cargados = colocarJugador(nombres, puntos, cargados, posicion, nombre, pts);
                    nombre = null;

                } else if (linea.startsWith("</jugador>") && nombre != null) {
                    // Ha cerrado el jugador sin pasar por <puntos>
                    System.out.println("Error: al jugador " + (jugadores + 1) + " le faltan los puntos.");
                    lector.close();
                    return -1;
                }
            }

            lector.close();
            return cargados;

        } catch (Exception e) {
            System.out.println("Error al leer " + ruta + ": " + e.getMessage());
            return -1;
        }
    }

    // De una linea como <nombre>Villa</nombre> saca lo que hay entre las etiquetas
    public static String sacarTexto(String linea) {
        int inicio = linea.indexOf(">") + 1;
        int fin = linea.lastIndexOf("</");
        String texto = linea.substring(inicio, fin).trim();
        return texto.replace("&lt;", "<").replace("&gt;", ">").replace("&amp;", "&");
    }

    // Cambia los caracteres que XML no deja escribir tal cual
    public static String escapar(String texto) {
        return texto.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
    }

    // Comprueba que el texto sea un entero no negativo
    public static boolean esNumeroValido(String texto) {
        if (texto.isEmpty() || texto.length() > 9) {
            return false;
        }
        for (int i = 0; i < texto.length(); i++) {
            if (!Character.isDigit(texto.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    // Busca el puesto que le toca: pasa por delante de los que tienen MENOS puntos (en empate va detrás).
    // Devuelve -1 si el ranking está lleno y no supera al último
    public static int buscarPuesto(int[] puntos, int contador, int pts) {
        int posicion = 0;
        while (posicion < contador && puntos[posicion] >= pts) {
            posicion++;
        }
        if (posicion == MAX_JUGADORES) {
            return -1;
        }
        return posicion;
    }

    // Coloca al jugador en la posición indicada y desplaza a los de detrás. Devuelve el nuevo contador
    public static int colocarJugador(String[] nombres, int[] puntos, int contador, int posicion, String nombre, int pts) {

        // Si está lleno, el último se pierde
        int ultimo = contador;
        if (contador == MAX_JUGADORES) {
            ultimo = MAX_JUGADORES - 1;
        }

        // Mueve nombre y puntos a la vez para no desemparejarlos
        for (int i = ultimo; i > posicion; i--) {
            nombres[i] = nombres[i - 1];
            puntos[i] = puntos[i - 1];
        }

        nombres[posicion] = nombre;
        puntos[posicion] = pts;

        if (contador < MAX_JUGADORES) {
            contador++;
        }
        return contador;
    }

    // Mete una partida nueva en el ranking avisando por consola. Devuelve el nuevo contador
    public static int insertarJugador(String[] nombres, int[] puntos, int contador, String nombre, int pts) {

        int posicion = buscarPuesto(puntos, contador, pts);

        if (posicion == -1) {
            System.out.println(nombre + " (" + pts + " puntos) no entra en el ranking.");
            return contador;
        }

        System.out.println(nombre + " entra en el ranking en el puesto " + (posicion + 1) + ".");
        return colocarJugador(nombres, puntos, contador, posicion, nombre, pts);
    }

    // Escribe los arrays en el XML linea a linea. Devuelve true si se ha guardado bien
    public static boolean guardarRanking(String ruta, String[] nombres, int[] puntos, int contador) {

        try {
            PrintWriter escritor = new PrintWriter(new File(ruta), "UTF-8");

            escritor.println("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
            escritor.println("<!DOCTYPE ranking SYSTEM \"" + RUTA_DTD + "\">");
            escritor.println("<ranking>");

            for (int i = 0; i < contador; i++) {
                escritor.println("    <jugador posicion=\"" + (i + 1) + "\">");
                escritor.println("        <nombre>" + escapar(nombres[i]) + "</nombre>");
                escritor.println("        <puntos>" + puntos[i] + "</puntos>");
                escritor.println("    </jugador>");
            }

            escritor.println("</ranking>");
            escritor.close();
            return true;

        } catch (Exception e) {
            System.out.println("Error al guardar " + ruta + ": " + e.getMessage());
            return false;
        }
    }

    // Mete la partida en el ranking y lo guarda. Devuelve el nuevo contador
    public static int registrarPartida(String[] nombres, int[] puntos, int contador, String nombre, int pts, boolean xmlCorrecto) {

        System.out.println(" ");
        contador = insertarJugador(nombres, puntos, contador, nombre, pts);

        // Si el XML tenía errores al arrancar, no se sobrescribe
        if (xmlCorrecto) {
            if (guardarRanking(RUTA_XML, nombres, puntos, contador)) {
                System.out.println("Ranking guardado.");
                generarHTML(RUTA_XML);
            }
        } else {
            System.out.println("El ranking no se guarda porque " + RUTA_XML + " tiene errores. Corrígelo y vuelve a abrir el juego.");
        }
        return contador;
    }

    // Vuelve a generar ranking.html con ranking.xslt para que la tabla de la web esté al día
    public static boolean generarHTML(String rutaXML) {

        try {
            // ranking.xslt y ranking.html están en la misma carpeta que el XML
            File carpeta = new File(rutaXML).getAbsoluteFile().getParentFile();
            File xslt = new File(carpeta, "ranking.xslt");
            File html = new File(carpeta, "ranking.html");

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer(new StreamSource(xslt));
            transformer.transform(new StreamSource(new File(rutaXML)), new StreamResult(html));

            System.out.println("Página web actualizada: " + html.getName());
            return true;

        } catch (Exception e) {
            System.out.println("No se ha podido generar ranking.html: " + e.getMessage());
            return false;
        }
    }

    // Muestra el ranking por consola
    public static void mostrarRanking(String[] nombres, int[] puntos, int contador) {

        if (contador == 0) {
            System.out.println("El ranking está vacío. ¡Juega una partida para estrenarlo!");
            return;
        }

        System.out.println("========= RANKING =========");
        for (int i = 0; i < contador; i++) {
            System.out.printf("%2d. %-20s %4d pts%n", i + 1, nombres[i], puntos[i]);
        }
        System.out.println("===========================");
    }
}