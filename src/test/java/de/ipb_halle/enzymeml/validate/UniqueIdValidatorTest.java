package de.ipb_halle.enzymeml.validate;

import de.ipb_halle.enzymeml.model.Complex;
import de.ipb_halle.enzymeml.model.EnzymeMLDocument;
import de.ipb_halle.enzymeml.model.Measurement;
import de.ipb_halle.enzymeml.model.Parameter;
import de.ipb_halle.enzymeml.model.Protein;
import de.ipb_halle.enzymeml.model.Reaction;
import de.ipb_halle.enzymeml.model.SmallMolecule;
import de.ipb_halle.enzymeml.model.Vessel;
import de.ipb_halle.enzymeml.tools.PredefinedUnits;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class UniqueIdValidatorTest {

    UniqueIdValidator validator = new UniqueIdValidator();
    List<ValidationException> errors;

    @Test
    public void validate_withMinimalDocument_throwsNoError() throws Exception {
        errors = new ArrayList<>();
        EnzymeMLDocument doc = new EnzymeMLDocument("2.0", "test-document");
        validator.validate(doc, errors);

        Assertions.assertTrue(errors.isEmpty());
    }

    @Test
    public void validate_withCorrectDocument_throwsNoError() throws Exception {
        errors = new ArrayList<>();
        EnzymeMLDocument doc = new EnzymeMLDocument("2.0", "test-document");
        doc.addComplex(new Complex("c-1", "complex-1", true));
        doc.addComplex(new Complex("c-2", "complex-2", true));
        doc.addMeasurement(new Measurement("m-1", "measurement-1"));
        doc.addMeasurement(new Measurement("m-2", "measurement-2"));
        doc.addParameter(new Parameter("pa-1", "parameter-1", "µ"));
        doc.addParameter(new Parameter("pa-2", "parameter-2", "µ-1"));
        doc.addProtein(new Protein("p-1", "protein-1", false));
        doc.addProtein(new Protein("p-2", "protein-2", false));
        doc.addReaction(new Reaction("r-1", "reaction-1", false));
        doc.addReaction(new Reaction("r-2", "reaction-2", false));
        doc.addSmallMolecule(new SmallMolecule("sm-1", "small-molecule-1", true));
        doc.addSmallMolecule(new SmallMolecule("sm-2", "small-molecule-2", true));
        doc.addVessel(new Vessel("v-1", "vessel-1", 100, PredefinedUnits.milligram(), true));
        doc.addVessel(new Vessel("v-2", "vessel-2", 100, PredefinedUnits.milligram(), true));

        validator.validate(doc, errors);

        Assertions.assertTrue(errors.isEmpty());
    }

    @Test
    public void validate_withDuplicateIds_throwsError() throws Exception {
        errors = new ArrayList<>();
        EnzymeMLDocument doc = new EnzymeMLDocument("2.0", "test-document");
        doc.addComplex(new Complex("c-1", "complex-1", true));
        doc.addComplex(new Complex("c-1", "complex-2", true));
        doc.addMeasurement(new Measurement("m-1", "measurement-1"));
        doc.addMeasurement(new Measurement("m-1", "measurement-2"));
        doc.addParameter(new Parameter("pa-1", "parameter-1", "µ"));
        doc.addParameter(new Parameter("pa-1", "parameter-2", "µ-1"));
        doc.addProtein(new Protein("p-1", "protein-1", false));
        doc.addProtein(new Protein("p-1", "protein-2", false));
        doc.addReaction(new Reaction("r-1", "reaction-1", false));
        doc.addReaction(new Reaction("r-1", "reaction-2", false));
        doc.addSmallMolecule(new SmallMolecule("sm-1", "small-molecule-1", true));
        doc.addSmallMolecule(new SmallMolecule("sm-1", "small-molecule-2", true));
        doc.addVessel(new Vessel("v-1", "vessel-1", 100, PredefinedUnits.milligram(), true));
        doc.addVessel(new Vessel("v-1", "vessel-2", 100, PredefinedUnits.milligram(), true));

        validator.validate(doc, errors);

        Assertions.assertEquals(1, errors.size());
        Assertions.assertEquals("Duplicate IDs found", errors.get(0).getReason());
        Assertions.assertEquals("c-1,m-1,pa-1,p-1,r-1,sm-1,v-1", errors.get(0).getCauseId());
    }
}
