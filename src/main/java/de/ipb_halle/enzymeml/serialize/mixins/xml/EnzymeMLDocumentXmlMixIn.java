package de.ipb_halle.enzymeml.serialize.mixins.xml;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import de.ipb_halle.enzymeml.model.Complex;
import de.ipb_halle.enzymeml.model.Creator;
import de.ipb_halle.enzymeml.model.Equation;
import de.ipb_halle.enzymeml.model.Measurement;
import de.ipb_halle.enzymeml.model.Parameter;
import de.ipb_halle.enzymeml.model.Protein;
import de.ipb_halle.enzymeml.model.Reaction;
import de.ipb_halle.enzymeml.model.SmallMolecule;
import de.ipb_halle.enzymeml.model.Vessel;
import java.util.List;

@JsonPropertyOrder({
    "name", "version", "description", "created", "modified", "creators",
    "vessels", "proteins", "complexes", "small_molecules", "reactions",
    "measurements", "equations", "parameters", "references"
})
public interface EnzymeMLDocumentXmlMixIn {

    @JacksonXmlProperty(localName = "name")
    String getName();

    @JacksonXmlProperty(localName = "version")
    String getVersion();

    @JacksonXmlProperty(localName = "description")
    String getDescription();

    @JacksonXmlProperty(localName = "created")
    String getCreated();

    @JacksonXmlProperty(localName = "modified")
    String getModified();

    @JsonProperty("creators")
    @JacksonXmlProperty(localName = "Creator")
    @JacksonXmlElementWrapper(localName = "creators")
    List<Creator> getCreators();

    @JsonProperty("vessels")
    @JacksonXmlProperty(localName = "Vessel")
    @JacksonXmlElementWrapper(localName = "vessels")
    List<Vessel> getVessels();

    @JsonProperty("proteins")
    @JacksonXmlProperty(localName = "Protein")
    @JacksonXmlElementWrapper(localName = "proteins")
    List<Protein> getProteins();

    @JsonProperty("complexes")
    @JacksonXmlProperty(localName = "Complex")
    @JacksonXmlElementWrapper(localName = "complexes")
    List<Complex> getComplexes();

    @JsonProperty("small_molecules")
    @JacksonXmlProperty(localName = "SmallMolecule")
    @JacksonXmlElementWrapper(localName = "small_molecules")
    List<SmallMolecule> getSmallMolecules();

    @JsonProperty("reactions")
    @JacksonXmlProperty(localName = "Reaction")
    @JacksonXmlElementWrapper(localName = "reactions")
    List<Reaction> getReactions();

    @JsonProperty("measurements")
    @JacksonXmlProperty(localName = "Measurement")
    @JacksonXmlElementWrapper(localName = "measurements")
    List<Measurement> getMeasurements();

    @JsonProperty("equations")
    @JacksonXmlProperty(localName = "Equation")
    @JacksonXmlElementWrapper(localName = "equations")
    List<Equation> getEquations();

    @JsonProperty("parameters")
    @JacksonXmlProperty(localName = "Parameter")
    @JacksonXmlElementWrapper(localName = "parameters")
    List<Parameter> getParameters();

    @JsonProperty("references")
    @JacksonXmlProperty(localName = "reference")
    @JacksonXmlElementWrapper(localName = "references")
    List<String> getReferences();
}
