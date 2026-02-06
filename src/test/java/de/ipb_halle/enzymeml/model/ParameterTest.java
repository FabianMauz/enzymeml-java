package de.ipb_halle.enzymeml.model;

import de.ipb_halle.enzymeml.validate.ValidationException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class ParameterTest {

    @Test
    public void Paramter_whenIdIsNull_throwsError() {
        ValidationException ex = assertThrows(ValidationException.class, ()
                -> {
            new Parameter(null, "p-name", "µ");
        });
        assertEquals("Id of parameter was null", ex.getReason());
    }

    @Test
    public void Paramter_whenNameIsNull_throwsError() {
        ValidationException ex = assertThrows(ValidationException.class, ()
                -> {
            new Parameter("p-id", null, "µ");
        });
        assertEquals("Name of parameter was null", ex.getReason());
    }

    @Test
    public void Paramter_whenSymbolIsNull_throwsError() {
        ValidationException ex = assertThrows(ValidationException.class, ()
                -> {
            new Parameter("p-id", "p-name", null);
        });
        assertEquals("Symbol of parameter was null", ex.getReason());
    }
}
