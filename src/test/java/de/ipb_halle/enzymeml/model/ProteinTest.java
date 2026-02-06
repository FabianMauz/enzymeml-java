package de.ipb_halle.enzymeml.model;

import de.ipb_halle.enzymeml.validate.ValidationException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class ProteinTest {

    @Test
    public void Protein_whenIdIsNull_throwsError() {
        ValidationException ex = assertThrows(ValidationException.class, ()
                -> {
            new Protein(null, "p-name", true);
        });
        assertEquals("Id of protein was null", ex.getReason());
    }

    @Test
    public void Protein_whenNameIsNull_throwsError() {
        ValidationException ex = assertThrows(ValidationException.class, ()
                -> {
            new Protein("p-1", null, true);
        });
        assertEquals("Name of protein was null", ex.getReason());
    }

}
