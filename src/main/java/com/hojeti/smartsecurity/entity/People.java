package com.hojeti.smartsecurity.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Document(collection = "people")
public class People {
    @Id
    private String uuid;

    @NotBlank
    @Size(max = 100)
    private String name;

    @NotBlank
    @Pattern(regexp = "\\d{11}", message = "Invalid CPF format")
    private String cpf;

    @Size(max = 30)
    private String rg;

    @Size(max = 50)
    private String category;

    @Pattern(regexp = "\\d{7,11}", message = "Invalid cellphone format")
    private String cellphone;

    @Size(max = 7)
    private String licensePlate;

    @Size(max = 100)
    private String fatherName;

    @Size(max = 100)
    private String motherName;

    @Size(max = 100)
    private String associationOrigin;

    @Pattern(regexp = "\\d{14}", message = "Invalid CNPJ format")
    private String associationCnpjOrigin;

    @Size(max = 500000) 
    private String pictureFace;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getAssociationOrigin() {
		return associationOrigin;
	}

	public void setAssociationOrigin(String associationOrigin) {
		this.associationOrigin = associationOrigin;
	}

	public String getAssociationCnpjOrigin() {
		return associationCnpjOrigin;
	}

	public void setAssociationCnpjOrigin(String associationCnpjOrigin) {
		this.associationCnpjOrigin = associationCnpjOrigin;
	}

	public String getPictureFace() {
		return pictureFace;
	}

	public void setPictureFace(String pictureFace) {
		this.pictureFace = pictureFace;
	}
    
    
    
}
