package de.ipb_halle.enzymeml.serialize.mixins.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.ipb_halle.enzymeml.model.UnitType;
import de.ipb_halle.enzymeml.validate.ValidationException;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class BaseUnitJsonMixin {

    @JsonCreator
    public BaseUnitJsonMixin(
            @JsonProperty("kind") UnitType kind,
            @JsonProperty("exponent") int exponent,
            @JsonProperty("multiplier") float multiplier,
            @JsonProperty("scale") float scale
    ) throws ValidationException {
    }
}
