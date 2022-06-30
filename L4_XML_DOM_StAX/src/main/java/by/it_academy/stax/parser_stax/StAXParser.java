package by.it_academy.stax.parser_stax;

import by.it_academy.stax.model.Contact;
import by.it_academy.stax.model.Journal;
import by.it_academy.stax.model.Article;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StAXParser {
    private static final String XML_PATH = "journal.xml";
    private static List<Article> articles;
    private static List<String> hotkeys;
    private static Journal journal;
    private static Contact contact;
    private static Article article;
    private static String tagContent;
    private static int event;
    private static String localName;

    public static void parseXMLAndPrint() throws XMLStreamException {
        parseXML();
        System.out.println(journal);
    }

    public static void parseXML() throws XMLStreamException {
        XMLStreamReader reader = StaxParserUtil.createXMLStreamReader(XML_PATH);
        if (null != reader) {
            try {
                while (reader.hasNext()) {
                    event = reader.next();
                    switch (event) {
                        case XMLStreamConstants.START_ELEMENT:
                            parseStartElement(reader);
                            break;

                        case XMLStreamConstants.CHARACTERS:
                            tagContent = reader.getText().trim();
                            break;
                    }
                }
            } catch (XMLStreamException e) {
                throw new RuntimeException("Can not read file", e);
            }
        }
    }

    public static void parseStartElement(XMLStreamReader reader) throws XMLStreamException {
        localName = reader.getLocalName();
        if ("journal".equals(localName)) {
            journal = new Journal();
        } else if ("title".equals(localName)) {
            journal.setTitle(reader.getElementText());
        } else if ("contacts".equals(localName)) {
            parseContacts(reader);
        } else if ("articles".equals(localName)) {
            articles = new ArrayList<>();
        } else if ("article".equals(localName)) {
            parseArticles(reader);
        }
    }

    public static void parseContacts(XMLStreamReader reader) throws XMLStreamException {
        contact = new Contact();
        event = reader.next();
        do {
            event = reader.next();
            if (event == XMLStreamConstants.START_ELEMENT) {
                localName = reader.getLocalName();
                if ("address".equals(localName)) {
                    contact.setAddress(reader.getElementText());
                } else if ("tel".equals(localName)) {
                    contact.setTel(reader.getElementText());
                } else if ("email".equals(localName)) {
                    contact.setEmail(reader.getElementText());
                } else if ("url".equals(localName)) {
                    contact.setUrl(reader.getElementText());
                }
            }
        } while (reader.hasNext() && !localName.equals("contacts") && event != 2);
        journal.setContact(contact);
    }

    public static void parseArticles(XMLStreamReader reader) throws XMLStreamException {
        article = new Article();
        article.setId(reader.getAttributeValue(0));
        event = reader.next();
        do {
            event = reader.next();
            if (event == XMLStreamConstants.START_ELEMENT) {
                localName = reader.getLocalName();
                if ("title".equals(localName)) {
                    article.setTitle(reader.getElementText());
                } else if ("author".equals(localName)) {
                    article.setAuthor(reader.getElementText());
                } else if ("url".equals(localName)) {
                    article.setUrl(reader.getElementText());
                } else if ("hotkeys".equals(localName)) {
                    hotkeys = new ArrayList<>();
                } else if ("hotkey".equals(localName)) {
                    hotkeys.add(reader.getElementText());
                    article.setHotkeys(hotkeys);
                }
            }
        }
        while (reader.hasNext() && !localName.equals("articles") && event != 2);
        articles.add(article);
        journal.setArticles(articles);
        journal.setContact(contact);
    }
}


