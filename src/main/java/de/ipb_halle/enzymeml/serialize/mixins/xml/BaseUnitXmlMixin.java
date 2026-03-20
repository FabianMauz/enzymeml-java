package de.ipb_halle.enzymeml.serialize.mixins.xml;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import de.ipb_halle.enzymeml.model.UnitType;
import de.ipb_halle.enzymeml.validate.ValidationException;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
@JsonPropertyOrder({"kind", "exponent", "multiplier", "scale"})
public abstract class BaseUnitXmlMixin {

    @JsonCreator
    public BaseUnitXmlMixin(
            @JsonProperty("kind") UnitType kind,
            @JsonProperty("exponent") int exponent,
            @JsonProperty("multiplier") float multiplier,
            @JsonProperty("scale") float scale
    ) throws ValidationException {
    }

    @JacksonXmlProperty(isAttribute = true)
    abstract String getKind();

    @JacksonXmlProperty(isAttribute = true)
    abstract int getExponent();

    @JacksonXmlProperty(isAttribute = true)
    abstract float getMultiplier();

    @JacksonXmlProperty(isAttribute = true)
    abstract float getScale();
}
