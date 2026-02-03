package ipbhalle.de.enzymeml.model;

/**
 * Definition of a Vessel.
 *
 * The Vessel object represents containers used to conduct experiments, such as
 * reaction vessels, microplates, or bioreactors. It captures key properties
 * like volume and whether the volume remains constant during the experiment.
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class Vessel {

    private final String id;
    private final String name;
    private final float volume;
    private final UnitDefinition unit;
    private final boolean constant;

    public Vessel(String id,
            String name,
            float volume,
            UnitDefinition unit,
            boolean constant) {
        this.id = id;
        this.name = name;
        this.unit = unit;
        this.volume = volume;
        this.constant = constant;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getVolume() {
        return volume;
    }

    public UnitDefinition getUnit() {
        return unit;
    }

    public boolean isConstant() {
        return constant;
    }

}
