package de.ipb_halle.enzymeml.serialize.mixins.xml;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import de.ipb_halle.enzymeml.model.ModifierElement;
import de.ipb_halle.enzymeml.model.ReactionElement;
import java.util.List;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public interface ReactionXmlMixin {

    @JacksonXmlProperty(localName = "ReactionElement")
    @JsonProperty("reactantsList") // Unique ID 1
    @JacksonXmlElementWrapper(localName = "reactants") // Outer tag  
    List<ReactionElement> getReactants();

    @JacksonXmlElementWrapper(localName = "products") // Outer tag
    @JsonProperty("productsList") // Unique ID 1
    @JacksonXmlProperty(localName = "ReactionElement")
    List<ReactionElement> getProducts();

    @JsonProperty("modifiers") // Logical name for Jackson
    @JacksonXmlElementWrapper(localName = "modifiers") // Outer tag
    @JacksonXmlProperty(localName = "ModifierElement") // Inner tag
    List<ModifierElement> getModifiers();
}
