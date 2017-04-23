package fi.turbotiimi.paivyri.api;

public class RuokailuMedianModel {

	private String username;
	private int medianAteriakoko;
	private int medianHiilihydraatit;
	private int medianProteiinit;
	private int medianRasvat;
	
	public RuokailuMedianModel() {
		super();
	}
	
	public RuokailuMedianModel(String username, int medianAteriakoko, int medianHiilihydraatit, int medianProteiinit, int medianRasvat) {
		super();
		this.username = username;
		this.medianAteriakoko = medianAteriakoko;
		this.medianHiilihydraatit = medianHiilihydraatit;
		this.medianProteiinit = medianProteiinit;
		this.medianRasvat = medianRasvat;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getMedianAteriakoko() {
		return medianAteriakoko;
	}

	public void setMedianAteriakoko(int medianAteriakoko) {
		this.medianAteriakoko = medianAteriakoko;
	}

	public int getMedianHiilihydraatit() {
		return medianHiilihydraatit;
	}

	public void setMedianHiilihydraatit(int medianHiilihydraatit) {
		this.medianHiilihydraatit = medianHiilihydraatit;
	}

	public int getMedianProteiinit() {
		return medianProteiinit;
	}

	public void setMedianProteiinit(int medianProteiinit) {
		this.medianProteiinit = medianProteiinit;
	}

	public int getMedianRasvat() {
		return medianRasvat;
	}

	public void setMedianRasvat(int medianRasvat) {
		this.medianRasvat = medianRasvat;
	}
	
	
}
