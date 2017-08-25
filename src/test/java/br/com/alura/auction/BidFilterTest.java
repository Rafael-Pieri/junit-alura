package br.com.alura.auction;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

import br.com.alura.auction.domain.Bid;
import br.com.alura.auction.domain.User;
import br.com.alura.auction.service.BidFilter;

public class BidFilterTest {

    @Test
    public void shouldSelectBidsBetween1000And3000() {
        User john = new User("John");

        BidFilter bidFilter = new BidFilter();
        
        List<Bid> result = bidFilter.filter(Arrays.asList(new Bid(john, 2000), 
										                  new Bid(john, 1000), 
										                  new Bid(john, 3000), 
										                  new Bid(john, 800)));

        assertEquals(1, result.size());
        assertEquals(2000, result.get(0).getValue(), 0.00001);
    }

    @Test
    public void shouldSelectBidsBetween500And700() {
        User john = new User("John");

        BidFilter bidFilter = new BidFilter();
        
        List<Bid> result = bidFilter.filter(Arrays.asList(new Bid(john, 600), 
										                  new Bid(john, 500), 
										                  new Bid(john, 700), 
										                  new Bid(john, 800)));

        assertEquals(1, result.size());
        assertEquals(600, result.get(0).getValue(), 0.00001);
    }
    
    @Test
    public void shouldSelectBidsLargestThan5000() {
        User john = new User("John");

        BidFilter bidFilter = new BidFilter();
        
        List<Bid> result = bidFilter.filter(Arrays.asList(new Bid(john, 4000), 
										                  new Bid(john, 5000), 
										                  new Bid(john, 6000), 
										                  new Bid(john, 3500)));

        assertEquals(1, result.size());
        assertEquals(6000, result.get(0).getValue(), 0.00001);
    }
    
    @Test
    public void shouldEliminateBidsLowestThan500() {
        User john = new User("John");

        BidFilter bidFilter = new BidFilter();
        
        List<Bid> result = bidFilter.filter(Arrays.asList(new Bid(john, 100), 
											              new Bid(john, 200),
											              new Bid(john, 300), 
											              new Bid(john, 400)));

        assertEquals(0, result.size());
    }

    @Test
    public void shouldEliminateBidsBetween3000And5000() {
        User john = new User("John");

        BidFilter bidFilter = new BidFilter();
        
        List<Bid> result = bidFilter.filter(Arrays.asList(new Bid(john, 3000),
										        		  new Bid(john, 4000), 
										        		  new Bid(john, 5000)));

        assertEquals(0, result.size());
    }
}
