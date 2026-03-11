package de.ipb_halle.enzymeml.serialize.mixins.xml;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
@JsonPropertyOrder({"kind", "exponent", "multiplier", "scale"})
public interface BaseUnitXmlMixin {

    @JacksonXmlProperty(isAttribute = true)
    String getKind();

    @JacksonXmlProperty(isAttribute = true)
    String getExponent();

    @JacksonXmlProperty(isAttribute = true)
    String getMultiplier();

    @JacksonXmlProperty(isAttribute = true)
    String getScale();
}
