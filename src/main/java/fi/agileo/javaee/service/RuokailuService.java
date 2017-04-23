package fi.agileo.javaee.service;

import java.util.List;

import fi.agileo.javaee.api.Ruokailu;

public interface RuokailuService {
	List<Ruokailu> findAll();
	List<Ruokailu> findByUser(String username);
	Ruokailu create(Ruokailu ruokailu);
	Ruokailu edit(Ruokailu ruokailu);
	Ruokailu deleteById(int id);

}
