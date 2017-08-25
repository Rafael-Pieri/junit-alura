package br.com.alura.auction;

import static br.com.alura.auction.matcher.BidMatcher.hasABid;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.alura.auction.builder.CreaterOfBid;
import br.com.alura.auction.domain.Auction;
import br.com.alura.auction.domain.Bid;
import br.com.alura.auction.domain.User;

public class BidTest {

	@Test
	public void shouldReceiveABid() {
		Auction auction = new CreaterOfBid().to("Macbook Pro 15")
											.build();

		assertEquals(0, auction.getBids().size(), 0.00001);

		Bid bid = new Bid(new User("Steve Jobs"), 2000);
		auction.propose(bid);

		assertThat(auction.getBids().size(), equalTo(1));
		assertThat(auction, hasABid(bid));
	}

	@Test
	public void shouldReceiveMultipleBids() {
		Auction auction = new CreaterOfBid().to("Macbook Pro 15")
											.bid(new User("Steve Jobs"), 2000)
											.bid(new User("Steve Wozniak"), 3000)
											.build();

		assertEquals(2, auction.getBids().size());
		assertEquals(2000.0, auction.getBids().get(0).getValue(), 0.00001);
		assertEquals(3000.0, auction.getBids().get(1).getValue(), 0.00001);
	}

	@Test
	public void shouldNotAcceptTwoBidsInARowFromTheSameUser() {
		User steveJobs = new User("Steve Jobs");
		
		Auction auction = new CreaterOfBid().to("Macbook Pro 15")
											.bid(steveJobs, 2000.0)
											.bid(steveJobs, 3000.0)
											.build();

		assertEquals(1, auction.getBids().size());
		assertEquals(2000.0, auction.getBids().get(0).getValue(), 0.00001);
	}

	@Test
	public void shouldNotAcceptMoreThan5BidsFromTheSameUser() {
		User steveJobs = new User("Steve Jobs");
		User billGates = new User("Bill Gates");

		Auction auction = new CreaterOfBid().to("Macbook Pro 15")
											.bid(steveJobs, 2000)
											.bid(billGates, 3000)
											.bid(steveJobs, 4000)
											.bid(billGates, 5000)
											.bid(steveJobs, 6000)
											.bid(billGates, 7000)
											.bid(steveJobs, 8000)
											.bid(billGates, 9000)
											.bid(steveJobs, 10000)
											.bid(billGates, 11000)
											.bid(steveJobs, 12000)
											.build();

		assertEquals(10, auction.getBids().size());
		assertEquals(11000.0, auction.getBids().get(auction.getBids().size() - 1).getValue(), 0.00001);
	}

	@Test
	public void shouldDoubleTheValueOfTheLastBid() {
		User steveJobs = new User("Steve Jobs");
		User billGates = new User("Bill Gates");

		Auction auction = new CreaterOfBid().to("Macbook Pro 15")
											.bid(steveJobs, 2000.0)
											.bid(billGates, 3000.0)
											.build();

		auction.doubleBid(steveJobs);

		assertEquals(4000, auction.getBids().get(2).getValue(), 0.00001);
	}

}
