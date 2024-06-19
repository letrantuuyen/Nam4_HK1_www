package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.model.Order;
import com.model.OrderDetail;
import com.model.Product;
import com.service.OrderDetailService;
import com.service.OrderService;
import com.service.ProductService;


@Controller
@RequestMapping("/admin")
public class OrderDetailManagerController {
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderDetailService orderDetailService;
	@Autowired
	private ProductService productService;

	 @GetMapping("/listOrDetail")
	 public String listOrDetail(Model theModel) {
		 List<OrderDetail>orderDetails = orderDetailService.getAllOrderDetail();
		 theModel.addAttribute("orderDetails", orderDetails);
		 return "admin_layout/OrderManager";
	 }
	 @GetMapping("/deleteOrDetail")
	    public String delete(@RequestParam("orderdetailId") int theId) {

	            // delete the customer
	            orderDetailService.deleteOrDetail(theId);

	            return "redirect:/admin/listOrDetail";
	    }
	 @GetMapping("/loadOrDetail")
	 public String loadInforOrder(@RequestParam("orderdetailId") int theId, Model model) {
		 OrderDetail orderDetail = orderDetailService.getOrDetailById(theId);
		 model.addAttribute("orderDetail", orderDetail);
		 Product product = productService.getProductById(orderDetail.getProduct().getId());
		 model.addAttribute("proudct", product);
		 return "admin_layout/OrderInfor";
	 }
	 @PostMapping("/acceptOrDetail")
	 public String acceptOrDetail(@RequestParam("id") int id, MultipartFile photo) {
		 if (photo == null) {
			 OrderDetail orderDetail = orderDetailService.getOrDetailById(id);
			 orderDetail.setStatus("Chấp nhận");
			 orderDetailService.updateOrDetail(id, orderDetail);
	         return "redirect:/admin/listOrDetail";
		}
		 return null;
	 }
	}


