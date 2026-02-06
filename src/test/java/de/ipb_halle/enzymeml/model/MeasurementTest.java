package de.ipb_halle.enzymeml.model;

import de.ipb_halle.enzymeml.validate.ValidationException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class MeasurementTest {

    @Test
    public void Measurement_whenIdIsNull_throwsError() {
        ValidationException ex = assertThrows(ValidationException.class, ()
                -> {
            new Measurement(null, "m-name");
        });
        assertEquals("Id of measurement was null", ex.getReason());
    }

    @Test
    public void Measurement_whenNameIsNull_throwsError() {
        ValidationException ex = assertThrows(ValidationException.class, ()
                -> {
            new Measurement("m-1", null);
        });
        assertEquals("Name of measurement was null", ex.getReason());
    }

}
