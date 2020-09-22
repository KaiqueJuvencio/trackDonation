package com.br.trackDonation.controller;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.trackDonation.domains.DonatorVO;
import com.br.trackDonation.service.DonatorService;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

@CrossOrigin
@RestController
@RequestMapping("/donator")
public class DonatorController {

	@Autowired
	private DonatorService donatorService;
	
	private final static String QUEUE_NAME = "TrackDonation";

	@PostMapping
	public ResponseEntity<DonatorVO> register(@RequestParam(required = false) String name, @RequestParam(required = false) String donation,
			@RequestParam(required = false) String email, @RequestParam(required = false) String phone) {
		DonatorVO donatorVO = donatorService.registerDonator(name, donation, email, phone); 
		return ResponseEntity.ok(donatorVO); 
	}

	@GetMapping
	public List<Object[]> getAllDonators() {
		return donatorService.getAllDonators();
	}

	@PutMapping
	public ResponseEntity<DonatorVO> updateDonator(@RequestParam Integer id, @RequestParam(required = false) String name,
			@RequestParam(required = false) String donation, @RequestParam(required = false) String email,
			@RequestParam(required = false) String phone) {
		DonatorVO donatorVO = donatorService.updateDonator(id, name, donation, email, phone);
		return ResponseEntity.ok(donatorVO);
	}
	
	@CrossOrigin
	@DeleteMapping
	public String deleteDonator(@RequestParam Integer id) {
		return donatorService.deleteDonator(id);
	}
	
	@CrossOrigin
	@GetMapping("/send")
	public void send() throws IOException, TimeoutException {
			  
			  ConnectionFactory factory = new ConnectionFactory();
			  factory.setVirtualHost("/");
			  factory.setHost("172.30.192.1");
			  factory.setUsername("test");
			  factory.setPassword("test");
			  try (Connection connection = factory.newConnection();
					  
			       Channel channel = connection.createChannel()) {
				  System.out.println(connection);
				  System.out.println(channel);
				  channel.queueDeclarePassive(QUEUE_NAME);
				  String message = "Hello World!";
				  channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
				  System.out.println(" [x] Sent '" + message + "'");

			  }
	}
	
	@GetMapping("/recv")
	public void recvUm() throws IOException, TimeoutException {

				{
				ConnectionFactory factory = new ConnectionFactory();
				factory.setVirtualHost("/");
				factory.setHost("172.30.192.1");
				factory.setUsername("test");
				factory.setPassword("test");

				Connection connection = factory.newConnection();
				Channel channel = connection.createChannel();
				System.out.println(connection);
				System.out.println(channel);
				channel.queueDeclarePassive(QUEUE_NAME);
				System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

				DeliverCallback deliverCallback = (consumerTag, delivery) -> {
					String message = new String(delivery.getBody(), "UTF-8");
					System.out.println(" [x] Received '" + message + "'");
				};
				channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {
				});

			}
	}
}
