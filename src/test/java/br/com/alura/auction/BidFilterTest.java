package br.com.alura.auction;

import static org.junit.Assert.assertEquals;

import br.com.alura.auction.domain.Bid;
import br.com.alura.auction.domain.User;
import br.com.alura.auction.service.BidFilter;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class BidFilterTest {

    @Test
    public void shouldSelectBidsBetween1000And3000() {
        User john = new User("John");

        BidFilter bidFilter = new BidFilter();

        List<Bid> result = bidFilter.filter(Arrays.asList(new Bid(john, 2000d),
            new Bid(john, 1000d),
            new Bid(john, 3000d),
            new Bid(john, 800d)));

        assertEquals(1, result.size());
        assertEquals(2000, result.get(0).getValue(), 0.00001);
    }

    @Test
    public void shouldSelectBidsBetween500And700() {
        User john = new User("John");

        BidFilter bidFilter = new BidFilter();

        List<Bid> result = bidFilter.filter(Arrays.asList(new Bid(john, 600d),
            new Bid(john, 500d),
            new Bid(john, 700d),
            new Bid(john, 800d)));

        assertEquals(1, result.size());
        assertEquals(600, result.get(0).getValue(), 0.00001);
    }

    @Test
    public void shouldSelectBidsHighestThan5000() {
        User john = new User("John");

        BidFilter bidFilter = new BidFilter();

        List<Bid> result = bidFilter.filter(Arrays.asList(new Bid(john, 4000d),
            new Bid(john, 5000d),
            new Bid(john, 6000d),
            new Bid(john, 3500d)));

        assertEquals(1, result.size());
        assertEquals(6000, result.get(0).getValue(), 0.00001);
    }

    @Test
    public void shouldEliminateBidsLowestThan500() {
        User john = new User("John");

        BidFilter bidFilter = new BidFilter();

        List<Bid> result = bidFilter.filter(Arrays.asList(new Bid(john, 100d),
            new Bid(john, 200d),
            new Bid(john, 300d),
            new Bid(john, 400d)));

        assertEquals(0, result.size());
    }

    @Test
    public void shouldEliminateBidsBetween3000And5000() {
        User john = new User("John");

        BidFilter bidFilter = new BidFilter();

        List<Bid> result = bidFilter.filter(Arrays.asList(new Bid(john, 3000d),
            new Bid(john, 4000d),
            new Bid(john, 5000d)));

        assertEquals(0, result.size());
    }
}