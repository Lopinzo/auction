package cz.kb.sassfili.auction.controllers;

import cz.kb.sassfili.auction.data.Auction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AuctionController {
    private final Auction auction;

    @Autowired
    public AuctionController(Auction auction) {
        this.auction = auction;
    }
}
