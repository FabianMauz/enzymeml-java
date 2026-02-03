package ipbhalle.de.enzymeml.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition of a Protein.
 *
 * The Protein object represents enzymes and other proteins involved in the
 * experiment.
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class Protein {

    private final String id;
    private final String name;
    private final boolean constant;
    private String sequence;
    private Vessel vessel;
    private String ecNumber;
    private String organism;
    private String organismTaxId;
    private List<String> references = new ArrayList<>();

    public Protein(String id, String name, boolean constant) {
        this.id = id;
        this.name = name;
        this.constant = constant;
    }

}
