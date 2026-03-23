package de.ipb_halle.enzymeml.serialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import de.ipb_halle.enzymeml.validate.ValidationException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class JsonSyntaxValidator {

    public static void validateSyntax(ObjectMapper serializer, String jsonString) throws ValidationException, JsonProcessingException {
        JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V202012);
        try (InputStream schemaStream = JsonSerializer.class.getResourceAsStream("/enzymeml-v2.json")) {
            Objects.requireNonNull(schemaStream, "JSON schema /enzymeml-v2.json not found on classpath");
            JsonSchema jsonSchema = factory.getSchema(schemaStream);
            Set<ValidationMessage> errors = jsonSchema.validate(serializer.readTree(jsonString));
            if (!errors.isEmpty()) {
                throw new ValidationException("Json is invalid against schema");
            }
        } catch (Exception e) {
            throw new ValidationException("Json schema validation failed", e.getMessage());
        }
    }

}
