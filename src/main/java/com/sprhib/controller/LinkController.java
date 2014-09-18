/**
 * 
 */
package com.sprhib.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// TODO: Auto-generated Javadoc
/**
 * The Class LinkController.
 *
 * @author Eedanna
 */
@Controller
public class LinkController {

	/**
	 * Main page.
	 *
	 * @return the model and view
	 */
	@RequestMapping(value = "/")
	public ModelAndView mainPage() {
		return new ModelAndView("home");
	}

	/**
	 * Index page.
	 *
	 * @return the model and view
	 */
	@RequestMapping(value = "/index")
	public ModelAndView indexPage() {
		return new ModelAndView("home");
	}

}