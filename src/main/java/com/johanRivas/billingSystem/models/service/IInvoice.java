package com.johanRivas.billingSystem.models.service;

import java.util.List;

import com.johanRivas.billingSystem.models.entity.Invoice;

public interface IInvoice {

	public List<Invoice> getInvoices();

	public Invoice getInvoiceById(Long id);

	public void addInvoice(Invoice client);

	public void deleteInvoice(Long id);

	public List<Invoice> fetchdWithClientWhithItemInvoiceWithProduct();

}
