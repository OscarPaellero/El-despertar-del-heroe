public class Viaje
{
    public static void main(String[] args)
    {
        VillanoLim lim = new VillanoLim();
        System.out.println("=== " + lim.getNombre() + " ===");
        lim.atacarConArma(100);
        lim.levantarEscudo();
        System.out.println("Escudo levantado: " + lim.escudoLevantado());
        System.out.println("Vida del escudo: " + lim.getDefensa());
        System.out.println(" ");

        VillanoRoig roig = new VillanoRoig();
        System.out.println("=== " + roig.getNombre() + " ===");
        roig.atacarConArma(100);
        roig.levantarEscudo();
        System.out.println("Escudo levantado: " + roig.escudoLevantado());
        System.out.println("Vida del escudo: " + roig.getDefensa());
        roig.setVida(roig.getVida() - 20);
        System.out.println("Necesita curacion: " + roig.necesitaCuracion());
        roig.usarPocion();
        System.out.println("Pociones: " + roig.getPociones());
        System.out.println(" ");

        VillanoPresa presa = new VillanoPresa();
        System.out.println("=== " + presa.getNombre() + " ===");
        presa.recargar(2);
        presa.apuntar(100);
        presa.disparar(100);
        presa.invocar("esbirro con pelotas de golf");
        System.out.println("Invocados: " + presa.NumeroInvocados());
        presa.atacarConInvocados(100);
        System.out.println(" ");

        VillanoJoselu joselu = new VillanoJoselu();
        System.out.println("=== " + joselu.getNombre() + " ===");
        joselu.atacarConArma(100);
        joselu.levantarEscudo();
        System.out.println("Escudo levantado: " + joselu.escudoLevantado());
        System.out.println("Vida del escudo: " + joselu.getDefensa());
        joselu.prepararHechizo("Descendimiento");
        joselu.lanzarHechizo(100);
        joselu.recuperarMana(10);
        System.out.println(" ");

        VillanoTorres torres = new VillanoTorres();
        System.out.println("=== " + torres.getNombre() + " ===");
        torres.invocar("agente libre");
        System.out.println("Invocados: " + torres.NumeroInvocados());
        torres.atacarConInvocados(100);
        torres.prepararHechizo("Protesta");
        torres.lanzarHechizo(100);
        torres.recuperarMana(10);
        System.out.println(" ");

        VillanoLlorente llorente = new VillanoLlorente();
        System.out.println("=== " + llorente.getNombre() + " ===");
        llorente.atacarConArma(100);
        llorente.levantarEscudo();
        System.out.println("Escudo levantado: " + llorente.escudoLevantado());
        System.out.println("Vida del escudo: " + llorente.getDefensa());
        llorente.invocar("araña gigante");
        System.out.println("Invocados: " + llorente.NumeroInvocados());
        llorente.atacarConInvocados(100);
        System.out.println(" ");

        VillanoDorovic dorovic = new VillanoDorovic();
        System.out.println("=== " + dorovic.getNombre() + " ===");
        dorovic.atacarConArma(100);
        dorovic.levantarEscudo();
        System.out.println("Escudo levantado: " + dorovic.escudoLevantado());
        System.out.println("Vida del escudo: " + dorovic.getDefensa());
        dorovic.recargar(2);
        dorovic.apuntar(100);
        dorovic.disparar(100);
        System.out.println(" ");

        VillanoDelNido delNido = new VillanoDelNido();
        System.out.println("=== " + delNido.getNombre() + " ===");
        delNido.atacarConArma(100);
        delNido.levantarEscudo();
        System.out.println("Escudo levantado: " + delNido.escudoLevantado());
        System.out.println("Vida del escudo: " + delNido.getDefensa());
        delNido.setVida(delNido.getVida() - 20);
        System.out.println("Necesita curacion: " + delNido.necesitaCuracion());
        delNido.usarPocion();
        System.out.println("Pociones: " + delNido.getPociones());
        delNido.prepararHechizo("Herencia");
        delNido.lanzarHechizo(100);
        delNido.recuperarMana(10);
        System.out.println(" ");

        VillanoLopera lopera = new VillanoLopera();
        System.out.println("=== " + lopera.getNombre() + " ===");
        lopera.setVida(lopera.getVida() - 20);
        System.out.println("Necesita curacion: " + lopera.necesitaCuracion());
        lopera.usarPocion();
        System.out.println("Pociones: " + lopera.getPociones());
        lopera.prepararHechizo("Excusas de la UVI");
        lopera.lanzarHechizo(100);
        lopera.recuperarMana(10);
        System.out.println(" ");

        VillanoGil gil = new VillanoGil();
        System.out.println("=== " + gil.getNombre() + " ===");
        gil.atacarConArma(100);
        gil.levantarEscudo();
        System.out.println("Escudo levantado: " + gil.escudoLevantado());
        System.out.println("Vida del escudo: " + gil.getDefensa());
        gil.setVida(gil.getVida() - 20);
        System.out.println("Necesita curacion: " + gil.necesitaCuracion());
        gil.usarPocion();
        System.out.println("Pociones: " + gil.getPociones());
        gil.invocar("jacuzzi de verdad");
        System.out.println("Invocados: " + gil.NumeroInvocados());
        gil.atacarConInvocados(100);
        System.out.println(" ");

        VillanoLaporta laporta = new VillanoLaporta();
        System.out.println("=== " + laporta.getNombre() + " ===");
        laporta.atacarConArma(100);
        laporta.levantarEscudo();
        System.out.println("Escudo levantado: " + laporta.escudoLevantado());
        System.out.println("Vida del escudo: " + laporta.getDefensa());
        laporta.invocar("mensajero de Negreira");
        System.out.println("Invocados: " + laporta.NumeroInvocados());
        laporta.atacarConInvocados(100);
        laporta.prepararHechizo("Llamada de Negreira");
        laporta.lanzarHechizo(100);
        laporta.recuperarMana(10);
        System.out.println(" ");

        VillanoFlorentino florentino = new VillanoFlorentino();
        System.out.println("=== " + florentino.getNombre() + " ===");
        florentino.recargar(2);
        florentino.apuntar(100);
        florentino.disparar(100);
        florentino.prepararHechizo("Fichaje galo");
        florentino.lanzarHechizo(100);
        florentino.recuperarMana(10);
        System.out.println(" ");

        VillanoPalermo palermo = new VillanoPalermo();
        System.out.println("=== " + palermo.getNombre() + " ===");
        palermo.atacarConArma(100);
        palermo.levantarEscudo();
        System.out.println("Escudo levantado: " + palermo.escudoLevantado());
        System.out.println("Vida del escudo: " + palermo.getDefensa());
        palermo.recargar(2);
        palermo.apuntar(100);
        palermo.disparar(100);
        palermo.prepararHechizo("Mal milagro de la lluvia");
        palermo.lanzarHechizo(100);
        palermo.recuperarMana(10);
        System.out.println(" ");

        VillanoHiguain higuain = new VillanoHiguain();
        System.out.println("=== " + higuain.getNombre() + " ===");
        higuain.recargar(2);
        higuain.apuntar(100);
        higuain.disparar(100);
        higuain.setVida(higuain.getVida() - 20);
        System.out.println("Necesita curacion: " + higuain.necesitaCuracion());
        higuain.usarPocion();
        System.out.println("Pociones: " + higuain.getPociones());
        System.out.println(" ");

        VillanoLewandowski lewandowski = new VillanoLewandowski();
        System.out.println("=== " + lewandowski.getNombre() + " ===");
        lewandowski.atacarConArma(100);
        lewandowski.levantarEscudo();
        System.out.println("Escudo levantado: " + lewandowski.escudoLevantado());
        System.out.println("Vida del escudo: " + lewandowski.getDefensa());
        lewandowski.recargar(2);
        lewandowski.apuntar(100);
        lewandowski.disparar(100);
        lewandowski.invocar("aliado traicionero");
        System.out.println("Invocados: " + lewandowski.NumeroInvocados());
        lewandowski.atacarConInvocados(100);
        System.out.println(" ");

        VillanoMbappe mbappe = new VillanoMbappe();
        System.out.println("=== " + mbappe.getNombre() + " ===");
        mbappe.atacarConArma(100);
        mbappe.levantarEscudo();
        System.out.println("Escudo levantado: " + mbappe.escudoLevantado());
        System.out.println("Vida del escudo: " + mbappe.getDefensa());
        mbappe.montar("cohete");
        mbappe.atacarDesdeMontura(100);
        mbappe.desmontar();
        System.out.println(" ");

        VillanoVanPersie vanPersie = new VillanoVanPersie();
        System.out.println("=== " + vanPersie.getNombre() + " ===");
        vanPersie.montar("serpiente gigante");
        vanPersie.atacarDesdeMontura(100);
        vanPersie.desmontar();
        vanPersie.prepararHechizo("Ejecutor de serpiente");
        vanPersie.lanzarHechizo(100);
        vanPersie.recuperarMana(10);
        System.out.println(" ");

        VillanoTevez tevez = new VillanoTevez();
        System.out.println("=== " + tevez.getNombre() + " ===");
        tevez.recargar(2);
        tevez.apuntar(100);
        tevez.disparar(100);
        tevez.montar("caballo apache");
        tevez.atacarDesdeMontura(100);
        tevez.desmontar();
        System.out.println(" ");

        VillanoDonnarumma donnarumma = new VillanoDonnarumma();
        System.out.println("=== " + donnarumma.getNombre() + " ===");
        donnarumma.atacarConArma(100);
        donnarumma.levantarEscudo();
        System.out.println("Escudo levantado: " + donnarumma.escudoLevantado());
        System.out.println("Vida del escudo: " + donnarumma.getDefensa());
        donnarumma.recargar(2);
        donnarumma.apuntar(100);
        donnarumma.disparar(100);
        donnarumma.setVida(donnarumma.getVida() - 20);
        System.out.println("Necesita curacion: " + donnarumma.necesitaCuracion());
        donnarumma.usarPocion();
        System.out.println("Pociones: " + donnarumma.getPociones());
        System.out.println(" ");

        VillanoBoateng boateng = new VillanoBoateng();
        System.out.println("=== " + boateng.getNombre() + " ===");
        boateng.setVida(boateng.getVida() - 20);
        System.out.println("Necesita curacion: " + boateng.necesitaCuracion());
        boateng.usarPocion();
        System.out.println("Pociones: " + boateng.getPociones());
        boateng.invocar("hermano gemelo");
        System.out.println("Invocados: " + boateng.NumeroInvocados());
        boateng.atacarConInvocados(100);
        System.out.println(" ");

        VillanoSuarez suarez = new VillanoSuarez();
        System.out.println("=== " + suarez.getNombre() + " ===");
        suarez.montar("tiburon");
        suarez.atacarDesdeMontura(100);
        suarez.desmontar();
        suarez.setVida(suarez.getVida() - 20);
        System.out.println("Necesita curacion: " + suarez.necesitaCuracion());
        suarez.usarPocion();
        System.out.println("Pociones: " + suarez.getPociones());
        System.out.println(" ");

        VillanoInfantino infantino = new VillanoInfantino();
        System.out.println("=== " + infantino.getNombre() + " ===");
        infantino.atacarConArma(100);
        infantino.levantarEscudo();
        System.out.println("Escudo levantado: " + infantino.escudoLevantado());
        System.out.println("Vida del escudo: " + infantino.getDefensa());
        infantino.recargar(2);
        infantino.apuntar(100);
        infantino.disparar(100);
        infantino.montar("dragon");
        infantino.atacarDesdeMontura(100);
        infantino.desmontar();
        infantino.setVida(infantino.getVida() - 20);
        System.out.println("Necesita curacion: " + infantino.necesitaCuracion());
        infantino.usarPocion();
        System.out.println("Pociones: " + infantino.getPociones());
        infantino.invocar("guardia de la FIFA");
        System.out.println("Invocados: " + infantino.NumeroInvocados());
        infantino.atacarConInvocados(100);
        infantino.prepararHechizo("Tres fases");
        infantino.lanzarHechizo(100);
        infantino.recuperarMana(10);
        System.out.println(" ");

    }
}