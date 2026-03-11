package de.ipb_halle.enzymeml.validate;

import de.ipb_halle.enzymeml.model.EnzymeMLDocument;
import de.ipb_halle.enzymeml.model.Measurement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class Validator {

    private final CreatorValidator creatorValidator = new CreatorValidator();
    private final UniqueIdValidator uniqueIdValidator = new UniqueIdValidator();
    private final DataValidator dataValidator = new DataValidator();
    private final IdReferenceValidator referenceValidator = new IdReferenceValidator();

    public List<ValidationException> validate(EnzymeMLDocument enzymeMLDoc) {
        List<ValidationException> errors = new ArrayList<>();
        creatorValidator.validate(enzymeMLDoc.getCreators(), errors);
        uniqueIdValidator.validate(enzymeMLDoc, errors);
        referenceValidator.validate(enzymeMLDoc, errors);
        for (Measurement m : enzymeMLDoc.getMeasurements()) {
            dataValidator.validate(m, errors);
        }

        return errors;
    }
}
