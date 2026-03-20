package de.ipb_halle.enzymeml.serialize.mixins.xml;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import de.ipb_halle.enzymeml.model.ModifierRole;
import de.ipb_halle.enzymeml.validate.ValidationException;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
@JsonPropertyOrder({"speciesId", "role"})
public abstract class ModifierElementXmlMixin {

    @JsonCreator
    public ModifierElementXmlMixin(
            @JsonProperty("species_id") String speciesId,
            @JsonProperty("role") ModifierRole role
    ) throws ValidationException {
    }

    @JacksonXmlProperty(localName = "species_id")
    abstract String getSpeciesId();
}
