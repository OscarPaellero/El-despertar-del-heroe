public class personaje extends juego
{
    private String nombre;
    private int vida;
    private arma armaPersonaje;
    private poder poderPersonaje;
 
    public personaje(String nombre, int vida, arma armaPersonaje, poder poderPersonaje)
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
 
    public void setArma(arma armaPersonaje) {
        this.armaPersonaje  = armaPersonaje ;
    }
 
    public void setPoder(poder poderPersonaje) {
        this.poderPersonaje  = poderPersonaje ;
    }
 

// ===/====/===/===/===/===/=== NIVEL: LA LIGA ESPAÑOLA ===/====/===/===/===/===/===

// -------------------------- RONDA INICIAL --------------------------

    // VALENCIA CF
    public static personaje villanoLim = new personaje("Peter Lim", 60,
    new arma("Silencio", "Te bloquea un ataque.", 8),
    new poder("Venta forzosa", "Te quita una pocion.", 8));
 
    public static personaje heroeVilla = new personaje("David Villa", 30,
    new arma("Bota de ariete", "Una bota que derriba cualquier muro.", 20),
    new poder("Tiro de ariete", "Un disparo que lo atraviesa todo.", 15));
 



// -------------------------- RONDA 1 -------------------------- 

    // VILLAREAL ------------------
    public static personaje villanoRoig =  
    new personaje("Juan Roig", 80, 
    new arma("Ladrillo amarillo", "Te marea y no puedes atacar durante una ronda.", 10),
    new poder("Muro", "+5 de vida a el mismo.", 10));

    public static personaje heroeSenna = 
    new personaje("Marcos Senna", 30,
    new arma("Bote de pastillas", "El bote que nunca se vacia.", 20),
    new poder("Curacion", "Cura a quien lo necesite.", 15));
 

    // RAYO VALLECANO ------------------
    public static personaje villanoPresa = 
    new personaje("Martin Presa", 80,
    new arma("Pelotas de golf", "Sus esbirros tiran enormes cantidades de estas pelotas.", 10),
    new poder("Pelazo de señor", "Te tapa la vision con su pelo y no atacas durante 1 turno.", 10));

    public static personaje heroePalazon = 
    new personaje("Isi Palazon", 30,
    new arma("Rayo de Vallecas", "Un rayo que cae sobre el rival.", 20),
    new poder("Calva luminosa", "Una calva que ciega al rival.", 15));
 

    // ESPANYOL ------------------
    public static personaje villanoJoselu = 
    new personaje("Joselu Mato", 80,
    new arma("Poste de porteria", "Hace un x2 en uno de sus ataques.", 10),
    new poder("Descendimiento", "Te quita 5 de vida, de vez en cuando.",10));

    public static personaje heroeJarque = 
    new personaje("Dani Jarque", 30,
    new arma("Brazalete eterno", "Un brazalete que nunca se rompe.", 20),
    new poder("Eternidad", "Su recuerdo no se apaga.", 15));




// -------------------------- RONDA 2 -------------------------- 

    // GETAFE ------------------
    public static personaje villanoTorres =
    new personaje("Angel Torres", 90,
    new arma("Agentes libres", "Trae a un esbirro que te quita 10 de vida.", 12),
    new poder("Protesta", "Hay un 25% de que te quite el turno.", 12));
 
    public static personaje heroeBordalas =
    new personaje("Bordalas", 30,
    new arma("Gafas de ultravision", "Unas gafas que ven mas alla de lo normal.", 20),
    new poder("Carisma insoportable", "Un carisma que nadie aguanta.", 15));
 
 
    // ATHLETIC CLUB ------------------
    public static personaje villanoLlorente =
    new personaje("Fernando Llorente", 90,
    new arma("Diente de leon", "Te apuñala quitandote 10 de vida.", 12),
    new poder("Maman", "Sale una araña gigante que te quita 20 de vida.", 12));
 
    public static personaje heroeMuniain =
    new personaje("Iker Muniain", 30,
    new arma("Escudo de leon", "Un escudo con la fuerza de un leon.", 20),
    new poder("Barba paragolpes", "Una barba que amortigua cualquier golpe.", 15));
 
 
    // CELTA ------------------
    public static personaje villanoDorovic =
    new personaje("Goran Dorovic", 90,
    new arma("Escudo rebotante", "Te hace el doble.", 12),
    new poder("Doble identidad", "El proximo ataque te lo haces a ti mismo.", 12));
 
    public static personaje heroeAspas =
    new personaje("Iago Aspas", 30,
    new arma("Cetro de Triskel de Moana", "Un cetro con el simbolo celta.", 20),
    new poder("Regate de Akapo", "Un regate imposible de parar.", 15));
 

 

// -------------------------- RONDA 3 -------------------------- 

    // SEVILLA ------------------
    public static personaje villanoDelNido =
    new personaje("Del Nido Jr", 100,
    new arma("Baston del contrato vitalicio", "Te quita un x1,5 en cada ataque durante esta ronda.", 15),
    new poder("Herencia", "Se cura +10 aleatoriamente.", 15));
 
    public static personaje heroeNavas =
    new personaje("Jesus Navas", 30,
    new arma("Microfono de El Arrebato", "Un microfono de radio.", 20),
    new poder("El viento de Nervion", "Una carrera por la banda que arrasa.", 15));
 
 
    // BETIS ------------------
    public static personaje villanoLopera =
    new personaje("Lopera", 100,
    new arma("Maletin de la UVI", "Te pone excusas que te lian y te quita un arma aleatoria.", 15),
    new poder("El busto de la Providencia", "Duplica su daño al grito de: yo os entregue un Betis libre.", 15));
 
    public static personaje heroeJoaquin =
    new personaje("Joaquin", 30,
    new arma("Baston del huliogan", "Un baston muy travieso.", 20),
    new poder("Risa desternillante", "Una risa que descoloca al rival.", 15));
 
 
    // ATLETICO DE MADRID ------------------
    public static personaje villanoGil =
    new personaje("Jesus Gil", 100,
    new arma("Mazo de Marbella", "Mazo de dinero que te quita 20 de vida.", 15),
    new poder("Jacuzzi de verdad", "Invoca un jacuzzi que te hace y te quita -15 de vida.", 15));
 
    public static personaje heroeGriezmann =
    new personaje("Griezmann", 30,
    new arma("Pincel de corona francesa", "Un pincel con el que pinta jugadas.", 20),
    new poder("Baile hipnotico", "Un baile que hipnotiza al rival.", 15));
 


// -------------------------- RONDA FINAL NIVEL 1 -------------------------- 
 
    // FC BARCELONA ------------------
    public static personaje villanoLaporta =
    new personaje("Laporta", 120,
    new arma("Palanca cosmica", "Te mete un palancazo y se añade 15 de vida.", 17),
    new poder("Llamada de Negreira", "25% de quitarte una pocion.", 17));
 
    public static personaje heroeMessi =
    new personaje("Messi", 50,
    new arma("Bota de zurdo", "Una bota de zurdo magica.", 30),
    new poder("Anomalia de crecimiento", "Un crecimiento fuera de lo normal.", 20));
 
 
    // REAL MADRID ------------------
    public static personaje villanoFlorentino =
    new personaje("Florentino Perez", 120,
    new arma("Fachada del Bernabeu", "Te tira una fachada que te tapa la vision y el siguiente golpe que haces lo fallas.", 17),
    new poder("Fichaje galo", "Si eres Galo te quita un 20% de vida de un solo golpe.", 17));
 
    public static personaje heroeCristiano =
    new personaje("Cristiano Ronaldo", 50,
    new arma("Jabalina de trueno", "Una jabalina cargada de trueno.", 30),
    new poder("Vuelo de chilena", "Una chilena que vuela.", 20));
 




// ===/====/===/===/===/===/=== NIVEL: INTENACIONALES ===/====/===/===/===/===/===

// -------------------------- RONDA 1 -------------------------- 

    // BOCA JUNIORS ------------------
    public static personaje villanoPalermo =
    new personaje("Martin Palermo", 160,
    new arma("Penal fallado", "Usa un penalti que te quita un x3 de vida.", 20),
    new poder("Mal milagro de la lluvia", "Te anula 1 de cada 3 ataques.", 20));
 
    public static personaje heroeRiquelme =
    new personaje("J.R. Riquelme", 30,
    new arma("Balon inmortal", "Un balon que nunca se pierde.", 20),
    new poder("Llamada en vivo", "Una llamada en vivo.", 15));
 
 
    // RIVER PLATE ------------------
    public static personaje villanoHiguain =
    new personaje("Gonzalo Higuain", 160,
    new arma("Barba de señor", "Te tira pelos que te quitan 1 de vida cada uno, con un numero aleatorio entre 10 y 30.", 20),
    new poder("Protector del astro", "Te quita una pocion y se la bebe el mismo.", 20));
 
    public static personaje heroeFrancescoli =
    new personaje("Francescoli", 30,
    new arma("Coche de Cars", "Un coche de carreras.", 20),
    new poder("Chilena del millon", "Una chilena que vale un millon.", 15));
 
 
    // BORUSSIA DORTMUND ------------------
    public static personaje villanoLewandowski =
    new personaje("Lewandowski", 160,
    new arma("Asalto de traicion", "Hace que uno de tus aliados te ataque sin querer.", 20),
    new poder("La ramatada polaca", "Te tira 5 balonazos de 5 de vida menos cada uno.", 20));
 
    public static personaje heroeReus =
    new personaje("Reus", 30,
    new arma("Muro amarillo", "Un muro amarillo imposible de pasar.", 20),
    new poder("Edad de piedra", "Un golpe de la edad de piedra.", 15));
 

 

// -------------------------- RONDA 2 -------------------------- 

    // PARIS SAINT-GERMAIN ------------------
    public static personaje villanoMbappe =
    new personaje("Mbappe", 200,
    new arma("Brazalete dictatorial", "Hace que un ataque aleatorio te quite x3.", 30),
    new poder("Sprint", "Te ataca el doble cada 3 rondas.", 30));
 
    public static personaje heroeZlatan =
    new personaje("Zlatan Ibrahimovic", 30,
    new arma("Coleta de aura", "Una coleta con mucha aura.", 20),
    new poder("Taekondo", "Patadas de taekondo.", 15));
 
 
    // ARSENAL ------------------
    public static personaje villanoVanPersie =
    new personaje("Van Persie", 200,
    new arma("Roja de la final", "Te saca una roja por la cara que te anula los dos siguientes ataques.", 30),
    new poder("Ejecutor de serpiente", "Te marca un golazo que te noquea 1 ataque.", 30));
 
    public static personaje heroeHenry =
    new personaje("Thierry Henry", 30,
    new arma("Cañonazo", "Un cañonazo imparable.", 20),
    new poder("Sprint de calvicie", "Un sprint de calvicie.", 15));
 
 
    // MANCHESTER UNITED ------------------
    public static personaje villanoTevez =
    new personaje("Carlos Tevez", 200,
    new arma("Cola de apache", "Le arranca la cola a un apache y te la lanza -15.", 30),
    new poder("Noche azul", "Cambia el cielo por una noche que te hace no ver nada, y te anula 2 ataques.", 30));
 
    public static personaje heroeStam =
    new personaje("Jaap Stam", 30,
    new arma("Escudo de sangre", "Un escudo manchado de sangre.", 20),
    new poder("Mirada de aura", "Una mirada con mucha aura.", 15));
 
 


// -------------------------- RONDA 3 -------------------------- 

    // AC MILAN ------------------
    public static personaje villanoDonnarumma =
    new personaje("Donnarumma", 250,
    new arma("Billetardos", "Te tira billetes -7 por cada uno entre 5 y 15.", 40),
    new poder("Parada", "Te anula un bloqueo cada 3 ataques.", 40));
 
    public static personaje heroeMaldini =
    new personaje("Maldini", 30,
    new arma("Entrada limpia", "Una entrada limpia y perfecta.", 20),
    new poder("Atractivamiento", "Un atractivo que atrae al rival.", 15));
 
 
    // BAYERN MUNICH ------------------
    public static personaje villanoBoateng =
    new personaje("Boateng", 250,
    new arma("Hermano gemelo", "Se duplica y te quita el doble.", 40),
    new poder("Entrada de un astro", "Tiene un 25% de aturdirte.", 40));
 
    public static personaje heroeBeckenbauer =
    new personaje("Beckenbauer", 30,
    new arma("Balon imperial", "Un balon imperial.", 20),
    new poder("Libero", "Cura 20 al equipo.", 15));
 
 
    // LIVERPOOL ------------------
    public static personaje villanoSuarez =
    new personaje("Luis Suarez", 250,
    new arma("Colmillos de nariz", "Te ataca con su colmillo y te lo clava quitandote 20 de vida.", 40),
    new poder("Mordisco", "Te muerde cada 3 rondas y te quita 10 de vida.", 40));
 
    public static personaje heroeWenger =
    new personaje("Arsene Wenger", 30,
    new arma("Abrigo de los kilometros", "Un abrigo larguisimo.", 20),
    new poder("Años eternos", "Años y años de experiencia.", 15));
 
 


// -------------------------- RONDA FINAL / EVENTO FINAAAAAAAAAAAAL -------------------------- 

    // SEDE DE LA FIFA
    public static personaje villanoInfantonico =
    new personaje("Gianni Infantonico", 600,
    new arma("Tarjeta roja manipulada", "Te saca una tarjeta roja que te anula 2 ataques seguidos, 20%.", 60),
    new poder("Tres fases", "1ª: te mata un aliado al morir. 2ª: revive a un enemigo muerto aleatorio. 3ª: mata a la mitad de tus aliados.", 60));
 



    // Me da le nombre de String
    public String getNombre() {
        return this.nombre;
    }
 
    // Me da l avida en int
    public int getVida() {
        return this.vida;
    }
 
    // Me da el objeto (arma) del personaje
    public arma getArma() {
        return this.armaPersonaje;
    }
 
    // Me da le objeto (poder) del persoanje
    public poder getPoder() {
        return this.poderPersonaje;
    }

}