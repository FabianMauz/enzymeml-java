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
        return unit.addBaseUnit(new BaseUnit(UnitType.GRAM, 1, 1, -3));
    }

    public static UnitDefinition microgram() throws ValidationException {
        UnitDefinition unit = new UnitDefinition("µg", "microgram");
        return unit.addBaseUnit(new BaseUnit(UnitType.GRAM, 1, 1, -6));
    }

    public static UnitDefinition nanogram() throws ValidationException {
        UnitDefinition unit = new UnitDefinition("ng", "nanogram");
        return unit.addBaseUnit(new BaseUnit(UnitType.GRAM, 1, 1, -9));
    }

    public static UnitDefinition second() throws ValidationException {
        UnitDefinition unit = new UnitDefinition("s", "second");
        return unit.addBaseUnit(new BaseUnit(UnitType.SECOND, 1, 1, 0));
    }

    public static UnitDefinition perSecond() throws ValidationException {
        UnitDefinition unit = new UnitDefinition("s-1", "perSecond");
        return unit.addBaseUnit(new BaseUnit(UnitType.SECOND, -1, 1, 0));
    }

    public static UnitDefinition celcius() throws ValidationException {
        UnitDefinition unit = new UnitDefinition("C°", "celcius");
        return unit.addBaseUnit(new BaseUnit(UnitType.CELSIUS, 1, 1, 0));
    }

    public static UnitDefinition liter() throws ValidationException {
        UnitDefinition unit = new UnitDefinition("l", "litre");
        return unit.addBaseUnit(new BaseUnit(UnitType.LITRE, 1, 1, 0));
    }

    public static UnitDefinition mililiter() throws ValidationException {
        UnitDefinition unit = new UnitDefinition("ml", "mililitre");
        return unit.addBaseUnit(new BaseUnit(UnitType.LITRE, 1, 1, -3));
    }

    public static UnitDefinition nanoMolar() throws ValidationException {
        UnitDefinition unit = new UnitDefinition("nM", "nanomolar");
        unit.addBaseUnit(new BaseUnit(UnitType.LITRE, -1, 1, 0));
        return unit.addBaseUnit(new BaseUnit(UnitType.MOLE, 1, 1, -9));
    }

    public static UnitDefinition microMolar() throws ValidationException {
        UnitDefinition unit = new UnitDefinition("µM", "micromolar");
        unit.addBaseUnit(new BaseUnit(UnitType.LITRE, -1, 1, 0));
        return unit.addBaseUnit(new BaseUnit(UnitType.MOLE, 1, 1, -6));
    }

    public static UnitDefinition milliMolar() throws ValidationException {
        UnitDefinition unit = new UnitDefinition("mM", "millimolar");
        unit.addBaseUnit(new BaseUnit(UnitType.LITRE, -1, 1, 0));
        return unit.addBaseUnit(new BaseUnit(UnitType.MOLE, 1, 1, -3));
    }
}
