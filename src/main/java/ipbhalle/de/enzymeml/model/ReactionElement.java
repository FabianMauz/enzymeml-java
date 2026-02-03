package ipbhalle.de.enzymeml.model;

/**
 * Definition of a ReactionElement.
 *
 * This object is part of the object and describes a species (SmallMolecule,
 * Protein, Complex) participating in the reaction. The stochiometry is of the
 * species is specified in the field, whereas negative values indicate that the
 * species is a reactant and positive values indicate that the species is a
 * product of the reaction.
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class ReactionElement {

    private String speciesId;
    private Float stoichiometry;
}
