package de.ipb_halle.enzymeml.serialize.mixins.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.ipb_halle.enzymeml.model.EquationType;
import de.ipb_halle.enzymeml.model.Variable;
import java.util.List;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class EquationJsonMixin {

    @JsonProperty("species_id")
    private String speciesId;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Variable> variables;

    @JsonProperty("equation_type")
    private EquationType equationType;
}
