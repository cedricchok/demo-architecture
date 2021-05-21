package com.example.demo.shared.dto;

public class AddressDto {
	private long id;
	private String addressId;
	private String streetName;
	private String city;
	private String postalCode;
	private String country;
	// Addresse de facturation pour la facture  ou addresse ou habite le user
	private String type;
	private UserDto userDetails;

	public long getId() {
		return id;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public UserDto getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDto userDetails) {
		this.userDetails = userDetails;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
