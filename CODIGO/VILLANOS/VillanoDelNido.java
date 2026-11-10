package VILLANOS;

import INTERFACES.IntCombatiente;
import INTERFACES.IntSanador;
import INTERFACES.IntHechicero;

public class VillanoDelNido extends Personaje implements IntCombatiente, IntSanador, IntHechicero
{
    private int pociones = 2;
    private int mana = 30;
    private String hechizo;

    public VillanoDelNido()
    {
        super("Del Nido Jr", 100,
        new Arma("Baston del contrato vitalicio", "Te quita un x1,5 en cada ataque durante esta ronda.", 15),
        new Poder("Herencia", "Se cura +10 aleatoriamente.", 15));
        setDanoAtaque(8, 22);
        setEscudo(new Escudo(20));
        setUmbralEscudo(25);
        setUmbralCuracion(30);
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
    public int turnoSanador(int vidaJugador)
    {
        boolean pocaVida = getVidaPorcentaje() < getUmbralCuracion();

        if (pocaVida && necesitaCuracion() && getPociones() > 0 && azar(100) < 80) {
            usarPocion();
            return 0;
        }
        return -1;
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