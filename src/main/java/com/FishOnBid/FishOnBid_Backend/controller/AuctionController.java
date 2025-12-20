package com.FishOnBid.FishOnBid_Backend.controller;

import com.FishOnBid.FishOnBid_Backend.entity.Auction;
import com.FishOnBid.FishOnBid_Backend.entity.Bid;
import com.FishOnBid.FishOnBid_Backend.service.AuctionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auctions")
@RequiredArgsConstructor
@CrossOrigin
public class AuctionController {

    private final AuctionService auctionService;

    // 🔹 Close auction & select winner
    @PostMapping("/{id}/close")
    public Bid closeAuction(@PathVariable Long id) {
        return auctionService.closeAuctionAndSelectWinner(id);
    }

    // 🔹 Get winner of auction
    @GetMapping("/{id}/winner")
    public Bid getWinner(@PathVariable Long id) {
        return auctionService.getWinningBid(id);
    }

    // 🔹 Get full bid history
    @GetMapping("/{id}/bids")
    public List<Bid> getBidHistory(@PathVariable Long id) {
        return auctionService.getBidHistory(id);
    }

    // 🔹 Get auction summary (auction + winner + bids)
    @GetMapping("/{id}/summary")
    public Auction getAuctionSummary(@PathVariable Long id) {
        return auctionService.getAuctionById(id);
    }
}
