package br.com.alura.auction.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Auction {

	private String description;
	private List<Bid> bids;

	public Auction(String description) {
		this.description = description;
		this.bids = new ArrayList<Bid>();
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
		int total = 0;

		for (Bid bid : bids) {
			if (bid.getUser().equals(user))
				total++;
		}

		return total;
	}

	private Bid lastGivenBid() {
		return bids.get(bids.size() - 1);
	}

	public void doubleBid(User user) {
		Bid lastBid = null;

		for (Bid bid : bids) {
			if (bid.getUser().equals(user))
				lastBid = bid;
		}

		propose(new Bid(user, lastBid.getValue() * 2));
	}

	public String getDescription() {
		return description;
	}

	public List<Bid> getBids() {
		return Collections.unmodifiableList(bids);
	}

}
