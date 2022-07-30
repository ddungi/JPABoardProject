package com.bank.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.domain.Reply;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Integer>{

}
