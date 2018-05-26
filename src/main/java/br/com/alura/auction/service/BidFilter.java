package br.com.alura.auction.service;

import br.com.alura.auction.domain.Bid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BidFilter {

    public List<Bid> filter(List<Bid> bids) {
        return bids.stream().filter(bid -> (bid.getValue() > 1000 && bid.getValue() < 3000) ||
            (bid.getValue() > 500 && bid.getValue() < 700) ||
            (bid.getValue() > 5000)).collect(Collectors.toCollection(ArrayList::new));
    }
}