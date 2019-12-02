package com.thecoffeshop.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import com.thecoffeshop.common.Common;
import com.thecoffeshop.common.converter.ProductConverter;
import com.thecoffeshop.entity.Categoryproduct;
import com.thecoffeshop.entity.Image;
import com.thecoffeshop.entity.Price;
import com.thecoffeshop.entity.Product;
import com.thecoffeshop.service.CategoryProductService;
import com.thecoffeshop.service.PriceService;
import com.thecoffeshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


import com.thecoffeshop.DTO.*;

@Controller
@RequestMapping("/")
@SessionAttributes({"gio-hang", "customer"})
public class IndexUserController extends Common {

	@Autowired
	private CategoryProductService categoryProductService;
	@Autowired
	private ProductService productService;
	@Autowired
	private PriceService priceService;

	@GetMapping(value = "")
	public String getHome(ModelMap modelMap, HttpSession httpSession) {
		List<ProductDTO> productDTOS = getListProductDTOBySession(httpSession);
		if (null != productDTOS){
			modelMap.addAttribute("soluonggiohang", productDTOS.size());
		}
		pagination(modelMap, httpSession, 0, null, null, null, null, null);

		return "/user/index";

	}

	@GetMapping(value = "/index")
	public String index(ModelMap modelMap, HttpSession httpSession) {
		List<ProductDTO> productDTOS = getListProductDTOBySession(httpSession);
		if (null != productDTOS){
			modelMap.addAttribute("soluonggiohang", productDTOS.size());
		}
		pagination(modelMap, httpSession, 0, null, null, null, null, null);

		return "/user/index";

	}


	@PostMapping(value = "/index/search")
	public String search(ModelMap modelMap, HttpSession httpSession, @RequestParam String page,
			@RequestParam String cgPrdId, @RequestParam String strSearch, @RequestParam String isHotDeal,
			@RequestParam String priceAZ, @RequestParam String priceZA) {

		int startPosition = Integer.valueOf(page.trim());
		// pagination(modelMap, httpSession, startPosition, cgPrdId, strSearch,
		// isHotDeal, priceAZ, priceZA);
		pagination(modelMap, httpSession, startPosition, cgPrdId, strSearch.trim(), null, null, null);
		return "user/content/content-index";

	}

	/* get info of product */
	@PostMapping(value = "/infoProduct")
	public String infoProduct(@RequestParam String productid, ModelMap modelMap) {


		Product product = productService.getInfoById(productid);

		if (product == null) {
			return "Sản phẩm không tồn tại";
		}

		modelMap.addAttribute("product", product);
		modelMap.addAttribute("old_prPrice", priceService.getOldPrice(product.getProductid()));
		Price new_Price = priceService.getNewPrice(product.getProductid());
		if (new_Price != null) {
			modelMap.addAttribute("new_Price", new_Price);
		}
		Set<Image> images = new HashSet<>();
		modelMap.addAttribute("images", images);

		return "/user/content/infoProduct";
	}

	public void pagination(ModelMap modelMap, HttpSession httpSession, int startPosition, String cgPrdId,
			String strSearch, String isHotDeal, String priceAZ, String priceZA) {

		modelMap.addAttribute("startPosition", startPosition + 1);
		modelMap.addAttribute("cgPrdId", cgPrdId);
		modelMap.addAttribute("strSearch", strSearch);
		modelMap.addAttribute("isHotDeal", isHotDeal);
		modelMap.addAttribute("priceAZ", priceAZ);
		modelMap.addAttribute("priceZA", priceZA);

		/* display Categoryproduct on combobox */
		List<Categoryproduct> categoryProducts = categoryProductService.findAll();
		modelMap.addAttribute("categoryProducts", categoryProducts);

		/* display list product on page */
		if (cgPrdId != null && cgPrdId.equals("-1")) {
			cgPrdId = null;
		}
		if(strSearch == "") {
			strSearch = null;
		}

		List<Product> products = productService.getListProductLimit(startPosition, cgPrdId, strSearch, null);

		ProductConverter productConverter = new ProductConverter();
		List<ProductDTO> productDTOs = productConverter.converterDAOtoDTO(products);
		/* display price product and sale price and new product release */
		modelMap.addAttribute("productDTOs", productDTOs);
	}

	private List<ProductDTO> getListProductDTOBySession(HttpSession httpSession){
		return (List<ProductDTO>) httpSession.getAttribute("gio-hang");
	}
}
