package com.springboot;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private JdbcTemplate jdbcTemplate;
  
  private EmbeddedDatabase db;
  
  @PostConstruct
  public void userService(){
	  db = new EmbeddedDatabaseBuilder()
	    		.setType(EmbeddedDatabaseType.H2)
	    		.addScript("db/sql/create-db.sql")
	    		.addScript("db/sql/insert-data.sql")
	    		.build();
  }
  

  /*public int addU(User user){
    String sql = "INSERT INTO user(first_name, last_name, age, place) VALUES(?,?,?,?)";
    return jdbcTemplate.update(sql, user.getFirstName(),
        user.getLastName(), user.getAge(), user.getPlace());
  }*/

  public List<User> getAllUsers(){
    return jdbcTemplate.query("SELECT * FROM USER", new RowMapper<User>(){

      public User mapRow(ResultSet rs, int arg1) throws SQLException {
        User u = new User();
        u.setId(rs.getInt("id"));
        u.setName(rs.getString("name"));
        u.setEmail(rs.getString("email"));
        return u;
      }

    });
  }
}