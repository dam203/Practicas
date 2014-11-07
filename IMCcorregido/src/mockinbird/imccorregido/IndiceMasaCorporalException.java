package mockinbird.imccorregido;

public class IndiceMasaCorporalException extends Exception {
	
	boolean errorPeso=false;
	boolean errorAltura=false;
	
	public IndiceMasaCorporalException(boolean errorPeso, boolean errorAltura){
		
		super();
		
		this.errorPeso=errorPeso;
		this.errorAltura=errorAltura;
		
	}

	/**
	 * @return the errorPeso
	 */
	public boolean isErrorPeso() {
		return errorPeso;
	}

	/**
	 * @return the errorAltura
	 */
	public boolean isErrorAltura() {
		return errorAltura;
	}

}
