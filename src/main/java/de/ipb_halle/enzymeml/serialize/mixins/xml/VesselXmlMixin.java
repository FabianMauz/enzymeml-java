package de.ipb_halle.enzymeml.serialize.mixins.xml;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import de.ipb_halle.enzymeml.model.UnitDefinition;
import de.ipb_halle.enzymeml.validate.ValidationException;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
@JsonPropertyOrder({"id", "name", "volume", "unit", "constant"})
public abstract class VesselXmlMixin {

    @JsonCreator
    public VesselXmlMixin(
            @JsonProperty("id") String id,
            @JsonProperty("name") String name,
            @JsonProperty("volume") float volume,
            @JsonProperty("unit") UnitDefinition unit,
            @JsonProperty("constant") boolean constant) throws ValidationException {
    }
}
