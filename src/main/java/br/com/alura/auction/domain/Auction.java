package br.com.alura.auction.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Auction {

    private String description;
    private List<Bid> bids;

    public Auction(String description) {
        this.description = description;
        this.bids = new ArrayList<>();
    }

    public void propose(Bid bid) {
        if (bids.isEmpty() || canBid(bid.getUser())) {
            bids.add(bid);
        }
    }

    private boolean canBid(User user) {
        return !lastGivenBid().getUser().equals(user) && ammountOfBidsDoes(user) < 5;
    }

    private int ammountOfBidsDoes(User user) {
        return (int) bids.stream().filter(bid -> bid.getUser().equals(user)).count();
    }

    private Bid lastGivenBid() {
        return bids.get(bids.size() - 1);
    }

    public void doubleBid(User user) {
        Bid lastBid = null;

        for (Bid bid : bids) {
            if (bid.getUser().equals(user)) {
                lastBid = bid;
            }
        }

        propose(new Bid(user, (lastBid != null ? lastBid.getValue() : 0) * 2));
    }

    @SuppressWarnings("unused")
    public String getDescription() {
        return description;
    }

    public List<Bid> getBids() {
        return Collections.unmodifiableList(bids);
    }
}