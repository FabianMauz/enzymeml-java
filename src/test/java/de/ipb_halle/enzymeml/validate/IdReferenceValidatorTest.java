package de.ipb_halle.enzymeml.validate;

import de.ipb_halle.enzymeml.model.EnzymeMLDocument;
import de.ipb_halle.enzymeml.model.Equation;
import de.ipb_halle.enzymeml.model.EquationType;
import de.ipb_halle.enzymeml.model.Measurement;
import de.ipb_halle.enzymeml.model.MeasurementData;
import de.ipb_halle.enzymeml.model.SmallMolecule;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class IdReferenceValidatorTest {

    IdReferenceValidator validator = new IdReferenceValidator();

    @Test
    public void validate_withMinimalDocument_throwsNoError() throws Exception {
        List<ValidationException> errors = new ArrayList<>();
        EnzymeMLDocument doc = new EnzymeMLDocument("2.0", "test-document");
        validator.validate(doc, errors);

        Assertions.assertTrue(errors.isEmpty());
    }

    @Test
    public void validate_whenAllReferencesHadAnCorrectID_throwsNoError() throws Exception {
        List<ValidationException> errors = new ArrayList<>();
        EnzymeMLDocument doc = new EnzymeMLDocument("2.0", "test-document");

        doc.addSmallMolecule(new SmallMolecule("sm-1", "small-molecule-1", true));
        doc.addSmallMolecule(new SmallMolecule("sm-2", "small-molecule-2", true));
        doc.addSmallMolecule(new SmallMolecule("sm-3", "small-molecule-3", true));
        doc.addSmallMolecule(new SmallMolecule("sm-4", "small-molecule-4", true));

        Measurement measurement = new Measurement("m-1", "measurement-1");
        measurement.addSpeciesData(new MeasurementData("sm-1"));
        measurement.addSpeciesData(new MeasurementData("sm-2"));
        measurement.addSpeciesData(new MeasurementData("sm-3"));
        doc.addMeasurement(measurement);

        Measurement measurement2 = new Measurement("m-2", "measurement-1");
        measurement2.addSpeciesData(new MeasurementData("sm-2"));
        measurement2.addSpeciesData(new MeasurementData("sm-3"));
        measurement2.addSpeciesData(new MeasurementData("sm-4"));
        doc.addMeasurement(measurement2);

        validator.validate(doc, errors);

        Assertions.assertTrue(errors.isEmpty());
    }

    @Test
    public void validate_whenMeasurementDataReferencesNotValid_throwsError() throws Exception {
        List<ValidationException> errors = new ArrayList<>();
        EnzymeMLDocument doc = new EnzymeMLDocument("2.0", "test-document");
        doc.addSmallMolecule(new SmallMolecule("sm-1", "small-molecule-1", true));
        doc.addSmallMolecule(new SmallMolecule("e-1", "small-molecule-1", true));

        Measurement measurement = new Measurement("m-1", "measurement-1");
        measurement.addSpeciesData(new MeasurementData("sm-1"));
        measurement.addSpeciesData(new MeasurementData("sm-2"));
        doc.addMeasurement(measurement);

        validator.validate(doc, errors);

        Assertions.assertEquals(1, errors.size());
    }

    @Test
    public void validate_whenEquationReferencesNotValid_throwsError() throws Exception {
        List<ValidationException> errors = new ArrayList<>();
        EnzymeMLDocument doc = new EnzymeMLDocument("2.0", "test-document");
        doc.addSmallMolecule(new SmallMolecule("e-1", "small-molecule-1", true));

        doc.addEquation(new Equation("e-1", "E=mc²", EquationType.ASSIGNMENT));
        doc.addEquation(new Equation("e-2", "E=mc²", EquationType.ASSIGNMENT));
        doc.addEquation(new Equation("e-3", "E=mc²", EquationType.ASSIGNMENT));

        validator.validate(doc, errors);

        Assertions.assertEquals(2, errors.size());
    }
}
