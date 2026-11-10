package INTERFACES;

public interface IntInvocador
{
    // Crea una criatura aliada; hay que invocar antes de atacar, porque sin invocados no hay ataque.
    public void invocar(String criatura);

    // Cuenta las criaturas invocadas para no pasar el máximo y saber si puede atacar con ellas.
    public int NumeroInvocados();

    // El daño depende de cuántas hay: cada invocado pega la mitad, y con 0 no hace daño.
    public int atacarConInvocados(int jugadorTOP);
}