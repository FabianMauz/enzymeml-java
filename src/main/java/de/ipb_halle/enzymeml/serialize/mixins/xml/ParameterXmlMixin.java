package de.ipb_halle.enzymeml.serialize.mixins.xml;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import de.ipb_halle.enzymeml.model.UnitDefinition;
import de.ipb_halle.enzymeml.validate.ValidationException;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
@JsonPropertyOrder({"id", "name", "symbol", "value", "unit", "initial_value", "upper_bound", "lower_bound", "fit", "stderr", "constant"})
public abstract class ParameterXmlMixin {

    @JsonCreator
    public ParameterXmlMixin(
            @JsonProperty("id") String id,
            @JsonProperty("name") String name,
            @JsonProperty("symbol") String symbol) throws ValidationException {
    }

    @JacksonXmlProperty(localName = "id")
    abstract String getId();

    @JacksonXmlProperty(localName = "name")
    abstract String getName();

    @JacksonXmlProperty(localName = "symbol")
    abstract String getSymbol();

    @JacksonXmlProperty(localName = "value")
    abstract Float getValue();

    @JacksonXmlProperty(localName = "unit")
    abstract UnitDefinition getUnit();

    @JacksonXmlProperty(localName = "initial_value")
    abstract Float getInitialValue();

    @JacksonXmlProperty(localName = "upper_bound")
    abstract Float getUpperBound();

    @JacksonXmlProperty(localName = "lower_bound")
    abstract Float getLowerBound();

    @JacksonXmlProperty(localName = "fit")
    abstract Boolean getFit();

    @JacksonXmlProperty(localName = "stderr")
    abstract Float getStderr();

    @JacksonXmlProperty(localName = "constant")
    abstract Boolean isConstant();
}
