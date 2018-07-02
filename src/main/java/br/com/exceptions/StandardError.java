package br.com.exceptions;

import java.io.Serializable;
		
public class StandardError implements Serializable {
	
	private static final long serialVersionUID = -5L;
	
	private Integer status;
	private String msg;
	private String data;
	
	public StandardError(Integer status, String msg, String data) {
		super();
		this.status = status;
		this.msg = msg;
		this.data = data;
	}

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * @return the dateTime
	 */
	public String getDateTime() {
		return data;
	}

	/**
	 * @param dateTime the dateTime to set
	 */
	public void setDateTime(String dateTime) {
		this.data = dateTime;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "StandardError [status=" + status + ", msg=" + msg + ", data=" + data + "]";
	}
	
}
