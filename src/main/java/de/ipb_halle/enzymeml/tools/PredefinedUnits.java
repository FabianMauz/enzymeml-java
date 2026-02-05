package de.ipb_halle.enzymeml.tools;

import de.ipb_halle.enzymeml.model.BaseUnit;
import de.ipb_halle.enzymeml.model.UnitDefinition;
import de.ipb_halle.enzymeml.model.UnitType;
import de.ipb_halle.enzymeml.validate.ValidationException;

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
