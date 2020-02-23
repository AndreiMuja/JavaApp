package clase;

import java.util.List;
import java.util.Vector;

@SuppressWarnings("serial")
public class AvionPasageri extends Avion{
	private float nrLocuri;
	public List<String> cnpPasageri=new Vector<String>();
	
	public AvionPasageri(String serie, float tonaj, String marca, float nrLocuri, List<String> cnpPasageri) throws Exception {
		super(serie, tonaj, marca);
		this.nrLocuri = nrLocuri;
		this.cnpPasageri = cnpPasageri;
		if(tonaj<0)
			throw new Exception("Tonaj imposibil!");
	}

	@Override
	public float getCapacitate() {
		return nrLocuri;
	}
	
	@Override
	public AvionPasageri clone(){
		try{
			AvionPasageri ap=new AvionPasageri(this.getSerie(),this.getTonaj(),this.getMarca(),this.nrLocuri,this.cnpPasageri);
			return ap;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AvionPasageri other = (AvionPasageri) obj;
		if (cnpPasageri == null) {
			if (other.cnpPasageri != null)
				return false;
		} else if (!cnpPasageri.equals(other.cnpPasageri))
			return false;
		if (Float.floatToIntBits(nrLocuri) != Float.floatToIntBits(other.nrLocuri))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AvionPasageri [nrLocuri=" + nrLocuri + ", cnpPasageri=" + cnpPasageri + ", getSerie()=" + getSerie()
				+ ", getTonaj()=" + getTonaj() + ", getMarca()=" + getMarca() + "]";
	}
	
}
