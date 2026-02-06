package de.ipb_halle.enzymeml.factory;

import de.ipb_halle.enzymeml.model.Equation;
import de.ipb_halle.enzymeml.model.EquationType;
import de.ipb_halle.enzymeml.model.ModifierElement;
import de.ipb_halle.enzymeml.model.ModifierRole;
import de.ipb_halle.enzymeml.model.Reaction;
import de.ipb_halle.enzymeml.model.ReactionElement;
import de.ipb_halle.enzymeml.model.Variable;
import de.ipb_halle.enzymeml.validate.ValidationException;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class ReactionFactory {

    public static Reaction createReaction(String id, String substrateId, String productId, String modifierId) throws ValidationException {
        Reaction reaction = new Reaction(id, "reaction-name-" + id, true);
        reaction.addModifier(new ModifierElement(modifierId, ModifierRole.SOLVENT));
        reaction.addReactant(new ReactionElement(substrateId, -1));
        reaction.addProduct(new ReactionElement(productId, 1));

        Equation equation = new Equation(productId, "k * substrateId", EquationType.RATE_LAW);
        equation.addVariable(new Variable("var-1", "description of k", "k"));
        
        
        reaction.setKineticLaw(equation);

        return reaction;
    }
}
