package dao;

public class DaoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2545452232963083750L;
	public DaoException(){}
	public DaoException(String message){
		super(message);
	}
	public DaoException(String message,Throwable throwable){
		super(message,throwable);
	}
	public DaoException(Throwable throwable){
		super(throwable);
	}
	

}
