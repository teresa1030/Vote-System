package com.example.vote.dao.impl;

import com.example.vote.dao.VoteDao;
import com.example.vote.dto.ItemRequest;
import com.example.vote.dto.VoteRequest;
import com.example.vote.model.Items;
import com.example.vote.model.Vote;
import com.example.vote.rowmapper.ItemRowMapper;
import com.example.vote.rowmapper.VoteRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class VoteDaoImpl implements VoteDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Vote> getAllVotes() {
        String sql = "SELECT *" +
                "FROM vote ";
//        String sql = "SELECT vote_id, title, image_url, content" +
//                "FROM vote "; 不知道為什麼不行vote_id也符合命名規範

        Map<String, Object> map = new HashMap<>();

        List<Vote> voteList = namedParameterJdbcTemplate.query(sql, map, new VoteRowMapper());

        if (voteList.size() > 0) {
            return voteList;
        } else {
            return null;
        }
    }

    @Override
    public Vote getVoteById(Integer voteId) {
//        String sql = "SELECT book_id, title, author, image_url, price, published_date, created_date, last_modified_date " +
//                "FROM book WHERE book_id = :bookId";
        String sql = "SELECT *" +
                "FROM vote WHERE vote_id = :voteId";

        Map<String, Object> map = new HashMap<>();
        map.put("voteId", voteId);

        List<Vote> voteList = namedParameterJdbcTemplate.query(sql, map, new VoteRowMapper());

        if (voteList.size() > 0) {
            return voteList.get(0);
        } else {
            return null;
        }
    }
    @Override
    public List<Items> getItemsById(Integer voteId) {
        String sql = "SELECT *" +
                "FROM voteItems WHERE vote_id = :voteId ";

        Map<String, Object> map = new HashMap<>();
        map.put("voteId", voteId);

        List<Items> itemList = namedParameterJdbcTemplate.query(sql, map, new ItemRowMapper());

        if (itemList.size() > 0) {
            return itemList;
        } else {
            return null;
        }
    }
    @Override
    public Items getItemById(Integer itemId) {
        String sql = "SELECT *" +
                "FROM voteItems WHERE item_id = :itemId";

        Map<String, Object> map = new HashMap<>();
        map.put("itemId", itemId);

        List<Items> itemList = namedParameterJdbcTemplate.query(sql, map, new ItemRowMapper());

        if (itemList.size() > 0) {
            return itemList.get(0);
        } else {
            return null;
        }
    }
    @Override
    public Integer createVote(VoteRequest voteRequest) {
        String sql = "INSERT INTO vote(title, content, image_url) " +
                "VALUES (:voteTitle, :content, :imageUrl)";

        Map<String, Object> map = new HashMap<>();
        map.put("voteTitle", voteRequest.getVoteTitle());
        map.put("content", voteRequest.getContent());
        map.put("imageUrl", voteRequest.getImageUrl());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);

        int voteId = keyHolder.getKey().intValue();

        return voteId;
    }
    public Integer createItems(Integer voteId, ItemRequest itemRequest) {
        String sql = "INSERT INTO voteItems(title, vote_id, votes) " +
                "VALUES (:itemTitle, :voteId, :votes)";

        Map<String, Object> map = new HashMap<>();
        map.put("itemTitle", itemRequest.getItemTitle());
        map.put("voteId", voteId);
        map.put("votes", 0);

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);

        int itemId = keyHolder.getKey().intValue();

        return itemId;
    }


    @Override
    public void updateVote(Integer voteId, VoteRequest voteRequest) {
        String sql = "UPDATE vote SET title = :voteTitle, content = :content, image_url = :imageUrl " +
                " WHERE vote_id = :voteId";

        Map<String, Object> map = new HashMap<>();
        map.put("voteId", voteId);
        map.put("voteTitle", voteRequest.getVoteTitle());
        map.put("content", voteRequest.getContent());
        map.put("imageUrl", voteRequest.getImageUrl());
        System.out.println(map);

        namedParameterJdbcTemplate.update(sql, map);
    }
    @Override
    public void updateItem(Integer itemId, ItemRequest itemRequest) {
        String sql = "UPDATE voteItems SET title = :itemTitle " +
                " WHERE item_id = :itemId";

        Map<String, Object> map = new HashMap<>();
        map.put("itemId", itemId);
        map.put("itemTitle", itemRequest.getItemTitle());
        System.out.println(map);

        namedParameterJdbcTemplate.update(sql, map);
    }

    @Override
    public void updateItemVotes(Integer itemId) {
        String sql = "UPDATE voteItems SET votes = votes + 1 WHERE item_id = :itemId";

        Map<String, Object> map = new HashMap<>();
        map.put("itemId", itemId);

        namedParameterJdbcTemplate.update(sql, map);
    }

    @Override
    public void deleteVoteById(Integer voteId) {
        String sql = "DELETE FROM vote WHERE vote_id = :voteId ";

        Map<String, Object> map = new HashMap<>();
        map.put("voteId", voteId);

        namedParameterJdbcTemplate.update(sql, map);
    }
    @Override
    public void deleteItemsById(Integer voteId) {
        String sql = "DELETE FROM voteItems WHERE vote_id = :voteId ";

        Map<String, Object> map = new HashMap<>();
        map.put("voteId", voteId);

        namedParameterJdbcTemplate.update(sql, map);
    }

}
