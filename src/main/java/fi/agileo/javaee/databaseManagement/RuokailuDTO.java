package fi.agileo.javaee.databaseManagement;

import java.sql.Date;

public class RuokailuDTO {
	
	private int ID;
	private Date date;
	private String klo;
	private String nimi;
	private String ruoanNimi;
	private int ruoanMaara;
	private int kalorit;
	private int hiilihydraatit;
	private int proteiinit;
	private int rasvat;
	
	public RuokailuDTO() {
		System.out.println("Created RuokailuDTO");
	}
	
	public int getID() {
		return ID;
	}
	
	public void setID(int ID) {
		this.ID = ID;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date currentDate) {
		this.date = currentDate;
	}

	public String getKlo() {
		return klo;
	}

	public void setKlo(String klo) {
		this.klo = klo;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public String getRuoanNimi() {
		return ruoanNimi;
	}

	public void setRuoanNimi(String ruoanNimi) {
		this.ruoanNimi = ruoanNimi;
	}

	public int getRuoanMaara() {
		return ruoanMaara;
	}

	public void setRuoanMaara(int ruoanMaara) {
		this.ruoanMaara = ruoanMaara;
	}

	public int getKalorit() {
		return kalorit;
	}

	public void setKalorit(int kalorit) {
		this.kalorit = kalorit;
	}

	public int getHiilihydraatit() {
		return hiilihydraatit;
	}

	public void setHiilihydraatit(int hiilihydraatit) {
		this.hiilihydraatit = hiilihydraatit;
	}

	public int getProteiinit() {
		return proteiinit;
	}

	public void setProteiinit(int proteiinit) {
		this.proteiinit = proteiinit;
	}

	public int getRasvat() {
		return rasvat;
	}

	public void setRasvat(int rasvat) {
		this.rasvat = rasvat;
	}
	
	public void printRuokailu(){
		System.out.println(getID() + ", " + getDate() + ", " + getKlo() + ", " + getNimi() + ", " + getRuoanNimi() + ", " + getRuoanMaara() + ", " + getKalorit() + ", " + getHiilihydraatit() + ", " + getProteiinit() + ", " + getRasvat());
	}
}
