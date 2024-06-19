package com.example.vote.model;

public class Vote {

    private Integer voteId;
    private String voteTitle;
    private String content;
    private String imageUrl;

    public Integer getVoteId() {
        return voteId;
    }
    public void setVoteId(Integer voteId) {
        this.voteId = voteId;
    }

    public String getVoteTitle() {
        return voteTitle;
    }
    public void setVoteTitle(String voteTitle) {
        this.voteTitle = voteTitle;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
