package com.example.vote.dao;

import com.example.vote.dto.VoteRequest;
import com.example.vote.model.Vote;

import java.util.List;

public interface VoteDao {

    List<Vote> getAllVotes();

    Vote getVoteById(Integer voteId);

    Integer createVote(VoteRequest voteRequest);

    void updateVote(Integer voteId, VoteRequest voteRequest);

    void deleteVoteById(Integer bookId);
}
