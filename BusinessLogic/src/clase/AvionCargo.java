package clase;

import java.util.List;
import java.util.Vector;

@SuppressWarnings("serial")
public class AvionCargo extends Avion{
	private float capacitateTransportKg;
	public List<String> serieMarfuri=new Vector<String>();
	
	public AvionCargo(String serie, float tonaj, String marca, float capacitateTransportKg, List<String> serieMarfuri) throws Exception {
		super(serie, tonaj, marca);
		this.capacitateTransportKg = capacitateTransportKg;
		this.serieMarfuri = serieMarfuri;
		if(tonaj<0)
			throw new Exception("Tonaj inmposibil!");
	}

	@Override
	public float getCapacitate() {
		return capacitateTransportKg;
	}
	
	@Override
	public AvionCargo clone(){
		try{
			AvionCargo ac=new AvionCargo(this.getSerie(),this.getTonaj(),this.getMarca(),this.capacitateTransportKg,this.serieMarfuri);
			return ac;
		}catch(Exception ex){
			ex.printStackTrace();
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
		AvionCargo other = (AvionCargo) obj;
		if (Float.floatToIntBits(capacitateTransportKg) != Float.floatToIntBits(other.capacitateTransportKg))
			return false;
		if (serieMarfuri == null) {
			if (other.serieMarfuri != null)
				return false;
		} else if (!serieMarfuri.equals(other.serieMarfuri))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AvionCargo [capacitateTransportKg=" + capacitateTransportKg + ", serieMarfuri=" + serieMarfuri
				+ ", getSerie()=" + getSerie() + ", getTonaj()=" + getTonaj() + ", getMarca()=" + getMarca() + "]";
	}
	
}
