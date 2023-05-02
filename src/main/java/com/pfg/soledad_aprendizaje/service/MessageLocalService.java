package com.pfg.soledad_aprendizaje.service;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

@Service
public class MessageLocalService {
	
	@Autowired
	private MessageSource messageSource;

	public String getMessage(String keyMessage) {
		Locale locale = LocaleContextHolder.getLocale();
		return  messageSource.getMessage(keyMessage, null, locale);
	}
	
	public String getMessage(String keyMessage, String... args) {
		Locale locale = LocaleContextHolder.getLocale();
		return  messageSource.getMessage(keyMessage, args, locale);
	}
}
