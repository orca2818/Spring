package ncs.r4a118.shop;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class Product {
	private int code;
	@NotEmpty
	private String name;
	@Min(0)
	private int price;
	private String unit;
	private String desc;
	private String img;

	public Product() {}

	public Product(int code, String name, int price, String unit) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
		this.unit = unit;
	}

	public Product(int code, String name, int price, String unit, String desc, String img) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
		this.unit = unit;
		this.desc = desc;
		this.img = img;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [code=");
		builder.append(code);
		builder.append(", name=");
		builder.append(name);
		builder.append(", price=");
		builder.append(price);
		builder.append(", unit=");
		builder.append(unit);
		builder.append("]");
		return builder.toString();
	}

}
