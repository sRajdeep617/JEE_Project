package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import com.example.demo.entity.Order;
import com.example.demo.entity.Product;
import com.example.demo.utils.Utility;

@Controller
public class ClientController {
	@Autowired
	private RestTemplate template;

	
	public ClientController() {
		super();
	}

	// main page
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String WelcomePage() {
		return "index";
	}
	
	
	
	
	
	// product menu page
		@GetMapping(path = "/product-menu")
		public String productMenu() {
			return "product-menu";
		}
	
		@GetMapping(path =  "/product-section")
		public String productSection() {
			return "product-section"; 
		}
		
		@GetMapping(path="/product-section/products")
		public String getProducts(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int pageSize, Model model) {
			ResponseEntity<Product[]> products  = template.getForEntity("lb://PRODUCT-SERVICE/list" + Utility.pageQuery(page, pageSize)  , Product[].class) ;
		    if(products.getBody() == null) {
		    	model.addAttribute("item" , "product") ; 
		    	return "shortage"; 		
		    }
		    else {
		    	model.addAttribute("products", products.getBody());
		    	products  = template.getForEntity("lb://PRODUCT-SERVICE/list" + Utility.pageQuery(page + 1, pageSize) , Product[].class) ;
		    	model.addAttribute("pageNo", page); 
		    	model.addAttribute("hasNextPage", !(products.getBody()==null)); 
		    	model.addAttribute("nextPagePath", "/product-section/products" +  Utility.pageQuery(page + 1, pageSize) ); 
		    	model.addAttribute("hasPreviousPage" , page >= 1); 
		    	model.addAttribute("previousPagePath", "/product-section/products" +  Utility.pageQuery(page - 1, pageSize));
		    	model.addAttribute("pageSize", pageSize) ;
		    	return "products"; 
		    }
		}
		
		@GetMapping(path="/product-section/products/{merchant}")
		public String getProductsByMerchantName(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int pageSize, @PathVariable String merchant, Model model) {
			ResponseEntity<Product[]> products  = template.getForEntity("lb://PRODUCT-SERVICE/list/" + merchant + Utility.pageQuery(page, pageSize)  , Product[].class) ;
		    if(products.getBody() == null) {
		    	model.addAttribute("item" , "product") ; 
		    	return "shortage"; 		
		    }
		    else {
		    	model.addAttribute("products", products.getBody());
		    	products  = template.getForEntity("lb://PRODUCT-SERVICE/list/" + merchant + Utility.pageQuery(page + 1, pageSize) , Product[].class) ;
		    	System.out.println(products.getBody());
		    	model.addAttribute("pageNo", page); 
		    	model.addAttribute("marchant", merchant) ; 
		    	model.addAttribute("hasNextPage", !(products.getBody()==null)); 
		    	model.addAttribute("nextPagePath", "/product-section/products/" + merchant +  Utility.pageQuery(page + 1, pageSize) ); 
		    	model.addAttribute("hasPreviousPage" , page >= 1); 
		    	model.addAttribute("previousPagePath", "/product-section/products/" + merchant +  Utility.pageQuery(page - 1, pageSize));
		    	model.addAttribute("pageSize", pageSize) ; 
				return "products" ; 
		    }
		}
		
		@GetMapping(path="/product-section/products/available")
		public String getAvailableProducts(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int pageSize, Model model) {
			ResponseEntity<Product[]> products  = template.getForEntity("lb://PRODUCT-SERVICE/list/available" + Utility.pageQuery(page, pageSize)  , Product[].class) ;
		    if(products.getBody() == null) {
		    	model.addAttribute("item" , "product") ; 
		    	return "shortage"; 		
		    }
		    else {
		    	model.addAttribute("products", products.getBody());
		    	products  = template.getForEntity("lb://PRODUCT-SERVICE/list/available" + Utility.pageQuery(page + 1, pageSize) , Product[].class) ;
		    	System.out.println(products.getBody());
		    	model.addAttribute("pageNo", page);
		    	model.addAttribute("hasNextPage", !(products.getBody()==null)); 
		    	model.addAttribute("nextPagePath", "/product-section/products/available" +  Utility.pageQuery(page + 1, pageSize) ); 
		    	model.addAttribute("hasPreviousPage" , page >= 1); 
		    	model.addAttribute("previousPagePath", "/product-section/products/available" +  Utility.pageQuery(page - 1, pageSize));
		    	model.addAttribute("pageSize", pageSize) ; 
				return "products" ; 
		    }
		}
		
		@GetMapping(path="/product-section/products/not-available")
		public String getNotAvailableProducts(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int pageSize, Model model) {
			ResponseEntity<Product[]> products  = template.getForEntity("lb://PRODUCT-SERVICE/list/not-available" + Utility.pageQuery(page, pageSize)  , Product[].class) ;
		    if(products.getBody() == null) {
		    	model.addAttribute("item" , "product") ; 
		    	return "shortage"; 		
		    }
		    else {
		    	model.addAttribute("products", products.getBody());
		    	products  = template.getForEntity("lb://PRODUCT-SERVICE/list/not-available" + Utility.pageQuery(page + 1, pageSize) , Product[].class) ;
		    	System.out.println(products.getBody());
		    	model.addAttribute("pageNo", page);
		    	model.addAttribute("hasNextPage", !(products.getBody()==null)); 
		    	model.addAttribute("nextPagePath", "/product-section/products/not-available" +  Utility.pageQuery(page + 1, pageSize) ); 
		    	model.addAttribute("hasPreviousPage" , page >= 1); 
		    	model.addAttribute("previousPagePath", "/product-section/products/not-available" +  Utility.pageQuery(page - 1, pageSize));
		    	model.addAttribute("pageSize", pageSize) ; 
				return "products" ; 
		    }
		}
		
		@PostMapping(path="/product-section/products-by-merchant")
		public String postProductsByMerchant(@RequestParam("merchant") String merchant, @RequestParam("pageSize") int pageSize, Model model) { 
		    return getProductsByMerchantName(0, pageSize, merchant, model); 
		}
		
		@GetMapping(path="/product-section/save")
		public String AddProduct(Model model) {
			model.addAttribute("command", new Product());
	        return "add-product";
		}
		
		@PostMapping(path="/product-section/save")
		public String onSubmitAddProduct(@ModelAttribute("command") Product product, Model model) {
			ResponseEntity<Product> products = template.postForEntity("lb://PRODUCT-SERVICE/save", product, Product.class);
			model.addAttribute("message" , products.getBody()) ; 
	        return "add-product";
		}
		
	
	
	
	
	
	
	//ORDER-------------------------------------------------------------------------------------------------------------------------
	
	// order menu page
	@GetMapping(path = "/order-menu")
	public String OrderMenu() {
		return "OrderMenu";
	}
	
	
	// get all order or by user name and page size
	@GetMapping(path =  "/order-section")
	public String OrderSection() {
		return "order-section"; 
	}
	
	
	// get all order
	@GetMapping(path="/order-section/orders")
	public String getOrders(Model model) {
	    ResponseEntity<Order[]> orders  = template.getForEntity("lb://ORDER-SERVICE/order", Order[].class) ;
		model.addAttribute("orders", orders.getBody());
		return "orders" ; 
	}
	
	// map order by user page number
	@PostMapping(path="/order-section/orders-by-user")
	public String postOrdersByUser(@RequestParam("username") String username, 
			@RequestParam  (defaultValue = "0") int page,
		      @RequestParam(defaultValue = "3") int pageSize, Model model) {
	    ResponseEntity<Order[]> orders  = template.getForEntity("lb://ORDER-SERVICE/list/" + username, Order[].class) ;
//		model.addAttribute("orders", orders.getBody());
//		return "orders"; 
	    return getOrdersByUserAndPage(username, page, pageSize, model); 
	}
	
	// map by user page number
	@GetMapping(path="/order-section/orders-by-user/{username}")
	public String getOrdersByUserAndPage(@PathVariable("username") String username, @RequestParam int page,@RequestParam int pageSize, Model model) {
	    ResponseEntity<Order[]> orders  = template.getForEntity("lb://ORDER-SERVICE/list/" + username + "?page=" + page+"&pageSize="+pageSize , Order[].class) ;
	    if(orders.getBody() == null) {
	    	return "error404"; 	
	    }
	    else {
	    	model.addAttribute("orders", orders.getBody());
	    	orders  = template.getForEntity("lb://ORDER-SERVICE/list/" + username + "?page=" + (page + 1)+"&pageSize="+pageSize , Order[].class) ;
	    	System.out.println(orders.getBody());
	    	model.addAttribute("page", page);
	    	model.addAttribute("pageSize",pageSize);
	    	model.addAttribute("username", username) ; 
	    	model.addAttribute("hasNextPage", !(orders.getBody()==null)); 
			return "orders-by-user-page" ; 
	    }
	}
	
	// order id input page
	@GetMapping(path="/order-by-id")
	public String orderByIdInput() {
		return "order-by-id-input";
	}
	
	// get order by id
	@PostMapping(path="/order-by-id/id")
	public String postOrdersByUser(@RequestParam("orderId") int orderId, Model model) {
	    ResponseEntity<Order> orders  = template.getForEntity("lb://ORDER-SERVICE/"+orderId, Order.class) ;
//		model.addAttribute("orders", orders.getBody());
//		return "orders"; 
//		return "order-id";
	    return getOrdersByOrderId(orderId,model);
	}
	
	// show order by id
	@GetMapping(path="/order-by-id/id/{orderId}")
	public String getOrdersByOrderId(@PathVariable("orderId") int orderId, Model model) {
	    ResponseEntity<Order> orders  = template.getForEntity("lb://ORDER-SERVICE/" + orderId , Order.class) ;
	    if(orders.getBody() == null) {
	    	return "error404"; 	
	    }
	    else {
	    	model.addAttribute("orders", orders.getBody());
//	    	orders  = template.getForEntity("lb://ORDER-SERVICE/list/" + username + "?page=" + (page + 1)+"&pageSize="+pageSize , Order[].class) ;
	    	System.out.println(orders.getBody());
			return "order-id" ; 
	    }
	}
	
	// open add order page
	@GetMapping(path = "/add-order")
	public String addOrder(Model model){
		Order order = new Order(0, 0, null);
		model.addAttribute("command",order);
		return "addOrder";
	}
	
	// send order to order service to save
	@PostMapping(path="/add-order/saved")
	public String onSubmitAddOrder(@ModelAttribute("command") Order obj, Model model) {
		
		ResponseEntity<Order> orders = template.postForEntity("lb://ORDER-SERVICE/save", obj, Order.class);
//		System.out.println(orders.equals(obj));
//		System.out.println(obj);
		
		return "addOrder";
	}
	
	// open update page
	@GetMapping(path = "/update-order")
	public String updateOrder(Model model){
		Order order = new Order(0, 0, null);
		model.addAttribute("command",order);
		return "updateOrder";
	}
	
	// send data to update 
	@PostMapping(path="/update-order/updated")
	public String onSubmitUpdateOrder(@ModelAttribute("command") Order obj, Model model) {
		
		if(obj.getOrderId()==0) {
			return "error404";
		}
		ResponseEntity<Order> orders = null;
		try {
			orders  = template.getForEntity("lb://ORDER-SERVICE/" + obj.getOrderId() , Order.class) ;
		}catch (Exception e) {
			// TODO: handle exception
			return "error404";
		}
		
		if(orders.getBody() == null) {
	    	return "error404"; 	
	    }
		Order obj1 = orders.getBody();
		if(obj.getProductId()==0) {
			obj.setProductId(obj1.getProductId());
		}
		if(obj.getUsername()=="") {
			obj.setUsername(obj1.getUsername());
		}
		ResponseEntity<Order> order = template.postForEntity("lb://ORDER-SERVICE/save", obj, Order.class);
//		System.out.println(orders.equals(obj));
//		System.out.println(obj);
		
		return "updateOrder";
	}
}
