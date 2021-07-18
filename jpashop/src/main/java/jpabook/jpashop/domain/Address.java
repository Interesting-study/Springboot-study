package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
// Getter는 열어두지만, Setter는 잘 생각해봐야함
public class Address {

    private String city;
    private String street;
    private String zipcode;

    protected Address(){

    }

    public Address(String city, String street, String zipcode){
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
