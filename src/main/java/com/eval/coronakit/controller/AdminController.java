package com.eval.coronakit.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.eval.coronakit.entity.ProductMaster;
import com.eval.coronakit.exception.CkException;
import com.eval.coronakit.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	ProductService productService;

	@GetMapping("/home")
	public ModelAndView home() {
		return new ModelAndView("admin-home");
	}

	@GetMapping("/product-list")
	public ModelAndView showItemsList() throws CkException {
		return new ModelAndView("show-all-item-admin", "products", productService.getAllProducts());
	}

	@GetMapping("/product-entry")
	public ModelAndView showItemFormForAdding() {
		ModelAndView mv = new ModelAndView("add-new-item", "item", new ProductMaster());
		mv.addObject("isNew", true);
		return mv;
	}

	@PostMapping("/product-save")
	public ModelAndView productSave(@ModelAttribute("item") @Valid ProductMaster product, BindingResult result)
			throws CkException {
		ModelAndView mv = null;

		if (result.hasErrors()) {
			mv = new ModelAndView("add-new-item", "item", product);
			mv.addObject("isNew", false);
		} else {
			productService.save(product);
			mv = new ModelAndView("admin-home", "msg", "Item is saved!");
		}

		return mv;
	}

	@GetMapping("/product-delete/{productId}")
	public ModelAndView productDelete(@PathVariable("productId") int productId) throws CkException {
		productService.deleteProduct(productId);
		return new ModelAndView("index", "msg", "Item is deleted!");
	}

}
