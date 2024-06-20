package com.example.vote.dto;

import java.util.List;

public class EventRequest {
    private VoteRequest voteRequest;
    private List<ItemRequest> itemRequests;

    public VoteRequest getVoteRequest() {
        return voteRequest;
    }

    public void setVoteRequest(VoteRequest voteRequest) {
        this.voteRequest = voteRequest;
    }

    public List<ItemRequest> getItemRequests() {
        return itemRequests;
    }

    public void setItemRequests(List<ItemRequest> itemRequests) {
        this.itemRequests = itemRequests;
    }
}
