package by.it_academy.stax.main;

import by.it_academy.stax.parser_stax.StAXParser;

import javax.xml.stream.XMLStreamException;

public class MainStAX {
    public static void main(String[] args) throws XMLStreamException {
        StAXParser.parseXMLAndPrint();
    }
}
