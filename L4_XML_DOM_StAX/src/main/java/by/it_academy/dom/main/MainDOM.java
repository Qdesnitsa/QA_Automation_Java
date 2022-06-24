package by.it_academy.dom.main;

import by.it_academy.dom.parser_xml.DomParser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class MainDOM {
    public static final  String FILE_NAME = "journal.xml";

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DomParser.domParse(FILE_NAME);
    }
}
