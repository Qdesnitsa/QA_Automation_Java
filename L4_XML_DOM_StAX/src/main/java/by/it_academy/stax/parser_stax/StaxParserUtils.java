package by.it_academy.stax.parser_stax;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class StaxParserUtils {
    private static XMLInputFactory createXMLInputFactory() {
        return XMLInputFactory.newInstance();
    }

    public static XMLStreamReader createXMLStreamReader(String path) {
        XMLInputFactory factory = createXMLInputFactory();
        XMLStreamReader reader = null;
        if (null != factory) {
            try {
                reader = factory.createXMLStreamReader(
                        ClassLoader.getSystemResourceAsStream(path));
            } catch (XMLStreamException e) {
                e.printStackTrace();
                System.out.println("XMLStreamException log");
            }
        }
        return reader;
    }
}
