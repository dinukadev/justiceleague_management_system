package com.justiceleague.justiceleaguemodule.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.justiceleague.justiceleaguemodule.domain.JusticeLeagueMemberDetail;

public interface JusticeLeagueRepository extends MongoRepository<JusticeLeagueMemberDetail, String> {

	/**
	 * This method will retrieve the justice league member details pertaining to
	 * the name passed in.
	 * 
	 * @param superHeroName
	 *            the name of the justice league member to search and retrieve.
	 * @return an instance of {@link JusticeLeagueMemberDetail} with the member
	 *         details.
	 */
	@Query("{ 'name' : {$regex: ?0, $options: 'i' }}")
	JusticeLeagueMemberDetail findBySuperHeroName(final String superHeroName);
}
