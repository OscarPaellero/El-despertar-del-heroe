package INTERFACES;

public interface IntJinete
{
    // Devuelve true si monta y false si ya está montado o le tiraron, para no montar dos veces.
    public boolean montar(String animal);

    // Con poca vida la montura se asusta y lo tira; devuelve false si no estaba montado.
    public boolean desmontar();

    // Solo ataca si está montado; devuelve 0 si no hay montura y el turno pasa a otra acción.
    public int atacarDesdeMontura(int jugadorTOP);
}