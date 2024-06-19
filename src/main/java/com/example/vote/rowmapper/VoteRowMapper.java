package com.example.vote.rowmapper;

import com.example.vote.model.Vote;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VoteRowMapper implements RowMapper<Vote> {

    @Override
    public Vote mapRow(ResultSet resultSet, int i) throws SQLException {

        Vote vote = new Vote();

        vote.setVoteId(resultSet.getInt("vote_id"));
        vote.setVoteTitle(resultSet.getString("title"));
        vote.setImageUrl(resultSet.getString("image_url"));
        vote.setContent(resultSet.getString("content"));

        return vote;
    }
}
