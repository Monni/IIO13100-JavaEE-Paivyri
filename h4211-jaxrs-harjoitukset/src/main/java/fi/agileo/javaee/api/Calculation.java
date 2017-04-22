package fi.agileo.javaee.api;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Calculation.findAll", query = "SELECT c FROM Calculation c")
public class Calculation {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
    private String operation;
    private Integer left;
    private Integer right;
    private Integer result;
    
    public Calculation() {
    	super();
    }
    
    public Calculation(String operation, Integer left, Integer right) {
        super();
        this.operation = operation;
        this.left = left;
        this.right = right;
    }

    public String getOperation() {
        return operation;
    }
    
    public void setOperation(String operation) {
        this.operation = operation;
    }
    
    public Integer getLeft() {
        return left;
    }
    
    public void setLeft(Integer left) {
        this.left = left;
    }
    
    public Integer getRight() {
        return right;
    }
    
    public void setRight(Integer right) {
        this.right = right;
    }
    
    public Integer getResult() {
        return result;
    }
    
    public void setResult(Integer result) {
        this.result = result;
    }
    
}
