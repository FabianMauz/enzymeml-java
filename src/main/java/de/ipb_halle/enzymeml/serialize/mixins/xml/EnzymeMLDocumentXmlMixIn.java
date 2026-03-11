package de.ipb_halle.enzymeml.serialize.mixins.xml;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import de.ipb_halle.enzymeml.model.Creator;
import de.ipb_halle.enzymeml.model.Protein;
import de.ipb_halle.enzymeml.model.Vessel;
import java.util.List;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
@JsonPropertyOrder({"name", "version", "description", "created", "modified", "creators",
    "vessels", "proteins", "complexes", "smallMolecules", "reactions", "measurements", "equations", "parameters",
    "references"})
public interface EnzymeMLDocumentXmlMixIn {

    @JacksonXmlElementWrapper(localName = "small_molecules")
    @JacksonXmlProperty(localName = "SmallMolecule")
    String getSmallMolecules();

    @JacksonXmlProperty(localName = "Creator")
    @JacksonXmlElementWrapper(localName = "creators")
    List<Creator> getCreators();

    @JacksonXmlProperty(localName = "Vessel")
    @JacksonXmlElementWrapper(localName = "vessels")
    List<Vessel> getVessels();

    @JacksonXmlProperty(localName = "Protein")
    @JacksonXmlElementWrapper(localName = "proteins")
    List<Protein> getProteins();

    @JacksonXmlProperty(localName = "Complex")
    @JacksonXmlElementWrapper(localName = "complexes")
    List<Protein> getComplexes();

}
