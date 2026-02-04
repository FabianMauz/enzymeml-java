package ipbhalle.de.enzymeml.serialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import ipbhalle.de.enzymeml.model.EnzymeMLDocument;
import ipbhalle.de.enzymeml.validate.ValidationException;
import java.io.IOException;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class XmlSerializerTest {

    XmlSerializer serializer = new XmlSerializer();

    @Test
    public void serialize_withMinimalExample_returnsCorrectJsonOfMinimalExample() throws ValidationException, JsonProcessingException, IOException {
        EnzymeMLDocument document = new EnzymeMLDocument("2.0", "Example Document");

    }
}
