package ipbhalle.de.enzymeml.serialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ipbhalle.de.enzymeml.model.EnzymeMLDocument;
import ipbhalle.de.enzymeml.serialize.mixins.EnzymeMLDocumentJsonMixIn;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class JsonSerializer {

    public String serialize(EnzymeMLDocument document) throws JsonProcessingException {
        ObjectMapper serializer = new ObjectMapper();
        serializer.addMixIn(EnzymeMLDocument.class, EnzymeMLDocumentJsonMixIn.class);

        return serializer.writeValueAsString(document);

    }
}
