package ipbhalle.de.enzymeml.model;

import ipbhalle.de.enzymeml.validate.ValidationException;
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

    private final String speciesId;
    private final String equation;
    private final EquationType equationType;
    private final List<Variable> variables = new ArrayList<>();

    public Equation(String speciesId, String equation, EquationType equationType) throws ValidationException {
        if (speciesId == null) {
            throw new ValidationException("SpeciesId of equation was null");
        }
        if (equation == null) {
            throw new ValidationException("EquationString of equation was null", "Equation of speciesId " + speciesId);
        }
        this.speciesId = speciesId;
        this.equation = equation;
        this.equationType = equationType;
    }

    public Equation addVariable(Variable var) {
        this.variables.add(var);
        return this;
    }

    public String getSpeciesId() {
        return speciesId;
    }

    public String getEquation() {
        return equation;
    }

    public EquationType getEquationType() {
        return equationType;
    }

    public List<Variable> getVariables() {
        return variables;
    }

}
