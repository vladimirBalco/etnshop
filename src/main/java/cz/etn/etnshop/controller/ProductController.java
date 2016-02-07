package cz.etn.etnshop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import cz.etn.etnshop.dao.Product;
import cz.etn.etnshop.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping("/list")
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("product/list");
		System.out.println("Count:" + productService.getProducts().size());
		// modelAndView.addObject("test", "mytest");// useless
		// modelAndView.addObject("count",productService.getProducts().size());//useless
		modelAndView.addObject("products", productService.getProducts());
		return modelAndView;
	}

	// Handler method for displaying new product form:
	@RequestMapping(value = "/newProduct", method = RequestMethod.GET)
	public ModelAndView newProduct(ModelAndView model) {
		Product newProduct = new Product();
		model.addObject("product", newProduct);
		model.setViewName("product/productForm");
		return model;
	}

	// Handler method for saving new product:
	@RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
	public ModelAndView saveProduct(@ModelAttribute Product product) {
		if (product.getId() > 0) {// Editing product
			productService.updateProduct(product);

		} else { // Creating product
			productService.saveProduct(product);
		}
		return new ModelAndView("redirect:/product/list");
	}

	// Handler method for deleting product:
	@RequestMapping(value = "/deleteProduct", method = RequestMethod.GET)
	public ModelAndView deleteProduct(HttpServletRequest request) {
		int productId = Integer.parseInt(request.getParameter("id"));
		productService.deleteProduct(productId);
		return new ModelAndView("redirect:/product/list");
	}

	// Handler method for editing product:
	@RequestMapping(value = "/editProduct", method = RequestMethod.GET)
	public ModelAndView editProduct(HttpServletRequest request) {
		int productId = Integer.parseInt(request.getParameter("id"));
		Product product = productService.getProduct(productId);
		ModelAndView model = new ModelAndView("product/productForm");
		model.addObject("product", product);
		return model;
	}
	
	// Handler method for product search form:
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView searchPage() {
		ModelAndView mav = new ModelAndView("product/search");
		return mav;
	}

	// Handler method for product search results:
	@RequestMapping(value = "/doSearch", method = RequestMethod.POST)
	public ModelAndView searchProduct(@RequestParam("searchText") String searchText){
		List<Product> allFound = productService.searchForProduct(searchText);
		ModelAndView mav = new ModelAndView("product/foundProducts");
		mav.addObject("foundProducts", allFound);
		return mav;
	}
	
	// Handler method for indexing products from database for search purpose. Use it when there are products in database which were created outside the application
	@RequestMapping(value = "/doIndexing", method = RequestMethod.GET)
	   public ModelAndView indexProducts(){
		  productService.indexProducts();
	      ModelAndView mav = new ModelAndView("/index");	      
	      return mav;
	   }

}
