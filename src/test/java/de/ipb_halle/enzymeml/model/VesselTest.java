package de.ipb_halle.enzymeml.model;

import de.ipb_halle.enzymeml.tools.PredefinedUnits;
import de.ipb_halle.enzymeml.validate.ValidationException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class VesselTest {

    @Test
    public void Vessel_whenIdIsNull_throwsError() {
        ValidationException ex = assertThrows(ValidationException.class, ()
                -> {
            new Vessel(null, "vessel-name", 10f, PredefinedUnits.milligram(), true);
        });
        assertEquals("Id of vessel was null", ex.getReason());
    }

    @Test
    public void Vessel_whenNameIsNull_throwsError() {
        ValidationException ex = assertThrows(ValidationException.class, ()
                -> {
            new Vessel("v-1", null, 10f, PredefinedUnits.milligram(), true);
        });
        assertEquals("Name of vessel was null", ex.getReason());
    }

    @Test
    public void Vessel_whenUnitIsNull_throwsError() {
        ValidationException ex = assertThrows(ValidationException.class, ()
                -> {
            new Vessel("v-1", "v-name", 10f, null, true);
        });
        assertEquals("Unit of vessel was null", ex.getReason());
    }
}
