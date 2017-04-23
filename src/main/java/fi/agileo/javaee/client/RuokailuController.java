package fi.agileo.javaee.client;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fi.agileo.javaee.api.Ruokailu;


@Controller
public class RuokailuController {


	// TODO Tähän injektoidaan RuokailuService joka käyttää DAOta?
	//@Inject
	//private RuokailuDAO ruokailuDao;
	
	// Näytetään index
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		return "index";
	}
	
	// Näytetään index tietyn käyttäjän tiedoilla
	@RequestMapping(value ="/", method = RequestMethod.POST)
	public String indexWithUserData(@RequestParam(value="firstname", required=true) String username, Model model) {
		// TODO
		//model.addAttribute("ruokailu", ruokailuDao.findByUser(username));
		return "index";
	}
	
	
	

}