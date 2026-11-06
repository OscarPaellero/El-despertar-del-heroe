public class Inventario extends Juego
{
    private int pociones;
    private static final int CURACION = 3;
 
    public Inventario()
    {
        this.pociones = 5;
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
}
 