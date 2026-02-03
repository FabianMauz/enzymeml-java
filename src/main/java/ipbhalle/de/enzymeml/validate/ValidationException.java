package ipbhalle.de.enzymeml.validate;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class ValidationException extends Exception {

    private final String causeId;
    private final String reason;

    public ValidationException(String reason, String id) {
        this.causeId = id;
        this.reason = reason;
    }

    public String getCauseId() {
        return causeId;
    }

    public String getReason() {
        return reason;
    }
}
