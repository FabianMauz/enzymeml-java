package ipbhalle.de.enzymeml.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition of a Complex.
 *
 * The Complex object allows the grouping of multiple species using their . This
 * enables the representation of protein-small molecule complexes (e.g.,
 * enzyme-substrate complexes) as well as buffer or solvent mixtures
 * (combinations of SmallMolecule species).
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class Complex {

    private String id;
    private String name;
    private boolean constant;
    private String vesselId;
    private List<String> participants = new ArrayList<>();

    public Complex(String id, String name, boolean constant) {
        this.id = id;
        this.name = name;
        this.constant = constant;
    }

}
