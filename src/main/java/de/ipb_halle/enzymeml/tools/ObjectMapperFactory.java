package de.ipb_halle.enzymeml.tools;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.ipb_halle.enzymeml.model.BaseUnit;
import de.ipb_halle.enzymeml.model.Complex;
import de.ipb_halle.enzymeml.model.Creator;
import de.ipb_halle.enzymeml.model.DataType;
import de.ipb_halle.enzymeml.model.EnzymeMLDocument;
import de.ipb_halle.enzymeml.model.Equation;
import de.ipb_halle.enzymeml.model.EquationType;
import de.ipb_halle.enzymeml.model.Measurement;
import de.ipb_halle.enzymeml.model.MeasurementData;
import de.ipb_halle.enzymeml.model.ModifierElement;
import de.ipb_halle.enzymeml.model.ModifierRole;
import de.ipb_halle.enzymeml.model.Parameter;
import de.ipb_halle.enzymeml.model.Protein;
import de.ipb_halle.enzymeml.model.Reaction;
import de.ipb_halle.enzymeml.model.ReactionElement;
import de.ipb_halle.enzymeml.model.SmallMolecule;
import de.ipb_halle.enzymeml.model.UnitDefinition;
import de.ipb_halle.enzymeml.model.UnitType;
import de.ipb_halle.enzymeml.model.Variable;
import de.ipb_halle.enzymeml.model.Vessel;
import de.ipb_halle.enzymeml.serialize.mixins.json.BaseUnitJsonMixin;
import de.ipb_halle.enzymeml.serialize.mixins.json.ComplexJsonMixin;
import de.ipb_halle.enzymeml.serialize.mixins.json.CreatorJsonMixin;
import de.ipb_halle.enzymeml.serialize.mixins.json.DataTypeJsonMixin;
import de.ipb_halle.enzymeml.serialize.mixins.json.EnzymeMLDocumentJsonMixIn;
import de.ipb_halle.enzymeml.serialize.mixins.json.EquationJsonMixin;
import de.ipb_halle.enzymeml.serialize.mixins.json.EquationTypeJsonMixin;
import de.ipb_halle.enzymeml.serialize.mixins.json.MeasurementDataJsonMixin;
import de.ipb_halle.enzymeml.serialize.mixins.json.MeasurementJsonMixin;
import de.ipb_halle.enzymeml.serialize.mixins.json.ModifierElementJsonMixin;
import de.ipb_halle.enzymeml.serialize.mixins.json.ModifierRoleJsonMixin;
import de.ipb_halle.enzymeml.serialize.mixins.json.ParameterJsonMixin;
import de.ipb_halle.enzymeml.serialize.mixins.json.ProteinJsonMixin;
import de.ipb_halle.enzymeml.serialize.mixins.json.ReactionElementJsonMixin;
import de.ipb_halle.enzymeml.serialize.mixins.json.ReactionJsonMixin;
import de.ipb_halle.enzymeml.serialize.mixins.json.SmallMoleculeJsonMixin;
import de.ipb_halle.enzymeml.serialize.mixins.json.UnitDefinitionJsonMixin;
import de.ipb_halle.enzymeml.serialize.mixins.json.UnitTypeJsonMixin;
import de.ipb_halle.enzymeml.serialize.mixins.json.VariableJsonMixin;
import de.ipb_halle.enzymeml.serialize.mixins.json.VesselJsonMixin;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class ObjectMapperFactory {

    public static ObjectMapper createJsonMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
        mapper.setVisibility(PropertyAccessor.GETTER, JsonAutoDetect.Visibility.DEFAULT);
        mapper.setVisibility(PropertyAccessor.IS_GETTER, JsonAutoDetect.Visibility.DEFAULT);
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.NONE);

        mapper.addMixIn(EnzymeMLDocument.class, EnzymeMLDocumentJsonMixIn.class);
        mapper.addMixIn(Creator.class, CreatorJsonMixin.class);
        mapper.addMixIn(UnitDefinition.class, UnitDefinitionJsonMixin.class);
        mapper.addMixIn(UnitType.class, UnitTypeJsonMixin.class);
        mapper.addMixIn(Protein.class, ProteinJsonMixin.class);
        mapper.addMixIn(Complex.class, ComplexJsonMixin.class);
        mapper.addMixIn(SmallMolecule.class, SmallMoleculeJsonMixin.class);
        mapper.addMixIn(Reaction.class, ReactionJsonMixin.class);
        mapper.addMixIn(Equation.class, EquationJsonMixin.class);
        mapper.addMixIn(EquationType.class, EquationTypeJsonMixin.class);
        mapper.addMixIn(ModifierRole.class, ModifierRoleJsonMixin.class);
        mapper.addMixIn(ModifierElement.class, ModifierElementJsonMixin.class);
        mapper.addMixIn(ReactionElement.class, ReactionElementJsonMixin.class);
        mapper.addMixIn(Measurement.class, MeasurementJsonMixin.class);
        mapper.addMixIn(MeasurementData.class, MeasurementDataJsonMixin.class);
        mapper.addMixIn(DataType.class, DataTypeJsonMixin.class);
        mapper.addMixIn(Parameter.class, ParameterJsonMixin.class);
        mapper.addMixIn(Vessel.class, VesselJsonMixin.class);
        mapper.addMixIn(Variable.class, VariableJsonMixin.class);
        mapper.addMixIn(BaseUnit.class, BaseUnitJsonMixin.class);

        return mapper;
    }

}
