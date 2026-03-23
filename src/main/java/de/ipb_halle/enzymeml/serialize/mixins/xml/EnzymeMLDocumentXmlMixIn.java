package de.ipb_halle.enzymeml.serialize.mixins.xml;

import com.fasterxml.jackson.annotation.JsonCreator;
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
    "vessels", "proteins", "complexes", "smallMolecules", "reactions",
    "measurements", "equations", "parameters", "references"
})
public abstract class EnzymeMLDocumentXmlMixIn {

    @JsonCreator
    public EnzymeMLDocumentXmlMixIn(
            @JsonProperty("version") String version,
            @JsonProperty("name") String name) {
    }

    @JacksonXmlProperty(localName = "name")
    abstract String getName();

    @JacksonXmlProperty(localName = "version")
    abstract String getVersion();

    @JacksonXmlProperty(localName = "description")
    abstract String getDescription();

    @JacksonXmlProperty(localName = "created")
    abstract String getCreated();

    @JacksonXmlProperty(localName = "modified")
    abstract String getModified();

    @JsonProperty("creators")
    @JacksonXmlProperty(localName = "Creator")
    @JacksonXmlElementWrapper(localName = "creators")
    abstract List<Creator> getCreators();

    @JsonProperty("vessels")
    @JacksonXmlProperty(localName = "Vessel")
    @JacksonXmlElementWrapper(localName = "vessels")
    abstract List<Vessel> getVessels();

    @JsonProperty("proteins")
    @JacksonXmlProperty(localName = "Protein")
    @JacksonXmlElementWrapper(localName = "proteins")
    abstract List<Protein> getProteins();

    @JsonProperty("complexes")
    @JacksonXmlProperty(localName = "Complex")
    @JacksonXmlElementWrapper(localName = "complexes")
    abstract List<Complex> getComplexes();

    @JacksonXmlProperty(localName = "SmallMolecule")
    @JacksonXmlElementWrapper(localName = "small_molecules")
    abstract List<SmallMolecule> getSmallMolecules();

    @JsonProperty("reactions")
    @JacksonXmlProperty(localName = "Reaction")
    @JacksonXmlElementWrapper(localName = "reactions")
    abstract List<Reaction> getReactions();

    @JsonProperty("measurements")
    @JacksonXmlProperty(localName = "Measurement")
    @JacksonXmlElementWrapper(localName = "measurements")
    abstract List<Measurement> getMeasurements();

    @JsonProperty("equations")
    @JacksonXmlProperty(localName = "Equation")
    @JacksonXmlElementWrapper(localName = "equations")
    abstract List<Equation> getEquations();

    @JsonProperty("parameters")
    @JacksonXmlProperty(localName = "Parameter")
    @JacksonXmlElementWrapper(localName = "parameters")
    abstract List<Parameter> getParameters();

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "references")
    abstract List<String> getReferences();
}
