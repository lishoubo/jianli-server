/**
 * guanyuhuhu 2016年7月2日
 */
package com.jl.platform.service.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.SafeHtml;

import com.jl.platform.service.model.common.Address;

/**
 * @author zhanglu
 */
public class Charge extends BaseModel {
	private static final long serialVersionUID = -3150317123797033797L;

	/** 房屋面积 */
	@SafeHtml(whitelistType = SafeHtml.WhiteListType.SIMPLE_TEXT)
	@NotEmpty(message = "请填写房屋面积")
	private int area;

	/** 地址 */
	@NotEmpty(message = "请填写地址")
	private Address address;

	/** 客户姓名 */
	@NotEmpty(message = "请填写客户姓名")
	@SafeHtml(whitelistType = SafeHtml.WhiteListType.SIMPLE_TEXT)
	private String userName;

	/** 联系方式 */
	@SafeHtml(whitelistType = SafeHtml.WhiteListType.SIMPLE_TEXT)
	@NotEmpty(message = "请填写联系方式")
	private String mobile;

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
