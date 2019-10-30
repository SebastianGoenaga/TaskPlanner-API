package eci.exception;

public class TodoPlannerException extends Exception {

	private static final long serialVersionUID = 1L;
	public static final String NOT_FOUND = "El elemento no existe";
	public static final String USER_ALREADY_EXISTS = "Usuario ya existe";
	public static final String UNEXPECTED_ERROR = "Ha ocurrido un error inesperado";

	public TodoPlannerException(String message) {
		super(message);
	}

}