package de.ipb_halle.enzymeml.model;

import de.ipb_halle.enzymeml.validate.ValidationException;

/**
 * Definition of a Variable.
 *
 * This object describes a variable that is part of an equation. Variables can
 * represent species concentrations, time, or other quantities that appear in
 * mathematical expressions. Each variable must have a unique identifier, name,
 * and symbol that is used in equations.
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class Variable {

    private final String id;
    private final String name;
    private final String symbol;

    public Variable(String id, String name, String symbol) throws ValidationException {
        if (id == null) {
            throw new ValidationException("Id of variable was null");
        }
        if (name == null) {
            throw new ValidationException("Name of variable was null", "Variable " + id);
        }
        if (symbol == null) {
            throw new ValidationException("Symbol of variable was null", "Variable " + id);
        }
        this.id = id;
        this.name = name;
        this.symbol = symbol;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

}
