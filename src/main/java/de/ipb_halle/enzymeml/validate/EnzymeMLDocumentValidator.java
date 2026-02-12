package de.ipb_halle.enzymeml.validate;

import de.ipb_halle.enzymeml.model.EnzymeMLDocument;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Fabian Mauz
 */
public class EnzymeMLDocumentValidator {
    
    private Set<String> unitIds = new HashSet<>();
    private Set<String> speciesId = new HashSet<>();
    private EnzymeMLDocument document;
    
    public void validate(EnzymeMLDocument document) throws ValidationException {
        this.document = document;
    }
    
    private void checkForUniqueIds() throws ValidationException {
        for (String id : collectIdsOfPossibleSpecies()) {
            if (speciesId.contains(id)) {
                throw new ValidationException("ID: " + id + " already used");
            } else {
                speciesId.add(id);
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
