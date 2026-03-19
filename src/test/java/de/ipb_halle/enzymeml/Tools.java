package de.ipb_halle.enzymeml;

import de.ipb_halle.enzymeml.model.BaseUnit;
import de.ipb_halle.enzymeml.model.UnitDefinition;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class Tools {

    private static final float EPSILON = 0.000001f;

    public static boolean areUnitEqual(
            UnitDefinition unit1,
            UnitDefinition unit2) {
        boolean idNameCondition = unit1.getId().equals(unit2.getId())
                && unit1.getName().equals(unit2.getName());

        if (!idNameCondition) {
            return false;
        }
        if (unit1.getBaseUnits().size() != unit2.getBaseUnits().size()) {
            return false;
        }
        for (int i = 0; i < unit1.getBaseUnits().size(); i++) {
            BaseUnit buOfUnit1 = unit1.getBaseUnits().get(i);
            BaseUnit buOfUnit2 = unit2.getBaseUnits().get(i);

            if (buOfUnit1.getExponent() != buOfUnit2.getExponent()) {
                return false;
            }
            if (Math.abs(buOfUnit1.getMultiplier() - buOfUnit2.getMultiplier()) > EPSILON) {
                return false;
            }
            if (Math.abs(buOfUnit1.getScale() - buOfUnit2.getScale()) > EPSILON) {
                return false;
            }
            if (buOfUnit1.getKind() != buOfUnit2.getKind()) {
                return false;
            }
        }

        return true;
    }

}
