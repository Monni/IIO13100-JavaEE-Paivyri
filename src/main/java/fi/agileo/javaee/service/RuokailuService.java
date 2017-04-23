package fi.agileo.javaee.service;

import java.util.List;

import fi.agileo.javaee.api.Ruokailu;
import fi.agileo.javaee.databaseManagement.RuokailuDTO;

public interface RuokailuService {
	List<RuokailuDTO> findAll();
	List<RuokailuDTO> findByID(String username);
	void create(RuokailuDTO ruokailu);
	void deleteAll(String username);
}
