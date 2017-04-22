package fi.agileo.javaee.jaxrs;

public enum operationEnum {
	summa("+"),
	add("+"),
	erotus("-"),
	substract("-"),
	tulo("*"),
	multiply("*"),
	jako("/"),
	divide("/"),
	jakojaannos("%"),
	remainder("%");
	
	private String operation;
	
	operationEnum(String operation) {
		this.operation = operation;
	}
	
	public String operation() {
		return operation;
	}
	
}
