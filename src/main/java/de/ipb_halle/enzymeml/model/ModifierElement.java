package de.ipb_halle.enzymeml.model;

import de.ipb_halle.enzymeml.validate.ValidationException;

/**
 * Definition of a ModifierElement.
 *
 * The ModifierElement object represents a species that is not part of the
 * reaction but influences it.
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class ModifierElement {

    private final String speciesId;
    private final ModifierRole role;

    public ModifierElement(String speciesId, ModifierRole role) throws ValidationException {
        if (speciesId == null) {
            throw new ValidationException("SpeciesId of modifier element was null");
        }
        this.speciesId = speciesId;
        this.role = role;
    }

    public String getSpeciesId() {
        return speciesId;
    }

    public ModifierRole getRole() {
        return role;
    }

}
