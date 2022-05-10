package com.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ilp.utilities.DbCon;

/*
 *
 * CREATE TABLE cm1871044_users 
(
    userId NUMBER(12, 0) primary key,
    username VARCHAR2(32 BYTE) NOT NULL,
    password VARCHAR2(32 BYTE) NOT NULL
);
    
CREATE SEQUENCE USER_ID_SEQ MINVALUE 1 START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER USER_TR
    BEFORE INSERT
     ON cm1871044_users REFERENCING NEW as New OLD as Old
     FOR EACH ROW
        WHEN (New.userId is null)
         BEGIN
          :new.userId := user_id_seq.nextval;
        END;
/
--ALTER TRIGGER BUILDING_TR ENABLE;

SET DEFINE OFF; --Turn off substitution variables.
Insert into cm1871044_users (username, password) values ('Mike', 'mysecret');
Insert into cm1871044_users (username, password) values ('Rosa', 'willneverguess');

 * 
 */



public class UserDao {
	String table = "cm1871044_users";
	Connection con = DbCon.getConnection();
	
	public boolean isPasswordCorrect(String username, String password)
	{
		boolean result = false;
		try 
		{
			String qry = "Select count(*) from "+table+" where username = ? and password=?";
			PreparedStatement ps = con.prepareStatement(qry);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				if(rs.getInt(1) != 0)
					return true;
			}
			else
				System.out.println("No data");
				
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbCon.closeConnection();
		}
		
		return result;
	}
	
}
