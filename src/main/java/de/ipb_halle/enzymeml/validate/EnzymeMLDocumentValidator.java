package de.ipb_halle.enzymeml.validate;

import de.ipb_halle.enzymeml.model.EnzymeMLDocument;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Fabian Mauz
 */
public class EnzymeMLDocumentValidator {

    private Set<String> unitIds = new HashSet<>();
    private Set<String> speciesId = new HashSet<>();

    public void validate(EnzymeMLDocument document) throws ValidationException {

    }

    private void checkForUniqueIds() throws ValidationException {

    }

    private void checkForExistingIdsOfReactionElements() throws ValidationException {

    }

    private void collectIds() {

    }
}
