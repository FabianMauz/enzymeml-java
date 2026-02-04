package ipbhalle.de.enzymeml.model;

import ipbhalle.de.enzymeml.validate.ValidationException;
import java.util.ArrayList;
import java.util.List;

/**
 * Definition of a Reaction.
 *
 * The Reaction object represents a chemical or enzymatic reaction and holds the
 * different species and modifiers that are part of the reaction.
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class Reaction {

    private final String id;
    private final String name;
    private final boolean reversible;
    private Equation kineticLaw;
    private final List<ReactionElement> reactants = new ArrayList<>();
    private final List<ReactionElement> products = new ArrayList<>();
    private final List<ModifierElement> modifiers = new ArrayList<>();

    public Reaction(String id, String name, boolean reversible) throws ValidationException {
        if (id == null) {
            throw new ValidationException("Id of reaction was null");
        }
        if (name == null) {
            throw new ValidationException("Name of reaction was null", "Reaction " + id);
        }
        this.id = id;
        this.name = name;
        this.reversible = reversible;
    }

    public Reaction setKineticLaw(Equation equation) {
        this.kineticLaw = equation;
        return this;
    }

    public Reaction addReactant(ReactionElement element) {
        this.reactants.add(element);
        return this;
    }

    public Reaction addProduct(ReactionElement element) {
        this.products.add(element);
        return this;
    }

    public Reaction addModifier(ModifierElement element) {
        this.modifiers.add(element);
        return this;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isReversible() {
        return reversible;
    }

    public Equation getKineticLaw() {
        return kineticLaw;
    }

    public List<ReactionElement> getReactants() {
        return reactants;
    }

    public List<ReactionElement> getProducts() {
        return products;
    }

    public List<ModifierElement> getModifiers() {
        return modifiers;
    }

}
