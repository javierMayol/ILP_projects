package com.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.ChicagoArchitecture;
import com.utilities.DbCon;

/*
 *  
CREATE TABLE cm1871044_CHICAGO_ARCHITECTURE 
(
    BUILDING_ID NUMBER(12,0) primary key, 
    BUILDING_NAME VARCHAR2(60 BYTE) NOT NULL, 
    ARCHITECTS VARCHAR2(60 BYTE) NOT NULL,
    ADDRESS VARCHAR2 (80 CHAR) NOT NULL,
    YEAR_BUILT NUMBER(6,0) 
);

--CREATE SEQUENCE id
CREATE SEQUENCE BUILDING_ID_SEQ MINVALUE 1 START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER BUILDING_TR
    BEFORE INSERT
     ON cm1871044_CHICAGO_ARCHITECTURE REFERENCING NEW as New OLD as Old
     FOR EACH ROW
        WHEN (New.building_id is null)
         BEGIN
          :new.building_id := building_id_seq.nextval;
        END;
/
--ALTER TRIGGER BUILDING_TR ENABLE;

SET DEFINE OFF; --Turn off substitution variables.
Insert into cm1871044_CHICAGO_ARCHITECTURE (BUILDING_NAME, ARCHITECTS, ADDRESS, YEAR_BUILT) values ('Robie House' , 'Frank Lloyd Wright', '5757 S Woodlawn Ave', 1909);
Insert into cm1871044_CHICAGO_ARCHITECTURE (BUILDING_NAME, ARCHITECTS, ADDRESS, YEAR_BUILT) values ('Navy Pier', 'D. Burnham '|| chr(38) ||' E. H. Bennett', '600 E. Grand Avenue', 1916);
Insert into cm1871044_CHICAGO_ARCHITECTURE (BUILDING_NAME, ARCHITECTS, ADDRESS, YEAR_BUILT) values ('DuSable Bridge', 'E. H. Bennett', 'Michigan Avenue', 1920);
Insert into cm1871044_CHICAGO_ARCHITECTURE (BUILDING_NAME, ARCHITECTS, ADDRESS, YEAR_BUILT) values ('Wrigley Building', 'GAP '|| chr(38) ||' W', '400-410 N. Michigan Ave', 1924);
Insert into cm1871044_CHICAGO_ARCHITECTURE (BUILDING_NAME, ARCHITECTS, ADDRESS, YEAR_BUILT) values ('John Hancock Center', 'F. R. Khan '|| chr(38) ||' SOM', '875 North Michigan', 1969);
Insert into cm1871044_CHICAGO_ARCHITECTURE (BUILDING_NAME, ARCHITECTS, ADDRESS, YEAR_BUILT) values ('Wanda Vista Tower', 'Jeanne Gang', '363 East Wacker Drive', 2020);
Insert into cm1871044_CHICAGO_ARCHITECTURE (BUILDING_NAME, ARCHITECTS, ADDRESS, YEAR_BUILT) values ('330 North Wabash', 'Ludwig Mies van der Rohe', '330 North Wabash', 1973);
Insert into cm1871044_CHICAGO_ARCHITECTURE (BUILDING_NAME, ARCHITECTS, ADDRESS, YEAR_BUILT) values ('Millennium Park', 'Many', '201 E Randolph St' , 2004);

commit;
 */

public class ChicagoArchitectureDao implements DAOInterface<ChicagoArchitecture> {
	
	public static String table = "cm1871044_CHICAGO_ARCHITECTURE";
	ArrayList<ChicagoArchitecture> buildings = new ArrayList<>();


	@Override
	public ArrayList<ChicagoArchitecture> findAll() {
		Connection con = DbCon.getConnection();
		
		try {
			String sql = "select * from "+ table;
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			//Populate games array with game board objects if rs.next().
			while(rs.next()) 
			{
				ChicagoArchitecture building = new ChicagoArchitecture();
				building.setBuildingId(rs.getInt(1));
				building.setBuildingName(rs.getString(2));
				building.setArchitects(rs.getString(3));
				building.setAddress(rs.getString(4));
				building.setYearBuilt(rs.getInt(5));
				
				buildings.add(building);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbCon.closeConnection();
		}
		return buildings;
	}

	@Override
	public ChicagoArchitecture findById(int id) {
		
			Connection con = DbCon.getConnection();
			ChicagoArchitecture building = new ChicagoArchitecture(); //b  for building;
				
				try {
					String sql = "select * from "+ table + " where building_id = ?";
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setInt(1, id);
					ResultSet rs = ps.executeQuery();
					
					//Populate games array with game board objects if rs.next().
					while(rs.next()) 
					{
						building.setBuildingId(rs.getInt(1));
						building.setBuildingName(rs.getString(2));
						building.setArchitects(rs.getString(3));
						building.setAddress(rs.getString(4));
						building.setYearBuilt(rs.getInt(5));
					}
					
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					DbCon.closeConnection();
				}
				return building;
	}

	@Override
	public void update(ChicagoArchitecture obj) {
		Connection con = DbCon.getConnection();
		
		try {
			String qry = "update "+table+" set building_name = ?, architects=?, address=?, year_built=? where building_id=?";
			PreparedStatement ps = con.prepareStatement(qry);
			ps.setString(1, obj.getBuildingName());
			ps.setString(2, obj.getArchitects());
			ps.setString(3, obj.getAddress());
			ps.setInt(4, obj.getYearBuilt());
			ps.setInt(5, obj.getBuildingId());
			ps.executeUpdate();
			
			System.out.println(obj.getBuildingName());
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbCon.closeConnection();
		}
		
	}

	@Override
	public ChicagoArchitecture save(ChicagoArchitecture obj) {
		Connection con = DbCon.getConnection();
		
		try
		{
			String qry = "insert into "+table+" (BUILDING_NAME, ARCHITECTS, ADDRESS, YEAR_BUILT) values (?, ?, ?, ?)";
			PreparedStatement st = con.prepareStatement(qry);
			st.setString(1, obj.getBuildingName());
			st.setString(2, obj.getArchitects());
			st.setString(3, obj.getAddress());
			st.setInt(4, obj.getYearBuilt());
			
			st.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			DbCon.closeConnection();
		}
	
		return obj;
	}

	@Override
	public void deleteById(int id) {
		Connection con = DbCon.getConnection();
		
		try
		{
			
			String qry = "delete from "+table+" where building_id = ?";
			PreparedStatement ps = con.prepareStatement(qry);
			ps.setInt(1,id);
			ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			DbCon.closeConnection();
		}
		
	}
	
	@Override
	public ArrayList<ChicagoArchitecture> sort(String sorting) {
		Connection con = DbCon.getConnection();
		
		try {
			String sql = "select * from "+ table + " order by year_built "+sorting;
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			//Populate games array with game board objects if rs.next().
			while(rs.next()) 
			{
				ChicagoArchitecture building = new ChicagoArchitecture();
				building.setBuildingId(rs.getInt(1));
				building.setBuildingName(rs.getString(2));
				building.setArchitects(rs.getString(3));
				building.setAddress(rs.getString(4));
				building.setYearBuilt(rs.getInt(5));
				
				buildings.add(building);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbCon.closeConnection();
		}
		return buildings;
	}

	

}
