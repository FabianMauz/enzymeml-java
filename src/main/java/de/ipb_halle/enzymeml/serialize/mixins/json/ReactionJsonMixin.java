package de.ipb_halle.enzymeml.serialize.mixins.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.ipb_halle.enzymeml.model.Equation;
import de.ipb_halle.enzymeml.model.ModifierElement;
import de.ipb_halle.enzymeml.model.ReactionElement;
import java.util.List;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class ReactionJsonMixin {

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
