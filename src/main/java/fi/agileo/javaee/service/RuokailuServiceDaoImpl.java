package fi.agileo.javaee.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import fi.agileo.javaee.api.Ruokailu;
import fi.agileo.javaee.databaseManagement.RuokailuDAO;
import fi.agileo.javaee.databaseManagement.RuokailuDTO;

@Service
@Primary
public class RuokailuServiceDaoImpl implements RuokailuService {

	RuokailuDAO ruokailuDao = new RuokailuDAO();

	public List<RuokailuDTO> findAll() {
		return this.ruokailuDao.findAll();
	}
	
	public List<RuokailuDTO> findByID(String username) {
		return this.ruokailuDao.findByID(username);
	}

	public void create(RuokailuDTO ruokailu) {
		this.ruokailuDao.save(ruokailu);
	}

	public void deleteAll(String username) {
		this.ruokailuDao.deleteAll(username);
	}


	
}
