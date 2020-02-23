package clase;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;

public class OperatiiInOutFisier implements OperatiiFisier, Comparable<OperatiiInOutFisier>, Cloneable {
	private String numeFisier;
	private List<Object> listaObiecte = new Vector<Object>();

	public OperatiiInOutFisier(List<Object> listaObiecte) {
		super();
		this.listaObiecte = listaObiecte;
	}

	public OperatiiInOutFisier() {
	}

	public String getNumeFisier() {
		return numeFisier;
	}

	public void setNumeFisier(String numeFisier) {
		this.numeFisier = numeFisier;
	}

	public List<Object> getListaObiecte() {
		return listaObiecte;
	}

	public void setListaObiecte(List<Object> listaObiecte) {
		this.listaObiecte = listaObiecte;
	}

	@Override
	public OperatiiInOutFisier clone() {
		OperatiiInOutFisier of = new OperatiiInOutFisier(this.getListaObiecte());
		return of;
	}

	@Override
	public int compareTo(OperatiiInOutFisier arg0) {
		File f1 = new File(this.numeFisier);
		File f2 = new File(this.numeFisier);
		int s1 = (int) f1.getTotalSpace();
		int s2 = (int) f2.getTotalSpace();
		return s1 - s2;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OperatiiInOutFisier other = (OperatiiInOutFisier) obj;
		if (listaObiecte == null) {
			if (other.listaObiecte != null)
				return false;
		} else if (!listaObiecte.equals(other.listaObiecte))
			return false;
		if (numeFisier == null) {
			if (other.numeFisier != null)
				return false;
		} else if (!numeFisier.equals(other.numeFisier))
			return false;
		return true;
	}

	@Override
	public void citesteObiecteDinFisierText(String numeFisier) {
		List<String> cnpSauSerie = new Vector<String>();
		try {
			FileReader fr = new FileReader(numeFisier);
			BufferedReader br = new BufferedReader(fr);
			String retine = br.readLine();
			while (retine != null) {
				StringTokenizer st = new StringTokenizer(retine, "#");
				String serie = (String) st.nextElement();
				float tonaj = Float.valueOf((String) st.nextElement());
				String marca = (String) st.nextElement();
				float capacitate = (float) st.nextElement();
				StringTokenizer altern = new StringTokenizer((String) st.nextElement(), ",");
				while (altern.hasMoreElements()) {
					cnpSauSerie.add((String) altern.nextElement());
				}
				if (numeFisier.equals("AvionPasageri01.txt")) {
					AvionPasageri ap = new AvionPasageri(serie, tonaj, marca, capacitate, cnpSauSerie);
					listaObiecte.add(ap);
					cnpSauSerie = new Vector<String>();
				} 
				if(numeFisier.equals("AvionCargo01.txt")) {
					AvionCargo ag=new AvionCargo(serie,tonaj,marca,capacitate, cnpSauSerie);
					listaObiecte.add(ag);
					cnpSauSerie=new Vector<String>();
				}
				retine = br.readLine();
			}
			br.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void scrieObiecteInFisierText(String numeFisier) {
		String newLine = System.getProperty("line.separator");
		int numarator = 1;
		try {
			FileWriter fw = new FileWriter(numeFisier);
			BufferedWriter bw = new BufferedWriter(fw);
			for (Object o : listaObiecte) {
				if (o instanceof AvionPasageri) {
					AvionPasageri ap = (AvionPasageri) o;
					bw.write(ap.getSerie());
					bw.write("#");
					bw.write(String.valueOf(ap.getTonaj()));
					bw.write("#");
					bw.write(ap.getMarca());
					bw.write("#");
					bw.write(String.valueOf(ap.getCapacitate()));
					for (String s : ap.cnpPasageri) {
						if (numarator < ap.cnpPasageri.size()) {
							bw.write(s);
							bw.write("#");
							numarator++;
						} else {
							bw.write(s);
							bw.write(newLine);
							numarator = 1;
						}
					}
				}
			}
			bw.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
