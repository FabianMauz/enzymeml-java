package de.ipb_halle.enzymeml.model;

import de.ipb_halle.enzymeml.validate.ValidationException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class ReactionElementTest {

    @Test
    public void ReactionElement_whenSpeciesIdIsNull_throwsError() {
        ValidationException ex = assertThrows(ValidationException.class, ()
                -> {
            new ReactionElement(null, 1);
        });
        assertEquals("SpeciesId of reaction element was null", ex.getReason());
    }

}
