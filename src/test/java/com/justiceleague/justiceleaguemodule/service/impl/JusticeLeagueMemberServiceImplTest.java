package com.justiceleague.justiceleaguemodule.service.impl;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.justiceleague.justiceleaguemodule.dao.JusticeLeagueRepository;
import com.justiceleague.justiceleaguemodule.domain.JusticeLeagueMemberDetail;
import com.justiceleague.justiceleaguemodule.exception.JusticeLeagueManagementException;
import com.justiceleague.justiceleaguemodule.test.util.BaseIntegrationTest;
import com.justiceleague.justiceleaguemodule.web.dto.JusticeLeagueMemberDTO;

/**
 * This class will test out the functionality exposed by
 * {@link JusticeLeagueMemberServiceImpl}.
 * 
 * @author dinuka
 *
 */
public class JusticeLeagueMemberServiceImplTest extends BaseIntegrationTest {

	@Autowired
	private JusticeLeagueMemberServiceImpl justiceLeagueMemberService;

	@Autowired
	private JusticeLeagueRepository justiceLeagueRepo;

	@Autowired
	private MongoTemplate mongoTemplate;

	@After
	public void tearDown() {
		mongoTemplate.dropCollection(JusticeLeagueMemberDetail.class);
	}

	@Test
	public void testAddMember() {
		JusticeLeagueMemberDTO member = new JusticeLeagueMemberDTO("Barry Allen", "Super Speed", "Central City");
		justiceLeagueMemberService.addMember(member);

		JusticeLeagueMemberDetail addedMemberFromDB = justiceLeagueRepo.findBySuperHeroName("Barry Allen");

		Assert.assertNotNull("The member retrieved from the DB should not be null", addedMemberFromDB);
	}

	@Test(expected = JusticeLeagueManagementException.class)
	public void testAddMemberWhenMemberAlreadyExists() {
		JusticeLeagueMemberDetail flash = new JusticeLeagueMemberDetail("Barry Allen", "Super speed", "Central City");
		justiceLeagueRepo.save(flash);
		JusticeLeagueMemberDTO member = new JusticeLeagueMemberDTO("Barry Allen", "Super Speed", "Central City");
		justiceLeagueMemberService.addMember(member);
	}

}
