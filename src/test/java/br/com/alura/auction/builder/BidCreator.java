package br.com.alura.auction.builder;

import br.com.alura.auction.domain.Auction;
import br.com.alura.auction.domain.Bid;
import br.com.alura.auction.domain.User;

public class BidCreator {

    private Auction auction;

    public BidCreator() {}

    public BidCreator to(String description) {
        this.auction = new Auction(description);
        return this;
    }

    public BidCreator bid(User user, double value) {
        auction.propose(new Bid(user, value));
        return this;
    }

    public Auction build() {
        return auction;
    }
}