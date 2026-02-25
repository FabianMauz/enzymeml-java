package de.ipb_halle.enzymeml.serialize.mixins.xml;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
@JsonPropertyOrder({ "name", "version", "description", "created", "modified", "creators",
        "vessels", "proteins", "complexes", "smallMolecules", "reactions", "measurements", "equations", "parameters",
        "references" })
public interface EnzymeMLDocumentXmlMixIn {
    @JacksonXmlProperty(localName = "small_molecules")
    String getSmallMolecules();

}
