package ed.trabalho.exceptions;

/**
 * User is already mentioned by another user.
 */
public class UserIsAlreadyMentionedException extends Exception {

    public UserIsAlreadyMentionedException() {
        super();
    }

    public UserIsAlreadyMentionedException(String message) {
        super(message);
    }
}
