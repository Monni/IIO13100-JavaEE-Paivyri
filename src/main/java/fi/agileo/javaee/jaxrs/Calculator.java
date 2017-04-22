package fi.agileo.javaee.jaxrs;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



@Path("/calculator")
public class Calculator {
	// Luodaan entitymanageri
	private EntityManagerFactory tehdas;
	private EntityManager manageri;; 
	private EntityTransaction transaktio;
	/*
	public Calculator() {
		this.tehdas = Persistence.createEntityManagerFactory("Ruokailu");
		this.manageri = tehdas.createEntityManager(); 
		this.transaktio = manageri.getTransaction();
	}

	@GET
	@Path("/calc/{op}/{left}/{right}")
	@Produces(MediaType.APPLICATION_JSON)
	// String op
	public Calculation calculate(@PathParam("op") String op,
			@PathParam("left") Integer left, @PathParam("right") Integer right) throws NegativeValueException, DivideByZeroException {
		Calculation result = new Calculation();
		String operation = operationEnum.valueOf(op).operation();
		result.setOperation(operation);
		result.setLeft(left);
		result.setRight(right);
		return doCalc(result);
	}

	@POST
	@Path("/calcform")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Calculation calculate(Calculation calc) throws NegativeValueException, DivideByZeroException {
		return doCalc(calc);
	}

	private Calculation doCalc(Calculation c) throws NegativeValueException, DivideByZeroException {	  
		transaktio.begin(); 
		
		String op = c.getOperation();
		int left = c.getLeft();
		int right = c.getRight();
		
		if (left < 0 || right < 0) {
			throw new NegativeValueException("Kumpikaan luvuista ei saa olla negatiivinen!");
		} else if (op.equalsIgnoreCase("/") && right == 0) {
			throw new DivideByZeroException("Ei saa jakaa nollalla!");
		} else {
			if (op.equalsIgnoreCase("-")) {
				c.setResult(left - right);
			} else if (op.equalsIgnoreCase("*")) {
				c.setResult(left * right);
			} else if (op.equalsIgnoreCase("/")) {
				c.setResult(left / right);
			} else if (op.equalsIgnoreCase("+")) {
				c.setResult(left + right);
			} else {
				c.setResult(left % right);
			}
		}
		// Tallennetaan tietokantaan
		manageri.persist(c);
		transaktio.commit();
		
		return c;
	}*/

}
