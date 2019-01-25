package ed.trabalho.exceptions;

/**
 * User is already a contact of another user.
 */
public class UserIsAlreadyAContactException extends Exception {

    public UserIsAlreadyAContactException() {
        super();
    }

    public UserIsAlreadyAContactException(String message) {
        super(message);
    }
}
