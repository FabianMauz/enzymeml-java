package de.ipb_halle.enzymeml.model;

import de.ipb_halle.enzymeml.validate.ValidationException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class ReactionTest {

    @Test
    public void Reaction_whenIdIsNull_throwsError() {
        ValidationException ex = assertThrows(ValidationException.class, ()
                -> {
            new Reaction(null, "r-name", true);
        });
        assertEquals("Id of reaction was null", ex.getReason());
    }

    @Test
    public void Reaction_whenNameIsNull_throwsError() {
        ValidationException ex = assertThrows(ValidationException.class, ()
                -> {
            new Reaction("r-1", null, true);
        });
        assertEquals("Name of reaction was null", ex.getReason());
    }

}
