package INTERFACES;

public interface IntHechicero
{
    // Se prepara un turno antes: guarda el hechizo para poder lanzarlo después.
    public void prepararHechizo(String hechizo);

    // Solo lanza si hay hechizo preparado y maná suficiente; si no, devuelve 0 y toca preparar otro.
    public int lanzarHechizo(int jugadorTOP);

    // Se usa al preparar, para que le quede maná y pueda lanzar el siguiente hechizo.
    public void recuperarMana(int cantidad);
}