package com.johanRivas.billingSystem.controllers;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.johanRivas.billingSystem.models.entity.Product;
import com.johanRivas.billingSystem.models.service.IProductService;

@Controller
@SessionAttributes("product")
public class ProductController {

	@Autowired
	private IProductService productService;
	protected final Log logger = LogFactory.getLog(this.getClass());

	@RequestMapping(value = { "/", "/products" }, method = RequestMethod.GET)
	public String getProducts(Model model) {
		model.addAttribute("product", new Product());
		return "/product/product";
	}

	@PostMapping(value = "/addProduct")
	public String addProduct(@Valid Product product, BindingResult result, SessionStatus status,
			RedirectAttributes flash) {
		if (result.hasErrors()) {
			flash.addFlashAttribute("error", "El roducto: '" + product.getName() + "' no pudo ser creado");
			return "redirect:/products";
		}
		try {
			status.setComplete();
			String flashMessage = (product.getId() != null) ? "Product editado con exito"
					: "Producto agregado con exito ";
			productService.addProduct(product);
			flash.addFlashAttribute("success", flashMessage);

		} catch (DataAccessException e) {
			logger.info(e.getMessage());
		}
		return "redirect:/products";
	}

	@GetMapping(value = "/deleteProduct/{id}")
	public String deleteProduct(@PathVariable(value = "id") Long id, RedirectAttributes flash) {
		if (id > 0) {
			productService.deleteProduct(id);
			flash.addFlashAttribute("success", "Producto eliminado exitosamente");
		}
		return "redirect:/products";
	}
}
