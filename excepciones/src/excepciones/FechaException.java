package excepciones;

public class FechaException extends RuntimeException {
	public FechaException() {
		super();
	}

	public FechaException(String message) {
		super(message);
	}

	public FechaException(String message, Throwable cause) {
		super(message,cause);
	}

	public FechaException(Throwable cause) {
		super(cause);
	}
}