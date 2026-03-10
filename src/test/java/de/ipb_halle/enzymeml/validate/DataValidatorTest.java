package de.ipb_halle.enzymeml.validate;

import de.ipb_halle.enzymeml.model.EnzymeMLDocument;
import de.ipb_halle.enzymeml.model.Measurement;
import de.ipb_halle.enzymeml.model.MeasurementData;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class DataValidatorTest {

    DataValidator validator = new DataValidator();

    @Test
    public void validate_withNoData_throwsNoError() throws Exception {
        List<ValidationException> errors = new ArrayList<>();

        Measurement measurement = new Measurement("m-1", "measurement");
        MeasurementData data = new MeasurementData("s-1");
        measurement.addSpeciesData(data);

        validator.validate(measurement, errors);

        Assertions.assertTrue(errors.isEmpty());
    }

    @Test
    public void validate_withValidData_throwsNoError() throws Exception {
        List<ValidationException> errors = new ArrayList<>();

        Measurement measurement = new Measurement("m-1", "measurement");
        MeasurementData data = new MeasurementData("s-1");
        data.addDataPoint(1.24f, 10);
        data.setInitial(1.24f);
        measurement.addSpeciesData(data);

        validator.validate(measurement, errors);

        Assertions.assertTrue(errors.isEmpty());
    }

    @Test
    public void validate_withValidDataInitialIsNull_throwsNoError() throws Exception {
        List<ValidationException> errors = new ArrayList<>();

        Measurement measurement = new Measurement("m-1", "measurement");
        MeasurementData data = new MeasurementData("s-1");
        data.addDataPoint(1.24f, 10);
        measurement.addSpeciesData(data);

        validator.validate(measurement, errors);

        Assertions.assertTrue(errors.isEmpty());
    }

    @Test
    public void validate_withValidDataOnlyInitialDataGiven_throwsNoError() throws Exception {
        List<ValidationException> errors = new ArrayList<>();

        Measurement measurement = new Measurement("m-1", "measurement");
        MeasurementData data = new MeasurementData("s-1");
        data.setInitial(1.24f);
        measurement.addSpeciesData(data);

        validator.validate(measurement, errors);

        Assertions.assertTrue(errors.isEmpty());
    }

    @Test
    public void validate_withInValidData_throwsNoError() throws Exception {
        List<ValidationException> errors = new ArrayList<>();

        Measurement measurement = new Measurement("m-1", "measurement");
        MeasurementData data = new MeasurementData("s-1");
        data.setInitial(1.444f);
        data.addDataPoint(1.24f, 10);
        measurement.addSpeciesData(data);

        validator.validate(measurement, errors);

        Assertions.assertEquals(1, errors.size());
    }

}
