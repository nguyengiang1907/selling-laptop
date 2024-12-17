package com.example.sellinglaptops.model;

import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.springframework.web.multipart.MultipartFile;
@Getter
@Setter
public class AccountDTO {
    private String name;
    private String email;
    private String password;
    private String rePassword;
    private String phoneNumber;
    private String address;
    private MultipartFile image;

    public AccountDTO() {
    }

    public AccountDTO(String name, String email, String password, String rePassword, String phoneNumber, String address, MultipartFile image) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.rePassword = rePassword;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.image = image;
    }
}
