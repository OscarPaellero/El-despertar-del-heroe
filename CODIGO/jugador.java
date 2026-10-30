public class jugador extends juego
{
    private String nombre;
    private int vida;
    private arma armaActual;
    //private int danyo;

    public jugador(String nombre)
    {
        this.nombre = nombre;
        this.vida = 100;
        this.armaActual = new arma("Banderin del corner", "Un banderin de corner normal y corriente, solo que esta roto, porque me he encontrado a Vardy y se ha tirado contra el de cabeza.", 10);
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getVida() {
        return this.vida;
    }

    public arma getArma() {
        return this.armaActual;
    }

    public void setVida(int vida) { this.vida = vida; }
    public void setArma(arma nuevaArma) { this.armaActual = nuevaArma; }

    public void mostrarEstado()
    {
        System.out.println(" ");
        System.out.println("================================================================");
        System.out.println("Jugador: " + nombre);
        System.out.println("Vida: " + vida);
        System.out.println("Arma: " + this.armaActual.getNombre() + " (daño: " + this.armaActual.getDaño() + " )");
        System.out.println("================================================================");
        System.out.println(" ");

    }
}
