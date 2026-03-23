package de.ipb_halle.enzymeml.validate;

import de.ipb_halle.enzymeml.model.EnzymeMLDocument;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class UniqueIdValidator {

    public void validate(EnzymeMLDocument doc, List<ValidationException> errors) {
        List<String> ids = collectIds(doc);

        Set<String> itemsSeen = new HashSet<>();

        List<String> duplicates = ids.stream()
                .filter(s -> !itemsSeen.add(s)) // A set returns false if item is already in 
                .distinct()
                .collect(Collectors.toList());

        if (!duplicates.isEmpty()) {
            errors.add(new ValidationException("Duplicate IDs found", duplicates.stream().collect(Collectors.joining(","))));
        }
    }

    public List<String> collectIds(EnzymeMLDocument doc) {
        List<String> ids = new ArrayList<>();
        ids.addAll(doc.getComplexes().stream().map(c -> c.getId()).toList());
        ids.addAll(doc.getMeasurements().stream().map(m -> m.getId()).toList());
        ids.addAll(doc.getParameters().stream().map(p -> p.getId()).toList());
        ids.addAll(doc.getProteins().stream().map(p -> p.getId()).toList());
        ids.addAll(doc.getReactions().stream().map(r -> r.getId()).toList());
        ids.addAll(doc.getSmallMolecules().stream().map(sm -> sm.getId()).toList());
        ids.addAll(doc.getVessels().stream().map(v -> v.getId()).toList());
        return ids;
    }
}
