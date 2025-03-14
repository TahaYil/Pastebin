package com.taa.okullab.dao;

import com.taa.okullab.entity.Pastebin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface PastebinDao extends CrudRepository<Pastebin, Long> {

    public Pastebin findByHash(String hash);
    public List<Pastebin> findAll();
}
