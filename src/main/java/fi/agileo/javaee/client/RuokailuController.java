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

import fi.agileo.javaee.api.Ruokailu;
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
		List<Ruokailu> ruokailuList = ruokailuService.findByUser(username);
		model.addAttribute("ruokailuList", ruokailuList);
		return "index";
	}
	
	// Tallennetaan 
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
		
		Ruokailu ruokailu = new Ruokailu();
		ruokailu.setNimi(nimi);
		
		SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Date parsed = null;
		try {
			parsed = format.parse(pvm);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        java.sql.Date sql = new java.sql.Date(parsed.getTime());
		ruokailu.setPvm(sql);
		
		
		ruokailu.setKlo(klo);
		ruokailu.setRuoanmaara(Integer.parseInt(ruoanMaara));
		ruokailu.setKalorit(Integer.parseInt(kalorit));
		if (!hiilarit.isEmpty()) {
			ruokailu.setHiilihydraatit(Integer.parseInt(hiilarit));
		}
		if (!proteiinit.isEmpty()) {
			ruokailu.setProteiini(Integer.parseInt(proteiinit));
		}
		if (!rasvat.isEmpty()) {
			ruokailu.setRasva(Integer.parseInt(rasvat));
		}
		
		ruokailuService.create(ruokailu);
		
		model.addAttribute("save", "Success");
		return "index";
		
	}
	
	

}