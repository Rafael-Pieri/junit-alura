package br.com.alura.auction.matcher;

import br.com.alura.auction.domain.Auction;
import br.com.alura.auction.domain.Bid;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class BidMatcher extends TypeSafeMatcher<Auction> {

    private final Bid bid;

    private BidMatcher(Bid bid) {
        this.bid = bid;
    }

    public static Matcher<Auction> hasABid(Bid bid) {
        return new BidMatcher(bid);
    }

    public void describeTo(Description description) {
        description.appendText("Auction with Bid " + bid.getValue());
    }

    @Override
    protected boolean matchesSafely(Auction auction) {
        return auction.getBids().contains(bid);
    }
}