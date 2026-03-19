package de.ipb_halle.enzymeml.serialize.mixins.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.ipb_halle.enzymeml.model.UnitDefinition;
import de.ipb_halle.enzymeml.validate.ValidationException;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class VesselJsonMixin {

    @JsonCreator
    public VesselJsonMixin(
            @JsonProperty("id") String id,
            @JsonProperty("name") String name,
            @JsonProperty("volume") float volume,
            @JsonProperty("unit") UnitDefinition unit,
            @JsonProperty("constant") boolean constant) throws ValidationException {
    }
}
