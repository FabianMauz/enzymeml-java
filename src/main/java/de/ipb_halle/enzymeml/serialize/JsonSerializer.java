package de.ipb_halle.enzymeml.serialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import de.ipb_halle.enzymeml.model.EnzymeMLDocument;
import de.ipb_halle.enzymeml.tools.ObjectMapperFactory;
import de.ipb_halle.enzymeml.validate.ValidationException;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class JsonSerializer {

    ObjectMapper serializer;
    private final boolean strict;

    public JsonSerializer(boolean prettyOutput, boolean strict) {
        this.serializer = ObjectMapperFactory.createJsonMapper();
        if (prettyOutput) {
            serializer.enable(SerializationFeature.INDENT_OUTPUT);
        }
        this.strict = strict;

    }

    public String serialize(EnzymeMLDocument document) throws JsonProcessingException, ValidationException {
        String jsonString = serializer.writeValueAsString(document);

        if (strict) {
            JsonSyntaxValidator.validateSyntax(serializer, jsonString);
        }

        return serializer.writeValueAsString(document);

    }
}
