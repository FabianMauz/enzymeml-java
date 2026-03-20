package de.ipb_halle.enzymeml.serialize.mixins.xml;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import de.ipb_halle.enzymeml.validate.ValidationException;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
@JacksonXmlRootElement(localName = "ReactionElement")
public abstract class ReactionElementXmlMixin {

    @JsonCreator
    public ReactionElementXmlMixin(
            @JsonProperty("species_id") String speciesId,
            @JsonProperty("stoichiometry") float stoichiometry
    ) throws ValidationException {
    }

    @JacksonXmlProperty(localName = "species_id")
    abstract String getSpeciesId();

    @JacksonXmlProperty(localName = "stoichiometry")
    abstract double getStoichiometry();
}
