package com.example.vote.service;

import com.example.vote.dto.VoteRequest;
import com.example.vote.model.Vote;

import java.util.List;

public interface VoteService {

    List<Vote> getAllVotes();

    Vote getVoteById(Integer voteId);

    Integer createVote(VoteRequest voteRequest);

    void updateVote(Integer voteId, VoteRequest voteRequest);

    void deleteVoteById(Integer voteId);

}
