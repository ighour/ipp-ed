package ed.trabalho.exceptions;

/**
 * User is already added.
 */
public class UserIsAlreadyAddedException extends Exception {

    public UserIsAlreadyAddedException() {
        super();
    }

    public UserIsAlreadyAddedException(String message) {
        super(message);
    }
}