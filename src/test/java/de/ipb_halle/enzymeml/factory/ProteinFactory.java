package de.ipb_halle.enzymeml.factory;

import de.ipb_halle.enzymeml.model.Protein;
import de.ipb_halle.enzymeml.validate.ValidationException;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class ProteinFactory {

    public static Protein createNewProtein(String id, String vesselId) throws ValidationException {
        Protein p1 = new Protein(id, "proteinname-" + id, true);
        p1.addReference("reference-001");
        p1.addReference("reference-002");
        p1.addSequence("Test-Sequence");
        p1.setVesselId(vesselId);
        p1.setOrganism("test-organism");
        p1.setOrganismTaxonomyId("123");
        p1.setEcNumber("1.1.1.1");
        return p1;
    }
}
