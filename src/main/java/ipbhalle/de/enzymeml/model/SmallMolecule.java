package ipbhalle.de.enzymeml.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition of a Small Molecule.
 *
 * The SmallMolecule object represents small chemical compounds that participate
 * in the experiment as substrates, products, or modifiers. It captures key
 * molecular identifiers like SMILES and InChI.
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class SmallMolecule {

    private String id;
    private String name;
    private boolean constant;
    private String vesselId;
    private String canonicalSmiles;
    private String inchi;
    private String inchiKey;
    private List<String> synonmousNames = new ArrayList<>();
    private List<String> references = new ArrayList<>();
}
