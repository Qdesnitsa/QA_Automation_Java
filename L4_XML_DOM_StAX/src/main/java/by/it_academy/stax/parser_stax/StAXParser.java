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
    private static final String XML_PATH = "journall.xml";
    private List<Article> articles = null;
    private List<String> hotkeys = null;
    private Journal journal = new Journal();
    private Contact contact = new Contact();
    private Article curArticle = null;
    private String tagContent = null;

    public void parseXMLAndPrintJournal() throws XMLStreamException {
        parseXML();
        journal.setContact(contact);
        journal.setArticles(articles);
        System.out.println(journal);
    }

    public void parseXML() throws XMLStreamException {
        XMLStreamReader reader = StaxParserUtil.createXMLStreamReader(XML_PATH);
        if (null != reader) {
            try {
                while (reader.hasNext()) {
                    int event = reader.next();
                    switch (event) {
                        case XMLStreamConstants.START_ELEMENT:
                            parseStartElement(reader);
                            break;

                        case XMLStreamConstants.CHARACTERS:
                            tagContent = reader.getText().trim();
                            break;

                        case XMLStreamConstants.END_ELEMENT:
                            parseEndElement(reader);
                            break;
                    }
                }
            } catch (XMLStreamException e) {
                e.printStackTrace();
                System.out.println("XMLStreamException e");
            }
        }
    }

    public void parseStartElement(XMLStreamReader reader) throws XMLStreamException {
        String localName = reader.getLocalName();
        if ("journal_title".equals(localName)) {
            journal.setTitle(reader.getElementText());
        } else if ("address".equals(localName)) {
            contact.setAddress(reader.getElementText());
        } else if ("tel".equals(localName)) {
            contact.setTel(reader.getElementText());
        } else if ("email".equals(localName)) {
            contact.setEmail(reader.getElementText());
        } else if ("journal_url".equals(localName)) {
            contact.setUrl(reader.getElementText());
        } else if ("articles".equals(localName)) {
            articles = new ArrayList<>();
        } else if ("article".equals(localName)) {
            curArticle = new Article();
            curArticle.setId(reader.getAttributeValue(0));
        } else if ("hotkeys".equals(localName)) {
            hotkeys = new ArrayList<>();
        } else if ("hotkey".equals(localName)) {
            hotkeys.add(reader.getElementText());
            curArticle.setHotkeys(hotkeys);
        }
    }

    public void parseEndElement(XMLStreamReader reader) {
        switch (reader.getLocalName()) {
            case "article":
                articles.add(curArticle);
                break;
            case "title":
                curArticle.setTitle(tagContent);
                break;
            case "author":
                curArticle.setAuthor(tagContent);
                break;
            case "url":
                curArticle.setUrl(tagContent);
                break;
        }
    }
}

