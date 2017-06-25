package com.justiceleague.justiceleaguemodule.dao;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.justiceleague.justiceleaguemodule.domain.JusticeLeagueMemberDetail;

public interface JusticeLeagueRepository extends MongoRepository<JusticeLeagueMemberDetail, ObjectId>{


}
