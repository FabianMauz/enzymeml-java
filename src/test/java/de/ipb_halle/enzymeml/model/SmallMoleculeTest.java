package de.ipb_halle.enzymeml.model;

import de.ipb_halle.enzymeml.validate.ValidationException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class SmallMoleculeTest {

    @Test
    public void SmallMolecule_whenIdIsNull_throwsError() {
        ValidationException ex = assertThrows(ValidationException.class, ()
                -> {
            new SmallMolecule(null, "v-name", true);
        });
        assertEquals("Id of small molecule was null", ex.getReason());
    }

    @Test
    public void SmallMolecule_whenNameIsNull_throwsError() {
        ValidationException ex = assertThrows(ValidationException.class, ()
                -> {
            new SmallMolecule("sm-1", null, true);
        });
        assertEquals("Name of small molecule was null", ex.getReason());
    }

}
