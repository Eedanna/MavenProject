/**
 * 
 */
package com.sprhib.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sprhib.model.Team;
import com.sprhib.service.TeamService;

// TODO: Auto-generated Javadoc
/**
 * The Class TeamController.
 *
 * @author Eedanna
 */
@Controller
public class TeamController {

	/** The team service. */
	@Autowired
	private TeamService teamService;

	/**
	 * Adds the team page.
	 *
	 * @return the model and view
	 */
	@RequestMapping(value = "/team/add")
	public ModelAndView addTeamPage() {
		ModelAndView modelAndView = new ModelAndView("add-team-form");
		modelAndView.addObject("team", new Team());
		return modelAndView;
	}

	/**
	 * Adding team.
	 *
	 * @param team the team
	 * @return the model and view
	 */
	@RequestMapping(value = "/team/add/process")
	public ModelAndView addingTeam(@ModelAttribute Team team) {

		ModelAndView modelAndView = new ModelAndView("home");
		teamService.addTeam(team);

		String message = "Team was successfully added.";
		modelAndView.addObject("message", message);

		return modelAndView;
	}

	/**
	 * List of teams.
	 *
	 * @return the model and view
	 */
	@RequestMapping(value = "/team/list")
	public ModelAndView listOfTeams() {
		ModelAndView modelAndView = new ModelAndView("list-of-teams");

		List<Team> teams = teamService.getTeams();
		modelAndView.addObject("teams", teams);

		return modelAndView;
	}

	/**
	 * Edits the team page.
	 *
	 * @param id the id
	 * @return the model and view
	 */
	@RequestMapping(value = "/team/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editTeamPage(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("edit-team-form");
		Team team = teamService.getTeam(id);
		modelAndView.addObject("team", team);
		return modelAndView;
	}

	/**
	 * Edditing team.
	 *
	 * @param team the team
	 * @param id the id
	 * @return the model and view
	 */
	@RequestMapping(value = "/team/edit/{id}", method = RequestMethod.POST)
	public ModelAndView edditingTeam(@ModelAttribute Team team,
			@PathVariable Integer id) {

		ModelAndView modelAndView = new ModelAndView("home");

		teamService.updateTeam(team);

		String message = "Team was successfully edited.";
		modelAndView.addObject("message", message);

		return modelAndView;
	}

	/**
	 * Delete team.
	 *
	 * @param id the id
	 * @return the model and view
	 */
	@RequestMapping(value = "/team/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteTeam(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("home");
		teamService.deleteTeam(id);
		String message = "Team was successfully deleted.";
		modelAndView.addObject("message", message);
		return modelAndView;
	}

}