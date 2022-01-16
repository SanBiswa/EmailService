package com.hirekarma.beans;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Arrays;

import org.springframework.web.multipart.MultipartFile;

public class UserBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long userId;
	private String name;
	private String email;
	private String universityEmailAddress;
	private String phoneNo;
    private byte[] image;
	private String userType;
	private String password;
	private String address;
	private Timestamp createdOn;
	private Timestamp updatedOn;
	private MultipartFile file;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUniversityEmailAddress() {
		return universityEmailAddress;
	}
	public void setUniversityEmailAddress(String universityEmailAddress) {
		this.universityEmailAddress = universityEmailAddress;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Timestamp getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}
	public Timestamp getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(Timestamp updatedOn) {
		this.updatedOn = updatedOn;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	@Override
	public String toString() {
		return "UserBean [userId=" + userId + ", name=" + name + ", email=" + email + ", universityEmailAddress="
				+ universityEmailAddress + ", phoneNo=" + phoneNo + ", image=" + Arrays.toString(image) + ", userType="
				+ userType + ", password=" + password + ", address=" + address + ", createdOn="
				+ createdOn + ", updatedOn=" + updatedOn + ", file=" + file + "]";
	}
}