package de.ipb_halle.enzymeml.validate;

import de.ipb_halle.enzymeml.model.Measurement;
import de.ipb_halle.enzymeml.model.MeasurementData;
import java.util.List;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class DataValidator {

    private static final float EPSILON = 1e-6f;

    public void validate(Measurement measurement, List<ValidationException> errors) {
        for (MeasurementData md : measurement.getSpeciesData()) {
            if (!md.getData().isEmpty() && md.getInitial() != null) {
                if (Math.abs(md.getData().get(0) - md.getInitial()) > EPSILON) {
                    errors.add(new ValidationException(
                            "First data value and initial are not equal",
                            measurement.getId() + ":" + md.getSpeciesId()
                    ));
                }
            }
        }
    }
}
