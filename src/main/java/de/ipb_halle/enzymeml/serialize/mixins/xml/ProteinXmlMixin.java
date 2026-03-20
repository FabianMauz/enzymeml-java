package de.ipb_halle.enzymeml.serialize.mixins.xml;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import de.ipb_halle.enzymeml.validate.ValidationException;
import java.util.List;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
@JsonPropertyOrder({"id", "name", "constant", "sequence", "vesselId", "ecnumber", "organism", "organismTaxId", "references"})
public abstract class ProteinXmlMixin {

    @JsonCreator
    public ProteinXmlMixin(
            @JsonProperty("id") String id,
            @JsonProperty("name") String name,
            @JsonProperty("constant") boolean constant
    ) throws ValidationException {
    }

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "references")
    abstract public List<String> getReferences();

    @JacksonXmlProperty(localName = "organism_tax_id")
    abstract public String getOrganismTaxId();

    @JacksonXmlProperty(localName = "vessel_id")
    abstract public String getVesselId();

    @JacksonXmlProperty(localName = "ecnumber")
    abstract public String getEcNumber();
}
