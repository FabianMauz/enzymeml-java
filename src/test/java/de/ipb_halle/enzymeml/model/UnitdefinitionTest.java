package de.ipb_halle.enzymeml.model;

import de.ipb_halle.enzymeml.validate.ValidationException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class UnitDefinitionTest {

    @Test
    public void UnitDefinition_whenIdIsNull_throwsError() {
        ValidationException ex = assertThrows(ValidationException.class, ()
                -> {
            new UnitDefinition(null, "kilogram");
        });
        assertEquals("Id of unit definition was null", ex.getReason());
    }

    @Test
    public void UnitDefinition_whenNameIsNull_throwsError() {
        ValidationException ex = assertThrows(ValidationException.class, ()
                -> {
            new UnitDefinition("kg", null);
        });
        assertEquals("Name of unit definition was null", ex.getReason());
    }

}
