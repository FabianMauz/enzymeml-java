package ipbhalle.de.enzymeml.model;

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
    private List<ReactionElement> reactants = new ArrayList<>();
    private List<ReactionElement> products = new ArrayList<>();
    private List<ModifierElement> modifiers = new ArrayList<>();

    public Reaction(String id, String name, boolean reversible) {
        this.id = id;
        this.name = name;
        this.reversible = reversible;
    }
}
