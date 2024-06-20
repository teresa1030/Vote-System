package com.example.vote.dao;

import com.example.vote.dto.ItemRequest;
import com.example.vote.dto.VoteRequest;
import com.example.vote.model.Items;
import com.example.vote.model.Vote;

import java.util.List;

public interface VoteDao {

    List<Vote> getAllVotes();

    Vote getVoteById(Integer voteId);
    List<Items> getItemsById(Integer voteId);
    Items getItemById(Integer itemId);

    Integer createVote(VoteRequest voteRequest);
    Integer createItems(Integer voteId, ItemRequest itemRequest);

    void updateVote(Integer voteId, VoteRequest voteRequest);
    void updateItem(Integer itemId, ItemRequest itemRequest);
    void updateItemVotes(Integer itemId);

    void deleteVoteById(Integer bookId);
    void deleteItemsById(Integer bookId);
}
