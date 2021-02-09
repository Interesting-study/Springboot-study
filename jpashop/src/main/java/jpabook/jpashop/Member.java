package jpabook.jpashop;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Member {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    //ids for this class must be manually assigned before calling save() hibernate
    private Long id;
    private String username;
}
