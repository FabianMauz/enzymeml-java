package de.ipb_halle.enzymeml.serialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.ipb_halle.enzymeml.model.EnzymeMLDocument;
import de.ipb_halle.enzymeml.tools.ObjectMapperFactory;
import de.ipb_halle.enzymeml.validate.ValidationException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 *
 * @author Fabian Mauz
 */
public class JsonDeserializer {

    public static EnzymeMLDocument deserialize(String jsonString) throws ValidationException, JsonProcessingException {
        ObjectMapper mapper = ObjectMapperFactory.createJsonMapper();
        EnzymeMLDocument document = mapper.readValue(jsonString, EnzymeMLDocument.class);
        return document;
    }

    public EnzymeMLDocument deserialize(File fileOfJson) throws ValidationException, IOException {
        String jsonFile = new String(Files.readAllBytes(fileOfJson.toPath()));
        return JsonDeserializer.deserialize(jsonFile);
    }
}
