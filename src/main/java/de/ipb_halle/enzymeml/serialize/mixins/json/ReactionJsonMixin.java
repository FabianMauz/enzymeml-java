package de.ipb_halle.enzymeml.serialize.mixins.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.ipb_halle.enzymeml.model.Equation;
import de.ipb_halle.enzymeml.model.ModifierElement;
import de.ipb_halle.enzymeml.model.ReactionElement;
import de.ipb_halle.enzymeml.validate.ValidationException;
import java.util.List;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class ReactionJsonMixin {

    @JsonCreator
    public ReactionJsonMixin(
            @JsonProperty("id") String id,
            @JsonProperty("name") String name,
            @JsonProperty("reversible") boolean reversible) throws ValidationException {
    }

    @JsonProperty("kinetic_law")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Equation kineticLaw;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ReactionElement> reactants;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ReactionElement> products;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ModifierElement> modifiers;
}
