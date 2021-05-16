package com.example.demo.models.response;

public enum ErrorMessages {
	MISSING_REQUIRED_FIELD("Missing requiered field."), RECORD_ALREADY_EXISTS("Record already exists"),
	INTERNAL_SERVER_ERROR("Internal server error"), NO_RECORD_FOUND("Record with provided id is not found"),
	AUTHENTICATION_FAILED("Authentication failed"), COULD_NOT_UPDATE_RECORD("Could not update record"),
	COULD_NOT_DELETE_RECORD("Could not delete record"),
	COULD_NOT_DELETE_USER_ID("Could not delete. User not found with ID: "),
	EMAIL_ADDRESS_NOT_VERIFIED("Email address could not be verified"), EMAIL_NOT_FOUND("Email not found : ");

	private String errorMessage;

	private ErrorMessages(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * 
	 * @param errorMessage
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
