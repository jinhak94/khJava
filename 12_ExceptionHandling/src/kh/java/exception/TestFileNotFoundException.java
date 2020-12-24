package kh.java.exception;

public class TestFileNotFoundException extends Exception{

	public TestFileNotFoundException() {
		super();
	}

	public TestFileNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public TestFileNotFoundException(String message) {
		super(message);
	}

	public TestFileNotFoundException(Throwable cause) {
		super(cause);
	}
	
}
