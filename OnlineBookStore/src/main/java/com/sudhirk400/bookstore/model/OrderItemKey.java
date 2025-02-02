package com.sudhirk400.bookstore.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

 
/**
 * The Class OrderItemKey.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Embeddable
public class OrderItemKey implements Serializable {

    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1903819098810364746L;
	
	/** The order ID. */
	private Integer orderID;
	
    /** The book ID. */
    private Integer bookID;

}
