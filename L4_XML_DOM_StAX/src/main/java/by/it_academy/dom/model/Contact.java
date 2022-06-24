package by.it_academy.dom.model;

import java.util.Objects;

public class Contact {
    private String address;
    private String tel;
    private String email;
    private String url;

    public Contact() {}

    public Contact(String address, String tel, String email, String url) {
        this.address = address;
        this.tel = tel;
        this.email = email;
        this.url = url;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(address, contact.address) && Objects.equals(tel, contact.tel) &&
                Objects.equals(email, contact.email) && Objects.equals(url, contact.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, tel, email, url);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                " address='" + address + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}

