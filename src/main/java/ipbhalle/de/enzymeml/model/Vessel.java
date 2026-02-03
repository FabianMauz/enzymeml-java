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

    private String id;
    private String name;
    private String volume;
    private UnitDefinition unit;
    private boolean constant;

}
