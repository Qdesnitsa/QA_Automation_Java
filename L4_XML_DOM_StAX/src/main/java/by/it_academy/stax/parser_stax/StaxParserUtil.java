package by.it_academy.stax.parser_stax;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class StaxParserUtil {

    public static XMLStreamReader createXMLStreamReader(String path) throws XMLStreamException {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader = null;
        reader = factory.createXMLStreamReader(
                ClassLoader.getSystemResourceAsStream(path));
        return reader;
    }
}
