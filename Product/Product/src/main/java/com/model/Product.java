package com.model;




import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name = "products")
public class Product {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message = "Tên sản phẩm không được trống")
	@Column(name = "title")
	private String title;
	
	private int price;

	private String description, image, status, created_at;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id")
	private Category category;
//	@OneToMany
//	@JoinColumn(name = "product_id")
//	private List<OrderDetail>orderDetails;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

//	public List<OrderDetail> getOrderDetails() {
//		return orderDetails;
//	}
//
//	public void setOrderDetails(List<OrderDetail> orderDetails) {
//		this.orderDetails = orderDetails;
//	}

	public Product(int id, String title, int price, String description, String image, String status, String created_at,
			Category category) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.description = description;
		this.image = image;
		this.status = status;
		this.created_at = created_at;
		this.category = category;

	}
	
	public Product(String title, int price, String description, String image, String status, String created_at,
			Category category) {
		super();
		this.title = title;
		this.price = price;
		this.description = description;
		this.image = image;
		this.status = status;
		this.created_at = created_at;
		this.category = category;

	}
	
	public Product(String title, int price, String description, String status, String created_at, Category category) {
		super();
		this.title = title;
		this.price = price;
		this.description = description;
		this.status = status;
		this.created_at = created_at;
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", price=" + price + ", description=" + description
				+ ", image=" + image + ", status=" + status + ", created_at=" + created_at + ", category=" + category
				+ "]";
	}
	
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
}
