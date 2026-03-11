package de.ipb_halle.enzymeml.validate;

import de.ipb_halle.enzymeml.model.Creator;
import de.ipb_halle.enzymeml.model.EnzymeMLDocument;
import de.ipb_halle.enzymeml.model.Measurement;
import de.ipb_halle.enzymeml.model.Reaction;
import de.ipb_halle.enzymeml.model.SmallMolecule;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class ValidatorTest {

    Validator validator = new Validator();

    @Test
    public void validate_withMinimalDocument_throwsNoError() throws Exception {
        EnzymeMLDocument doc = new EnzymeMLDocument("2.0", "doc");
        List<ValidationException> error = validator.validate(doc);

        Assertions.assertTrue(error.isEmpty());
    }

    @Test
    public void validate_withInvalidCreator_throwsNoError() throws Exception {
        EnzymeMLDocument doc = new EnzymeMLDocument("2.0", "doc");
        doc.addCreator(new Creator("user", "user-fam", "invalid-email"));

        List<ValidationException> error = validator.validate(doc);

        Assertions.assertEquals(1, error.size());
    }

    @Test
    public void validate_withTwoIdenticalIds_throwsNoError() throws Exception {
        EnzymeMLDocument doc = new EnzymeMLDocument("2.0", "doc");
        doc.addReaction(new Reaction("r-1", "reation-1", false));
        doc.addSmallMolecule(new SmallMolecule("r-1", "small-molecule-1", false));

        List<ValidationException> error = validator.validate(doc);

        Assertions.assertEquals(1, error.size());
    }

    @Test
    public void validate_withInvalidReference_throwsNoError() throws Exception {
        EnzymeMLDocument doc = new EnzymeMLDocument("2.0", "doc");
        Measurement measurement = new Measurement("m1", "measurement-1");

        List<ValidationException> error = validator.validate(doc);

        Assertions.assertEquals(1, error.size());
    }
}
