package clase;

import java.util.List;
import java.util.Vector;

public class MainClass {

	public static void main(String[] args) throws Exception {
		String newLine = System.getProperty("line.separator");
		List<String> stringuri = new Vector<String>();
		stringuri.add("111");
		stringuri.add("222");
		stringuri.add("AAA");
		stringuri.add("BBB");
		AvionPasageri ap = new AvionPasageri("S1", 500, "Hercule", 120, stringuri);
		AvionCargo ac = new AvionCargo("S2", 1000, "Hercule", 5000, stringuri);
		System.out.println(ap.toString());
		System.out.println(ac.toString() + newLine);
		
		OperatiiInOutFisier of = new OperatiiInOutFisier();
		of.citesteObiecteDinFisierText("AvionPasageri01.txt");
		of.scrieObiecteInFisierText("AvionPasageri.txt");
		of.setListaObiecte(new Vector<Object>());
		
		of.citesteObiecteDinFisierText("AvionCargo01.txt");
		of.scrieObiecteInFisierText("AvionCargo.txt");
		of.setListaObiecte(new Vector<Object>());
		
		of.citesteObiecteDinFisierText("AvionPasageri01.txt");
		of.citesteObiecteDinFisierText("AvionCargo01.txt");
		of.scrieObiecteInFisierText("Avioane.txt");

		Client c=new Client();
		c.transmite(ap);
	}

}
