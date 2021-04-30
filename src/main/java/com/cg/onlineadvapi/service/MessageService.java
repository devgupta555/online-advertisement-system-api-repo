package com.cg.onlineadvapi.service;

import java.util.List;

import com.cg.onlineadvapi.domain.Message;

public interface MessageService {

	Message sendMessage(Message message);

	Message messagesSentByUser(Integer senderId);

	void deleteMessageByMessageId(Integer messageId);

	List<Message> showAllMessageByUser();

	List<Message> allMessageSentOnAdvertise(Integer advertiseId);

}
