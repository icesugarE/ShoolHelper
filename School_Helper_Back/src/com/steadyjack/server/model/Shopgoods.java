package com.steadyjack.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="shopgoods")
public class Shopgoods {
	private int shopgoods_id;
	private int shop_id;
	private String shop_name;
	private String shopgoods_state;
	private String shopgoods_describe;
	private String shopgoods_image;
	private double shopgodds_price;
	
	
	public Shopgoods() {
		super();
	}
	
	public Shopgoods(String name,String state,String describe,String image,double price) {
		super();
		this.shop_name = name;
		this.shopgoods_state = state;
		this.shopgoods_describe = describe;
		this.shopgoods_image = image;
		this.shopgodds_price = price;
	}
	
	public Shopgoods(String name,String state,String describe,double price) {
		super();
		this.shop_name = name;
		this.shopgoods_state = state;
		this.shopgoods_describe = describe;
		this.shopgodds_price = price;
	}
	
	@Id
	@GeneratedValue(generator="my_gen")
	@GenericGenerator(name="my_gen",strategy="native")
	public int getShopgoods_id() {
		return shopgoods_id;
	}
	public void setShopgoods_id(int shopgoods_id) {
		this.shopgoods_id = shopgoods_id;
	}
	
	@Column(name="shop_id")
	public int getShop_id() {
		return shop_id;
	}
	public void setShop_id(int shop_id) {
		this.shop_id = shop_id;
	}
	
	@Column(name="shop_name")
	public String getShop_name() {
		return shop_name;
	}
	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}
	
	@Column(name="shopgodds_price")
	public double getShopgodds_price() {
		return shopgodds_price;
	}
	public void setShopgodds_price(double shopgodds_price) {
		this.shopgodds_price = shopgodds_price;
	}
	
	@Column(name="shopgoods_state")
	public String getShopgoods_state() {
		return shopgoods_state;
	}
	public void setShopgoods_state(String shopgoods_state) {
		this.shopgoods_state = shopgoods_state;
	}
	
	@Column(name="shopgoods_describe")
	public String getShopgoods_describe() {
		return shopgoods_describe;
	}
	public void setShopgoods_describe(String shopgoods_describe) {
		this.shopgoods_describe = shopgoods_describe;
	}
	
	@Column(name="shopgoods_image")
	public String getShopgoods_image() {
		return shopgoods_image;
	}
	public void setShopgoods_image(String shopgoods_image) {
		this.shopgoods_image = shopgoods_image;
	}
}
