package de.ipb_halle.enzymeml.model;

import de.ipb_halle.enzymeml.validate.ValidationException;
import java.util.ArrayList;
import java.util.List;

/**
 * Definition of a Protein.
 *
 * The Protein object represents enzymes and other proteins involved in the
 * experiment.
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class Protein {

    private final String id;
    private final String name;
    private final boolean constant;

    private String sequence;
    private String vesselId;
    private String ecNumber;
    private String organism;
    private String organismTaxId;
    private final List<String> references = new ArrayList<>();

    public Protein(String id, String name, boolean constant) throws ValidationException {
        if (id == null) {
            throw new ValidationException("Id of protein was null");
        }
        if (name == null) {
            throw new ValidationException("Name of protein was null", "Protein " + id);
        }
        this.id = id;
        this.name = name;
        this.constant = constant;
    }

    public Protein addSequence(String sequence) {
        this.sequence = sequence;
        return this;
    }

    public Protein setVesselId(String vesselId) {
        this.vesselId = vesselId;
        return this;
    }

    public Protein setEcNumber(String ecNumber) {
        this.ecNumber = ecNumber;
        return this;
    }

    public Protein setOrganism(String organism) {
        this.organism = organism;
        return this;
    }

    public Protein setOrganismTaxonomyId(String taxoId) {
        this.organismTaxId = taxoId;
        return this;
    }

    public Protein addReference(String reference) {
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

    public String getSequence() {
        return sequence;
    }

    public String getVesselId() {
        return vesselId;
    }

    public String getEcNumber() {
        return ecNumber;
    }

    public String getOrganism() {
        return organism;
    }

    public String getOrganismTaxId() {
        return organismTaxId;
    }

    public List<String> getReferences() {
        return references;
    }

}
