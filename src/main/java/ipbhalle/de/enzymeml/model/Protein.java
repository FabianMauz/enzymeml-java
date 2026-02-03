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

    private String id;
    private String name;
    private boolean constant;
    private String sequence;
    private Vessel vessel;
    private String ecNumber;
    private String organism;
    private String organismTaxId;
    private List<String> references = new ArrayList<>();

}
