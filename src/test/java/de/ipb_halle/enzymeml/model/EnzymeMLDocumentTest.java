package de.ipb_halle.enzymeml.model;

import de.ipb_halle.enzymeml.validate.ValidationException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class EnzymeMLDocumentTest {

    @Test
    public void EnzymeMLDocument_whenVersionIsNull_throwsError() {

        ValidationException ex = assertThrows(ValidationException.class, ()
                -> {
            new EnzymeMLDocument(null, "example-document");
        });
        assertEquals("Version was null", ex.getReason());
    }

    @Test
    public void EnzymeMLDocument_whenNameIsNull_throwsError() {

        ValidationException ex = assertThrows(ValidationException.class, ()
                -> {
            new EnzymeMLDocument("1.0", null);
        });
        assertEquals("Name was null", ex.getReason());
    }
}
