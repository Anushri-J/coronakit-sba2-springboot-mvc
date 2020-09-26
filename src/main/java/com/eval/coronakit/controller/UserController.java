package com.eval.coronakit.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.eval.coronakit.entity.CoronaKit;
import com.eval.coronakit.entity.KitDetail;
import com.eval.coronakit.entity.ProductMaster;
import com.eval.coronakit.exception.CkException;
import com.eval.coronakit.service.CoronaKitService;
import com.eval.coronakit.service.KitDetailService;
import com.eval.coronakit.service.ProductService;

@Controller
@RequestMapping("/user/")
public class UserController {

	@Autowired
	ProductService productService;

	@Autowired
	CoronaKitService coronaKitService;

	@Autowired
	KitDetailService kitDetailService;

	@RequestMapping("/home")
	public ModelAndView home() {
		return new ModelAndView("user-home");
	}

	@RequestMapping("/show-list")
	public ModelAndView showItemsList() throws CkException {
		return new ModelAndView("show-all-item-user", "products", productService.getAllProducts());
	}

	@PostMapping("/show-kit")
	public ModelAndView showkitList(@RequestParam MultiValueMap<String, String> requestParams) throws CkException {
		Map<Integer, Integer> productIdToQuantityMap = new HashMap<>();
		for (String id : requestParams.keySet()) {
			if (requestParams.getFirst(id).equalsIgnoreCase("on")) {
				productIdToQuantityMap.put(Integer.parseInt(id), Integer.parseInt(requestParams.getFirst(id + "_quantity")));
			}
		}
		List<ProductMaster> productMasters = productService.getAllProducts();
		for (ProductMaster product : productMasters) {
			if (productIdToQuantityMap.containsKey(product.getId())) {
				KitDetail kitDetail = new KitDetail();
				kitDetail.setProductId(product.getId());
				kitDetail.setQuantity(productIdToQuantityMap.get(product.getId()));
				kitDetail.setAmount(kitDetail.getQuantity()*product.getCost());
				kitDetailService.save(kitDetail);
			}
		}
		List<KitDetail> kitDetails = kitDetailService.getAllKitItemsOfAKit();
		return new ModelAndView("show-cart", "kits", kitDetails);
	}

	@RequestMapping("/add-to-cart/{productId}")
	public String showKit(@PathVariable("productId") int productId) {
		return null;
	}

	@RequestMapping("/checkout")
	public ModelAndView checkout(@RequestParam MultiValueMap<String, String> requestParams) throws CkException {
		String deliveryAddress = requestParams.getFirst("deliveryAddress");
		String orderDate = requestParams.getFirst("orderDate");
		int totalAmount = 0;
		List<KitDetail> allKits = kitDetailService.getAllKitItemsOfAKit();
		List<KitDetail> orderedKit =new ArrayList<>();
		for (String kitId: requestParams.get("kitId")) {
			for (KitDetail kitDetail : allKits) {
				if (Integer.parseInt(kitId) == kitDetail.getId()) {
					totalAmount += kitDetail.getAmount();
					orderedKit.add(kitDetail);
				}
			}
		}
		CoronaKit coronaKit = new CoronaKit();
		coronaKit.setDeliveryAddress(deliveryAddress);
		coronaKit.setOrderDate(orderDate);
		coronaKit.setTotalAmount(totalAmount);
		coronaKit = coronaKitService.saveKit(coronaKit);
		for (KitDetail kitDetail : orderedKit) {
			kitDetail.setCoronaKitId(coronaKit.getId());
			kitDetailService.save(kitDetail);
		}
		return new ModelAndView("show-summary", "coronaKit", coronaKit);
	}

	@RequestMapping("/finalize")
	public String finalizeOrder(String address, Model model) {
		return null;
	}

	@RequestMapping("/delete/{itemId}")
	public String deleteItem(@PathVariable("itemId") int itemId) {
		return null;
	}
}
