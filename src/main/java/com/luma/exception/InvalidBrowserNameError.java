package com.luma.exception;

public class InvalidBrowserNameError extends Error {
	private String msg;

	public InvalidBrowserNameError(String text) {
		msg = "Invalid Browser name" + text;
	}

	@Override
	public String toString() {

		return msg;
	}
}
