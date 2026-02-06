package de.ipb_halle.enzymeml.model;

import de.ipb_halle.enzymeml.validate.ValidationException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class CreatorTest {

    @Test
    public void Creator_whenGivenNameIsNull_throwsError() {
        ValidationException ex = assertThrows(ValidationException.class, ()
                -> {
            new Creator(null, "f-name", "email");
        });
        assertEquals("Given name was null", ex.getReason());
    }

    @Test
    public void Creator_whenFamilyNameIsNull_throwsError() {
        ValidationException ex = assertThrows(ValidationException.class, ()
                -> {
            new Creator("g-name", null, "email");
        });
        assertEquals("Family name was null", ex.getReason());
    }

    @Test
    public void Creator_whenEmailIsNull_throwsError() {
        ValidationException ex = assertThrows(ValidationException.class, ()
                -> {
            new Creator("g-name", "f-name", null);
        });
        assertEquals("Email was null", ex.getReason());
    }

}
