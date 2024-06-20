package com.example.vote.service.impl;
import com.example.vote.dao.VoteDao;
import com.example.vote.dto.ItemRequest;
import com.example.vote.dto.VoteRequest;
import com.example.vote.model.Items;
import com.example.vote.model.Vote;
import com.example.vote.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class VoteServiceImpl implements VoteService {

    @Autowired
    private VoteDao voteDao;

    @Override
    public List<Vote> getAllVotes() {
        return voteDao.getAllVotes();
    }

    @Override
    public Vote getVoteById(Integer voteId) {
        return voteDao.getVoteById(voteId);
    }
    @Override
    public List<Items> getItemsById(Integer voteId) {
        return voteDao.getItemsById(voteId);
    }
    @Override
    public Items getItemById(Integer itemId) {
        return voteDao.getItemById(itemId);
    }

    @Override
    public Integer createVote(VoteRequest voteRequest) {
        return voteDao.createVote(voteRequest);
    }
    @Override
    public Integer createItems(Integer voteId, ItemRequest itemRequest) {
        return voteDao.createItems(voteId, itemRequest);
    }

    @Override
    public void updateVote(Integer voteId, VoteRequest voteRequest) {
        voteDao.updateVote(voteId, voteRequest);
    }
    @Override
    public void updateItem(Integer itemId, ItemRequest itemRequest) {
        voteDao.updateItem(itemId, itemRequest);
    }
    public void updateItemVotes(Integer itemId) {
        voteDao.updateItemVotes(itemId);
    }

    @Override
    public void deleteVoteById(Integer voteId) {
        voteDao.deleteVoteById(voteId);
    }
    @Override
    public void deleteItemsById(Integer voteId) {
        voteDao.deleteItemsById(voteId);
    }
}
