package cz.kb.sassfili.auction.controllers;

import cz.kb.sassfili.auction.data.Auction;
import cz.kb.sassfili.auction.data.Bid;
import cz.kb.sassfili.auction.data.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

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

    @PostMapping
    String post(@RequestParam String nameInput, Model model){
        if(nameInput == null || nameInput == ""){
            model.addAttribute("userName", "insert username!");
            model.addAttribute("currentValue", auction.getCurrentValue());
            model.addAttribute("amIWinning", "Ne");
        }
        else {
            Person bidder = new Person(nameInput);
            auction.add(new Bid(bidder));
            model.addAttribute("userName", nameInput);
            model.addAttribute("currentValue", auction.getCurrentValue());
            model.addAttribute("amIWinning", auction.isWinning(bidder) ? "Ano" : "Ne");
        }
        return "index";
    }
}
