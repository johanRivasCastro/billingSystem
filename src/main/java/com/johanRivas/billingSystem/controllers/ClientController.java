package com.johanRivas.billingSystem.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.johanRivas.billingSystem.models.entity.Client;
import com.johanRivas.billingSystem.models.service.ClientServiceImpl;

@Controller
@SessionAttributes("client")
public class ClientController {

	@Autowired
	private ClientServiceImpl clientService;

	private Logger logger = LoggerFactory.getLogger(ClientController.class);

	@RequestMapping(value = { "/clients" }, method = RequestMethod.GET)
	public String getClients(Model model) {
		model.addAttribute("client", new Client());
		return "client/client";
	}

	@RequestMapping(value = { "/addClient" }, method = RequestMethod.POST)
	public String addClient(@Valid Client client, BindingResult result, SessionStatus status,
			RedirectAttributes flash) {
		if (result.hasErrors()) {
			flash.addFlashAttribute("error",
					"Error. El producto: ".concat(client.getName().concat(" no puede ser creado")));
			return "redirect:/clients";
		}
		try {
			status.setComplete();
			String message = (client.getId() != null) ? "Cliente agregado" : "Cliente editado con exito";
			clientService.addClient(client);
			flash.addAttribute("succes", message);
		} catch (Exception e) {
			logger.info("Error al crear / editar el cliente: ".concat(e.getMessage()));
		}
		return "redirect:/clients";
	}

	@GetMapping("/deleteClient/{id}")
	public String deleteClient(@PathVariable("id") Long id, RedirectAttributes flash) {
		if (id > 0) {
			flash.addFlashAttribute("succes", "cliente eliminado con exito");
			clientService.deleteClient(id);
		}
		return "redirect:/clients";
	}

}
