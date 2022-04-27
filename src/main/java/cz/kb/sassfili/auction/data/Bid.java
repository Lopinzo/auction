package cz.kb.sassfili.auction.data;

import java.util.Objects;

public class Bid {
    final Person person;

    public Bid(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bid bid = (Bid) o;
        return person.equals(bid.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person);
    }
}
