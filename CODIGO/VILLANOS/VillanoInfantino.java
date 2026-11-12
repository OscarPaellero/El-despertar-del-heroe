package VILLANOS;

import INTERFACES.IntCombatiente;
import INTERFACES.IntTirador;
import INTERFACES.IntJinete;
import INTERFACES.IntSanador;
import INTERFACES.IntInvocador;
import INTERFACES.IntHechicero;

public class VillanoInfantino extends Personaje implements IntCombatiente, IntTirador, IntJinete, IntSanador, IntInvocador, IntHechicero
{
    private int municion = 3;
    private String montura;
    private boolean tirado;
    private int pociones = 2;
    private int invocados;
    private int mana = 60;
    private String hechizo;

    // Sin parametros es el Infantino de siempre. Con parametros se usa para cada fase del combate final
    public VillanoInfantino()
    {
        this(600, 30, 90);
    }

    public VillanoInfantino(int vida, int danoMin, int danoMax)
    {
        super("Gianni Infantino", vida,
        new Arma("Tarjeta roja manipulada", "Te saca una tarjeta roja que te anula 2 ataques seguidos, 20%.", 60),
        new Poder("Tres fases", "1ª: mata a un aliado al caer. 2ª: revive a 2 enemigos y hace x1,5 de daño. 3ª: hace x2 de daño.", 60));
        setDanoAtaque(danoMin, danoMax);
        setEscudo(new Escudo(20));
        setUmbralEscudo(50);
        setUmbralCuracion(50);
        setAnimal("dragon");
        setUmbralMontura(10);
        setCriatura("guardia de la FIFA");
        setMaxInvocados(3);
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
    public boolean apuntar(int jugadorTOP)
    {
        System.out.println("| " + getNombre() + " apunta al jugador");
        return jugadorTOP > 0;
    }

    @Override
    public int disparar(int jugadorTOP)
    {
        if (this.municion <= 0) {
            return 0;
        }
        this.municion--;
        System.out.println("| " + getNombre() + " dispara con " + getPoder().getNombre());
        return getDanoAtaque();
    }

    @Override
    public void recargar(int cantidad)
    {
        this.municion = this.municion + cantidad;
        System.out.println("| " + getNombre() + " se queda sin municion y recarga " + cantidad);
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
    public void invocar(String criatura)
    {
        this.invocados++;
        System.out.println("| " + getNombre() + " invoca a: " + criatura);
    }

    @Override
    public int NumeroInvocados()
    {
        return this.invocados;
    }

    @Override
    public int atacarConInvocados(int jugadorTOP)
    {
        int dano = 0;
        for (int i = 0; i < this.invocados; i++) {
            dano = dano + getDanoAtaque() / 2;
        }
        System.out.println("| Los " + this.invocados + " invocados de " + getNombre() + " atacan");
        return dano;
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
    public int turnoTirador(int vidaJugador)
    {
        apuntar(vidaJugador);
        int dano = disparar(vidaJugador);
        if (dano == 0) {
            recargar(3);
        }
        return dano;
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

    @Override
    public int turnoInvocador(int vidaJugador)
    {
        int actuales = NumeroInvocados();

        if (actuales < getMaxInvocados() && (actuales == 0 || azar(100) < 50)) {
            invocar(getCriatura());
            return 0;
        }
        if (actuales > 0) {
            return atacarConInvocados(vidaJugador);
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