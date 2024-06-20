package com.example.vote.rowmapper;

import com.example.vote.model.Items;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemRowMapper implements RowMapper<Items> {
    @Override
    public Items mapRow(ResultSet resultSet, int i) throws SQLException {

        Items items = new Items();

        items.setItemId(resultSet.getInt("item_id"));
        items.setVoteId(resultSet.getInt("vote_id"));
        items.setItemTitle(resultSet.getString("title"));
        items.setVotes(resultSet.getInt("votes"));

        return items;
    }
}
