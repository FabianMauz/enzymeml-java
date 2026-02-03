package ipbhalle.de.enzymeml.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a unit definition that is based on the SI unit system.
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class UnitDefinition {

    private final String id;
    private final String name;
    private List<BaseUnit> baseUnits = new ArrayList<>();

    public UnitDefinition(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
