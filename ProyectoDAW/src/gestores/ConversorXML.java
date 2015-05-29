package gestores;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import entidades.Entrada;
import entidades.Usuario;

public class ConversorXML {
	private Document dom = null;
	// private ArrayList<Entrada> entrada = null;
	private Entrada entrada = null;

	public ConversorXML(Entrada e) {
		entrada = e;

	}
	
	public ConversorXML(){}

	public void crearDocumento() {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try {

			DocumentBuilder db = dbf.newDocumentBuilder();
			// parseamos el XML y obtenemos una representacion DOM
			dom = db.newDocument();
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		}
	}

	public void crearArbolDOM() {
		// creamos el elemento raiz "Entrada"
		Element docEle = dom.createElement("Entrada");
		dom.appendChild(docEle);

		Element entradaEle = setEntrada(entrada);
		docEle.appendChild(entradaEle);

	}

	private Element setEntrada(Entrada e) {
		// creamos el elemento entrada
		Element entradaEle = dom.createElement("entrada");

		// creamos el elemento nombre y el nodo de texto y lo añadimos al
		// elemento raiz
		
		Element idEle = dom.createElement("ID");
		Text idTexto = dom.createTextNode(Integer.toString(e.getIDentrada()));
		idEle.appendChild(idTexto);
		entradaEle.appendChild(idEle);
		
		Element nombreEle = dom.createElement("Nombre");
		Text nombreTexto = dom.createTextNode(e.getNombreEvento());
		nombreEle.appendChild(nombreTexto);
		entradaEle.appendChild(nombreEle);

		Element infoEle = dom.createElement("Informacion");
		Text infoTexto = dom.createTextNode(e.getInformacion());
		infoEle.appendChild(infoTexto);
		entradaEle.appendChild(infoEle);

		Element tipoEle = dom.createElement("tipo");
		Text tipoTexto = dom.createTextNode(e.getTipoEntrada());
		tipoEle.appendChild(tipoTexto);
		entradaEle.appendChild(tipoEle);

		Element precioEle = dom.createElement("precio");
		Text precioTexto = dom.createTextNode(Float.toString(e.getPrecio()));
		precioEle.appendChild(precioTexto);
		entradaEle.appendChild(precioEle);

		Element datoEle = dom.createElement("datos");
		Text datoTexto = dom.createTextNode(e.getDatosCliente());
		datoEle.appendChild(datoTexto);
		entradaEle.appendChild(datoEle);

		return entradaEle;

	}

	public void escribirDocumentoAXml(File file) throws TransformerException {

		// creamos una instancia para escribir el resultado
		Transformer trans = TransformerFactory.newInstance().newTransformer();
		trans.setOutputProperty(OutputKeys.INDENT, "yes");

		// especificamos donde escribimos y la fuente de datos
		StreamResult result = new StreamResult(file);
		DOMSource source = new DOMSource(dom);
		trans.transform(source, result);

	}
	public void transform(String XML, String XSL, String HTML)
			throws TransformerConfigurationException, TransformerException {

		TransformerFactory factory = TransformerFactory.newInstance();
		StreamSource xslStream = new StreamSource(XSL);
		Transformer transformer = factory.newTransformer(xslStream);

		StreamSource in = new StreamSource(XML);		
		StreamResult out = new StreamResult(HTML);
		transformer.transform(in, out);
		JOptionPane
		.showMessageDialog(
				null,
				"Se ha generado su HTML con información de la entrada.\n Gracias.",
				"Gracias", JOptionPane.INFORMATION_MESSAGE);

	}
	public void abrir(String fichero) throws IOException{
		File htmlFile = new File(fichero);
		Desktop.getDesktop().browse(htmlFile.toURI());	
	}

}