package VILLANOS;

import INTERFACES.IntCombatiente;
import INTERFACES.IntJinete;

public class VillanoMbappe extends Personaje implements IntCombatiente, IntJinete
{
    private String montura;
    private boolean tirado;

    public VillanoMbappe()
    {
        super("Mbappe", 200,
        new Arma("Brazalete dictatorial", "Hace que un ataque aleatorio te quite x3.", 30),
        new Poder("Sprint", "Te ataca el doble cada 3 rondas.", 30));
        setDanoAtaque(15, 45);
        setEscudo(new Escudo(20));
        setUmbralEscudo(15);
        setAnimal("cohete");
        setUmbralMontura(15);
    }

    @Override
    public int atacarConArma(int jugadorTOP)
    {
        setDefendiendo(false);
        System.out.println("| " + getNombre() + " ataca con " + getArma().getNombre());
        return getDanoAtaque();
    }

    @Override
    public void levantarEscudo()
    {
        if (getEscudo().estaRoto()) {
            System.out.println("| El escudo de " + getNombre() + " esta roto y no puede defenderse");
            return;
        }
        setDefendiendo(true);
        System.out.println("| " + getNombre() + " levanta el escudo para defenderse");
    }

    @Override
    public boolean escudoLevantado()
    {
        return isDefendiendo();
    }

    @Override
    public int getDefensa()
    {
        return getEscudo().getVida();
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
    public int turnoCombatiente(int vidaJugador)
    {
        boolean pocaVida = getVidaPorcentaje() < getUmbralEscudo();
        boolean puedeDefender = !escudoLevantado() && !getEscudo().estaRoto();

        if (pocaVida && puedeDefender && azar(100) < 70) {
            levantarEscudo();
            return 0;
        }
        return atacarConArma(vidaJugador);
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
}