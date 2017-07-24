package com.justiceleague.justiceleaguemodule.dao;

import org.hamcrest.beans.SamePropertyValuesAs;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.justiceleague.justiceleaguemodule.domain.JusticeLeagueMemberDetail;
import com.justiceleague.justiceleaguemodule.test.util.BaseIntegrationTest;

/**
 * <p>
 * This class will test the functionality exposed by
 * {@link JusticeLeagueRepository}. Since we are using
 * {@link BaseIntegrationTest}, it will boot up an embedded mongodb.
 * </p>
 * 
 * @author dinuka
 *
 */
public class JusticeLeagueRepositoryTest extends BaseIntegrationTest {

	@Autowired
	private JusticeLeagueRepository justiceLeagueRepo;

	@Autowired
	private MongoTemplate mongoTemplate;

	@After
	public void tearDown() {
		mongoTemplate.dropCollection(JusticeLeagueMemberDetail.class);
	}

	/**
	 * This method will test if we can successfully retrieve the justice league
	 * members using there name.
	 */
	@Test
	public void testFindByName() {
		JusticeLeagueMemberDetail expected = new JusticeLeagueMemberDetail("Barry Allen", "Super speed",
				"Central City");
		mongoTemplate.save(expected);

		JusticeLeagueMemberDetail actual = justiceLeagueRepo.findBySuperHeroName("barry allen");

		Assert.assertThat(actual, SamePropertyValuesAs.samePropertyValuesAs(expected));
	}

}
