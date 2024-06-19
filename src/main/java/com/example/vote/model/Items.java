package com.example.vote.model;

public class Items {
    private Integer itemId;
    private String itemTitle;
    private Integer voteId;
    private Integer votes;

    public Integer getItemId() {
        return itemId;
    }
    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemTitle() {
        return itemTitle;
    }
    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public Integer getVoteId() {
        return voteId;
    }
    public void setVoteId(Integer voteId) {
        this.voteId = voteId;
    }

    public Integer getVotes() {
        return votes;
    }
    public void setVotes(Integer votes) {
        this.votes = votes;
    }
}
