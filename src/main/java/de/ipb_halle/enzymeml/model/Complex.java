package de.ipb_halle.enzymeml.model;

import de.ipb_halle.enzymeml.validate.ValidationException;
import java.util.ArrayList;
import java.util.List;

/**
 * Definition of a Complex.
 *
 * The Complex object allows the grouping of multiple species using their . This
 * enables the representation of protein-small molecule complexes (e.g.,
 * enzyme-substrate complexes) as well as buffer or solvent mixtures
 * (combinations of SmallMolecule species).
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class Complex {

    private final String id;
    private final String name;
    private final boolean constant;
    private String vesselId;
    private final List<String> participants = new ArrayList<>();

    public Complex(String id, String name, boolean constant) throws ValidationException {
        if (id == null) {
            throw new ValidationException("Id of complex was null");
        }

        if (name == null) {
            throw new ValidationException("Name of complex was null", "Complex " + id);
        }

        this.id = id;
        this.name = name;
        this.constant = constant;
    }

    public Complex addParticipant(String id) {
        this.participants.add(id);
        return this;
    }

    public Complex setVesselId(String vesselId) {
        this.vesselId = vesselId;
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

    public List<String> getParticipants() {
        return participants;
    }

}
