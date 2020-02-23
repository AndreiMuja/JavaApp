package clase;

import java.io.File;

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

public class XML {
	
	public static void main(String[] args) throws ParserConfigurationException, TransformerException{
		OperatiiInOutFisier of=new OperatiiInOutFisier();
		of.citesteObiecteDinFisierText("AvionPasageri01.txt");
		
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		DocumentBuilder db=dbf.newDocumentBuilder();
		Document d=db.newDocument();
		Element el=d.createElement("Avioane");
		for(Object o:of.getListaObiecte()){
			Element e1=d.createElement("Serie");
			Element e2=d.createElement("Tonaj");
			Element e3=d.createElement("Marca");
			Element e4=d.createElement("Capacitate");
			Element e5=d.createElement("CNP/Serie");
			if(o instanceof AvionPasageri){
				AvionPasageri ap=(AvionPasageri) o;
				String s="";
				for(String sir:ap.cnpPasageri){
					s+=sir+" ";
				}
				e1.appendChild(d.createTextNode(String.valueOf(ap.getSerie())));
				e2.appendChild(d.createTextNode(String.valueOf(ap.getTonaj())));
				e3.appendChild(d.createTextNode(String.valueOf(ap.getMarca())));
				e4.appendChild(d.createTextNode(String.valueOf(ap.getCapacitate())));
				e5.appendChild(d.createTextNode(String.valueOf(s)));
				el.appendChild(e1);
				el.appendChild(e2);
				el.appendChild(e3);
				el.appendChild(e4);
				el.appendChild(e5);
			}
			if(o instanceof AvionCargo){
				AvionCargo ag=(AvionCargo) o;
				String s="";
				for(String sir:ag.serieMarfuri){
					s+=sir+" ";
				}
				e1.appendChild(d.createTextNode(String.valueOf(ag.getSerie())));
				e2.appendChild(d.createTextNode(String.valueOf(ag.getTonaj())));
				e3.appendChild(d.createTextNode(String.valueOf(ag.getMarca())));
				e4.appendChild(d.createTextNode(String.valueOf(ag.getCapacitate())));
				e5.appendChild(d.createTextNode(String.valueOf(s)));
				el.appendChild(e1);
				el.appendChild(e2);
				el.appendChild(e3);
				el.appendChild(e4);
				el.appendChild(e5);
			}
		}
		d.appendChild(el);
		TransformerFactory tf=TransformerFactory.newInstance();
		Transformer t=tf.newTransformer();
		t.setOutputProperty(OutputKeys.INDENT, "yes");
		DOMSource dom=new DOMSource();
		StreamResult sr=new StreamResult(new File("Avioane.xml"));
		t.transform(dom, sr);
	}
}
