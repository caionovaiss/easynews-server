package com.easynews.easynewsserver.model;

public record UserRequest(String email, String password, String cpf, String dateOfBirth) {
}
