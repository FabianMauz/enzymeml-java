package de.ipb_halle.enzymeml.serialize.mixins.xml;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import de.ipb_halle.enzymeml.model.Equation;
import de.ipb_halle.enzymeml.model.ModifierElement;
import de.ipb_halle.enzymeml.model.Reaction;
import de.ipb_halle.enzymeml.model.ReactionElement;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public class ReactionXmlSerializer extends StdSerializer<Reaction> {

    public ReactionXmlSerializer() {
        super(Reaction.class);
    }

    @Override
    public void serialize(Reaction reaction, JsonGenerator gen, SerializerProvider provider) throws IOException {

        ToXmlGenerator xmlGen = (ToXmlGenerator) gen;

        xmlGen.writeStartObject();
        xmlGen.writeStringField("id", reaction.getId());
        xmlGen.writeStringField("name", reaction.getName());
        xmlGen.writeBooleanField("reversible", reaction.isReversible());

        Equation kineticLaw = reaction.getKineticLaw();
        if (kineticLaw != null) {
            xmlGen.writeFieldName("kinetic_law");
            xmlGen.writeStartObject();

            xmlGen.writeObjectField("Equation", kineticLaw);
            xmlGen.writeEndObject();
        }

        writeReactionElements(xmlGen, "reactants", reaction.getReactants());
        writeReactionElements(xmlGen, "products", reaction.getProducts());
        writeModifierElements(xmlGen, "modifiers", reaction.getModifiers());

        xmlGen.writeEndObject();
    }

    private void writeReactionElements(ToXmlGenerator xmlGen, String wrapperName,
            List<ReactionElement> elements) throws IOException {
        xmlGen.writeFieldName(wrapperName);
        xmlGen.writeStartObject();
        if (elements != null) {
            for (ReactionElement element : elements) {
                if (element != null) {
                    xmlGen.writeObjectField("ReactionElement", element);
                }
            }
        }
        xmlGen.writeEndObject();
    }

    private void writeModifierElements(ToXmlGenerator xmlGen, String wrapperName,
            List<ModifierElement> elements) throws IOException {
        xmlGen.writeFieldName(wrapperName);
        xmlGen.writeStartObject();
        if (elements != null) {
            for (ModifierElement element : elements) {
                if (element != null) {
                    xmlGen.writeObjectField("ModifierElement", element);
                }
            }
        }
        xmlGen.writeEndObject();
    }
}
