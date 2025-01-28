package com.hojeti.smartsecurity.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Document(collection = "accesspeople")
public class AccessPeople {
    @Id
    private String uuid;

    @NotBlank
    @Size(max = 100)
    private String name;

    @NotBlank
    @Pattern(regexp = "\\d{11}", message = "Invalid CPF format")
    private String cpf;
    
    @NotBlank
    @Size(max = 2)
    private String uf;
    
    public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	@NotBlank
    @Size(max = 50)
    private String accessDirection;

    @NotBlank
    @Size(max = 50)
    private String accessLocation;

    @NotBlank
    @Size(max = 100)
    private String associationOrigin;

    @Pattern(regexp = "\\d{14}", message = "Invalid CNPJ format")
    private String associationCnpjOrigin;

    private LocalDateTime accessDateTime;

    @Size(max = 500000) 
    private String pictureAccess;

    @NotBlank
    @Pattern(regexp = "\\d{9}", message = "Invalid RG format") 
    private String rg;
    
	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

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

	public String getAccessDirection() {
		return accessDirection;
	}

	public void setAccessDirection(String accessDirection) {
		this.accessDirection = accessDirection;
	}

	public String getAccessLocation() {
		return accessLocation;
	}

	public void setAccessLocation(String accessLocation) {
		this.accessLocation = accessLocation;
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

	public LocalDateTime getAccessDateTime() {
		return accessDateTime;
	}

	public void setAccessDateTime(LocalDateTime accessDateTime) {
		this.accessDateTime = accessDateTime;
	}

	public String getPictureAccess() {
		return pictureAccess;
	}

	public void setPictureAccess(String pictureAccess) {
		this.pictureAccess = pictureAccess;
	}
    
    
}
