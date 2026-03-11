package de.ipb_halle.enzymeml.serialize.mixins.xml;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.List;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
@JsonPropertyOrder({"id", "name", "constant", "sequence", "vesselId", "ecnumber", "organism", "organismTaxId", "references"})
public interface ProteinXmlMixin {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "references")
    public List<String> getReferences();

    @JacksonXmlProperty(localName = "organism_tax_id")
    public String getOrganismTaxId();

    @JacksonXmlProperty(localName = "vessel_id")
    public String getVesselId();

    @JacksonXmlProperty(localName = "ecnumber")
    public String getEcNumber();
}
