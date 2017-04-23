package fi.turbotiimi.paivyri.service;

import java.util.List;

import fi.turbotiimi.paivyri.databaseManagement.RuokailuDTO;

public interface RuokailuService {
	List<RuokailuDTO> findAll();
	List<RuokailuDTO> findByID(String username);
	void create(RuokailuDTO ruokailu);
	void deleteAll(String username);
}
