import java.io.File;

// Leer y escribir el XML
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

// Gestionar el documento XML
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

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

    // Carga el XML en los arrays. Devuelve cuántos jugadores ha cargado o -1 si hay un error
    public static int cargarRanking(String ruta, String[] nombres, int[] puntos) {

        File archivo = new File(ruta);

        // Si todavía no existe, se empieza con el ranking vacío
        if (!archivo.exists()) {
            System.out.println("No existe " + ruta + ". Se empieza con el ranking vacío.");
            return 0;
        }

        try {
            DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();

            // Acepta el DOCTYPE pero no carga la DTD (la validación se hace aparte)
            fabrica.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);

            DocumentBuilder constructor = fabrica.newDocumentBuilder();
            Document documento = constructor.parse(archivo);

            NodeList lista = documento.getElementsByTagName("jugador");

            if (lista.getLength() > MAX_JUGADORES) {
                System.out.println("Error: el ranking tiene más de " + MAX_JUGADORES + " jugadores.");
                return -1;
            }

            int cargados = 0;

            for (int i = 0; i < lista.getLength(); i++) {
                Element jugador = (Element) lista.item(i);

                NodeList nodoNombre = jugador.getElementsByTagName("nombre");
                NodeList nodoPuntos = jugador.getElementsByTagName("puntos");

                if (nodoNombre.getLength() == 0 || nodoPuntos.getLength() == 0) {
                    System.out.println("Error: al jugador " + (i + 1) + " le falta el nombre o los puntos.");
                    return -1;
                }

                String nombre = nodoNombre.item(0).getTextContent().trim();
                String textoPuntos = nodoPuntos.item(0).getTextContent().trim();

                if (nombre.isEmpty()) {
                    System.out.println("Error: el jugador " + (i + 1) + " tiene el nombre vacío.");
                    return -1;
                }

                if (!esNumeroValido(textoPuntos)) {
                    System.out.println("Error: los puntos del jugador " + (i + 1) + " no son un número válido.");
                    return -1;
                }

                int pts = Integer.parseInt(textoPuntos);

                // Se coloca en su puesto, así da igual el orden en que venga en el XML
                int posicion = buscarPuesto(puntos, cargados, pts);
                cargados = colocarJugador(nombres, puntos, cargados, posicion, nombre, pts);
            }

            return cargados;

        } catch (Exception e) {
            System.out.println("Error al leer " + ruta + ": " + e.getMessage());
            return -1;
        }
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

    // Escribe los arrays en el XML. Devuelve true si se ha guardado bien
    public static boolean guardarRanking(String ruta, String[] nombres, int[] puntos, int contador) {

        try {
            DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
            DocumentBuilder constructor = fabrica.newDocumentBuilder();
            Document documento = constructor.newDocument();

            Element raiz = documento.createElement("ranking");
            documento.appendChild(raiz);

            for (int i = 0; i < contador; i++) {
                Element jugador = documento.createElement("jugador");
                jugador.setAttribute("posicion", String.valueOf(i + 1));
                raiz.appendChild(jugador);

                // setTextContent escapa solo los caracteres como & y <
                Element nombre = documento.createElement("nombre");
                nombre.setTextContent(nombres[i]);
                jugador.appendChild(nombre);

                Element pts = documento.createElement("puntos");
                pts.setTextContent(String.valueOf(puntos[i]));
                jugador.appendChild(pts);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            // Vuelve a escribir el DOCTYPE para que el XML siga enlazado a la DTD
            transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, RUTA_DTD);

            DOMSource origen = new DOMSource(documento);
            StreamResult destino = new StreamResult(new File(ruta));
            transformer.transform(origen, destino);

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