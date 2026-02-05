package de.ipb_halle.enzymeml.factory;

import de.ipb_halle.enzymeml.model.SmallMolecule;
import de.ipb_halle.enzymeml.validate.ValidationException;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class SmallMoleculeFactory {

    public static SmallMolecule createSmallMolecule(String id, String vesselId) throws ValidationException {
        SmallMolecule sm = new SmallMolecule(id, id + "-name", true);
        sm.addReference("ref-1");
        sm.addReference("ref-2");
        sm.addSynonym("synonym-1");
        sm.setInchi("inchi");
        sm.setInchiKey("inchiKey");
        sm.setSmiles("smiles");
        sm.setVesselId(vesselId);
        return sm;
    }
}
