/**
 * guanyuhuhu 2016年6月9日
 */
package com.my.home.common;

/**
 * @author zhanglu
 */
public class BizException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorCode;
	private String errorMessage;
	private String viewErrorMessage;

	public BizException(String errorCode, String errorMessage,
			String viewErrorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.viewErrorMessage = viewErrorMessage;
	}

	public BizException(StatusCode status) {
		this.errorCode = status.getCode();
		this.errorMessage = status.getMessage();
		this.viewErrorMessage = status.getViewMesage();

	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public String getViewErrorMessage() {
		return viewErrorMessage;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public void setViewErrorMessage(String viewErrorMessage) {
		this.viewErrorMessage = viewErrorMessage;
	}

}
