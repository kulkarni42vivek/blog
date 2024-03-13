package com.blogservice.blog.entities;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
@AttributeOverrides({
	@AttributeOverride(name = "pincode" ,column = @Column(name="postal_pincode")),
	@AttributeOverride(name = "address" ,column = @Column(name="postal_adr")),
	@AttributeOverride(name = "state" ,column = @Column(name="postal_state")),
	@AttributeOverride(name = "district" ,column = @Column(name="postal_district"))
})
public class AddressModel {
	public int pincode;
	public String address ;
	public String state ;
	public String district ;
}
