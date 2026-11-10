package INTERFACES;

public interface IntTirador
{
    // Primero se apunta: devuelve true si el jugador sigue vivo, y solo entonces tiene sentido disparar.
    public boolean apuntar(int jugadorTOP);

    // Ataque a distancia: si no queda munición devuelve 0, y así sabemos que toca recargar.
    public int disparar(int jugadorTOP);

    // Se usa cuando disparar devuelve 0, para poder volver a disparar en el siguiente turno.
    public void recargar(int cantidad);
}