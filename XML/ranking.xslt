<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:output method="html" encoding="UTF-8" indent="yes"/>

  <xsl:template match="/">
    <html lang="es">
      <head>
        <meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <title>Ranking · El despertar del héroe</title>
        <link rel="stylesheet" href="ranking.css"/>
      </head>
      <body>
        <h1>El despertar del héroe</h1>
        <h2>Clasificación de jugadores</h2>

        <xsl:choose>
          <!-- Hay jugadores: se pinta la tabla -->
          <xsl:when test="count(/ranking/jugador) &gt; 0">
            <table>
              <thead>
                <tr>
                  <th>Puesto</th>
                  <th>Jugador</th>
                  <th>Puntos</th>
                </tr>
              </thead>
              <tbody>
                <xsl:for-each select="/ranking/jugador">
                  <!-- Orden numérico de mayor a menor; en empate se respeta el orden del XML -->
                  <xsl:sort select="puntos" data-type="number" order="descending"/>

                  <!-- Después de ordenar, position() es el puesto. Solo se muestran los 10 primeros -->
                  <xsl:if test="position() &lt;= 10">
                    <tr>
                      <td class="puesto"><xsl:value-of select="position()"/></td>
                      <td><xsl:value-of select="nombre"/></td>
                      <td class="puntos"><xsl:value-of select="puntos"/></td>
                    </tr>
                  </xsl:if>
                </xsl:for-each>
              </tbody>
            </table>
            <p class="nota">Jugadores registrados: <xsl:value-of select="count(/ranking/jugador)"/> (se muestran como máximo los 10 mejores)</p>
          </xsl:when>

          <!-- No hay jugadores -->
          <xsl:otherwise>
            <p class="vacio">Todavía no hay registros en el ranking.</p>
          </xsl:otherwise>
        </xsl:choose>
      </body>
    </html>
  </xsl:template>

</xsl:stylesheet>