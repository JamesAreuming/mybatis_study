package mybatis_study.dto;

public class Address {
	private int addrId;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String country;
	public Address() {
		// TODO Auto-generated constructor stub
	}
	public Address(int addId, String street, String city, String state, String zip, String country) {
		this.addrId = addId;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
	}
	public int getAddId() {
		return addrId;
	}
	public void setAddId(int addId) {
		this.addrId = addId;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return String.format("Address[%s,%s,%s,%s,%s,%s]", addrId, street, city, state, zip, country);
	}
	
	
}
