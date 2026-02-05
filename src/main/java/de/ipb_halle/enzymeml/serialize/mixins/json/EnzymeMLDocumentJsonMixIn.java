package de.ipb_halle.enzymeml.serialize.mixins.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.ipb_halle.enzymeml.model.Complex;
import de.ipb_halle.enzymeml.model.Equation;
import de.ipb_halle.enzymeml.model.Measurement;
import de.ipb_halle.enzymeml.model.Protein;
import de.ipb_halle.enzymeml.model.Reaction;
import de.ipb_halle.enzymeml.model.SmallMolecule;
import java.lang.reflect.Parameter;
import java.util.List;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class EnzymeMLDocumentJsonMixIn {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String description;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String created;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String modified;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Protein> proteins;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Complex> complexes;

    @JsonProperty("small_molecules")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SmallMolecule> smallMolecules;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Reaction> reactions;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Measurement> measurements;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Equation> equations;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Parameter> parameters;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> references;
}
