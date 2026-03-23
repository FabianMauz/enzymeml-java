package de.ipb_halle.enzymeml.serialize;

import de.ipb_halle.enzymeml.Tools;
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
import de.ipb_halle.enzymeml.model.Protein;
import de.ipb_halle.enzymeml.model.Reaction;
import de.ipb_halle.enzymeml.model.ReactionElement;
import de.ipb_halle.enzymeml.model.Variable;
import de.ipb_halle.enzymeml.model.Vessel;
import de.ipb_halle.enzymeml.tools.PredefinedUnits;
import de.ipb_halle.enzymeml.validate.ValidationException;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class XmlDeserializerTest {

    XmlDeserializer deserializer = new XmlDeserializer();

    @Test
    public void deserialize_fromMinimalDocumentXml_returnsMinimalDocument() throws ValidationException, IOException {
        EnzymeMLDocument document = deserializer.deserialize(new File("src/test/resources/fixtures/xml/withMinimalDocument.xml"));

        Assertions.assertEquals("Example Document", document.getName());
        Assertions.assertEquals("2.0", document.getVersion());
        Assertions.assertEquals(0, document.getCreators().size());
        Assertions.assertEquals(0, document.getComplexes().size());
        Assertions.assertEquals(0, document.getMeasurements().size());
        Assertions.assertEquals(0, document.getEquations().size());
        Assertions.assertEquals(0, document.getParameters().size());
        Assertions.assertEquals(0, document.getProteins().size());
        Assertions.assertEquals(0, document.getReactions().size());
        Assertions.assertEquals(0, document.getReferences().size());
        Assertions.assertEquals(0, document.getSmallMolecules().size());
        Assertions.assertEquals(0, document.getVessels().size());
        Assertions.assertNull(document.getCreated());
        Assertions.assertNull(document.getModified());
        Assertions.assertNull(document.getDescription());
    }

    @Test
    public void deserialize_fromComplexReactionXml_returnsDocumentWithReaction() throws ValidationException, IOException {
        EnzymeMLDocument document = deserializer.deserialize(new File("src/test/resources/fixtures/xml/withOneComplexReaction.xml"));

        Assertions.assertEquals(1, document.getVessels().size());
        Vessel vessel = document.getVessels().get(0);
        Assertions.assertEquals("v-1", vessel.getId());
        Assertions.assertEquals("vessel-1", vessel.getName());
        Assertions.assertEquals(1.1f, vessel.getVolume(), 0.00001f);
        Assertions.assertTrue(vessel.isConstant());
        Assertions.assertTrue(Tools.areUnitEqual(PredefinedUnits.liter(), vessel.getUnit()));

        Assertions.assertEquals(1, document.getProteins().size());
        Protein protein = document.getProteins().get(0);
        Assertions.assertEquals("p-1", protein.getId());
        Assertions.assertEquals("Protein-1", protein.getName());
        Assertions.assertTrue(protein.isConstant());

        Assertions.assertEquals(3, document.getSmallMolecules().size());

        Assertions.assertEquals(1, document.getReactions().size());

        Reaction reaction = document.getReactions().get(0);
        Assertions.assertEquals("r-1", reaction.getId());
        Assertions.assertEquals("reaction-1", reaction.getName());
        Assertions.assertTrue(reaction.isReversible());

        Equation equation = reaction.getKineticLaw();
        Assertions.assertEquals("sm-1", equation.getSpeciesId());
        Assertions.assertEquals(EquationType.ASSIGNMENT, equation.getEquationType());
        Assertions.assertEquals(1, equation.getVariables().size());

        Variable variable = equation.getVariables().get(0);
        Assertions.assertEquals("v-1", variable.getId());
        Assertions.assertEquals("variable-1", variable.getName());
        Assertions.assertEquals("b", variable.getSymbol());

        Assertions.assertEquals(1, reaction.getReactants().size());
        ReactionElement reactant = reaction.getReactants().get(0);
        Assertions.assertEquals("sm-1", reactant.getSpeciesId());
        Assertions.assertEquals(-1, reactant.getStoichiometry());

        Assertions.assertEquals(1, reaction.getProducts().size());
        ReactionElement product = reaction.getProducts().get(0);
        Assertions.assertEquals("sm-2", product.getSpeciesId());
        Assertions.assertEquals(1, product.getStoichiometry());

        Assertions.assertEquals(2, reaction.getModifiers().size());
        ModifierElement modifier = reaction.getModifiers().get(0);
        Assertions.assertEquals("sm-3", modifier.getSpeciesId());
        Assertions.assertEquals(ModifierRole.BUFFER, modifier.getRole());
        modifier = reaction.getModifiers().get(1);
        Assertions.assertEquals("p-1", modifier.getSpeciesId());
        Assertions.assertEquals(ModifierRole.BIOCATALYST, modifier.getRole());
    }

    @Test
    public void deserialize_fromOneReactionXml_returnsDocumentWithOneEquation() throws ValidationException, IOException {
        EnzymeMLDocument document = deserializer.deserialize(new File("src/test/resources/fixtures/xml/withOneEquation.xml"));

        Assertions.assertEquals(1, document.getEquations().size());
        Equation equation = document.getEquations().get(0);
        Assertions.assertEquals("sm-1", equation.getSpeciesId());
        Assertions.assertEquals("a=b*c", equation.getEquation());
        Assertions.assertEquals(EquationType.ASSIGNMENT, equation.getEquationType());
        Assertions.assertEquals(1, equation.getVariables().size());

        Variable variable = equation.getVariables().get(0);
        Assertions.assertEquals("v-1", variable.getId());
        Assertions.assertEquals("variable-1", variable.getName());
        Assertions.assertEquals("b", variable.getSymbol());
    }

    @Test
    public void deserialize_fromOneMeasurementXml_returnsDocumentWithOneMeasurement() throws ValidationException, IOException {
        EnzymeMLDocument document = deserializer.deserialize(new File("src/test/resources/fixtures/xml/withOneMeasurement.xml"));

        Assertions.assertEquals(1, document.getMeasurements().size());

        Measurement measurement = document.getMeasurements().get(0);
        Assertions.assertEquals("m-1", measurement.getId());
        Assertions.assertEquals("measurement-1", measurement.getName());
        Assertions.assertEquals("1", measurement.getGroupId());
        Assertions.assertEquals(7.3, measurement.getpH(), 0.00001f);
        Assertions.assertEquals(37.4, measurement.getTemperature(), 0.00001f);
        Assertions.assertTrue(Tools.areUnitEqual(PredefinedUnits.celsius(), measurement.getTemperatureUnit()));

        Assertions.assertEquals(1, measurement.getSpeciesData().size());
        MeasurementData data = measurement.getSpeciesData().get(0);
        Assertions.assertEquals("sm-1", data.getSpeciesId());
        Assertions.assertEquals(100.3, data.getPrepared(), 0.0001f);
        Assertions.assertEquals(100.2, data.getInitial(), 0.0001f);
        Assertions.assertTrue(Tools.areUnitEqual(PredefinedUnits.liter(), data.getDataUnit()));
        Assertions.assertEquals(3, data.getData().size());
        Assertions.assertEquals(3, data.getTime().size());
        assertIterableEquals(List.of(100.2f, 75.3f, 50.2f), data.getData());
        assertIterableEquals(List.of(0.0f, 1.0f, 2.0f), data.getTime());
        Assertions.assertTrue(Tools.areUnitEqual(PredefinedUnits.second(), data.getTimeUnit()));
        Assertions.assertEquals(DataType.AMOUNT, data.getDataType());
        Assertions.assertFalse(data.getIsSimulated());
    }

    @Test
    public void deserialize_fromTwoComplexesXml_returnsDocumentWithTwoComplexes() throws ValidationException, IOException {
        EnzymeMLDocument document = deserializer.deserialize(new File("src/test/resources/fixtures/xml/withTwoComplexes.xml"));

        Assertions.assertEquals(2, document.getComplexes().size());
        Complex complex = document.getComplexes().get(0);
        Assertions.assertEquals("c-1", complex.getId());
        Assertions.assertEquals("complex-1", complex.getName());
        Assertions.assertTrue(complex.isConstant());
        Assertions.assertEquals("v-1", complex.getVesselId());
        Assertions.assertEquals(2, complex.getParticipants().size());
        Assertions.assertEquals("p-1", complex.getParticipants().get(0));
        Assertions.assertEquals("p-2", complex.getParticipants().get(1));
    }

    @Test
    public void deserialize_fromTwoCreatorsXml_returnsDocumentWithTwoCreators() throws ValidationException, IOException {
        EnzymeMLDocument document = deserializer.deserialize(new File("src/test/resources/fixtures/xml/withTwoCreators.xml"));
        Assertions.assertEquals(2, document.getCreators().size());

        Creator creator = document.getCreators().get(0);
        Assertions.assertEquals("user-1-fn", creator.getFamilyName());
        Assertions.assertEquals("user-1-gn", creator.getGivenName());
        Assertions.assertEquals("user1@test.de", creator.getEmail());
        creator = document.getCreators().get(1);
        Assertions.assertEquals("user-2-fn", creator.getFamilyName());
        Assertions.assertEquals("user-2-gn", creator.getGivenName());
        Assertions.assertEquals("user2@test.de", creator.getEmail());
    }
}
