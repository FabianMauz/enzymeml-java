package de.ipb_halle.enzymeml.model;

import de.ipb_halle.enzymeml.validate.ValidationException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class ComplexTest {

    @Test
    public void Complex_whenIdIsNull_throwsError() {
        ValidationException ex = assertThrows(ValidationException.class, ()
                -> {
            new Complex(null, "complex-name", false);
        });
        assertEquals("Id of complex was null", ex.getReason());
    }

    @Test
    public void Complex_whenNameIsNull_throwsError() {
        ValidationException ex = assertThrows(ValidationException.class, ()
                -> {
            new Complex("c-1", null, false);
        });
        assertEquals("Name of complex was null", ex.getReason());
        assertEquals("Complex c-1", ex.getCauseId());
    }

}
