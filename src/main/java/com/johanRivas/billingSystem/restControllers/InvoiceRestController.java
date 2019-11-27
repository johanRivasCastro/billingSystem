package com.johanRivas.billingSystem.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.johanRivas.billingSystem.models.entity.Invoice;
import com.johanRivas.billingSystem.models.service.InvoiceServiceImpl;

@RestController
public class InvoiceRestController {

	@Autowired
	private InvoiceServiceImpl invoiceService;

	@GetMapping(value = { "/rest/invoices" })
	public List<Invoice> invoces() {
		return invoiceService.fetchdWithClientWhithItemInvoiceWithProduct();
	}

	@GetMapping("/invoice/{id}")
	public Invoice invoice(@PathVariable("id") Long id) {
		return invoiceService.getInvoiceById(id);
	}

}
