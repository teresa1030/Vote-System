package com.example.vote.controller;

import com.example.vote.dto.EventRequest;
import com.example.vote.dto.ItemRequest;
import com.example.vote.dto.VoteRequest;
import com.example.vote.model.Vote;
import com.example.vote.model.Items;
import com.example.vote.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class VoteController {

    @Autowired
    private VoteService voteService;

    @RequestMapping("/api/votes")
    public ResponseEntity<List<Vote>> allVotes() {
        List<Vote> voteList = voteService.getAllVotes();

        if (voteList != null) {
            return ResponseEntity.status(HttpStatus.OK).body(voteList);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/api/votes/{voteId}")
    public ResponseEntity<Vote> getVote(@PathVariable Integer voteId) {
        Vote vote = voteService.getVoteById(voteId);

        System.out.println(voteId);
        if (vote != null) {
            return ResponseEntity.status(HttpStatus.OK).body(vote);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @RequestMapping("/api/votes/{voteId}/items")
    public ResponseEntity<List<Items>> getItems(@PathVariable Integer voteId) {
        List<Items> itemList = voteService.getItemsById(voteId);
        //System.out.println(itemList);
        if (itemList != null) {
            return ResponseEntity.status(HttpStatus.OK).body(itemList);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

//    @PostMapping("/api/votes")
//    public ResponseEntity<Vote> createVote(@RequestBody VoteRequest voteRequest) {
//        Integer voteId = voteService.createVote(voteRequest);
//
//        Vote vote = voteService.getVoteById(voteId);
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(vote);
//    }
    @PostMapping("/api/votes")
    public ResponseEntity<Vote> createVote(@RequestBody EventRequest eventRequest) {
        System.out.println(eventRequest);
        VoteRequest voteRequest = eventRequest.getVoteRequest();
        List<ItemRequest> itemRequests = eventRequest.getItemRequests();

        Integer voteId = voteService.createVote(voteRequest);

        List<Integer> items = new ArrayList<>();
        for (ItemRequest itemRequest : itemRequests) {
            Integer itemId = voteService.createItems(voteId, itemRequest);
            items.add(itemId);
        }
        Vote vote = voteService.getVoteById(voteId);
        System.out.println(items);
        return ResponseEntity.status(HttpStatus.CREATED).body(vote);
    }

    @PutMapping("/api/votes/{voteId}")
    public ResponseEntity<Vote> updateVote(@PathVariable Integer voteId,
                                           @RequestBody VoteRequest voteRequest) {

        Vote vote = voteService.getVoteById(voteId);

        if (vote == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        voteService.updateVote(voteId, voteRequest);

        Vote updateVote = voteService.getVoteById(voteId);

        return ResponseEntity.status(HttpStatus.OK).body(updateVote);
    }
    @PutMapping("/api/items/{itemId}")
    public ResponseEntity<Items> updateItem(@PathVariable Integer itemId,
                                           @RequestBody ItemRequest itemRequest) {

        Items item = voteService.getItemById(itemId);

        if (item == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        voteService.updateItem(itemId, itemRequest);

        Items updateItem = voteService.getItemById(itemId);

        return ResponseEntity.status(HttpStatus.OK).body(updateItem);
    }

    @PutMapping("/api/votes/{voteId}/items")
    public ResponseEntity<List<Items>> updateItemVotes(@PathVariable Integer voteId, @RequestBody List<Integer> itemIds) {
        for (Integer itemId : itemIds) {
            voteService.updateItemVotes(itemId);
        }
        List<Items> itemList = voteService.getItemsById(voteId);
        return ResponseEntity.status(HttpStatus.OK).body(itemList);
    }


    @DeleteMapping("/api/votes/{voteId}")
    public ResponseEntity<?> deleteVote(@PathVariable Integer voteId) {
        voteService.deleteItemsById(voteId);
        voteService.deleteVoteById(voteId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
