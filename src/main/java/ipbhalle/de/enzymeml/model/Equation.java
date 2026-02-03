package ipbhalle.de.enzymeml.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition of a Equation.
 *
 * The Equation object describes a mathematical equation used to model parts of
 * a reaction system.
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class Equation {

    private String speciesId;
    private String equation;
    private EquationType equationType;
    private List<Variable> variables = new ArrayList<>();
}
