package de.ipb_halle.enzymeml.serialize.mixins.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.ipb_halle.enzymeml.model.ModifierRole;
import de.ipb_halle.enzymeml.validate.ValidationException;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class ModifierElementJsonMixin {

    @JsonCreator
    public ModifierElementJsonMixin(
            @JsonProperty("species_id") String speciesId,
            @JsonProperty("role") ModifierRole role
    ) throws ValidationException {
    }

    @JsonProperty("species_id")
    private String speciesId;
}
