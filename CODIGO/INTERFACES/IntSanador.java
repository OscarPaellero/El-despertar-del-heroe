package INTERFACES;

public interface IntSanador
{
    // Suma vida sin pasar de su máximo; la llama usarPocion al beber.
    public void curar(int cantidad);

    // Evita gastar una poción cuando ya tiene la vida llena.
    public boolean necesitaCuracion();

    // Gasta una poción y llama a curar; si no le quedan devuelve 0 y no cura.
    public int usarPocion();

    // Permite comprobar si le quedan pociones antes de intentar beber otra.
    public int getPociones();
}