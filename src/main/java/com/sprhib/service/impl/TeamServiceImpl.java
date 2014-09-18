/**
 * 
 */
package com.sprhib.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprhib.dao.TeamDAO;
import com.sprhib.model.Team;
import com.sprhib.service.TeamService;

// TODO: Auto-generated Javadoc
/**
 * The Class TeamServiceImpl.
 *
 * @author Eedanna
 */
@Service
@Transactional
public class TeamServiceImpl implements TeamService {
	
	/** The team dao. */
	@Autowired
	private TeamDAO teamDAO;

	/* (non-Javadoc)
	 * @see com.sprhib.service.TeamService#addTeam(com.sprhib.model.Team)
	 */
	public void addTeam(Team team) {
		teamDAO.addTeam(team);
	}

	/* (non-Javadoc)
	 * @see com.sprhib.service.TeamService#updateTeam(com.sprhib.model.Team)
	 */
	public void updateTeam(Team team) {
		teamDAO.updateTeam(team);
	}

	/* (non-Javadoc)
	 * @see com.sprhib.service.TeamService#getTeam(int)
	 */
	public Team getTeam(int id) {
		return teamDAO.getTeam(id);
	}

	/* (non-Javadoc)
	 * @see com.sprhib.service.TeamService#deleteTeam(int)
	 */
	public void deleteTeam(int id) {
		teamDAO.deleteTeam(id);
	}

	/* (non-Javadoc)
	 * @see com.sprhib.service.TeamService#getTeams()
	 */
	public List<Team> getTeams() {
		return teamDAO.getTeams();
	}

}
