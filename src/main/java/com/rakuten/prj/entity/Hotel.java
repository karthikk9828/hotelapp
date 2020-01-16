/**
 * 
 */
package com.rakuten.prj.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ar-karthik.k
 *
 */

@Entity
@Table(name = "hotels")
public class Hotel implements Comparable<Hotel> {
	
	@Id
	@Column(name = "hotel_id")
	private int hotelId;
	
	private double price;
	
	@Column(name = "hotel_name")
	private String hotelName;
	
	private String address;

	@Column(name = "city")
	private String city;

	private String state;

	private String zip;
	
	private String country;

	public Hotel() {
		super();
	}

	public Hotel(int hotelId, double price, String hotelName, String address, String city, String state, String zip,
			String country) {
		super();
		this.hotelId = hotelId;
		this.price = price;
		this.hotelName = hotelName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
	}
	
	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
		return "Hotel [hotelId=" + hotelId + ", price=" + price + ", hotelName=" + hotelName + ", address=" + address
				+ ", city=" + city + ", state=" + state + ", zip=" + zip + ", country=" + country + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + hotelId;
		result = prime * result + ((hotelName == null) ? 0 : hotelName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((zip == null) ? 0 : zip.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hotel other = (Hotel) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (hotelId != other.hotelId)
			return false;
		if (hotelName == null) {
			if (other.hotelName != null)
				return false;
		} else if (!hotelName.equals(other.hotelName))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (zip == null) {
			if (other.zip != null)
				return false;
		} else if (!zip.equals(other.zip))
			return false;
		return true;
	}

	@Override
	public int compareTo(Hotel o) {
		return this.hotelId - o.hotelId;
	} 

}
