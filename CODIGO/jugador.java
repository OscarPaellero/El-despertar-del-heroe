import VILLANOS.*;

public class Jugador
{
    private String nombre;
    private int vida;
    private Arma armaActual;
    private Inventario inventario;
    private Escudo escudo;
    private int puntos;
    private int enemigosDerrotados;
    private int vidaFinal;
    private int subidaArma = 1;
 
    public Jugador(String nombre)
    {
        this.nombre = nombre;
        this.vida = 1000;
        this.armaActual = new Arma("Banderin del corner", "Un banderin de corner normal y corriente, solo que esta roto, porque me he encontrado a Vardy y se ha tirado contra el de cabeza.", 10);
        this.inventario = new Inventario();
        this.escudo = new Escudo(20);
        this.puntos = 0;
        this.enemigosDerrotados = 0;
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

    public int getPuntos() {
        return this.puntos;
    }

    // Cada enemigo derrotado da 100 puntos. Guarda la vida con la que acaba el combate
    public int sumarPuntos()
    {
        this.enemigosDerrotados++;
        this.puntos = 100 * this.enemigosDerrotados;
        this.vidaFinal = this.vida;
        return 100;
    }

    // Solo se llama al ganar toda la aventura: suma la vida restante
    public int sumarVidaFinal()
    {
        this.puntos = this.puntos + this.vidaFinal;
        return this.vidaFinal;
    }

    // Tras cada victoria la vida vuelve a 100 + 5 por cada enemigo derrotado (105, 110, 115...)
    public void curarTrasCombate()
    {
        this.vida = 100 + 5 * this.enemigosDerrotados;
    }

    // Cuanto daño gana el arma en cada victoria (1 en LaLiga, 4 en las internacionales)
    public int getSubidaArma() {
        return this.subidaArma;
    }

    public void setSubidaArma(int subidaArma) {
        this.subidaArma = subidaArma;
    }

    public void setVida(int vida) { this.vida = vida; }
    public void setArma(Arma nuevaArma) { this.armaActual = nuevaArma; }
 
    public void mostrarEstado()
    {
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("================================================================");
        System.out.println("Jugador: " + nombre + " (" + puntos + " puntos)");
        System.out.println("Vida: " + vida);
        System.out.println("Arma: " + this.armaActual.getNombre() + " (daño: " + this.armaActual.getDaño() + " )");
        System.out.println("Pociones: " + this.inventario.getPociones());
        System.out.println("Escudo: " + this.escudo.getVida() + "/" + this.escudo.getVidaMax());
        System.out.println("================================================================");
        System.out.println(" ");
    }
}