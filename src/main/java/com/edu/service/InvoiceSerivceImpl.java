package com.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.repository.InvoiceRepository;

@Service
public class InvoiceSerivceImpl implements InvoiceService {
	
	@Autowired
	private InvoiceRepository invoiceRepository;
}
