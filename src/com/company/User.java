package com.company;

import java.time.LocalDate;


public class User {

          int id , phone;
          String username,password   ;
          LocalDate birthDate;
          public User( int id, int phone,String username,String password,LocalDate birthDate){
              this.id=id;
              this.phone=phone;
              this.password= password;
              this.username=username;
              this.birthDate=birthDate;

          }

}
