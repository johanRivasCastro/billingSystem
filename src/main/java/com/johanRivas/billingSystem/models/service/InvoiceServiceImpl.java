package com.johanRivas.billingSystem.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johanRivas.billingSystem.models.dao.IInvoiceDao;
import com.johanRivas.billingSystem.models.entity.Invoice;

@Service
public class InvoiceServiceImpl implements IInvoiceService {

	@Autowired
	private IInvoiceDao invoiceDao;

	@Override
	public void addInvoice(Invoice invoice) {
		invoiceDao.save(invoice);
	}

	@Override
	public void deleteInvoice(Long id) {
		invoiceDao.deleteById(id);
	}

	@Override
	public List<Invoice> getInvoices() {
		return invoiceDao.findAll();
	}

	@Override
	public Invoice getInvoiceById(Long id) {
		return invoiceDao.findById(id).orElse(null);
	}

	@Override
	public List<Invoice> fetchdWithClientWhithItemInvoiceWithProduct() {

		return invoiceDao.findAll();
	}

}
