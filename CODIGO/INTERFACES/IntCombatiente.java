package INTERFACES;
 
public interface IntCombatiente
{
    // Ataque normal: baja el escudo y devuelve el daño aleatorio que "Combate" resta al jugador.
    public int atacarConArma(int jugadorTOP);
 
    // Se usa con poca vida (25%): si el escudo no está roto, se defiende y recibe menos daño.
    public void levantarEscudo();
 
    // Sirve para saber si se defiende: si es true recibe solo un 10% del daño, si no, todo.
    public boolean escudoLevantado();
 
    // Devuelve la vida del escudo para saber cuánto aguanta; al llegar a 0 se rompe.
    public int getDefensa();
}