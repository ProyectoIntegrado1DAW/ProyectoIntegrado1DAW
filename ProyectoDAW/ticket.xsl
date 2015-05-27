<?xml version="1.0" encoding="iso-8859-1"?>
<!-- DWXMLSource="ticket2.xml" -->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:template match="/">
    <html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
    </head>
    <body background="Fondo_entrada.png" style="background-repeat:no-repeat">
    <br />
    <div style="width:500px; position:relative; left:200px">
    <h1  align="center"><xsl:value-of select="Entrada/entrada/Nombre"/></h1>
    <br />
    <table>
      <tr>
        <td><xsl:value-of select="Entrada/entrada/descripcion"/></td>
      </tr>
    </table>
    <td></td>
    <table  border="3" >
      <tr>
        <th>Informacion</th>
        <th>Tipo</th>
        <th>Datos</th>
        <th>ID</th>
      </tr>
      <tr>
        <td><xsl:value-of select="Entrada/entrada/Informacion"/></td>
        <td><xsl:value-of select="Entrada/entrada/tipo"/></td>
        <td><xsl:value-of select="Entrada/entrada/datos"/></td>
        <td><xsl:value-of select="Entrada/entrada/ID"/></td>
      </tr>
    </table>
    <br />
    <table border="3" align="center">
      <tr >
        <th>Total</th>
      </tr>
      <tr>
        <td><xsl:value-of select="Entrada/entrada/precio"/></td>
      </tr>
    </table>
    </div>
    </body>
    </html>
  </xsl:template>
</xsl:stylesheet>