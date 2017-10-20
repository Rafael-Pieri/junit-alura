package br.com.alura.auction;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.alura.auction.builder.CreaterOfBid;
import br.com.alura.auction.domain.Auction;
import br.com.alura.auction.domain.Bid;
import br.com.alura.auction.domain.User;
import br.com.alura.auction.service.Appraiser;

public class AppraiserTest {
	
	private Appraiser appraiser;
	private User mary;
    private User joshua;
    private User john;
    
    @BeforeClass
    public static void testingBeforeClass() {
      System.out.println("before class");
    }

    @AfterClass
    public static void testingAfterClass() {
      System.out.println("after class");
    }

	@Before
	public void setUp() {
		System.out.println("Inicialize test...");
		this.appraiser = new Appraiser();
        this.john = new User("John");
        this.joshua = new User("Joshua");
        this.mary = new User("Mary");
	}
	
	@After
	public void finalize() {
		System.out.println("end");
	}
	
	@Test
	public void shouldUnderstandBidsInDescendingOrder() {

		Auction auction = new CreaterOfBid().to("New Playstation 3")
					        				.bid(john, 250.0)
					        				.bid(joshua, 300.0)
					        				.bid(mary, 400.0)
					        				.build();
		
		appraiser.evaluate(auction);
		
		assertThat(appraiser.getHighestBid(), equalTo(400.0));
		assertThat(appraiser.getLowestBid(), equalTo(250.0));
	}
	
	@Test
	public void shouldCalculateTheAverage() {
		
		Auction auction = new CreaterOfBid().to("New Playstation 3")
					        				.bid(john, 200.0)
					        				.bid(joshua, 800.0)
					        				.bid(mary, 500.0)
					        				.build();
		
		appraiser.evaluate(auction);
			
		assertThat(appraiser.getAverageBid(), equalTo(500.0));
	}
	
	@Test
	public void shouldUndertandAuctionWithJustOneBid(){
		
		Auction auction = new CreaterOfBid().to("New Playstation 3")
					        				.bid(john, 1000.0)
					        				.build();
		
		appraiser.evaluate(auction);
		
		assertThat(appraiser.getLowestBid(), equalTo(appraiser.getHighestBid()));
	}
	
	@Test
    public void shouldFindTheThreeHighestBids() {
        Auction auction = new CreaterOfBid().to("New Playstation 3")
        									.bid(john, 100.0)
        									.bid(mary, 200.0)
        									.bid(john, 300.0)
        									.bid(mary, 400.0)
        									.build();

        appraiser.evaluate(auction);

        List<Bid> highestBids = appraiser.getThreeHighest();
        
        assertEquals(3, highestBids.size());

		assertThat(highestBids, hasItems(new Bid(mary, 400.0), 
						             	 new Bid(john, 300.0),
						             	 new Bid(mary, 200.0)
        ));    
    }
	
	@Test
	public void shouldFindOnlyTheTwoHighestBids(){
		
		Auction auction = new CreaterOfBid().to("New Playstation 3")
					        				.bid(john,  100.0)
					        				.bid(mary, 200.0)
					        				.build();
		
		appraiser.evaluate(auction);
		
		List<Bid> highestBids = appraiser.getThreeHighest();
		
		assertEquals(2, highestBids.size());

		assertThat(highestBids, hasItems(new Bid(john,  100.0), 
						             	 new Bid(mary, 200.0)
		));
	}
	
	@Test(expected=RuntimeException.class)
	public void shouldNotAllowAppraiserEvaluateAuctionWithoutAnOffer() {
		
	    Auction auction = new CreaterOfBid().to("New Playstation 3")
	    									.build();

	    appraiser.evaluate(auction);
	}
	
	@Test(expected=IllegalArgumentException.class)
    public void shouldRefuseBidsWithAZeroValue() {
        new Bid(new User("John Malcovich"), Double.valueOf(0));
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldRefuseBidsWithNegativeValues() {
        new Bid(new User("John Malcovich"), Double.valueOf(-10));
    }
}
