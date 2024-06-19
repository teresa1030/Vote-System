package com.example.vote.service.impl;
import com.example.vote.dao.VoteDao;
import com.example.vote.dto.VoteRequest;
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
    public Integer createVote(VoteRequest voteRequest) {
        return voteDao.createVote(voteRequest);
    }

    @Override
    public void updateVote(Integer voteId, VoteRequest voteRequest) {
        voteDao.updateVote(voteId, voteRequest);
    }

    @Override
    public void deleteVoteById(Integer voteId) {
        voteDao.deleteVoteById(voteId);
    }
}
