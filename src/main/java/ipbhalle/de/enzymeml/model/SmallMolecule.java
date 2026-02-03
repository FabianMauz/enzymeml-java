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

    private final String id;
    private final String name;
    private final boolean constant;
    private String vesselId;
    private String canonicalSmiles;
    private String inchi;
    private String inchiKey;
    private final List<String> synonmousNames = new ArrayList<>();
    private final List<String> references = new ArrayList<>();

    public SmallMolecule(String id, String name, boolean constant) {
        this.id = id;
        this.name = name;
        this.constant = constant;
    }

    public SmallMolecule setVesselId(String id) {
        this.vesselId = id;
        return this;
    }

    public SmallMolecule setSmiles(String smiles) {
        this.canonicalSmiles = smiles;
        return this;
    }

    public SmallMolecule setInchi(String inchi) {
        this.inchi = inchi;
        return this;
    }

    public SmallMolecule setInchiKey(String inchiKey) {
        this.inchiKey = inchiKey;
        return this;
    }

    public SmallMolecule addSynonym(String synonym) {
        this.synonmousNames.add(synonym);
        return this;
    }

    public SmallMolecule addReference(String reference) {
        this.references.add(reference);
        return this;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isConstant() {
        return constant;
    }

    public String getVesselId() {
        return vesselId;
    }

    public String getCanonicalSmiles() {
        return canonicalSmiles;
    }

    public String getInchi() {
        return inchi;
    }

    public String getInchiKey() {
        return inchiKey;
    }

    public List<String> getSynonmousNames() {
        return synonmousNames;
    }

    public List<String> getReferences() {
        return references;
    }

}
