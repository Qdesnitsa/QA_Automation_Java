package by.it_academy.dom.parser_dom;

import by.it_academy.dom.model.Article;
import by.it_academy.dom.model.Contact;
import by.it_academy.dom.model.Journal;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DomParser {
    public static Document document;
    public static Journal journal;
    public static void domParse(String fileName) throws ParserConfigurationException, IOException, SAXException {
        document = obtainDocument(fileName);
        journal = createJournal("journal");
        journal.setContact(createContact("contacts"));
        journal.setArticles(createArticle("article"));
    }


    private static Journal createJournal(String tagName) throws ParserConfigurationException, IOException, SAXException {
        journal = new Journal();
        NodeList nListJournal = document.getElementsByTagName(tagName);
        for (int i = 0; i < nListJournal.getLength(); i++) {
            Node nodeJournal = nListJournal.item(i);
            if (nodeJournal.getNodeType() == Node.ELEMENT_NODE) {
                Element eElementJournal = (Element) nodeJournal;
                journal.setTitle(eElementJournal.getElementsByTagName("title").item(0).getTextContent().trim());
            }
        }
        return journal;
    }

    private static Contact createContact(String tagName) throws ParserConfigurationException, IOException, SAXException {
        NodeList nListContacts = document.getElementsByTagName(tagName);
        Contact contact = null;
        for (int j = 0; j < nListContacts.getLength(); j++) {
            Node nodeContact = nListContacts.item(j);
            if (nodeContact.getNodeType() == Node.ELEMENT_NODE) {
                Element eElementContact = (Element) nodeContact;
                contact = new Contact(
                        eElementContact.getElementsByTagName("address").item(0).getTextContent().trim(),
                        eElementContact.getElementsByTagName("tel").item(0).getTextContent().trim(),
                        eElementContact.getElementsByTagName("email").item(0).getTextContent().trim(),
                        eElementContact.getElementsByTagName("url").item(0).getTextContent().trim());
            }
        }
        return contact;
    }

    private static List<Article> createArticle(String tagName) throws ParserConfigurationException, IOException, SAXException {
        List<Article> articles = new ArrayList<>();
        NodeList articleNodes = document.getElementsByTagName(tagName);
        Article article = null;
        for (int k = 0; k < articleNodes.getLength(); k++) {
            article = new Article();
            Node nodeHotkeys = articleNodes.item(k);
            if (nodeHotkeys.getNodeType() == Node.ELEMENT_NODE) {
                List<String> hotkeys = new ArrayList<>();
                Element articleElement = (Element) articleNodes.item(k);
                article.setId(articleElement.getAttribute("ID"));
                article.setTitle(articleElement.getElementsByTagName("title").item(0).getTextContent().trim());
                article.setAuthor(articleElement.getElementsByTagName("author").item(0).getTextContent().trim());
                article.setUrl(articleElement.getElementsByTagName("url").item(0).getTextContent().trim());

                NodeList childNodesHotkeys = ((Element) nodeHotkeys).getElementsByTagName("hotkey");
                Stream<Node> stream = IntStream.range(0, childNodesHotkeys.getLength())
                        .mapToObj(childNodesHotkeys::item);
                stream.forEach(node -> {
                    if (node instanceof Element) {
                        hotkeys.add(node.getTextContent());
                    }
                });
                article.setHotkeys(hotkeys);
                articles.add(article);
            }
        }
        return articles;
    }

    private static Element getSingleChild(Element element, String childName) {
        NodeList nlist = element.getElementsByTagName(childName);
        Element child = (Element) nlist.item(0);
        return child;
    }

    private static Document obtainDocument(String fileName) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(ClassLoader.getSystemResourceAsStream(fileName));
        document.getDocumentElement().normalize();
        return document;
    }
}



