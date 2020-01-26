package com.fastsloth.dao;
import java.sql.*;
import java.util.ArrayList;

import com.fastsloth.beans.Dog;
import com.fastsloth.beans.ShowList;

public class DAO {
	
	// Method for adding dogs into a database (table name = dog_list)
	public void addDog(Dog d) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = null;
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost/dogShow", "root", "root");
			
			String preparedStatement = "INSERT INTO dog_list VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement ps = conn.prepareStatement(preparedStatement);
			
			ps.setInt(1, d.getNumber());
			ps.setString(2, d.getName());
			ps.setString(3, d.getOwnerName());
			ps.setString(4, d.getBreed());
			ps.setString(5, d.getGroup());
			ps.setString(6, d.getGender());
			ps.setString(7, d.getDogClass());
			ps.setString(8, d.getDay1());
			ps.setString(9, d.getDay2());
			ps.setString(10, d.getDay3());
			ps.setString(11, d.getEmail());
			ps.setString(12, d.getPassword());
			ps.setString(13, d.getMembership());
			
			ps.executeUpdate();
						
			System.out.println("Connection Success");
			conn.close();
		} catch (Exception e) {
			System.out.println("Connection Failed");
			System.out.println(e);
		}
	}

	// Method for getting dog list from the database (table name = dog_list)
	
	public ArrayList<Dog> getDog() {
		ArrayList<Dog> dogs = new ArrayList<Dog>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = null;
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost/dogShow", "root", "root");
			String q = "SELECT * FROM dog_list";
			
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery(q);			
						
			while(rs.next()) {
				Dog dog = new Dog();
				dog.setNumber(rs.getInt(1));
				System.out.println(dog.getNumber());
				dog.setName(rs.getString(2));
				dog.setOwnerName(rs.getString(3));
				dog.setBreed(rs.getString(4));
				dog.setGroup(rs.getString(5));
				dog.setGender(rs.getString(6));
				dog.setDogClass(rs.getString(7));
				dog.setDay1(rs.getString(8));
				dog.setDay2(rs.getString(9));
				dog.setDay3(rs.getString(10));
				
				if (rs.getString(8).equals("on")) {
					dog.setDay1("Fri");
				} else {
					dog.setDay1("");
				}
					
				if (rs.getString(9).equals("on")) {
					dog.setDay2("Sat");
				} else {
					dog.setDay2("");
				}
				
				if (rs.getString(10).equals("on")) {
					dog.setDay3("Sun");
				} else {
					dog.setDay3("");
				}
				
				dogs.add(dog);
			}
				
			System.out.println("Connection Success");
			conn.close();
		} catch (Exception e) {
			System.out.println("Connection Failed");
			System.out.println(e);
		}
		return dogs;
	}

	// Method for getting show list from the database (table name = dog_list)
	
	public ArrayList<ShowList> getShowList(int date, int groupKey) {
		ArrayList<ShowList> showLists = new ArrayList<ShowList>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = null;
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost/dogShow", "root", "root");

			String dateReal;
			
				if (date == 1) {
					dateReal = "Day1";
				} else if (date ==2) {
					dateReal = "Day2";					
				} else {
					dateReal = "Day3";
				}
			
			String groupNo = "Null";
			
				if (groupKey == 1) {
					groupNo = "Group 1: Sporting Dogs";
				} else if (groupKey == 2) {
					groupNo = "Group 2: Hounds";
				} else if (groupKey == 3) {
					groupNo = "Group 3: Working Dogs";
				} else if (groupKey == 4) {
					groupNo = "Group 4: Terriers";
				} else if (groupKey == 5) {
					groupNo = "Group 5: Toys";
				} else if (groupKey == 6) {
					groupNo = "Group 6: Non-sporting Dogs";
				} else {
					groupNo = "Group 7: Herding";
				}
						
			
			String q = "SELECT Count(*) as 'No_Of_Dogs', breed as 'Breed'," + 
					"Count(CASE WHEN gender = 'male' and dogClass='class' THEN entryNumber END) as 'Male_Class'," + 
					"Count(CASE WHEN gender = 'female' and dogClass='class' THEN entryNumber END) as 'Female_Class'," + 
					"Count(CASE WHEN gender = 'male' and dogClass='specialty' THEN entryNumber END) as 'Male_Specialty'," + 
					"Count(CASE WHEN gender = 'female' and dogClass='specialty' THEN entryNumber END) as 'Female_Specialty'" + 
					"from dog_list where dogGroup = '" + groupNo + 
					"' and " + dateReal + " = 'on' group by breed;";
			
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery(q);
			
			switch(groupKey) {
			case(1):
				while(rs.next()) {
					ShowList s = new ShowList();
					s.setGroupName("Group 1: Sporting Dogs");
					s.setNoOfDogs(rs.getString(1));
					s.setBreed(rs.getString(2));
					s.setMaleClass(rs.getString(3));
					s.setFemaleClass(rs.getString(4));
					s.setMaleSpecialty(rs.getString(5));
					s.setFemaleSpecialty(rs.getString(6));
					
					showLists.add(s);
				}
				break;
			case(2):
				while(rs.next()) {
					ShowList s = new ShowList();
					s.setGroupName("Group 2: Hound");
					s.setNoOfDogs(rs.getString(1));
					s.setBreed(rs.getString(2));
					s.setMaleClass(rs.getString(3));
					s.setFemaleClass(rs.getString(4));
					s.setMaleSpecialty(rs.getString(5));
					s.setFemaleSpecialty(rs.getString(6));
					
					showLists.add(s);
				}
				break;
			case(3):
				while(rs.next()) {
					ShowList s = new ShowList();
					s.setGroupName("Group 3: Working Dogs");
					s.setNoOfDogs(rs.getString(1));
					s.setBreed(rs.getString(2));
					s.setMaleClass(rs.getString(3));
					s.setFemaleClass(rs.getString(4));
					s.setMaleSpecialty(rs.getString(5));
					s.setFemaleSpecialty(rs.getString(6));
					
					showLists.add(s);
				}
				break;
			case(4):
				while(rs.next()) {
					ShowList s = new ShowList();
					s.setGroupName("Group 4: Terriers");
					s.setNoOfDogs(rs.getString(1));
					s.setBreed(rs.getString(2));
					s.setMaleClass(rs.getString(3));
					s.setFemaleClass(rs.getString(4));
					s.setMaleSpecialty(rs.getString(5));
					s.setFemaleSpecialty(rs.getString(6));
					
					showLists.add(s);
				}
				break;
			case(5):
				while(rs.next()) {
					ShowList s = new ShowList();
					s.setGroupName("Group 5: Toys");
					s.setNoOfDogs(rs.getString(1));
					s.setBreed(rs.getString(2));
					s.setMaleClass(rs.getString(3));
					s.setFemaleClass(rs.getString(4));
					s.setMaleSpecialty(rs.getString(5));
					s.setFemaleSpecialty(rs.getString(6));
					
					showLists.add(s);
				}
				break;
			case(6):
				while(rs.next()) {
					ShowList s = new ShowList();
					s.setGroupName("Group 6: Non-Sporting");
					s.setNoOfDogs(rs.getString(1));
					s.setBreed(rs.getString(2));
					s.setMaleClass(rs.getString(3));
					s.setFemaleClass(rs.getString(4));
					s.setMaleSpecialty(rs.getString(5));
					s.setFemaleSpecialty(rs.getString(6));
					
					showLists.add(s);
				}
				break;
			case(7):
				while(rs.next()) {
					ShowList s = new ShowList();
					s.setGroupName("Group 7: Herding");
					s.setNoOfDogs(rs.getString(1));
					s.setBreed(rs.getString(2));
					s.setMaleClass(rs.getString(3));
					s.setFemaleClass(rs.getString(4));
					s.setMaleSpecialty(rs.getString(5));
					s.setFemaleSpecialty(rs.getString(6));
					
					showLists.add(s);
				}
				break;
			default:
				break;
			}
	
			System.out.println("Connection Success");
			conn.close();
		} catch (Exception e) {
			System.out.println("Connection Failed");
			System.out.println(e);
		}
		
		return showLists;
	}
	
	// Method for getting dog list from the database for edit (table name = dog_list)

	public Dog getForEdit(int num) {
		Dog dog = new Dog();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = null;
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost/dogShow", "root", "root");
			String q = "SELECT * FROM dog_list where EntryNumber=" + num +";";
			System.out.println(q);
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery(q);
				System.out.println(q);

			while(rs.next()) {
				dog.setNumber(rs.getInt(1));
				dog.setName(rs.getString(2));
				dog.setOwnerName(rs.getString(3));
				dog.setBreed(rs.getString(4));
				dog.setGroup(rs.getString(5));
				dog.setGender(rs.getString(6));
				dog.setDogClass(rs.getString(7));
				dog.setDay1(rs.getString(8));
				dog.setDay2(rs.getString(9));
				dog.setDay3(rs.getString(10));
				dog.setEmail(rs.getString(11));
				dog.setPassword(rs.getString(12));
				
			}
	
			System.out.println("Connection Success");
			conn.close();
		} catch (Exception e) {
			System.out.println("Connection Failed");
			System.out.println(e);
		}
		System.out.println(dog);
		return dog;
	}
	
    public static int updateDog(Dog d){  
        int status=0;  
        try{  
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = null;
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost/dogShow", "root", "root");
			
			String preparedStatement = "update dog_list set name=?,OwnerName=?,Breed=?,DogGroup=?,Gender=?,DogClass=?,Day1=?" +
										",Day2=?,Day3=?,Email=?,Password=?,Membership=? where EntryNumber=?";

			PreparedStatement ps = conn.prepareStatement(preparedStatement);
			
			ps.setString(1, d.getName());
			ps.setString(2, d.getOwnerName());
			ps.setString(3, d.getBreed());
			ps.setString(4, d.getGroup());
			ps.setString(5, d.getGender());
			ps.setString(6, d.getDogClass());
			ps.setString(7, d.getDay1());
			ps.setString(8, d.getDay2());
			ps.setString(9, d.getDay3());
			ps.setString(10, d.getEmail());
			ps.setString(11, d.getPassword());
			ps.setString(12, d.getMembership());
			ps.setInt(13, d.getNumber());
						
			status=ps.executeUpdate();  
              
            conn.close();  
        }catch(Exception ex){ex.printStackTrace();}  
        System.out.println(status); 
        return status;
        
    }
    
    
    public static int deleteDog(int num){  
        int status=0;  
        try {
        	Class.forName("com.mysql.jdbc.Driver");
			Connection conn = null;
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost/dogShow", "root", "root");
			
			String preparedStatement = "delete from dog_list where EntryNumber=?";

			PreparedStatement ps = conn.prepareStatement(preparedStatement);
			
            ps.setInt(1, num);  
            status=ps.executeUpdate();  
              
            conn.close();  
        } catch (Exception e) {e.printStackTrace();}  
          
        return status;  
    }  
//Handler    
	public ArrayList<Dog> getHandler(String handler) {
		ArrayList<Dog> dogs = new ArrayList<Dog>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = null;
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost/dogShow", "root", "root");
			String q = "SELECT * FROM dog_list where ownerName='" + handler + "'";
			
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery(q);			
						
			while(rs.next()) {
				Dog dog = new Dog();
				dog.setNumber(rs.getInt(1));
				System.out.println(dog.getNumber());
				dog.setName(rs.getString(2));
				dog.setOwnerName(rs.getString(3));
				dog.setBreed(rs.getString(4));
				dog.setGroup(rs.getString(5));
				dog.setGender(rs.getString(6));
				dog.setDogClass(rs.getString(7));
				dog.setDay1(rs.getString(8));
				dog.setDay2(rs.getString(9));
				dog.setDay3(rs.getString(10));
				
				if (rs.getString(8).equals("on")) {
					dog.setDay1("Fri");
				} else {
					dog.setDay1("");
				}
					
				if (rs.getString(9).equals("on")) {
					dog.setDay2("Sat");
				} else {
					dog.setDay2("");
				}
				
				if (rs.getString(10).equals("on")) {
					dog.setDay3("Sun");
				} else {
					dog.setDay3("");
				}
				
				dogs.add(dog);
			}
				
			System.out.println("Connection Success");
			conn.close();
		} catch (Exception e) {
			System.out.println("Connection Failed");
			System.out.println(e);
		}
		return dogs;
	}


}
