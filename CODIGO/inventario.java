import VILLANOS.*;
import java.util.Random;

public class Inventario
{
    private int pociones;
    private static final int CURACION = 20;
    private static final int MAX_ALIADOS = 6;
    private static Random random = new Random();

    // Dos arrays paralelos: en la misma posicion estan el aliado y si ya ha gastado su poder
    private Personaje[] aliados;
    private boolean[] poderUsado;
    private int numAliados;

    public Inventario()
    {
        this.pociones = 5;
        this.aliados = new Personaje[MAX_ALIADOS];
        this.poderUsado = new boolean[MAX_ALIADOS];
        this.numAliados = 0;
    }

    public int getPociones() {
        return this.pociones;
    }

    public boolean tienePociones() {
        return this.pociones > 0;
    }

    // Gasta una pocion y devuelve cuanta vida cura
    public int usarPocion()
    {
        this.pociones--;
        return CURACION;
    }

    public int getNumAliados() {
        return this.numAliados;
    }

    public Personaje getAliado(int posicion) {
        return this.aliados[posicion];
    }

    public boolean poderUsado(int posicion) {
        return this.poderUsado[posicion];
    }

    // Guarda al heroe en el primer hueco libre
    public void agregarAliado(Personaje heroe)
    {
        if (this.numAliados < MAX_ALIADOS) {
            this.aliados[this.numAliados] = heroe;
            this.poderUsado[this.numAliados] = false;
            this.numAliados++;
        }
    }

    // Quita al aliado y mueve a los de detras un hueco hacia delante
    public void quitarAliado(int posicion)
    {
        for (int i = posicion; i < this.numAliados - 1; i++) {
            this.aliados[i] = this.aliados[i + 1];
            this.poderUsado[i] = this.poderUsado[i + 1];
        }
        this.numAliados--;
        this.aliados[this.numAliados] = null;
        this.poderUsado[this.numAliados] = false;
    }

    // Quita a un aliado al azar y lo devuelve. Con protegerEstrellas, Messi y Cristiano no pueden salir elegidos
    public Personaje quitarAliadoAlAzar(boolean protegerEstrellas)
    {
        int validos = 0;
        for (int i = 0; i < this.numAliados; i++) {
            if (!(protegerEstrellas && esEstrella(this.aliados[i]))) {
                validos++;
            }
        }
        if (validos == 0) {
            return null;
        }

        // Elige el numero de entre los validos y busca a quien le toca
        int elegido = random.nextInt(validos);
        for (int i = 0; i < this.numAliados; i++) {
            if (!(protegerEstrellas && esEstrella(this.aliados[i]))) {
                if (elegido == 0) {
                    Personaje quitado = this.aliados[i];
                    quitarAliado(i);
                    return quitado;
                }
                elegido--;
            }
        }
        return null;
    }

    private boolean esEstrella(Personaje aliado)
    {
        return aliado == Personaje.heroeMessi || aliado == Personaje.heroeCristiano;
    }

    // Marca el poder como gastado hasta el siguiente combate
    public void gastarPoder(int posicion) {
        this.poderUsado[posicion] = true;
    }

    // Al empezar cada combate todos los aliados recuperan su poder
    public void reiniciarPoderes()
    {
        for (int i = 0; i < this.numAliados; i++) {
            this.poderUsado[i] = false;
        }
    }

    // Cuantos aliados todavia pueden usar su poder en este combate
    public int getPoderesDisponibles()
    {
        int disponibles = 0;
        for (int i = 0; i < this.numAliados; i++) {
            if (!this.poderUsado[i]) {
                disponibles++;
            }
        }
        return disponibles;
    }
}