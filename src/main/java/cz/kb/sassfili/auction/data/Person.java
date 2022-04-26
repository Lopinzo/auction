package cz.kb.sassfili.auction.data;

import java.util.Objects;

public class Person {
    final String username;

    public Person(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return username.equals(person.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}
