package com.salesmanager.shop.store.controller.email;

import javax.mail.MessagingException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/gmail")

public class GmailController {

    @RequestMapping(value="/send",method=RequestMethod.POST)
	public void send(@RequestBody Gmail gmail) throws MessagingException {
    	
    	GmailSmtpSSL sender = new GmailSmtpSSL();
    	
    	String body = gmail.getPedido();
		String sub = "Pedido de " + gmail.getNome() + " - " + gmail.getEmail() + " - " + gmail.getTelefone();
		String to = gmail.getDestino();
		
		
		try {
			sender.sendMailTo(to, sub, body);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		
	}
	
}
