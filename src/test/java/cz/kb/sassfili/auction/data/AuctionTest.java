package cz.kb.sassfili.auction.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuctionTest {

    final int TEST_NOMINAL_VALUE = 100;
    final int TEST_BID_VALUE = 10;

    @Test
    void auction() {
        Auction testAuction = new Auction(TEST_NOMINAL_VALUE, TEST_BID_VALUE);
        assert(testAuction.nominalValue == TEST_NOMINAL_VALUE);
        assert(testAuction.bidValue == TEST_BID_VALUE);
    }

    @Test
    void isWinning() {
        Auction testAuction = new Auction(TEST_NOMINAL_VALUE, TEST_BID_VALUE);
        Person testPerson1 = new Person("testPerson1");
        Person testPerson2 = new Person("testPerson2");
        Bid testBid1 = new Bid(testPerson1);
        Bid testBid2 = new Bid(testPerson2);

        assert(!testAuction.isWinning(testPerson1));
        assert(!testAuction.isWinning(testPerson2));
        testAuction.add(testBid1);
        assert(testAuction.isWinning(testPerson1));
        assert(!testAuction.isWinning(testPerson2));
        testAuction.add(testBid2);
        assert(!testAuction.isWinning(testPerson1));
        assert(testAuction.isWinning(testPerson2));
        testAuction.add(testBid2);
        assert(!testAuction.isWinning(testPerson1));
        assert(testAuction.isWinning(testPerson2));
    }

    @Test
    void getWinningBid() {
        Auction testAuction = new Auction(TEST_NOMINAL_VALUE, TEST_BID_VALUE);
        Bid testBid1 = new Bid(new Person("testPerson1"));
        Bid testBid2 = new Bid(new Person("testPerson1"));

        assert(testAuction.getWinningBid().isEmpty());
        testAuction.add(testBid1);
        assert(testAuction.getWinningBid().isPresent() && testAuction.getWinningBid().get().equals(testBid1));
        testAuction.add(testBid2);
        assert(testAuction.getWinningBid().isPresent() && testAuction.getWinningBid().get().equals(testBid2));
        testAuction.add(testBid2);
        assert(testAuction.getWinningBid().isPresent() && testAuction.getWinningBid().get().equals(testBid2));
    }

    @Test
    void getCurrentValue() {
        Auction testAuction = new Auction(TEST_NOMINAL_VALUE, TEST_BID_VALUE);
        Bid testBid1 = new Bid(new Person("testPerson1"));
        Bid testBid2 = new Bid(new Person("testPerson1"));

        for(int i = 1; i <= 10; i++){
            testAuction.add(testBid1);
            assert(testAuction.getCurrentValue() == TEST_NOMINAL_VALUE + i * TEST_BID_VALUE);
        }

        testAuction = new Auction(TEST_NOMINAL_VALUE, TEST_BID_VALUE);

        for(int i = 1; i <= 10; i++){
            testAuction.add(testBid2);
            assert(testAuction.getCurrentValue() == TEST_NOMINAL_VALUE + i * TEST_BID_VALUE);
        }

        testAuction = new Auction(TEST_NOMINAL_VALUE, TEST_BID_VALUE);


        for(int i = 1; i <= 10; i++){
            if(i % 2 == 0)
                testAuction.add(testBid1);
            else
                testAuction.add(testBid2);
            assert(testAuction.getCurrentValue() == TEST_NOMINAL_VALUE + i * TEST_BID_VALUE);
        }
    }
}