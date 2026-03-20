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
@JsonPropertyOrder({"id", "name", "constant", "vesselId", "canonicalSmiles",
    "inchi", "inchiKey", "synonmousNames", "references"})
public abstract class SmallMoleculeXmlMixin {

    @JsonCreator
    public SmallMoleculeXmlMixin(
            @JsonProperty("id") String id,
            @JsonProperty("name") String name,
            @JsonProperty("constant") boolean constant) throws ValidationException {
    }

    @JacksonXmlProperty(localName = "inchikey")
    abstract public String getInchiKey();

    @JacksonXmlProperty(localName = "vessel_id")
    abstract public String getVesselId();

    @JacksonXmlProperty(localName = "canonical_smiles")
    abstract public String getCanonicalSmiles();

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "synonymous_names")
    abstract public List<String> getSynonmousNames();

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "references")
    abstract public List<String> getReferences();

}
