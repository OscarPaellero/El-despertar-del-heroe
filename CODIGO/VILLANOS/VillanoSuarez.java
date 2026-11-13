package VILLANOS;

import INTERFACES.IntJinete;
import INTERFACES.IntSanador;

public class VillanoSuarez extends Personaje implements IntJinete, IntSanador
{
    private String montura;
    private boolean tirado;
    private int pociones = 2;

    public VillanoSuarez()
    {
        super("Luis Suarez", 200,
        new Arma("Colmillos de nariz", "Te ataca con su colmillo y te lo clava quitandote 20 de vida.", 40),
        new Poder("Mordisco", "Te muerde cada 3 rondas y te quita 10 de vida.", 40));
        setDanoAtaque(25, 40);
        setUmbralCuracion(30);
        setAnimal("Tiburon");
        setUmbralMontura(30);
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
    public void curar(int cantidad)
    {
        int nueva = getVida() + cantidad;
        if (nueva > getVidaMax()) {
            nueva = getVidaMax();
        }
        setVida(nueva);
        System.out.println("| " + getNombre() + " se cura y le quedan " + nueva + " de vida");
    }

    @Override
    public boolean necesitaCuracion()
    {
        return getVida() < getVidaMax();
    }

    @Override
    public int usarPocion()
    {
        if (this.pociones <= 0) {
            return 0;
        }
        this.pociones--;
        System.out.println("| " + getNombre() + " se bebe una pocion");
        curar(10);
        return 10;
    }

    @Override
    public int getPociones()
    {
        return this.pociones;
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
    public int turnoSanador(int vidaJugador)
    {
        boolean pocaVida = getVidaPorcentaje() < getUmbralCuracion();

        if (pocaVida && necesitaCuracion() && getPociones() > 0 && azar(100) < 80) {
            usarPocion();
            return 0;
        }
        return -1;
    }
}