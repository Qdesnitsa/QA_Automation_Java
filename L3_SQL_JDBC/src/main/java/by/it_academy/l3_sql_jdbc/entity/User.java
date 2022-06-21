package by.it_academy.l3_sql_jdbc.entity;

import java.util.Objects;

public class User {
    private int id;
    private String name;
    private String address;
    private String email;
    private String password;

    private User() {}

    public User(int id, String name, String address, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() { return password; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(name, user.name) &&
                Objects.equals(address, user.address) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, email);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'';

    }

    public static class Builder {
        private final User newUser;

        public Builder() {
            newUser = new User();
        }

        public Builder setId(int id) {
            newUser.id = id;
            return this;
        }

        public Builder setEmail(String email) {
            newUser.email = email;
            return this;
        }

        public Builder setName(String name) {
            newUser.name = name;
            return this;
        }

        public Builder setAddress(String address) {
            newUser.address = address;
            return this;
        }

        public Builder setPassword(String password) {
            newUser.password = password;
            return this;
        }

        public User build() {
            return newUser;
        }
    }
}
