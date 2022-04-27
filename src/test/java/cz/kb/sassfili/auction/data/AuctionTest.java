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
    }

    @Test
    void getWinningBid() {
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
    }
}