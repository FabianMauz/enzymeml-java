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

    private String id;
    private String name;
    private boolean reversible;
    private Equation kineticLaw;
    private List<ReactionElement> reactants = new ArrayList<>();
    private List<ReactionElement> products = new ArrayList<>();
    private List<ModifierElement> modifiers = new ArrayList<>();

}
