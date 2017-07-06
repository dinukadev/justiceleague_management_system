package com.justiceleague.justiceleaguemodule.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.justiceleague.justiceleaguemodule.dao.JusticeLeagueRepository;
import com.justiceleague.justiceleaguemodule.domain.JusticeLeagueMemberDetail;
import com.justiceleague.justiceleaguemodule.exception.JusticeLeagueManagementException;
import com.justiceleague.justiceleaguemodule.service.JusticeLeagueMemberService;
import com.justiceleague.justiceleaguemodule.web.dto.JusticeLeagueMemberDTO;
import com.justiceleague.justiceleaguemodule.web.transformer.DTOToDomainTransformer;

/**
 * This service class implements the {@link JusticeLeagueMemberService} to
 * provide the functionality required for the justice league system.
 * 
 * @author dinuka
 *
 */
@Service
public class JusticeLeagueMemberServiceImpl implements JusticeLeagueMemberService {

	@Autowired
	private JusticeLeagueRepository justiceLeagueRepo;

	/**
	 * {@inheritDoc}
	 */
	public void addMember(JusticeLeagueMemberDTO justiceLeagueMember) {
		JusticeLeagueMemberDetail dbMember = justiceLeagueRepo.findByName(justiceLeagueMember.getName());

		if (dbMember != null) {
			throw new JusticeLeagueManagementException("The member already exists.");
		}
		JusticeLeagueMemberDetail memberToPersist = DTOToDomainTransformer.transform(justiceLeagueMember);
		justiceLeagueRepo.insert(memberToPersist);
	}

}
