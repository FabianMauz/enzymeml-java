# enzymeml-java

Java library for reading, writing, and validating EnzymeML v2 documents in JSON and XML.

**Features**
- JSON and XML serialization and deserialization
- Schema validation for both formats
- Domain model for enzymes, reactions, measurements, and related entities
- Built-in validators for ID consistency and measurement integrity

**Requirements**
- Java 17
- Maven

**Build**
```bash
mvn -q test
```

**Quick Start**
```java
import de.ipb_halle.enzymeml.model.EnzymeMLDocument;
import de.ipb_halle.enzymeml.serialize.JsonSerializer;
import de.ipb_halle.enzymeml.serialize.XmlSerializer;

EnzymeMLDocument doc = new EnzymeMLDocument("2.0", "Example Document");

String json = new JsonSerializer(true, true).serialize(doc);
String xml = new XmlSerializer().serialize(doc);
```

**Deserialize**
```java
import de.ipb_halle.enzymeml.serialize.JsonDeserializer;
import de.ipb_halle.enzymeml.serialize.XmlDeserializer;

EnzymeMLDocument fromJson = new JsonDeserializer().deserialize(jsonString);
EnzymeMLDocument fromXml = new XmlDeserializer().deserialize(xmlString);
```

**Validation**
```java
import de.ipb_halle.enzymeml.validate.Validator;

Validator validator = new Validator();
var errors = validator.validate(doc);
```

**Predefined Units**
```java
import de.ipb_halle.enzymeml.tools.PredefinedUnits;

var unit = PredefinedUnits.millimolar();
```

**Notes**
- JSON and XML deserialization validate against the bundled schemas.
- For best results, provide stable IDs and consistent measurement data.

**Acknowledgements**
Thanks to the EnzymeML community for the specification and guidance.
