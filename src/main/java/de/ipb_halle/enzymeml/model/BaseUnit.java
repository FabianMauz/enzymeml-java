package de.ipb_halle.enzymeml.model;

/**
 * Represents a base unit in the unit definition.
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class BaseUnit {

    private final UnitType kind;
    private final float exponent;
    private final float multiplier;
    private final float scale;

    public BaseUnit(UnitType kind, float exponent, float multiplier, float scale) {
        this.kind = kind;
        this.exponent = exponent;
        this.multiplier = multiplier;
        this.scale = scale;
    }

    public UnitType getKind() {
        return kind;
    }

    public float getExponent() {
        return exponent;
    }

    public float getMultiplier() {
        return multiplier;
    }

    public float getScale() {
        return scale;
    }

}
