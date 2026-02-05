package ipbhalle.de.enzymeml.tools;

import ipbhalle.de.enzymeml.model.BaseUnit;
import ipbhalle.de.enzymeml.model.UnitDefinition;
import ipbhalle.de.enzymeml.model.UnitType;
import ipbhalle.de.enzymeml.validate.ValidationException;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class PredefinedUnits {

    public static UnitDefinition milligram() throws ValidationException {
        UnitDefinition unit = new UnitDefinition("mg", "milligram");
        return unit.addBaseUnit(new BaseUnit(UnitType.GRAM, 0, 0, -3));
    }

    public static UnitDefinition microgram() throws ValidationException {
        UnitDefinition unit = new UnitDefinition("µg", "microgram");
        return unit.addBaseUnit(new BaseUnit(UnitType.GRAM, 0, 0, -6));
    }

    public static UnitDefinition nanogram() throws ValidationException {
        UnitDefinition unit = new UnitDefinition("ng", "nanogram");
        return unit.addBaseUnit(new BaseUnit(UnitType.GRAM, 0, 0, -9));
    }

}
