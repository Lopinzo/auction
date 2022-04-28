package cz.kb.sassfili.auction.controllers;

import cz.kb.sassfili.auction.data.Auction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuctionController {
    private final Auction auction;

    @Autowired
    public AuctionController(Auction auction) {
        this.auction = auction;
    }

    @GetMapping
    String getAuction(Model model){
        model.addAttribute("currentValue", auction.getCurrentValue());
        model.addAttribute("amIWinning", "Ne");
        return "index";
    }
}
