package fi.turbotiimi.paivyri.service;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import fi.turbotiimi.paivyri.databaseManagement.RuokailuDAO;
import fi.turbotiimi.paivyri.databaseManagement.RuokailuDTO;

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
