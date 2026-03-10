package de.ipb_halle.enzymeml.validate;

import de.ipb_halle.enzymeml.model.EnzymeMLDocument;
import de.ipb_halle.enzymeml.model.Equation;
import de.ipb_halle.enzymeml.model.Measurement;
import de.ipb_halle.enzymeml.model.MeasurementData;
import java.util.List;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class IdReferenceValidator {

    UniqueIdValidator idValidator = new UniqueIdValidator();

    public void validate(EnzymeMLDocument doc, List<ValidationException> errors) {

        List<String> availableIds = idValidator.collectIds(doc);

        for (Measurement m : doc.getMeasurements()) {
            for (MeasurementData md : m.getSpeciesData()) {
                if (!availableIds.contains(md.getSpeciesId())) {
                    errors.add(new ValidationException("Reference-ID does not exist", md.getSpeciesId()));
                }
            }
        }
        for (Equation e : doc.getEquations()) {
            if (!availableIds.contains(e.getSpeciesId())) {
                errors.add(new ValidationException("Reference-ID does not exist", e.getSpeciesId()));
            }
        }
    }
}
