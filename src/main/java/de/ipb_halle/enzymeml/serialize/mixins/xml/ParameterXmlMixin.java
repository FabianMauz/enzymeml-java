package de.ipb_halle.enzymeml.serialize.mixins.xml;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import de.ipb_halle.enzymeml.model.UnitDefinition;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
@JsonPropertyOrder({"id", "name", "symbol", "value", "unit", "initial_value", "upper_bound", "lower_bound", "fit", "stderr", "constant"})
public interface ParameterXmlMixin {

    @JacksonXmlProperty(localName = "id")
    String getId();

    @JacksonXmlProperty(localName = "name")
    String getName();

    @JacksonXmlProperty(localName = "symbol")
    String getSymbol();

    @JacksonXmlProperty(localName = "value")
    Float getValue();

    @JacksonXmlProperty(localName = "unit")
    UnitDefinition getUnit();

    @JacksonXmlProperty(localName = "initial_value")
    Float getInitialValue();

    @JacksonXmlProperty(localName = "upper_bound")
    Float getUpperBound();

    @JacksonXmlProperty(localName = "lower_bound")
    Float getLowerBound();

    @JacksonXmlProperty(localName = "fit")
    Boolean getFit();

    @JacksonXmlProperty(localName = "stderr")
    Float getStderr();

    @JacksonXmlProperty(localName = "constant")
    Boolean isConstant();
}
