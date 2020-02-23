package clase;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class Avion implements Serializable {
	private String serie;
	private float tonaj;
	private final String marca;
	
	public Avion(String serie, float tonaj, String marca) {
		super();
		this.serie = serie;
		this.tonaj = tonaj;
		this.marca = marca;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public float getTonaj() {
		return tonaj;
	}

	public void setTonaj(float tonaj) {
		this.tonaj = tonaj;
	}

	public String getMarca() {
		return marca;
	}
	
	abstract public float getCapacitate();
}
