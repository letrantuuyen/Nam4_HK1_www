package com.controller;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.model.Order;
import com.model.OrderDetail;
import com.model.Product;
import com.model.Cart;
import com.model.CartDetail;
import com.reponsitory.CartDetailReponsitory;
import com.reponsitory.OrderDetailReponsitory;
import com.reponsitory.OrderReponsitory;
import com.service.OrderDetailService;
import com.service.OrderService;
import com.service.ProductService;



@Controller
public class AdminController {
	@Autowired
	private ProductService productService;
	@Autowired
	private OrderService orderService;
	@Autowired 
	private OrderDetailService oderDetailService;
	
	@Autowired 
	private OrderReponsitory orderReponsitory;
	
	@Autowired 
	private OrderDetailReponsitory orderDetailReponsitory;
	
	@Autowired 
	private CartDetailReponsitory cartDetailReponsitory;
	
	@GetMapping("/")
	public String Home(Model theModel) {
		List<Product> products = productService.getAllProducts();
		theModel.addAttribute("products", products);
		 return "index";
	}
	
	
	@GetMapping("/chitietsanpham")
	public String chitietsanpham(@RequestParam("productId") int theId,Model theModel) {
		List<Product> products = productService.getAllProducts();
		theModel.addAttribute("products", products);
		Product theProduct = productService.getProductById(theId);
		theModel.addAttribute("product",theProduct);
		return "chitietsanpham";
	}
	
	@GetMapping("/danhsachsanpham")
	public String danhsachsanpham(Model theModel) {
		List<Product> products = productService.getAllProducts();
		theModel.addAttribute("products", products);
		return "danhsachsanpham";
	}
	
	@GetMapping("/danhsachsanphamtheoloai")
	public String danhsachsanphamtheoloai(@RequestParam("theId")int theId,Model theModel) {
		List<Product> products = productService.getAllProducts();
		theModel.addAttribute("products", products);
		theModel.addAttribute("theId",theId);
		return "danhsachsanphamtheoloai";
	}
	@GetMapping("/muahang")
	public String muangay(@RequestParam(value="success", required=false) String success,Model theModel) {
		System.out.println(success);
		theModel.addAttribute("success", success);

//		List<Product> products = productService.getAllProducts();
//		theModel.addAttribute("products", products);
//		Product theProduct = productService.getProductById(theId);
//		theModel.addAttribute("product",theProduct);
		return "muahang";
	}
/*	
	@GetMapping("/test")
	public String test(@RequestParam("phone") String phone,@RequestParam("address") String address,@RequestParam("quantity") int quantity,@RequestParam("theId") int theId,Model theModel) {
		//theModel.addAttribute("phone", phone);
		//theModel.addAttribute("address", address);
		
		theModel.addAttribute("theId", theId);
		Product theProduct = productService.getProductById(theId);
		theModel.addAttribute("product",theProduct);
		
		long millis=System.currentTimeMillis();
		java.sql.Date date=new java.sql.Date(millis);
		theModel.addAttribute("product",theProduct);
		Order order = new Order(phone,address,quantity*theProduct.getPrice(),"default",date);		
		orderService.addOrder(order);
		theModel.addAttribute("order",order);
		OrderDetail orderDetail = new OrderDetail(quantity, "publish", date, order, theProduct);
		oderDetailService.addOrDetail(orderDetail);
		theModel.addAttribute("orderDetail",orderDetail);
		return "test";
	}
*/	
	@PostMapping("/dathang")
	public String dathang(@PathVariable(value="success", required=false) boolean success, @RequestParam("total") double total, @RequestParam("phone") String phone,@RequestParam("address") String address,@RequestParam("message") String quantity,@RequestParam("products") String products,Model theModel) {
	
		try {
		System.out.println(success);
	
		Gson gson = new Gson(); 
		
		Cart[] carts = gson.fromJson(products, Cart[].class); 
		long millis=System.currentTimeMillis();
		java.sql.Date date=new java.sql.Date(millis);
		Order order = new Order(phone,address,total,"Chờ xác nhận",date);		
		orderReponsitory.save(order);

//				public OrderDetail(int quantity, String status, Date createdAt, int product_id, int order_id) {
		for(Cart cart : carts) {
			CartDetail orderDetail = new CartDetail(cart.getQuantity(), "Chờ xác nhận", date, cart.getId(),order.getId());
			cartDetailReponsitory.save(orderDetail);
		}
		
			return "redirect:" + "/muahang?success=true";
		}catch(Exception e) {
			System.out.println(e);
			theModel.addAttribute("success", false);
			return "redirect:" + "/muahang?success=false";
		}
		
	}
	
	@GetMapping("/timkiem")
	public String timkiem(@RequestParam("search") String search,Model theModel) {
		List<Product> products = productService.getProductsByName(search);
		theModel.addAttribute("products", products);
		theModel.addAttribute("search", search);
		 return "timkiem";
	}
	//------
	@GetMapping("/muahangngay")
	public String muangay(@RequestParam("productId") int theId,Model theModel) {	
		List<Product> products = productService.getAllProducts();
		theModel.addAttribute("products", products);
		Product theProduct = productService.getProductById(theId);
		theModel.addAttribute("product",theProduct);
		return "muahangngay";
	}
	@GetMapping("/dathangngay")
	public String dathang(@RequestParam("phone") String phone,@RequestParam("address") String address,@RequestParam("quantity") int quantity,@RequestParam("theId") int theId,Model theModel) {
		Product theProduct = productService.getProductById(theId);
		
		long millis=System.currentTimeMillis();
		java.sql.Date date=new java.sql.Date(millis);
		theModel.addAttribute("product",theProduct);
		Order order = new Order(phone,address,quantity*theProduct.getPrice(),"Chờ xác nhận",date);		
		orderService.addOrder(order);
		
		OrderDetail orderDetail = new OrderDetail(quantity, "publish", date, order, theProduct);
		oderDetailService.addOrDetail(orderDetail);
		List<Product> products = productService.getAllProducts();
		theModel.addAttribute("products", products);
		return "index";
	}
}
