package ipbhalle.de.enzymeml.serialize.mixins.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import ipbhalle.de.enzymeml.model.Complex;
import ipbhalle.de.enzymeml.model.Equation;
import ipbhalle.de.enzymeml.model.Measurement;
import ipbhalle.de.enzymeml.model.Protein;
import ipbhalle.de.enzymeml.model.Reaction;
import ipbhalle.de.enzymeml.model.SmallMolecule;
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
