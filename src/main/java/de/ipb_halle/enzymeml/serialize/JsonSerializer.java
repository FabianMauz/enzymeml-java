package de.ipb_halle.enzymeml.serialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import de.ipb_halle.enzymeml.model.Creator;
import de.ipb_halle.enzymeml.model.EnzymeMLDocument;
import de.ipb_halle.enzymeml.model.UnitDefinition;
import de.ipb_halle.enzymeml.model.UnitType;
import de.ipb_halle.enzymeml.serialize.mixins.json.CreatorJsonMixin;
import de.ipb_halle.enzymeml.serialize.mixins.json.EnzymeMLDocumentJsonMixIn;
import de.ipb_halle.enzymeml.serialize.mixins.json.UnitDefinitionJsonMixin;
import de.ipb_halle.enzymeml.serialize.mixins.json.UnitTypeJsonMixin;
import de.ipb_halle.enzymeml.validate.ValidationException;
import java.util.Set;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class JsonSerializer {

    ObjectMapper serializer = new ObjectMapper();
    private boolean strict;

    public JsonSerializer(boolean prettyOutput, boolean strict) {
        if (prettyOutput) {
            serializer.enable(SerializationFeature.INDENT_OUTPUT);
        }
        this.strict = strict;

    }

    public String serialize(EnzymeMLDocument document) throws JsonProcessingException, ValidationException {
        serializer.addMixIn(EnzymeMLDocument.class, EnzymeMLDocumentJsonMixIn.class);
        serializer.addMixIn(Creator.class, CreatorJsonMixin.class);
        serializer.addMixIn(UnitDefinition.class, UnitDefinitionJsonMixin.class);
        serializer.addMixIn(UnitType.class, UnitTypeJsonMixin.class);

        String jsonString = serializer.writeValueAsString(document);

        if (strict) {
            JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V202012);
            JsonSchema jsonSchema = factory.getSchema(
                    JsonSerializer.class.getResourceAsStream("/enzymeml-v2.json"));
            Set<ValidationMessage> errors = jsonSchema.validate(serializer.readTree(jsonString));
            if (!errors.isEmpty()) {
                throw new ValidationException("Json is invalid against shema");
            }
        }

        return serializer.writeValueAsString(document);

    }
}
