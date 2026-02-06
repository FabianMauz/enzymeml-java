package de.ipb_halle.enzymeml.model;

import de.ipb_halle.enzymeml.validate.ValidationException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class MeasurementDataTest {

    @Test
    public void MeasurementData_whenIdIsNull_throwsError() {
        ValidationException ex = assertThrows(ValidationException.class, ()
                -> {
            new MeasurementData(null);
        });
        assertEquals("SpeciesId of measurementData was null", ex.getReason());
    }

}
