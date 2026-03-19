package de.ipb_halle.enzymeml.serialize.mixins.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import de.ipb_halle.enzymeml.model.EquationType;
import de.ipb_halle.enzymeml.model.Variable;
import de.ipb_halle.enzymeml.validate.ValidationException;
import java.util.List;

public abstract class EquationJsonMixin {

    @JsonCreator
    public EquationJsonMixin(
            @JsonProperty("species_id") String speciesId,
            @JsonProperty("equation") String equation,
            @JsonProperty("equation_type") EquationType equationType) throws ValidationException {
    }

    @JsonProperty("species_id")
    abstract String getSpeciesId();

    @JsonProperty("equation")
    abstract String getEquation();

    @JsonProperty("equation_type")
    abstract EquationType getEquationType();

    @JsonProperty("variables")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    abstract List<Variable> getVariables();
}
