package by.it_academy.dom.model;

import java.util.List;
import java.util.Objects;

public class Article {
    private String id;
    private String title;
    private String author;
    private String url;
    private List<String> hotkeys;

    public Article() {}

    public Article(String id, String title, String author, String url, List<String> hotkeys) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.url = url;
        this.hotkeys = hotkeys;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getHotkeys() {
        return hotkeys;
    }

    public void setHotkeys(List<String> hotkeys) {
        this.hotkeys = hotkeys;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return id == article.id && Objects.equals(title, article.title) && Objects.equals(author, article.author) &&
                Objects.equals(url, article.url) && Objects.equals(hotkeys, article.hotkeys);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, url, hotkeys);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                " id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", url='" + url + '\'' +
                ", hotkeys=" + hotkeys +
                "}";
    }
}
