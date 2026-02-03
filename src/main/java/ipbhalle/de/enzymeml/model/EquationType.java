package ipbhalle.de.enzymeml.model;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public enum EquationType {
    ASSIGNMENT("assignment"),
    INITIAL_ASSIGNMENT("initialAssignment"),
    ODE("ode"),
    RATE_LAW("rateLaw");

    private String name;

    private EquationType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
