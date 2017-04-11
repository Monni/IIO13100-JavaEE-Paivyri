package Paivyri.solution;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ruokailu")
public class Ruokailu implements Serializable {
	private static final long serialVersionUID = 1L;

	// Persistent Fields
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	int id;
	
	@Column(name = "pvm")
	private Date pvm;
	
	@Column(name = "klo")
	private Time klo;
	
	@Column(name = "nimi")
	private String nimi;
	
	@Column(name = "ruoannimi")
	private String ruoannimi;
	
	@Column(name = "ruoanmaara")
	private int ruoanmaara;
	
	@Column(name = "kalorit")
	private int kalorit;
	
	@Column(name = "hiilihydraatit")
	private int hiilihydraatit;
	
	@Column(name = "proteiini")
	private int proteiini;
	
	@Column(name = "rasva")
	private int rasva;
	
	public Ruokailu() {
		super();
	}
	
	public Ruokailu(Date pvm, Time klo, String nimi, String ruoannimi, int ruoanmaara, int kalorit) {
		this.pvm = pvm;
		this.klo = klo;
		this.nimi = nimi;
		this.ruoannimi = ruoannimi;
		this.ruoanmaara = ruoanmaara;
		this.kalorit = kalorit;
	}
	
	public Ruokailu(Date pvm, Time klo, String nimi, String ruoannimi, int ruoanmaara, int kalorit, int hiilihydraatit, int proteiini, int rasva) {
		this.pvm = pvm;
		this.klo = klo;
		this.nimi = nimi;
		this.ruoannimi = ruoannimi;
		this.ruoanmaara = ruoanmaara;
		this.kalorit = kalorit;
		this.hiilihydraatit = hiilihydraatit;
		this.proteiini = proteiini;
		this.rasva = rasva;
	}

	public Date getPvm() {
		return pvm;
	}

	public void setPvm(Date pvm) {
		this.pvm = pvm;
	}

	public Time getKlo() {
		return klo;
	}

	public void setKlo(Time klo) {
		this.klo = klo;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public String getRuoannimi() {
		return ruoannimi;
	}

	public void setRuoannimi(String ruoannimi) {
		this.ruoannimi = ruoannimi;
	}

	public int getRuoanmaara() {
		return ruoanmaara;
	}

	public void setRuoanmaara(int ruoanmaara) {
		this.ruoanmaara = ruoanmaara;
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

	public int getProteiini() {
		return proteiini;
	}

	public void setProteiini(int proteiini) {
		this.proteiini = proteiini;
	}

	public int getRasva() {
		return rasva;
	}

	public void setRasva(int rasva) {
		this.rasva = rasva;
	}
	
	@Override
	public String toString() {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String pvm = df.format(this.pvm);
		return "Ruokailu ID " + Integer.toString(id) + "\nAika: " + pvm + " " +  "\nRuokailija: " + this.nimi + "\nRuoka: " + this.ruoannimi + " " + Integer.toString(this.ruoanmaara) + "\nKaloreita per 100g: " + Integer.toString(this.kalorit);
	}
	
}
