package ipbhalle.de.enzymeml.serialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import ipbhalle.de.enzymeml.model.EnzymeMLDocument;
import ipbhalle.de.enzymeml.validate.ValidationException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class JsonSerializerTest {

    JsonSerializer serializer = new JsonSerializer();

    @Test
    public void serialize_withMinimalExample_returnsCorrectJsonOfMinimalExample() throws ValidationException, JsonProcessingException, IOException {
        EnzymeMLDocument document = new EnzymeMLDocument("2.0", "Example Document");

        Assertions.assertEquals(
                new String(Files.readAllBytes(Paths.get("src/test/resources/fixtures/minimalExample.json"))),
                serializer.serialize(document));
    }
}
