package de.ipb_halle.enzymeml.model;

import de.ipb_halle.enzymeml.validate.ValidationException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class VariableTest {

    @Test
    public void Variable_whenIdIsNull_throwsError() {
        ValidationException ex = assertThrows(ValidationException.class, ()
                -> {
            new Variable(null, "v-name", "V");
        });
        assertEquals("Id of variable was null", ex.getReason());
    }

    @Test
    public void Variable_whenNameIsNull_throwsError() {
        ValidationException ex = assertThrows(ValidationException.class, ()
                -> {
            new Variable("v-id", null, "V");
        });
        assertEquals("Name of variable was null", ex.getReason());
    }

    @Test
    public void Variable_whenSymbolIsNull_throwsError() {
        ValidationException ex = assertThrows(ValidationException.class, ()
                -> {
            new Variable("v-id", "v-name", null);
        });
        assertEquals("Symbol of variable was null", ex.getReason());
    }
}
