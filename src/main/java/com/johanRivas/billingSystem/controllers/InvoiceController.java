package com.johanRivas.billingSystem.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.johanRivas.billingSystem.models.entity.Invoice;

@Controller
@SessionAttributes("invoiceController")
public class InvoiceController {

	@GetMapping("/invoices")
	public String list(Model model) {
		model.addAttribute("invoice", new Invoice());
		return "invoice/listInvoices";
	}

	@GetMapping("/createInvoice")
	public String create(Model model) {
		model.addAttribute("invoice", new Invoice());
		return "invoice/createInvoice";
	}

	@PostMapping("/saveInvoice")
	public String save(@Valid Invoice invoice, BindingResult result, SessionStatus status, RedirectAttributes flash) {
		return "redirect:invoices";
	}

}
