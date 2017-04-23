package fi.agileo.javaee.client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fi.agileo.javaee.api.RuokailuMedianModel;
import fi.agileo.javaee.databaseManagement.RuokailuDTO;
import fi.agileo.javaee.service.RuokailuService;


@Controller
public class RuokailuController {

	@Autowired
	private RuokailuService ruokailuService;
	
	
	// Näytetään index blankkona
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		return "index";
	}
	
	
	// Näytetään index tietyn käyttäjän tiedoilla
	@RequestMapping(value ="/findbyuser", method = RequestMethod.GET)
	public String indexWithUserData(@RequestParam(value="firstname", required=true) String username, Model model) {
		List<RuokailuDTO> ruokailuList = ruokailuService.findByID(username);

		int medianAteriakoko = MedianAteriakoko(ruokailuList);
		int medianHiilihydraatit = medianHiilihydraatit(ruokailuList);
		int medianProteiinit = medianProteiinit(ruokailuList);
		int medianRasvat = medianRasvat(ruokailuList);
		
		RuokailuMedianModel ruokailuMedianModel = new RuokailuMedianModel();
		ruokailuMedianModel.setUsername(username);
		ruokailuMedianModel.setMedianAteriakoko(medianAteriakoko);
		ruokailuMedianModel.setMedianHiilihydraatit(medianHiilihydraatit);
		ruokailuMedianModel.setMedianProteiinit(medianProteiinit);
		ruokailuMedianModel.setMedianRasvat(medianRasvat);
		// Add to model
		model.addAttribute("ruokailuList", ruokailuList); // Tarvitaanko?
		model.addAttribute("username", username);
		model.addAttribute("ruokailuMedianModel", ruokailuMedianModel);
		return "index";
	}
	
	
	// Tallennetaan uusi ruokailu tietokantaan
	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public String saveRuokailu(
			@RequestParam(value="kuka", required=true) String nimi,
			@RequestParam(value="pvm", required=true) String pvm,
			@RequestParam(value="klo", required=true) String klo,
			@RequestParam(value="ruoka", required=true) String ruoka,
			@RequestParam(value="ruoanMaara", required=true) String ruoanMaara,
			@RequestParam(value="kalorit", required=true) String kalorit,
			@RequestParam(value="hiilarit", required=false) String hiilarit,
			@RequestParam(value="proteiinit", required=false) String proteiinit,
			@RequestParam(value="rasvat", required=false) String rasvat,
			Model model) {
		
		RuokailuDTO ruokailu = new RuokailuDTO();
		ruokailu.setNimi(nimi);
		
		SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Date parsed = null;
		try {
			parsed = format.parse(pvm);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        java.sql.Date sqldate = new java.sql.Date(parsed.getTime());
		ruokailu.setDate(sqldate);
		
		
		ruokailu.setKlo(klo);
		ruokailu.setRuoanNimi(ruoka);
		ruokailu.setRuoanMaara(Integer.parseInt(ruoanMaara));
		ruokailu.setKalorit(Integer.parseInt(kalorit));
		if (!hiilarit.isEmpty()) {
			ruokailu.setHiilihydraatit(Integer.parseInt(hiilarit));
		}
		if (!proteiinit.isEmpty()) {
			ruokailu.setProteiinit(Integer.parseInt(proteiinit));
		}
		if (!rasvat.isEmpty()) {
			ruokailu.setRasvat(Integer.parseInt(rasvat));
		}
		
		ruokailuService.create(ruokailu);
		
		model.addAttribute("save", "Success");
		return "index";
		
	}
	
	
	public int MedianAteriakoko(List<RuokailuDTO> ruokailuList) {
		int keskiarvo = 0;
		int jakaja = 0;
		
		for (int i = 0; i < ruokailuList.size(); i++) {
			keskiarvo += ruokailuList.get(i).getRuoanMaara();
			jakaja++;
		}
		if (jakaja != 0) {
			keskiarvo = keskiarvo / jakaja;
		}
		return keskiarvo;
	}
	
	
	public int medianHiilihydraatit(List<RuokailuDTO> ruokailuList) {
		int keskiarvo = 0;
		int jakaja = 0;
		
		for (int i = 0; i < ruokailuList.size(); i++) {
			if (ruokailuList.get(i).getHiilihydraatit() != 0 ) {
				keskiarvo += ruokailuList.get(i).getHiilihydraatit();
				jakaja++;
			}
		}
		if (jakaja != 0) {
			keskiarvo = keskiarvo / jakaja;
		}
		return keskiarvo;
	}
	
	
	public int medianProteiinit(List<RuokailuDTO> ruokailuList) {
		int keskiarvo = 0;
		int jakaja = 0;
		
		for (int i = 0; i < ruokailuList.size(); i++) {
			if (ruokailuList.get(i).getProteiinit() != 0 ) {
				keskiarvo += ruokailuList.get(i).getProteiinit();
				jakaja++;
			}
		}
		if (jakaja != 0) {
			keskiarvo = keskiarvo / jakaja;
		}
		return keskiarvo;
	}
	
	
	public int medianRasvat(List<RuokailuDTO> ruokailuList) {
		int keskiarvo = 0;
		int jakaja = 0;
		
		for (int i = 0; i < ruokailuList.size(); i++) {
			if (ruokailuList.get(i).getRasvat() != 0 ) {
				keskiarvo += ruokailuList.get(i).getRasvat();
				jakaja++;
			}
		}
		if (jakaja != 0) {
			keskiarvo = keskiarvo / jakaja;
		}
		return keskiarvo;
	}	
	

}