package de.ipb_halle.enzymeml.validate;

import de.ipb_halle.enzymeml.model.EnzymeMLDocument;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class Validator {

    private final List<ValidationException> errors = new ArrayList<>();
    private final CreatorValidator creatorValidator = new CreatorValidator();
    private final UniqueIdValidator uniqueIdValidator = new UniqueIdValidator();

    public List<ValidationException> validate(EnzymeMLDocument enzymeMLDoc) {
        errors.clear();
        creatorValidator.validate(enzymeMLDoc.getCreators(), errors);
        uniqueIdValidator.validate(enzymeMLDoc, errors);

        return errors;
    }
}
