package com.movies;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

@Component
public class MovieDataAccessServiceImpl implements DataAccessService {

	@Autowired
	MongoTemplate mongoTemplate;
	
	@Override
	public List<MovieDto> search(RequestDto requestDto) {
		Query criteriaQuery = buildCriteriaQuery(requestDto);
		List<MovieDto> moviesList = mongoTemplate.find(criteriaQuery, MovieDto.class);
		return moviesList;
	}

	@Override
	public MovieDto getOne(RequestDto requestDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(MovieDto movieDto) {
		//Invalid Data
		//then Throw exception to controller
		Query criteriaQuery = new Query();
		criteriaQuery.addCriteria(Criteria.where("name").is(movieDto.getName()));

		List<MovieDto> moviesList = mongoTemplate.find(criteriaQuery, MovieDto.class);
		if (moviesList.isEmpty()) {
			mongoTemplate.save(movieDto);
		}
	}

	private Query buildCriteriaQuery(RequestDto requestDto) {
		Query criteriaQuery = new Query();
		switch (requestDto.getSearchIndicator()) {
		
		case "name":
			criteriaQuery = criteriaQuery.addCriteria(Criteria.where("name").is(requestDto.getRequestParamMap().get("name")));
			break;
			
		case "namedirector":
			criteriaQuery = criteriaQuery.addCriteria(Criteria.where("name").is(requestDto.getRequestParamMap().get("name"))
					.andOperator(Criteria.where("director").is(requestDto.getRequestParamMap().get("director"))));
			break;
			
		case "namewebsiterating":
			criteriaQuery = criteriaQuery.addCriteria(Criteria.where("name").is(requestDto.getRequestParamMap().get("name"))
					.andOperator(Criteria.where("ratingList.website").is(requestDto.getRequestParamMap().get("website")))
					.andOperator(Criteria.where("ratingList.rating").is(requestDto.getRequestParamMap().get("rating"))));
			break;
			
		case "namewebsite":
			criteriaQuery = criteriaQuery.addCriteria(Criteria.where("name").is(requestDto.getRequestParamMap().get("name"))
					.andOperator(Criteria.where("ratingList.website").is(requestDto.getRequestParamMap().get("website"))));
			break;
		}
		return criteriaQuery;
	}

	@Override
	public void delete(RequestDto requestDto) {
		Query criteriaQuery = buildCriteriaQuery(requestDto);
		mongoTemplate.remove(criteriaQuery,  "Movies_Collection");
	}

	@Override
	public void update(MovieDto movieDto) {

		Query criteriaQuery = new Query();
		criteriaQuery.addCriteria(Criteria.where("name").is(movieDto.getName()));
		performUpsert(criteriaQuery, movieDto);
	}
	
	/**
	 * Perform an upsert operation to update ALL FIELDS in an object using native mongo driver's methods
	 * since mongoTemplate's upsert method doesn't allow it
	 * @param upsertQuery
	 * @param object
	 * @param collectionName
	 */
	private void performUpsert(Query upsertQuery, Object object) {

		//build update
		Document dbDoc = new Document();
		mongoTemplate.getConverter().write(object, dbDoc); //it is the one spring use for convertions.
		Update update = new Update();
		dbDoc.remove("_id");    // just to be sure to not create any duplicates
		update = Update.fromDocument(dbDoc, "_id");

		//run it!
		mongoTemplate.upsert(upsertQuery, update,  MovieDto.class);

	}
	
}
