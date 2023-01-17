package com.rationcenter.api.dto.userDtos;

public class SignInResponseDto {
    private String status;
    private String token;

    public SignInResponseDto(String status, String token) {
        this.status = status;
        this.token = token;
    }

    public SignInResponseDto() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "SignInResponseDto [status=" + status + ", token=" + token + "]";
    }

}
