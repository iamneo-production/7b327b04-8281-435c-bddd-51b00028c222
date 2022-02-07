package com.examly.springapp.repositories;

//import java.util.List;

//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.transaction.annotation.Transactional;

import com.examly.springapp.models.login;

public interface loginRepo extends CrudRepository<login, String>  {
    public login deleteByEmail(String email);
}
