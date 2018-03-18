# mymovies-rest

Movies RESTful service is developed with below technologies
1. Spring Boot
2. Mongo DB

Other technical stuff includes:
1. Add AOP for latency logging
2. Swagger for documentation
3. Junits
4. Cucumber Tests

It has below RESTful operations.
CRUD - 
Create - Done
Read - 
	> GET movie with name "Test Movie" - Done
	> GET movie with name "Test Movie" and "director" as "Cameron1" - Done
	> GET movie with name "Test Movie" and "director" as "Cameron1" and "averageRating" as 3.3
	> GET movie with name "Test Movie" and ratingList with site as Imdb - Done
	> GET movie with name "Test Movie" and ratingList with site as Imdb and rating as "3" and ratingList with site as Rotten Tomatoes and rating as "3"
	> GET only movie ratings - ratingList with site as Rotten Tomatoes and rating as "3"
	> Have some other criteria
Update - Pending
	> Update movie with name "Test Movie" to "Titatic"
	> Update movie with name "Test Movie" and "director" as "Cameron1"  to "Titatic" and "director" as "Cameron"
	> Update movie with name "Test Movie" and "director" as "Cameron1" and "averageRating" as 3.3 to Something else
	> Update movie with name "Test Movie" and ratingList with site as Imdb and rating as "3" to Something else
	> Update movie with name "Test Movie" and ratingList with site as Imdb and rating as "3" and ratingList with site as Rotten Tomatoes and rating as "3" to Something else
	> Have some other criteria
Delete - 
	> GET movie with name "Test Movie" - Done
	> GET movie with name "Test Movie" and "director" as "Cameron1" - Done
	> GET movie with name "Test Movie" and "director" as "Cameron1" and "averageRating" as 3.3
	> GET movie with name "Test Movie" and ratingList with site as Imdb - Done
	> GET movie with name "Test Movie" and ratingList with site as Imdb and rating as "3" and ratingList with site as Rotten Tomatoes and rating as "3"
	> GET only movie ratings - ratingList with site as Rotten Tomatoes and rating as "3"
	> Have some other criteria

