package com.example.vote.controller;

import com.example.vote.dto.VoteRequest;
import com.example.vote.model.Vote;
import com.example.vote.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/api/votes")
    public ResponseEntity<Vote> createVote(@RequestBody VoteRequest voteRequest) {
        Integer voteId = voteService.createVote(voteRequest);

        Vote vote = voteService.getVoteById(voteId);

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

    @DeleteMapping("/api/votes/{voteId}")
    public ResponseEntity<?> deleteVote(@PathVariable Integer voteId) {
        voteService.deleteVoteById(voteId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
