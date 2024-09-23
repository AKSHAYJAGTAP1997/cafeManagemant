package com.inn.cafe.com.inn.cafe.serviceImpl;

import com.inn.cafe.com.inn.cafe.POJO.User;
import com.inn.cafe.com.inn.cafe.constants.CafeConstants;
import com.inn.cafe.com.inn.cafe.dao.UserDao;
import com.inn.cafe.com.inn.cafe.service.UserService;
import com.inn.cafe.com.inn.cafe.utils.CafeUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Slf4j // logging purpose
@Service
public class UserServiceImpl implements UserService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserDao userDao;

    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {

        log.info("Inside SignUp {}",requestMap);
        if(validateSignUpMap(requestMap)){

            User user = userDao.findByEmail(requestMap.get("email"));
            if(Objects.isNull(user)){

                userDao.save(getUserFromMap(requestMap));
                return CafeUtils.getResponseEntity("Saved user", HttpStatus.OK);


            }else{
                return  CafeUtils.getResponseEntity("Email already exists", HttpStatus.BAD_REQUEST);
            }


        }
        else {
            return CafeUtils.getResponseEntity(CafeConstants.INVALID_DATA, HttpStatus.BAD_REQUEST);
        }
      //  return null;

    }

    private boolean validateSignUpMap(Map<String, String> requestMap){

        if(requestMap.containsKey("name") && requestMap.containsKey("contactNumber")
                && requestMap.containsKey("email") && requestMap.containsKey("password")){
            return  true;
        }
        return false;
    }

    private  static User getUserFromMap(Map<String, String> requestMap){
        User user = new User();
        user.setName(requestMap.get("name"));
        user.setContactNumber(requestMap.get("contactNumber"));
        user.setEmail(requestMap.get("email"));
        user.setPassword(requestMap.get("password"));
        user.setRole("role");
        user.setStatus("status");
        return user;
    }
}
