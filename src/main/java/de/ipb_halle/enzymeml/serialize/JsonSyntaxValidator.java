package de.ipb_halle.enzymeml.serialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import de.ipb_halle.enzymeml.validate.ValidationException;
import java.util.Set;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class JsonSyntaxValidator {

    public static void validateSyntax(ObjectMapper serializer, String jsonString) throws ValidationException, JsonProcessingException {
        JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V202012);
        JsonSchema jsonSchema = factory.getSchema(
                JsonSerializer.class.getResourceAsStream("/enzymeml-v2.json"));
        Set<ValidationMessage> errors = jsonSchema.validate(serializer.readTree(jsonString));
        if (!errors.isEmpty()) {
            throw new ValidationException("Json is invalid against shema");
        }
    }

}
