package de.ipb_halle.enzymeml.serialize.mixins.xml;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import de.ipb_halle.enzymeml.model.EquationType;
import de.ipb_halle.enzymeml.model.Variable;
import de.ipb_halle.enzymeml.validate.ValidationException;
import java.util.List;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
@JsonPropertyOrder({"speciesId", "equation", "equationType", "variables"})
public abstract class EquationXmlMixin {

    @JsonCreator
    public EquationXmlMixin(
            @JsonProperty("species_id") String speciesId,
            @JsonProperty("equation") String equation,
            @JsonProperty("equation_type") EquationType equationType) throws ValidationException {
    }

    @JacksonXmlProperty(localName = "species_id")
    abstract String getSpeciesId();

    @JacksonXmlProperty(localName = "equation_type")
    abstract String getEquationType();

    @JacksonXmlProperty(localName = "Variable")
    @JacksonXmlElementWrapper(localName = "variables")
    abstract List<Variable> getVariables();

}
