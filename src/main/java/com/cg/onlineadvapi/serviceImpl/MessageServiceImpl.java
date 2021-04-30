package com.cg.onlineadvapi.serviceImpl;
import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineadvapi.domain.Message;
import com.cg.onlineadvapi.exception.NoMessageException;
import com.cg.onlineadvapi.exception.NonExistingMessagesException;
import com.cg.onlineadvapi.exception.SameSenderException;
import com.cg.onlineadvapi.repository.MessageRepository;
import com.cg.onlineadvapi.service.MessageService;
@Service
public class MessageServiceImpl implements MessageService{

	Logger logger =LoggerFactory.getLogger(MessageServiceImpl.class);
	
	@Autowired
	MessageRepository messageRepository;

	
	@Override
	public Message sendMessage(Message message) {
		Message savedMessage = messageRepository.save(message);
		if(savedMessage.getSenderId().equals(savedMessage.getRecieverId())) 
		{
			//logger.error("Sender "+message.getSenderUserName()+" is trying to send message to himself");	
			throw new SameSenderException("User cannot send message to himself");
			}
			//if(senderId!=null)
			//message.setSenderId(user.getId());
		logger.info("Message has been send by "+message.getSenderUserName());
			return savedMessage;
	}

	@Override
	public Message messagesSentByUser(Integer senderId) {
		Message message = messageRepository.findBySenderId(senderId);
		if(message==null) {
			logger.error("Sender "+message.getSenderUserName()+" doesn't have any message");
			throw new NoMessageException("No Message avalaible for"+message.getSenderUserName());
		}
		return message;
	}
	
	@Override
	public void deleteMessageByMessageId(Integer messageId) {
		Message message= messageRepository.findByMessageId(messageId);
		if(message==null) {
			throw new NonExistingMessagesException("Can not delete Message.This message doesn't exist");
		}
		messageRepository.delete(message);
	}
	
	@Override
	public List<Message> showAllMessageByUser() {
		List<Message> allMessageList = messageRepository.findAll();
		if(allMessageList.isEmpty()==true) {
			throw new NoMessageException("No Messages Found");
		}
		return allMessageList;
	}

	@Override
	public List<Message> allMessageSentOnAdvertise(Integer advertiseId) {
		List<Message> messageList = messageRepository.findByAdvertiseId(advertiseId);
		if(messageList.isEmpty()) {
			throw new NoMessageException("No Messages Found");
		}
		return messageList;
	}
	

	


	
	
	
	

}
