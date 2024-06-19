package com.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.model.Category;
import com.model.Product;
import com.service.CategoryService;
import com.service.ProductService;
import com.serviceImpl.FileUploadUntill;

@Controller
@RequestMapping("/admin")
public class ProductManagetController {
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;

	@GetMapping("/listProduct")
	public String listOrDetail(Model theModel) {
		List<Product> products = productService.getAllProducts();
		theModel.addAttribute("products", products);
		return "admin_layout/ProductManager";
	}

	@GetMapping("/deleteProduct")
	public String delete(@RequestParam("productId") int theId) {

		// delete the customer
		productService.deleteProduct(theId);

		return "redirect:/admin/listProduct";
	}

	@GetMapping("/addProduct")
	public String showFormAddProduct(Model theModel) {
		List<Category> categories = categoryService.getAllCategories();
		Product product = new Product();
		theModel.addAttribute("categories", categories);
		theModel.addAttribute("product", product);
		
		return "admin_layout/addProduct";
	}

	@PostMapping("/saveProduct")
	public String saveInfor(@RequestParam("title") String title, @RequestParam("price") int price, 
			@RequestParam("description") String description, @RequestParam("type") String type, MultipartFile photo,
			ModelMap modelMap) {
		Product product = new Product();
		product.setTitle(title);
		product.setPrice(price);
		product.setDescription(description);
		Category category = categoryService.getCategoryByTitle(type);
		product.setCategory(null);
		product.setCreated_at(Date.valueOf(LocalDate.now()).toString());
		product.setCategory(category);
		product.setStatus("Còn hàng");
		if (photo.isEmpty()) {
			return "infor";
		}
		Path path = Paths.get("D:\\Nhom6_WWW\\baitaplonwww\\src\\main\\webapp\\resources\\images\\upload");
		try {
			InputStream inputStream = photo.getInputStream();
			Files.copy(inputStream, path.resolve(photo.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			product.setImage("resources/images/upload/" + photo.getOriginalFilename());

			modelMap.addAttribute("product", product);
			productService.addProduct(product);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "redirect:/admin/listProduct";
	}

	@GetMapping("/loadInfor")
	public String loadInfor(@RequestParam("productId") int theId, Model model) {
		Product product = productService.getProductById(theId);
		System.out.println(product);
		List<Category> categories = categoryService.getAllCategories();
		model.addAttribute("product", product);
		model.addAttribute("categories", categories);
		return "admin_layout/ProductInfor";
	}

	@PostMapping("/updateProduct")
	public String updateProduct(@RequestParam("id") int id, @RequestParam("title") String title,
			@RequestParam("price") int price, @RequestParam("description") String description,
			@RequestParam("type") String type, MultipartFile photo, ModelMap modelMap) {
		Product product = new Product();
		product.setTitle(title);
		product.setPrice(price);
		product.setDescription(description);
		System.out.println(photo.getOriginalFilename());

		if (photo.getOriginalFilename() == null) {
			String image = productService.getProductById(id).getImage();
			product.setImage(image);

		} else {
			Path path = Paths.get("D:\\Nhom6_WWW\\baitaplonwww\\src\\main\\webapp\\resources\\images\\upload");
			try {
				InputStream inputStream = photo.getInputStream();
				Files.copy(inputStream, path.resolve(photo.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
				product.setImage("resources/images/upload/" + photo.getOriginalFilename());
				modelMap.addAttribute("product", product);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		Category category = categoryService.getCategoryByTitle(type);
		product.setCategory(category);
		productService.updateProduct(id, product);
		return "redirect:/admin/listProduct";
	}
}
