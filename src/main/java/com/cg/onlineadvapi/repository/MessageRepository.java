package com.cg.onlineadvapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlineadvapi.domain.Message;
@Repository
public interface MessageRepository extends JpaRepository<Message, Integer>{

	Message findBySenderId(Integer senderId);

	List<Message> findByAdvertiseId(Integer advertiseId);

	Message findByMessageId(Integer messageId);

	
}
