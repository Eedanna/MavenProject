package com.sprhib.dao;

import java.util.List;

import com.sprhib.model.Team;

/**
 * The Interface TeamDAO.
 */
public interface TeamDAO {

	/**
	 * Adds the team.
	 *
	 * @param team
	 *            the team
	 */
	public void addTeam(Team team);

	/**
	 * Update team.
	 *
	 * @param team
	 *            the team
	 */
	public void updateTeam(Team team);

	/**
	 * Gets the team.
	 *
	 * @param id
	 *            the id
	 * @return the team
	 */
	public Team getTeam(int id);

	/**
	 * Delete team.
	 *
	 * @param id
	 *            the id
	 */
	public void deleteTeam(int id);

	/**
	 * Gets the teams.
	 *
	 * @return the teams
	 */
	public List<Team> getTeams();
}
