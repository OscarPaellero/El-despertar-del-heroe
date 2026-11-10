package VILLANOS;

import INTERFACES.IntJinete;
import INTERFACES.IntHechicero;

public class VillanoVanPersie extends Personaje implements IntJinete, IntHechicero
{
    private String montura;
    private boolean tirado;
    private int mana = 40;
    private String hechizo;

    public VillanoVanPersie()
    {
        super("Van Persie", 200,
        new Arma("Roja de la final", "Te saca una roja por la cara que te anula los dos siguientes ataques.", 30),
        new Poder("Ejecutor de serpiente", "Te marca un golazo que te noquea 1 ataque.", 30));
        setDanoAtaque(15, 45);
        setAnimal("serpiente gigante");
        setUmbralMontura(25);
    }

    @Override
    public boolean montar(String animal)
    {
        if (this.montura != null || this.tirado) {
            return false;
        }
        this.montura = animal;
        System.out.println("| " + getNombre() + " monta en " + animal);
        return true;
    }

    @Override
    public boolean desmontar()
    {
        if (this.montura == null) {
            return false;
        }
        System.out.println("| " + getNombre() + " se baja de " + this.montura);
        this.montura = null;
        this.tirado = true;
        return true;
    }

    @Override
    public int atacarDesdeMontura(int jugadorTOP)
    {
        if (this.montura == null) {
            return 0;
        }
        System.out.println("| " + getNombre() + " ataca desde " + this.montura);
        return getDanoAtaque();
    }

    @Override
    public void prepararHechizo(String hechizo)
    {
        this.hechizo = hechizo;
        System.out.println("| " + getNombre() + " prepara el hechizo: " + hechizo);
    }

    @Override
    public int lanzarHechizo(int jugadorTOP)
    {
        if (this.hechizo == null || this.mana < 10) {
            return 0;
        }
        this.mana = this.mana - 10;
        System.out.println("| " + getNombre() + " lanza el hechizo: " + this.hechizo);
        this.hechizo = null;
        return getDanoAtaque();
    }

    @Override
    public void recuperarMana(int cantidad)
    {
        this.mana = this.mana + cantidad;
        System.out.println("| " + getNombre() + " recupera " + cantidad + " de mana");
    }

    @Override
    public int turnoJinete(int vidaJugador)
    {
        if (montar(getAnimal())) {
            return 0;
        }

        boolean pocaVida = getVidaPorcentaje() < getUmbralMontura();
        if (pocaVida && azar(100) < 50 && desmontar()) {
            System.out.println("| La montura de " + getNombre() + " se asusta por las heridas y no vuelve a montarla");
            return 0;
        }

        int dano = atacarDesdeMontura(vidaJugador);
        if (dano == 0) {
            return -1;
        }
        return dano;
    }

    @Override
    public int turnoHechicero(int vidaJugador)
    {
        int dano = lanzarHechizo(vidaJugador);
        if (dano == 0) {
            prepararHechizo(getPoder().getNombre());
            recuperarMana(10);
        }
        return dano;
    }
}