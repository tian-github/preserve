package com.preserve.core.utils.mail;

import org.springframework.mail.MailSender;

public class MailHelper {
	private MailSender mailSender;

	public MailSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

}
