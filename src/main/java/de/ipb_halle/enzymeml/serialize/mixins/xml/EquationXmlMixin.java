package de.ipb_halle.enzymeml.serialize.mixins.xml;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import de.ipb_halle.enzymeml.model.Variable;
import java.util.List;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
@JsonPropertyOrder({"speciesId", "equation", "equationType", "variables"})
public interface EquationXmlMixin {

    @JacksonXmlProperty(localName = "species_id")
    String getSpeciesId();

    @JacksonXmlProperty(localName = "equation_type")
    String getEquationType();

    @JacksonXmlProperty(localName = "Variable")
    @JacksonXmlElementWrapper(localName = "variables")
    List<Variable> getVariables();

}
