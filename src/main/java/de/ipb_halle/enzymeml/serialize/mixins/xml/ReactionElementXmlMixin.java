package de.ipb_halle.enzymeml.serialize.mixins.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
@JacksonXmlRootElement(localName = "ReactionElement")
public interface ReactionElementXmlMixin {

    @JacksonXmlProperty(localName = "species_id")
    String getSpeciesId();

    @JacksonXmlProperty(localName = "stoichiometry")
    double getStoichiometry();
}
