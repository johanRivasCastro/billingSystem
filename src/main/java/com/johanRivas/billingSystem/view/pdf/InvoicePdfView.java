package com.johanRivas.billingSystem.view.pdf;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.johanRivas.billingSystem.models.entity.Invoice;
import com.johanRivas.billingSystem.models.entity.InvoiceItem;
import com.lowagie.text.Document;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component("invoice/details")
public class InvoicePdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Invoice invoice = (Invoice) model.get("invoice");

		PdfPTable table1 = new PdfPTable(1);
		table1.setSpacingAfter(20);
		table1.addCell("Datos del Cliente");
		table1.addCell(invoice.getClient().getName() + " " + invoice.getClient().getName());
		table1.addCell(invoice.getClient().getEmail());

		PdfPTable table2 = new PdfPTable(1);
		table2.setSpacingAfter(20);
		table2.addCell("Datos de la factura: ");
		table2.addCell("Folio: " + invoice.getId());
		table2.addCell("Fecha: " + invoice.getCreatedAt());
		table2.addCell("Descripcion: " + invoice.getDescription());

		PdfPTable table3 = new PdfPTable(4);
		table3.addCell("Prducto");
		table3.addCell("Precio");
		table3.addCell("Cantidad");
		table3.addCell("Total");

		for (InvoiceItem items : invoice.getItems()) {
			table3.addCell(items.getProduct().getName());
			table3.addCell(items.getProduct().getPrice().toString());
			table3.addCell(items.getQuatity().toString());
			table3.addCell(items.calcularImporte().toString());

		}

		PdfPCell cell = new PdfPCell(new Phrase("Total: "));
		cell.setColspan(3);
		cell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);

		table3.addCell(cell);
		table3.addCell(invoice.getTotal().toString());

		document.add(table1);
		document.add(table2);
		document.add(table3);
	}

}
