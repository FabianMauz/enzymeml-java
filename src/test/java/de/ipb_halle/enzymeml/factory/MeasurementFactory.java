package de.ipb_halle.enzymeml.factory;

import de.ipb_halle.enzymeml.model.DataType;
import de.ipb_halle.enzymeml.model.Measurement;
import de.ipb_halle.enzymeml.model.MeasurementData;
import de.ipb_halle.enzymeml.tools.PredefinedUnits;
import de.ipb_halle.enzymeml.validate.ValidationException;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class MeasurementFactory {

    public static Measurement createMeasurement(String id, String targetId, boolean isSimulated) throws ValidationException {
        Measurement measurement = new Measurement(id, "measurement-1");

        measurement.setGroupId("group-1");
        measurement.setPH(7f);
        measurement.setTemperature(36, PredefinedUnits.celcius());

        MeasurementData data = new MeasurementData(targetId);
        data.setDataType(DataType.AMOUNT);
        data.setInitial(10f);
        data.setDataUnit(PredefinedUnits.milligram());
        data.setPrepared(10f);
        data.setSimulated(isSimulated);
        data.setTimeUnit(PredefinedUnits.second());
        data.addDataPoint(10f, 0);
        data.addDataPoint(5f, 10);
        data.addDataPoint(0f, 20);

        measurement.addSpeciesData(data);
        return measurement;
    }
}
