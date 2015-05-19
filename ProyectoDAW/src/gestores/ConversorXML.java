package gestores;

import java.io.File;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import entidades.Entrada;
import entidades.Usuario;

public class ConversorXML {
	private Document dom = null;
	// private ArrayList<Entrada> entrada = null;
	private Entrada entrada = null;
	private Usuario usuario = null;
	
	public ConversorXML(Entrada e, Usuario u) {
		entrada = e;
		usuario = u;
	}

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

		Element entradaEle = setEntrada(entrada, usuario);
		docEle.appendChild(entradaEle);

	}

	private Element setEntrada(Entrada e, Usuario u) {
		// creamos el elemento entrada
		Element entradaEle = dom.createElement("entrada");

		// creamos el elemento nombre y el nodo de texto y lo añadimos al
		// elemento raiz
		Element nombreEle = dom.createElement("nombre");
		Text nombreTexto = dom.createTextNode(e.getNombre());
		nombreEle.appendChild(nombreTexto);
		entradaEle.appendChild(nombreEle);

		Element dniEle = dom.createElement("dni");
		Text dniTexto = dom.createTextNode(Integer.toString(e.getDni()));
		dniEle.appendChild(dniTexto);
		entradaEle.appendChild(dniEle);

		Element direccionEle = dom.createElement("direccion");
		Text direccionTexto = dom.createTextNode(e.getDireccion());
		direccionEle.appendChild(direccionTexto);
		entradaEle.appendChild(direccionEle);

		Element tipoEle = dom.createElement("tipo");
		Text tipoTexto = dom.createTextNode(e.getTipo());
		tipoEle.appendChild(tipoTexto);
		entradaEle.appendChild(tipoEle);

		Element eventoEle = dom.createElement("evento");
		Text eventoTexto = dom.createTextNode(e.getEvento());
		eventoEle.appendChild(eventoTexto);
		entradaEle.appendChild(eventoEle);

		Element fechaEle = dom.createElement("fecha");
		Text fechaTexto = dom.createTextNode(e.getFecha());
		fechaEle.appendChild(fechaTexto);
		entradaEle.appendChild(fechaEle);

		Element precioEle = dom.createElement("precio");
		Text precioTexto = dom.createTextNode(Integer.toString(e.getPrecio()));
		precioEle.appendChild(precioTexto);
		entradaEle.appendChild(precioEle);

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

}