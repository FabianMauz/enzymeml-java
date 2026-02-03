package ipbhalle.de.enzymeml.validate;

import ipbhalle.de.enzymeml.model.Creator;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class CreatorValidator {

    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final Pattern PATTERN = Pattern.compile(EMAIL_REGEX);

    public void validate(
            List<Creator> creators,
            List<ValidationException> errors) {
        int creatorCounter = 0;
        for (Creator creator : creators) {
            if (creator.getEmail() == null || !PATTERN.matcher(creator.getEmail()).matches()) {
                errors.add(new ValidationException("Email is invalid", "Creatornumber: " + creatorCounter));
            }
            creatorCounter++;
        }
    }
}
