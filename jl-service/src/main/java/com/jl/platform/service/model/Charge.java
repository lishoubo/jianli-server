/**
 * guanyuhuhu 2016年7月2日
 */
package com.jl.platform.service.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.SafeHtml;

import com.jl.platform.common.FitmentType;
import com.jl.platform.service.model.common.Address;

/**
 * @author zhanglu
 */
public class Charge extends BaseModel {
	private static final long serialVersionUID = -3150317123797033797L;

	/** 房屋面积 */
	@SafeHtml(whitelistType = SafeHtml.WhiteListType.SIMPLE_TEXT)
	@NotEmpty(message = "请填写房屋面积")
	private int acreage;

	/** 地址 */
	@NotEmpty(message = "请填写地址")
	private Address address;

	/** 装修档次 */
	@NotEmpty(message = "请选择装修档次")
	private FitmentType fitment;

	/** 联系方式 */
	@SafeHtml(whitelistType = SafeHtml.WhiteListType.SIMPLE_TEXT)
	@NotEmpty(message = "请填写联系方式")
	private String mobile;

	public int getAcreage() {
		return acreage;
	}

	public void setAcreage(int acreage) {
		this.acreage = acreage;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public FitmentType getFitment() {
		return fitment;
	}

	public void setFitment(FitmentType fitment) {
		this.fitment = fitment;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
