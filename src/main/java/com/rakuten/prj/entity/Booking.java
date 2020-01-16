/**
 * 
 */
package com.rakuten.prj.entity;

import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author ar-karthik.k
 *
 */

@Entity
@Table(name = "bookings")
public class Booking implements Comparable<Booking> {
	
	@Id
	@Column(name = "booking_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;
	
	@ManyToOne
	@JoinColumn(name = "hotel_name_fk")
	private Hotel hotel;
	
	@ManyToOne
	@JoinColumn(name = "user_name_fk")
	private User user;
	
	@Column(name = "check_in_date")
	private String checkInDate;
	
	@Column(name = "check_out_date")
	private String checkOutDate;

	public Booking() {
		super();
	}

	public Booking(int bookingId, Hotel hotel, User user, String checkInDate, String checkOutDate) {
		super();
		this.bookingId = bookingId;
		this.hotel = hotel;
		this.user = user;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}

	public String getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", hotel=" + hotel + ", user=" + user + ", checkInDate="
				+ checkInDate + ", checkOutDate=" + checkOutDate + "]";
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bookingId;
		result = prime * result + ((checkInDate == null) ? 0 : checkInDate.hashCode());
		result = prime * result + ((checkOutDate == null) ? 0 : checkOutDate.hashCode());
		result = prime * result + ((hotel == null) ? 0 : hotel.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Booking other = (Booking) obj;
		if (bookingId != other.bookingId)
			return false;
		if (checkInDate == null) {
			if (other.checkInDate != null)
				return false;
		} else if (!checkInDate.equals(other.checkInDate))
			return false;
		if (checkOutDate == null) {
			if (other.checkOutDate != null)
				return false;
		} else if (!checkOutDate.equals(other.checkOutDate))
			return false;
		if (hotel == null) {
			if (other.hotel != null)
				return false;
		} else if (!hotel.equals(other.hotel))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public int compareTo(Booking o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
