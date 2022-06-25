package by.it_academy.stax.model;

import java.util.List;
import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Journal journal = (Journal) o;
        return Objects.equals(title, journal.title) && Objects.equals(contact, journal.contact) &&
                Objects.equals(articles, journal.articles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, contact, articles);
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
