# El despertar del héroe · Football Edition

Aventura textual por turnos en Java ambientada en el fútbol. El jugador combate contra villanos en distintos estadios hasta llegar a Infantino. Las mejores puntuaciones se guardan en un ranking XML, que se valida con una DTD y se publica como página HTML con XSLT.

### Autor: Óscar Rodrigo Breso · Proyecto de la 1.ª evaluación.

## Requisitos

- JDK 21 (Eclipse Adoptium 21.0.13)
- Visual Studio Code con *Extension Pack for Java*
- Extensión *XSLT/XPath for Visual Studio Code* + Saxon-HE 13.1
- Git

> La ruta del proyecto no puede tener caracteres como `ª` (Saxon da *I/O error*).

## Estructura

```
EL DESPERATRA DEL HEROE/
├── CODIGO/      Código Java (Juego.java tiene el main)
│   ├── VILLANOS/
│   └── INTERFACES/
├── XML/         ranking.xml, ranking.dtd, ranking.xslt, ranking.css, ranking.html
│                y copias de prueba (Error*.xml)
├── README.md
└── .gitignore
```

## Compilar y ejecutar

En VS Code: abrir `CODIGO/Juego.java` y pulsar **Run**.

Desde la terminal, en la carpeta del proyecto:

```
javac -encoding UTF-8 -d bin -sourcepath CODIGO CODIGO/Juego.java
java -cp bin Juego
```

`javac` convierte los `.java` en `.class` (bytecode) y `java` los ejecuta en la JVM.

## Cómo se juega

- Menú: 1 Nueva partida · 2 Ranking · 3 Normas · 4 Salir.
- En combate: 1 Atacar · 2 Escudo · 3 Poción · 4 Poder de aliado · 5 Abandonar.
- 100 puntos por enemigo derrotado. Si ganas la aventura, se suma la vida que te queda.
