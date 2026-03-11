package de.ipb_halle.enzymeml.serialize.mixins.xml;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.List;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
@JsonPropertyOrder({"id", "name", "constant", "vesselId", "canonicalSmiles",
    "inchi", "inchiKey", "synonmousNames", "references"})
public interface SmallMoleculeXmlMixin {

    @JacksonXmlProperty(localName = "inchikey")
    public String getInchiKey();

    @JacksonXmlProperty(localName = "vessel_id")
    public String getVesselId();

    @JacksonXmlProperty(localName = "canonical_smiles")
    public String getCanonicalSmiles();

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "synonymous_names")
    public List<String> getSynonmousNames();

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "references")
    public List<String> getReferences();

}
