public class Hombre extends Personaje
{
    private boolean portadorAnillo;

    public Hombre(String nombre, boolean portadorAnillo)
    {
        super(nombre);
        this.portadorAnillo = portadorAnillo;
    }

    public void ponerAnillo()
    {
        if (portadorAnillo)
        {
            System.out.println(getNombre() + " ha desaparecido al ponerse el anillo!!!");
        }
        else
        {
            System.out.println(getNombre() + " no tiene el anillo!!!!!");
        }
    }
}