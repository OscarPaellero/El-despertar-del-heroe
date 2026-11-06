public class Personaje extends Juego
{
    private String nombre;
    private int vida;
    private Arma armaPersonaje;
    private Poder poderPersonaje;
 
    public Personaje(String nombre, int vida, Arma armaPersonaje, Poder poderPersonaje)
    {
        this.nombre = nombre;
        this.vida = vida;
        this.armaPersonaje = armaPersonaje;
        this.poderPersonaje = poderPersonaje;
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
 

// ===/====/===/===/===/===/=== NIVEL: LA LIGA ESPAÑOLA ===/====/===/===/===/===/===

// -------------------------- RONDA INICIAL --------------------------

    // VALENCIA CF
    public static Personaje villanoLim = new Personaje("Peter Lim", 60,
    new Arma("Silencio", "Te bloquea un ataque.", 8),
    new Poder("Venta forzosa", "Te quita una pocion.", 8));
 
    public static Personaje heroeVilla = new Personaje("David Villa", 30,
    new Arma("Bota de ariete", "Una bota que derriba cualquier muro.", 20),
    new Poder("Tiro de ariete", "Un disparo que lo atraviesa todo.", 15));
 



// -------------------------- RONDA 1 -------------------------- 

    // VILLAREAL ------------------
    public static Personaje villanoRoig =  
    new Personaje("Juan Roig", 80, 
    new Arma("Ladrillo amarillo", "Te marea y no puedes atacar durante una ronda.", 10),
    new Poder("Muro", "+5 de vida a el mismo.", 10));

    public static Personaje heroeSenna = 
    new Personaje("Marcos Senna", 30,
    new Arma("Bote de pastillas", "El bote que nunca se vacia.", 20),
    new Poder("Curacion", "Cura a quien lo necesite.", 15));
 

    // RAYO VALLECANO ------------------
    public static Personaje villanoPresa = 
    new Personaje("Martin Presa", 80,
    new Arma("Pelotas de golf", "Sus esbirros tiran enormes cantidades de estas pelotas.", 10),
    new Poder("Pelazo de señor", "Te tapa la vision con su pelo y no atacas durante 1 turno.", 10));

    public static Personaje heroePalazon = 
    new Personaje("Isi Palazon", 30,
    new Arma("Rayo de Vallecas", "Un rayo que cae sobre el rival.", 20),
    new Poder("Calva luminosa", "Una calva que ciega al rival.", 15));
 

    // ESPANYOL ------------------
    public static Personaje villanoJoselu = 
    new Personaje("Joselu Mato", 80,
    new Arma("Poste de porteria", "Hace un x2 en uno de sus ataques.", 10),
    new Poder("Descendimiento", "Te quita 5 de vida, de vez en cuando.",10));

    public static Personaje heroeJarque = 
    new Personaje("Dani Jarque", 30,
    new Arma("Brazalete eterno", "Un brazalete que nunca se rompe.", 20),
    new Poder("Eternidad", "Su recuerdo no se apaga.", 15));




// -------------------------- RONDA 2 -------------------------- 

    // GETAFE ------------------
    public static Personaje villanoTorres =
    new Personaje("Angel Torres", 90,
    new Arma("Agentes libres", "Trae a un esbirro que te quita 10 de vida.", 12),
    new Poder("Protesta", "Hay un 25% de que te quite el turno.", 12));
 
    public static Personaje heroeBordalas =
    new Personaje("Bordalas", 30,
    new Arma("Gafas de ultravision", "Unas gafas que ven mas alla de lo normal.", 20),
    new Poder("Carisma insoportable", "Un carisma que nadie aguanta.", 15));
 
 
    // ATHLETIC CLUB ------------------
    public static Personaje villanoLlorente =
    new Personaje("Fernando Llorente", 90,
    new Arma("Diente de leon", "Te apuñala quitandote 10 de vida.", 12),
    new Poder("Maman", "Sale una araña gigante que te quita 20 de vida.", 12));
 
    public static Personaje heroeMuniain =
    new Personaje("Iker Muniain", 30,
    new Arma("Escudo de leon", "Un escudo con la fuerza de un leon.", 20),
    new Poder("Barba paragolpes", "Una barba que amortigua cualquier golpe.", 15));
 
 
    // CELTA ------------------
    public static Personaje villanoDorovic =
    new Personaje("Goran Dorovic", 90,
    new Arma("Escudo rebotante", "Te hace el doble.", 12),
    new Poder("Doble identidad", "El proximo ataque te lo haces a ti mismo.", 12));
 
    public static Personaje heroeAspas =
    new Personaje("Iago Aspas", 30,
    new Arma("Cetro de Triskel de Moana", "Un cetro con el simbolo celta.", 20),
    new Poder("Regate de Akapo", "Un regate imposible de parar.", 15));
 

 

// -------------------------- RONDA 3 -------------------------- 

    // SEVILLA ------------------
    public static Personaje villanoDelNido =
    new Personaje("Del Nido Jr", 100,
    new Arma("Baston del contrato vitalicio", "Te quita un x1,5 en cada ataque durante esta ronda.", 15),
    new Poder("Herencia", "Se cura +10 aleatoriamente.", 15));
 
    public static Personaje heroeNavas =
    new Personaje("Jesus Navas", 30,
    new Arma("Microfono de El Arrebato", "Un microfono de radio.", 20),
    new Poder("El viento de Nervion", "Una carrera por la banda que arrasa.", 15));
 
 
    // BETIS ------------------
    public static Personaje villanoLopera =
    new Personaje("Lopera", 100,
    new Arma("Maletin de la UVI", "Te pone excusas que te lian y te quita un arma aleatoria.", 15),
    new Poder("El busto de la Providencia", "Duplica su daño al grito de: yo os entregue un Betis libre.", 15));
 
    public static Personaje heroeJoaquin =
    new Personaje("Joaquin", 30,
    new Arma("Baston del huliogan", "Un baston muy travieso.", 20),
    new Poder("Risa desternillante", "Una risa que descoloca al rival.", 15));
 
 
    // ATLETICO DE MADRID ------------------
    public static Personaje villanoGil =
    new Personaje("Jesus Gil", 100,
    new Arma("Mazo de Marbella", "Mazo de dinero que te quita 20 de vida.", 15),
    new Poder("Jacuzzi de verdad", "Invoca un jacuzzi que te hace y te quita -15 de vida.", 15));
 
    public static Personaje heroeGriezmann =
    new Personaje("Griezmann", 30,
    new Arma("Pincel de corona francesa", "Un pincel con el que pinta jugadas.", 20),
    new Poder("Baile hipnotico", "Un baile que hipnotiza al rival.", 15));
 


// -------------------------- RONDA FINAL NIVEL 1 -------------------------- 
 
    // FC BARCELONA ------------------
    public static Personaje villanoLaporta =
    new Personaje("Laporta", 120,
    new Arma("Palanca cosmica", "Te mete un palancazo y se añade 15 de vida.", 17),
    new Poder("Llamada de Negreira", "25% de quitarte una pocion.", 17));
 
    public static Personaje heroeMessi =
    new Personaje("Messi", 50,
    new Arma("Bota de zurdo", "Una bota de zurdo magica.", 30),
    new Poder("Anomalia de crecimiento", "Un crecimiento fuera de lo normal.", 20));
 
 
    // REAL MADRID ------------------
    public static Personaje villanoFlorentino =
    new Personaje("Florentino Perez", 120,
    new Arma("Fachada del Bernabeu", "Te tira una fachada que te tapa la vision y el siguiente golpe que haces lo fallas.", 17),
    new Poder("Fichaje galo", "Si eres Galo te quita un 20% de vida de un solo golpe.", 17));
 
    public static Personaje heroeCristiano =
    new Personaje("Cristiano Ronaldo", 50,
    new Arma("Jabalina de trueno", "Una jabalina cargada de trueno.", 30),
    new Poder("Vuelo de chilena", "Una chilena que vuela.", 20));
 




// ===/====/===/===/===/===/=== NIVEL: INTENACIONALES ===/====/===/===/===/===/===

// -------------------------- RONDA 1 -------------------------- 

    // BOCA JUNIORS ------------------
    public static Personaje villanoPalermo =
    new Personaje("Martin Palermo", 160,
    new Arma("Penal fallado", "Usa un penalti que te quita un x3 de vida.", 20),
    new Poder("Mal milagro de la lluvia", "Te anula 1 de cada 3 ataques.", 20));
 
    public static Personaje heroeRiquelme =
    new Personaje("J.R. Riquelme", 30,
    new Arma("Balon inmortal", "Un balon que nunca se pierde.", 20),
    new Poder("Llamada en vivo", "Una llamada en vivo.", 15));
 
 
    // RIVER PLATE ------------------
    public static Personaje villanoHiguain =
    new Personaje("Gonzalo Higuain", 160,
    new Arma("Barba de señor", "Te tira pelos que te quitan 1 de vida cada uno, con un numero aleatorio entre 10 y 30.", 20),
    new Poder("Protector del astro", "Te quita una pocion y se la bebe el mismo.", 20));
 
    public static Personaje heroeFrancescoli =
    new Personaje("Francescoli", 30,
    new Arma("Coche de Cars", "Un coche de carreras.", 20),
    new Poder("Chilena del millon", "Una chilena que vale un millon.", 15));
 
 
    // BORUSSIA DORTMUND ------------------
    public static Personaje villanoLewandowski =
    new Personaje("Lewandowski", 160,
    new Arma("Asalto de traicion", "Hace que uno de tus aliados te ataque sin querer.", 20),
    new Poder("La ramatada polaca", "Te tira 5 balonazos de 5 de vida menos cada uno.", 20));
 
    public static Personaje heroeReus =
    new Personaje("Reus", 30,
    new Arma("Muro amarillo", "Un muro amarillo imposible de pasar.", 20),
    new Poder("Edad de piedra", "Un golpe de la edad de piedra.", 15));
 

 

// -------------------------- RONDA 2 -------------------------- 

    // PARIS SAINT-GERMAIN ------------------
    public static Personaje villanoMbappe =
    new Personaje("Mbappe", 200,
    new Arma("Brazalete dictatorial", "Hace que un ataque aleatorio te quite x3.", 30),
    new Poder("Sprint", "Te ataca el doble cada 3 rondas.", 30));
 
    public static Personaje heroeZlatan =
    new Personaje("Zlatan Ibrahimovic", 30,
    new Arma("Coleta de aura", "Una coleta con mucha aura.", 20),
    new Poder("Taekondo", "Patadas de taekondo.", 15));
 
 
    // ARSENAL ------------------
    public static Personaje villanoVanPersie =
    new Personaje("Van Persie", 200,
    new Arma("Roja de la final", "Te saca una roja por la cara que te anula los dos siguientes ataques.", 30),
    new Poder("Ejecutor de serpiente", "Te marca un golazo que te noquea 1 ataque.", 30));
 
    public static Personaje heroeHenry =
    new Personaje("Thierry Henry", 30,
    new Arma("Cañonazo", "Un cañonazo imparable.", 20),
    new Poder("Sprint de calvicie", "Un sprint de calvicie.", 15));
 
 
    // MANCHESTER UNITED ------------------
    public static Personaje villanoTevez =
    new Personaje("Carlos Tevez", 200,
    new Arma("Cola de apache", "Le arranca la cola a un apache y te la lanza -15.", 30),
    new Poder("Noche azul", "Cambia el cielo por una noche que te hace no ver nada, y te anula 2 ataques.", 30));
 
    public static Personaje heroeStam =
    new Personaje("Jaap Stam", 30,
    new Arma("Escudo de sangre", "Un escudo manchado de sangre.", 20),
    new Poder("Mirada de aura", "Una mirada con mucha aura.", 15));
 
 


// -------------------------- RONDA 3 -------------------------- 

    // AC MILAN ------------------
    public static Personaje villanoDonnarumma =
    new Personaje("Donnarumma", 250,
    new Arma("Billetardos", "Te tira billetes -7 por cada uno entre 5 y 15.", 40),
    new Poder("Parada", "Te anula un bloqueo cada 3 ataques.", 40));
 
    public static Personaje heroeMaldini =
    new Personaje("Maldini", 30,
    new Arma("Entrada limpia", "Una entrada limpia y perfecta.", 20),
    new Poder("Atractivamiento", "Un atractivo que atrae al rival.", 15));
 
 
    // BAYERN MUNICH ------------------
    public static Personaje villanoBoateng =
    new Personaje("Boateng", 250,
    new Arma("Hermano gemelo", "Se duplica y te quita el doble.", 40),
    new Poder("Entrada de un astro", "Tiene un 25% de aturdirte.", 40));
 
    public static Personaje heroeBeckenbauer =
    new Personaje("Beckenbauer", 30,
    new Arma("Balon imperial", "Un balon imperial.", 20),
    new Poder("Libero", "Cura 20 al equipo.", 15));
 
 
    // LIVERPOOL ------------------
    public static Personaje villanoSuarez =
    new Personaje("Luis Suarez", 250,
    new Arma("Colmillos de nariz", "Te ataca con su colmillo y te lo clava quitandote 20 de vida.", 40),
    new Poder("Mordisco", "Te muerde cada 3 rondas y te quita 10 de vida.", 40));
 
    public static Personaje heroeWenger =
    new Personaje("Arsene Wenger", 30,
    new Arma("Abrigo de los kilometros", "Un abrigo larguisimo.", 20),
    new Poder("Años eternos", "Años y años de experiencia.", 15));
 
 


// -------------------------- RONDA FINAL / EVENTO FINAAAAAAAAAAAAL -------------------------- 

    // SEDE DE LA FIFA
    public static Personaje villanoInfantino =
    new Personaje("Gianni Infantino", 600,
    new Arma("Tarjeta roja manipulada", "Te saca una tarjeta roja que te anula 2 ataques seguidos, 20%.", 60),
    new Poder("Tres fases", "1ª: te mata un aliado al morir. 2ª: revive a un enemigo muerto aleatorio. 3ª: mata a la mitad de tus aliados.", 60));
 



    // Me da le nombre de String
    public String getNombre() {
        return this.nombre;
    }
 
    // Me da l avida en int
    public int getVida() {
        return this.vida;
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