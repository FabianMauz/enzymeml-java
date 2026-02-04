package ipbhalle.de.enzymeml.validate;

import ipbhalle.de.enzymeml.model.EnzymeMLDocument;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class Validator {

    private List<ValidationException> errors = new ArrayList<>();
    private CreatorValidator creatorValidator = new CreatorValidator();

    public List<ValidationException> validate(EnzymeMLDocument enzymeMLDoc) {
        
        //Version check mit regex auf x.y
        errors.clear();
        creatorValidator.validate(enzymeMLDoc.getCreators(), errors);

        return errors;
    }
}
