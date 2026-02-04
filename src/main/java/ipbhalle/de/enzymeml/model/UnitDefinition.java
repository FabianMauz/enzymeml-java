package ipbhalle.de.enzymeml.model;

import ipbhalle.de.enzymeml.validate.ValidationException;
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
    private final List<BaseUnit> baseUnits = new ArrayList<>();

    public UnitDefinition(String id, String name) throws ValidationException {
        if (id == null) {
            throw new ValidationException("Id of unit definition was null");
        }
        if (name == null) {
            throw new ValidationException("Name of unit definition was null", "UnitDefinition " + id);
        }
        this.id = id;
        this.name = name;
    }

    public UnitDefinition addBaseUnit(BaseUnit unit) {
        this.baseUnits.add(unit);
        return this;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<BaseUnit> getBaseUnits() {
        return baseUnits;
    }

}
