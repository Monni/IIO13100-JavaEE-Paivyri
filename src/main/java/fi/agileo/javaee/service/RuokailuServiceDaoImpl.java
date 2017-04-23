package fi.agileo.javaee.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import fi.agileo.javaee.api.Ruokailu;
import fi.agileo.javaee.databaseManagement.RuokailuDAO;

@Service
@Primary
public class RuokailuServiceDaoImpl implements RuokailuService {

	//@Inject
	RuokailuDAO ruokailuDao;
/*
	public List<Ruokailu> findAll() {
		return this.ruokailuDao.findAll();
	}

	public List<Ruokailu> findByUser(String username) {
		return this.ruokailuDao.findByUser(username);
	}

	public Ruokailu create(Ruokailu ruokailu) {
		return this.ruokailuDao.save(ruokailu);
	}

	public Ruokailu deleteAll(String username) {
		return this.ruokailuDao.delete(id);
	}
*/

	public List<Ruokailu> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Ruokailu> findByUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public Ruokailu create(Ruokailu ruokailu) {
		// TODO Auto-generated method stub
		return null;
	}

	public Ruokailu deleteAll(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
