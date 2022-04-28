package cz.kb.sassfili.auction.data;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class Auction {

    public List<Bid> getBids() {
        return bids;
    }

    private final List<Bid> bids;
    final int nominalValue;
    int currentValue;
    final int bidValue;

    /**
     * @param nominalValue is starting value of auction
     * @param bidValue is amount of what will be the current price increased with each bid
     */
    public Auction(int nominalValue, int bidValue) {
        this.nominalValue = nominalValue;
        this.currentValue = nominalValue;
        this.bidValue = bidValue;
        this.bids = new ArrayList<>();
    }

    /**
     * implicit constructor of Auction
     * nominal value is set to 100
     * bid value is set to 10
      */
    public Auction() {
        this.nominalValue = 100;
        this.currentValue = nominalValue;
        this.bidValue = 10;
        this.bids = new ArrayList<>();
    }

    /**
     * @param bid adds this bid to auction
     */
    public void add(Bid bid) {
        bids.add(bid);
        currentValue += bidValue;
    }

    /**
     * @param person will be compared to last bidder
     * @return true if last bidder is person, else false
     */
    public boolean isWinning(Person person){
        return !bids.isEmpty() && bids.get(bids.size() - 1).person.equals(person);
    }

    /**
     * @return optional of bidder who is winning auction or Optional.empty() if auction has no bidders yet
     */
    public Optional<Bid> getWinningBid(){
        return bids.isEmpty() ?
                Optional.empty() :
                Optional.of(bids.get(bids.size() - 1));
    }

    /**
     * @return price of winning bid
     */
    public int getCurrentValue() {
        return currentValue;
    }
}
