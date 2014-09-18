/**
 * 
 */
package com.sprhib.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sprhib.dao.TeamDAO;
import com.sprhib.model.Team;

/**
 * The Class TeamDAOImpl.
 *
 * @author Eedanna
 */
@Repository
public class TeamDAOImpl implements TeamDAO {

	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Gets the current session.
	 *
	 * @return the current session
	 */
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sprhib.dao.TeamDAO#addTeam(com.sprhib.model.Team)
	 */
	public void addTeam(Team team) {
		getCurrentSession().save(team);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sprhib.dao.TeamDAO#updateTeam(com.sprhib.model.Team)
	 */
	public void updateTeam(Team team) {
		Team teamToUpdate = getTeam(team.getId());
		teamToUpdate.setName(team.getName());
		teamToUpdate.setRating(team.getRating());
		getCurrentSession().update(teamToUpdate);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sprhib.dao.TeamDAO#getTeam(int)
	 */
	public Team getTeam(int id) {
		Team team = (Team) getCurrentSession().get(Team.class, id);
		return team;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sprhib.dao.TeamDAO#deleteTeam(int)
	 */
	public void deleteTeam(int id) {
		Team team = getTeam(id);
		if (team != null)
			getCurrentSession().delete(team);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sprhib.dao.TeamDAO#getTeams()
	 */
	@SuppressWarnings("unchecked")
	public List<Team> getTeams() {
		return getCurrentSession().createQuery("from Team").list();
	}

}
