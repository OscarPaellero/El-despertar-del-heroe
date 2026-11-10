package VILLANOS;

import java.util.Random;

public class Personaje
{
    private String nombre;
    private int vida;
    private int vidaMax;
    private int danoMin;
    private int danoMax;
    private String animal = "caballo";
    private String criatura = "esbirro";
    private static Random random = new Random();
    private Escudo escudo;
    private boolean defendiendo;
    private int umbralEscudo = 25;
    private int umbralCuracion = 40;
    private int umbralMontura = 20;
    private int maxInvocados = 3;
    private Arma armaPersonaje;
    private Poder poderPersonaje;
 
    public Personaje(String nombre, int vida, Arma armaPersonaje, Poder poderPersonaje)
    {
        this.nombre = nombre;
        this.vida = vida;
        this.vidaMax = vida;
        this.armaPersonaje = armaPersonaje;
        this.poderPersonaje = poderPersonaje;
        this.danoMin = armaPersonaje.getDaño();
        this.danoMax = armaPersonaje.getDaño();
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
    public void setVida(int vida) {
        this.vida = vida;
    }
 
    public void setArma(Arma armaPersonaje) {
        this.armaPersonaje  = armaPersonaje ;
    }
 
    public void setPoder(Poder poderPersonaje) {
        this.poderPersonaje  = poderPersonaje ;
    }

    public void setDanoAtaque(int min, int max) {
        this.danoMin = min;
        this.danoMax = max;
    }

    public void setEscudo(Escudo escudo) {
        this.escudo = escudo;
    }

    public void setDefendiendo(boolean defendiendo) {
        this.defendiendo = defendiendo;
    }

    public void setUmbralEscudo(int umbralEscudo) {
        this.umbralEscudo = umbralEscudo;
    }

    public void setUmbralCuracion(int umbralCuracion) {
        this.umbralCuracion = umbralCuracion;
    }

    public void setUmbralMontura(int umbralMontura) {
        this.umbralMontura = umbralMontura;
    }

    public void setMaxInvocados(int maxInvocados) {
        this.maxInvocados = maxInvocados;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public void setCriatura(String criatura) {
        this.criatura = criatura;
    }


// ===/====/===/===/===/===/=== NIVEL: LA LIGA ESPAÑOLA ===/====/===/===/===/===/===

// -------------------------- RONDA INICIAL --------------------------

    // VALENCIA CF
    public static Personaje heroeVilla = new Personaje("David Villa", 30,
    new Arma("Bota de ariete", "Una bota que derriba cualquier muro.", 20),
    new Poder("Tiro de ariete", "Un disparo que lo atraviesa todo.", 15));


// -------------------------- RONDA 1 -------------------------- 

    // VILLAREAL ------------------
    public static Personaje heroeSenna = new Personaje("Marcos Senna", 30,
    new Arma("Bote de pastillas", "El bote que nunca se vacia.", 20),
    new Poder("Curacion", "Cura a quien lo necesite.", 15));


    // RAYO VALLECANO ------------------
    public static Personaje heroePalazon = new Personaje("Isi Palazon", 30,
    new Arma("Rayo de Vallecas", "Un rayo que cae sobre el rival.", 20),
    new Poder("Calva luminosa", "Una calva que ciega al rival.", 15));


    // ESPANYOL ------------------
    public static Personaje heroeJarque = new Personaje("Dani Jarque", 30,
    new Arma("Brazalete eterno", "Un brazalete que nunca se rompe.", 20),
    new Poder("Eternidad", "Su recuerdo no se apaga.", 15));


// -------------------------- RONDA 2 -------------------------- 

    // GETAFE ------------------
    public static Personaje heroeBordalas = new Personaje("Bordalas", 30,
    new Arma("Gafas de ultravision", "Unas gafas que ven mas alla de lo normal.", 20),
    new Poder("Carisma insoportable", "Un carisma que nadie aguanta.", 15));


    // ATHLETIC CLUB ------------------
    public static Personaje heroeMuniain = new Personaje("Iker Muniain", 30,
    new Arma("Escudo de leon", "Un escudo con la fuerza de un leon.", 20),
    new Poder("Barba paragolpes", "Una barba que amortigua cualquier golpe.", 15));


    // CELTA ------------------
    public static Personaje heroeAspas = new Personaje("Iago Aspas", 30,
    new Arma("Cetro de Triskel de Moana", "Un cetro con el simbolo celta.", 20),
    new Poder("Regate de Akapo", "Un regate imposible de parar.", 15));


// -------------------------- RONDA 3 -------------------------- 

    // SEVILLA ------------------
    public static Personaje heroeNavas = new Personaje("Jesus Navas", 30,
    new Arma("Microfono de El Arrebato", "Un microfono de radio.", 20),
    new Poder("El viento de Nervion", "Una carrera por la banda que arrasa.", 15));


    // BETIS ------------------
    public static Personaje heroeJoaquin = new Personaje("Joaquin", 30,
    new Arma("Baston del huliogan", "Un baston muy travieso.", 20),
    new Poder("Risa desternillante", "Una risa que descoloca al rival.", 15));


    // ATLETICO DE MADRID ------------------
    public static Personaje heroeGriezmann = new Personaje("Griezmann", 30,
    new Arma("Pincel de corona francesa", "Un pincel con el que pinta jugadas.", 20),
    new Poder("Baile hipnotico", "Un baile que hipnotiza al rival.", 15));


// -------------------------- RONDA FINAL NIVEL 1 -------------------------- 
 
    // FC BARCELONA ------------------
    public static Personaje heroeMessi = new Personaje("Messi", 50,
    new Arma("Bota de zurdo", "Una bota de zurdo magica.", 30),
    new Poder("Anomalia de crecimiento", "Un crecimiento fuera de lo normal.", 20));


    // REAL MADRID ------------------
    public static Personaje heroeCristiano = new Personaje("Cristiano Ronaldo", 50,
    new Arma("Jabalina de trueno", "Una jabalina cargada de trueno.", 30),
    new Poder("Vuelo de chilena", "Una chilena que vuela.", 20));


// ===/====/===/===/===/===/=== NIVEL: INTENACIONALES ===/====/===/===/===/===/===

// -------------------------- RONDA 1 -------------------------- 

    // BOCA JUNIORS ------------------
    public static Personaje heroeRiquelme = new Personaje("J.R. Riquelme", 30,
    new Arma("Balon inmortal", "Un balon que nunca se pierde.", 20),
    new Poder("Llamada en vivo", "Una llamada en vivo.", 15));


    // RIVER PLATE ------------------
    public static Personaje heroeFrancescoli = new Personaje("Francescoli", 30,
    new Arma("Coche de Cars", "Un coche de carreras.", 20),
    new Poder("Chilena del millon", "Una chilena que vale un millon.", 15));


    // BORUSSIA DORTMUND ------------------
    public static Personaje heroeReus = new Personaje("Reus", 30,
    new Arma("Muro amarillo", "Un muro amarillo imposible de pasar.", 20),
    new Poder("Edad de piedra", "Un golpe de la edad de piedra.", 15));


// -------------------------- RONDA 2 -------------------------- 

    // PARIS SAINT-GERMAIN ------------------
    public static Personaje heroeZlatan = new Personaje("Zlatan Ibrahimovic", 30,
    new Arma("Coleta de aura", "Una coleta con mucha aura.", 20),
    new Poder("Taekondo", "Patadas de taekondo.", 15));


    // ARSENAL ------------------


    public static Personaje heroeHenry =new Personaje("Thierry Henry", 30,
    new Arma("Cañonazo", "Un cañonazo imparable.", 20),
    new Poder("Sprint de calvicie", "Un sprint de calvicie.", 15));


    // MANCHESTER UNITED ------------------


    public static Personaje heroeStam = new Personaje("Jaap Stam", 30,
    new Arma("Escudo de sangre", "Un escudo manchado de sangre.", 20),
    new Poder("Mirada de aura", "Una mirada con mucha aura.", 15));


// -------------------------- RONDA 3 -------------------------- 

    // AC MILAN ------------------


    public static Personaje heroeMaldini = new Personaje("Maldini", 30,
    new Arma("Entrada limpia", "Una entrada limpia y perfecta.", 20),
    new Poder("Atractivamiento", "Un atractivo que atrae al rival.", 15));


    // BAYERN MUNICH ------------------


    public static Personaje heroeBeckenbauer = new Personaje("Beckenbauer", 30,
    new Arma("Balon imperial", "Un balon imperial.", 20),
    new Poder("Libero", "Cura 20 al equipo.", 15));


    // LIVERPOOL ------------------


    public static Personaje heroeWenger = new Personaje("Arsene Wenger", 30,
    new Arma("Abrigo de los kilometros", "Un abrigo larguisimo.", 20),
    new Poder("Años eternos", "Años y años de experiencia.", 15));


// -------------------------- RONDA FINAL / EVENTO FINAAAAAAAAAAAAL -------------------------- 

    // SEDE DE LA FIFA


    // Me da le nombre de String
    public String getNombre() {
        return this.nombre;
    }
 
    // Me da l avida en int
    public int getVida() {
        return this.vida;
    }
 
    public int getVidaMax() {
        return this.vidaMax;
    }

    // Daño aleatorio entre danoMin y danoMax (los dos incluidos)
    public int getDanoAtaque() {
        return this.danoMin + random.nextInt(this.danoMax - this.danoMin + 1);
    }

    // Vida que le queda en porcentaje (0 a 100)
    public int getVidaPorcentaje() {
        return this.vida * 100 / this.vidaMax;
    }

    public Escudo getEscudo() {
        return this.escudo;
    }

    public boolean isDefendiendo() {
        return this.defendiendo;
    }

    public int getUmbralEscudo() {
        return this.umbralEscudo;
    }

    public int getUmbralCuracion() {
        return this.umbralCuracion;
    }

    public int getUmbralMontura() {
        return this.umbralMontura;
    }

    public int getMaxInvocados() {
        return this.maxInvocados;
    }

    public int azar(int max) {
        return random.nextInt(max);
    }

    // Cada villano sobreescribe solo los turnos de sus interfaces. -1 = no tiene esa acción, Combate tira otra vez el dado; 0 = actuó sin daño
    public int turnoCombatiente(int vidaJugador) {
        return -1;
    }

    public int turnoTirador(int vidaJugador) {
        return -1;
    }

    public int turnoJinete(int vidaJugador) {
        return -1;
    }

    public int turnoSanador(int vidaJugador) {
        return -1;
    }

    public int turnoInvocador(int vidaJugador) {
        return -1;
    }

    public int turnoHechicero(int vidaJugador) {
        return -1;
    }

    public String getAnimal() {
        return this.animal;
    }

    public String getCriatura() {
        return this.criatura;
    }

    // Me da el objeto (arma) del personaje
    public Arma getArma() {
        return this.armaPersonaje;
    }
 
    // Me da le objeto (poder) del persoanje
    public Poder getPoder() {
        return this.poderPersonaje;
    }
}