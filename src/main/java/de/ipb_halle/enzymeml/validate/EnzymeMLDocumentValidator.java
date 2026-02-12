package de.ipb_halle.enzymeml.validate;

import de.ipb_halle.enzymeml.model.EnzymeMLDocument;
import de.ipb_halle.enzymeml.model.Measurement;
import de.ipb_halle.enzymeml.model.Parameter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Fabian Mauz
 */
public class EnzymeMLDocumentValidator {

    private final Set<String> speciesId = new HashSet<>();
    private final Set<String> measurementIds = new HashSet<>();
    private final Set<String> parameterIds = new HashSet<>();
    private final EnzymeMLDocument document;

    public EnzymeMLDocumentValidator(EnzymeMLDocument document) {
        this.document = document;
    }

    public void validate() throws ValidationException {
        checkForUniqueIds();
        checkForExistingIdsOfReactionElements();
    }

    private void checkForUniqueIds() throws ValidationException {
        for (String id : collectIdsOfPossibleSpecies()) {
            if (speciesId.contains(id)) {
                throw new ValidationException("ID: " + id + " already used");
            } else {
                speciesId.add(id);
            }
        }
        for (Measurement measurement : document.getMeasurements()) {
            if (measurementIds.contains(measurement.getId())) {
                throw new ValidationException("ID: " + measurement.getId() + " already used");
            } else {
                measurementIds.add(measurement.getId());
            }
        }
        for (Parameter parameter : document.getParameters()) {
            if (parameterIds.contains(parameter.getId())) {
                throw new ValidationException("ID: " + parameter.getId() + " already used");
            } else {
                parameterIds.add(parameter.getId());
            }
        }
    }

    private void checkForExistingIdsOfReactionElements() throws ValidationException {

    }

    private List<String> collectIdsOfPossibleSpecies() {
        List<String> ids = new ArrayList<>();
        ids.addAll(document.getComplexes().stream().map(c -> c.getId()).toList());
        ids.addAll(document.getProteins().stream().map(c -> c.getId()).toList());
        ids.addAll(document.getSmallMolecules().stream().map(c -> c.getId()).toList());

        return ids;
    }

}
