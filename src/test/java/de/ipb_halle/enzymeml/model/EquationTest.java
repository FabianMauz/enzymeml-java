package de.ipb_halle.enzymeml.model;

import de.ipb_halle.enzymeml.validate.ValidationException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class EquationTest {

    @Test
    public void Equation_whenSpeciedIdIsNull_throwsError() {
        ValidationException ex = assertThrows(ValidationException.class, ()
                -> {
            new Equation(null, "e=mc²", EquationType.ASSIGNMENT);
        });
        assertEquals("SpeciesId of equation was null", ex.getReason());
    }

    @Test
    public void Equation_whenEquationIsNull_throwsError() {
        ValidationException ex = assertThrows(ValidationException.class, ()
                -> {
            new Equation("s-1", null, EquationType.ASSIGNMENT);
        });
        assertEquals("EquationString of equation was null", ex.getReason());
    }

}
