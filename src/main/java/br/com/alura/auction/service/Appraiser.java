package br.com.alura.auction.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.alura.auction.domain.Auction;
import br.com.alura.auction.domain.Bid;

public class Appraiser {

	private double largestOfAll = Double.NEGATIVE_INFINITY;
	private double lowestOfAll = Double.POSITIVE_INFINITY;
	private double average = 0;
	private List<Bid> largest;

	public void evaluate(Auction auction) {

		double total = 0;

		if (auction.getBids().size() == 0)
			throw new RuntimeException("It's not possible to evaluate an auction without bids.");

		for (Bid bid : auction.getBids()) {

			if (bid.getValue() > largestOfAll) {
				largestOfAll = bid.getValue();
			}
			if (bid.getValue() < lowestOfAll) {
				lowestOfAll = bid.getValue();
			}
			total += bid.getValue();
		}

		average = total / auction.getBids().size();

		largest = new ArrayList<Bid>(auction.getBids());

		Collections.sort(largest, new Comparator<Bid>() {

			public int compare(Bid bid1, Bid bid2) {
				if (bid1.getValue() < bid2.getValue())
					return 1;
				if (bid1.getValue() > bid2.getValue())
					return -1;
				return 0;
			}
		});

		largest = largest.subList(0, largest.size() > 3 ? 3 : largest.size());
	}

	public List<Bid> getThreeLargest() {
		return largest;
	}

	public double getLargestBid() {
		return largestOfAll;
	}

	public double getLowestBid() {
		return lowestOfAll;
	}

	public double getAverageBid() {
		return average;
	}

}
