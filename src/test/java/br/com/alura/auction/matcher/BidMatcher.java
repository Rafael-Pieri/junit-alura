package br.com.alura.auction.matcher;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import br.com.alura.auction.domain.Auction;
import br.com.alura.auction.domain.Bid;

public class BidMatcher extends TypeSafeMatcher<Auction> {

	private final Bid bid;

	public BidMatcher(Bid bid) {
		this.bid = bid;
	}

	public void describeTo(Description description) {
		description.appendText("Auction with Bid " + bid.getValue());
	}

	@Override
	protected boolean matchesSafely(Auction auction) {
		return auction.getBids().contains(bid);
	}

	public static Matcher<Auction> hasABid(Bid bid) {
		return new BidMatcher(bid);
	}
}