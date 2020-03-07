package ncs_coffee_ygj.ui.exception;

@SuppressWarnings("serial")
public class InvalidCheckException extends RuntimeException {
	
	public InvalidCheckException() {
		super("입력되지 않은 정보가 있습니다.");
	}
	
	public InvalidCheckException(Throwable cause) {
		super("입력되지 않은 정보가 있습니다.", cause);
	}
}
