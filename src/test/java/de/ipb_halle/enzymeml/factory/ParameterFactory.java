package de.ipb_halle.enzymeml.factory;

import de.ipb_halle.enzymeml.model.Parameter;
import de.ipb_halle.enzymeml.tools.PredefinedUnits;
import de.ipb_halle.enzymeml.validate.ValidationException;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class ParameterFactory {

    public static Parameter createParameter(String id) throws ValidationException {
        Parameter parameter = new Parameter(id, id + "-name", "symbol of " + id);
        parameter.setConstant(Boolean.TRUE);
        parameter.setFit(Boolean.FALSE);
        parameter.setInitialValue(20f);
        parameter.setLowerBound(19f);
        parameter.setUpperBound(21f);
        parameter.setStdError(3f);
        parameter.setUnit(PredefinedUnits.milligram());
        parameter.setValue(20f);
        return parameter;
    }
}
