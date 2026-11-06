public class Jugador extends Juego
{
    private String nombre;
    private int vida;
    private Arma armaActual;
    private Inventario inventario;
    private Escudo escudo;
 
    public Jugador(String nombre)
    {
        this.nombre = nombre;
        this.vida = 100;
        this.armaActual = new Arma("Banderin del corner", "Un banderin de corner normal y corriente, solo que esta roto, porque me he encontrado a Vardy y se ha tirado contra el de cabeza.", 10);
        this.inventario = new Inventario();
        this.escudo = new Escudo(20);
    }
 
    public String getNombre() {
        return this.nombre;
    }
 
    public int getVida() {
        return this.vida;
    }
 
    public Arma getArma() {
        return this.armaActual;
    }
 
    public Inventario getInventario() {
        return this.inventario;
    }
 
    public Escudo getEscudo() {
        return this.escudo;
    }
 
    public void setVida(int vida) { this.vida = vida; }
    public void setArma(Arma nuevaArma) { this.armaActual = nuevaArma; }
 
    public void mostrarEstado()
    {
        System.out.println(" ");
        System.out.println("================================================================");
        System.out.println("Jugador: " + nombre);
        System.out.println("Vida: " + vida);
        System.out.println("Arma: " + this.armaActual.getNombre() + " (daño: " + this.armaActual.getDaño() + " )");
        System.out.println("Pociones: " + this.inventario.getPociones());
        System.out.println("Escudo: " + this.escudo.getVida() + "/" + this.escudo.getVidaMax());
        System.out.println("================================================================");
        System.out.println(" ");
    }
}
 