package com.tcs.boot.Exception;

import java.util.Date;

public class MyErrorResponse {
private String message;
private String errorCode;
private Date  Time;
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public String getErrorCode() {
	return errorCode;
}
public void setErrorCode(String errorCode) {
	this.errorCode = errorCode;
}
public Date getTime() {
	return Time;
}
public void setTime(Date time) {
	Time = time;
}


}
