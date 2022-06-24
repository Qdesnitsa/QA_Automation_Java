package by.it_academy.dom.model;

import java.util.List;

public class Journal {
    private String title;
    private Contact contact;
    private List<Article> articles;

    public Journal() {}

    public Journal(String title, Contact contact, List<Article> articles) {
        this.title = title;
        this.contact = contact;
        this.articles = articles;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                " title='" + title + '\'' +
                ", \ncontact=" + contact +
                ", \narticles=" + articles +
                "}";
    }
}
