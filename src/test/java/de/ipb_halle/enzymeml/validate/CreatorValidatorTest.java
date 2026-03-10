package de.ipb_halle.enzymeml.validate;

import de.ipb_halle.enzymeml.model.Creator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class CreatorValidatorTest {

    CreatorValidator validator = new CreatorValidator();

    @Test
    public void CreatorValidator_whenAllDataIsCorrect_validationPassed() throws ValidationException {

        List<ValidationException> errors = new ArrayList<>();
        validator.validate(Arrays.asList(
                new Creator("test1", "user1", "test1@ipb-halle.de"),
                new Creator("test2", "user2", "test1@ipb-halle.de")), errors);

        Assertions.assertTrue(errors.isEmpty());
    }

    @Test
    public void CreatorValidator_whenEmailIsIncorrect_validationReturnsError() throws ValidationException {

        List<ValidationException> errors = new ArrayList<>();
        validator.validate(Arrays.asList(
                new Creator("test1", "user1", "invalidEmail"),
                new Creator("test2", "user2", "invalidEmail2")), errors);

        Assertions.assertEquals(2, errors.size());
        Assertions.assertEquals("Email is invalid", errors.get(0).getReason());
        Assertions.assertEquals("Creatornumber: 0", errors.get(0).getCauseId());
        Assertions.assertEquals("Email is invalid", errors.get(1).getReason());
        Assertions.assertEquals("Creatornumber: 1", errors.get(1).getCauseId());

    }
}
