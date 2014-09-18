/**
 * 
 */
package com.sprhib.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Team.
 *
 * @author Eedanna
 */
@Entity
@Table(name="teams")
public class Team {

	/**
	 * The Constructor.
	 */
	public Team() {
		// TODO Auto-generated constructor stub
	}

	/** The id. */
	@Id
	@GeneratedValue
	private Integer id;

	/** The name. */
	private String name;

	/** The rating. */
	private Integer rating;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the rating.
	 *
	 * @return the rating
	 */
	public Integer getRating() {
		return rating;
	}

	/**
	 * Sets the rating.
	 *
	 * @param rating the rating
	 */
	public void setRating(Integer rating) {
		this.rating = rating;
	}

}
