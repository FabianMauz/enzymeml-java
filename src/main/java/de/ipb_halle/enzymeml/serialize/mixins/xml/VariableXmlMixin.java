package de.ipb_halle.enzymeml.serialize.mixins.xml;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.ipb_halle.enzymeml.validate.ValidationException;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public abstract class VariableXmlMixin {

    @JsonCreator
    public VariableXmlMixin(
            @JsonProperty("id") String id,
            @JsonProperty("name") String name,
            @JsonProperty("symbol") String symbol
    ) throws ValidationException {
    }
}
