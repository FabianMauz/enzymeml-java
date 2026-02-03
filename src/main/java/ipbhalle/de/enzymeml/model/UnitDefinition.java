package ipbhalle.de.enzymeml.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a unit definition that is based on the SI unit system.
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class UnitDefinition {

    private String id;
    private String name;
    private List<BaseUnit> baseUnits = new ArrayList<>();
}
