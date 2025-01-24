package com.sudhirk400.bookstore.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Embeddable
public class OrderItemKey implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -1903819098810364746L;
	
	private Integer orderID;
    private Integer bookID;

}
