package de.ipb_halle.enzymeml.serialize.mixins.xml;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import de.ipb_halle.enzymeml.validate.ValidationException;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
@JsonSerialize(using = ReactionXmlSerializer.class)
public abstract class ReactionXmlMixin {

    @JsonCreator
    public ReactionXmlMixin(
            @JsonProperty("id") String id,
            @JsonProperty("name") String name,
            @JsonProperty("reversible") boolean reversible) throws ValidationException {
    }

    @JacksonXmlProperty(localName = "kinetic_law")
    abstract public String getKineticLaw();
}
