package com.nagarro.nagpmanagement.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.nagpmanagement.email.SendSMTP;

@RestController
@CrossOrigin(origins = "*")
public class EmailController {

	@Autowired
	SendSMTP sendMail;

	@PostMapping(value = "sendMail")
	public void sendMail() throws IOException {
		SendSMTP.sendMail("jaspreet7025@gmail.com", "hello from NAGP portal", "congratulations", null);
	}
}
