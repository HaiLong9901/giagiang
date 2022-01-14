package application;

import java.sql.*;
import java.util.ArrayList;
import application.Food;

public class interact {
	private static String urlString = "jdbc:mysql://localhost:3306/hailonget1";
	private static String userString = "root";
	private static String passString = "matkhau";
	private ArrayList<String> nameList = new ArrayList<>();
	private ArrayList<String> passList = new ArrayList<>();
	private ArrayList<String> idList = new ArrayList<>();
	
	private void freeList() {
		nameList.removeAll(nameList);
		idList.removeAll(idList);
		passList.removeAll(passList);
	}
	private void getData() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(urlString, userString, passString);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from hailonget1.staff;");
			while(resultSet.next()) {
				idList.add(resultSet.getString(1));
				nameList.add(resultSet.getString(2));
				passList.add(resultSet.getString(3));
			}
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	public boolean idExist(String id) {
		try {
			int test = Integer.parseInt(id);
			String test1 = "0";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(urlString, userString, passString);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select id" + "\nfrom hailonget1.staff" + "\nwhere id = " + test + ";");
//			while(resultSet.next()) {
//				idList.add(resultSet.getString(1));
//				nameList.add(resultSet.getString(2));
//				passList.add(resultSet.getString(3));
//			}
			while(resultSet.next()) {
				test1 = resultSet.getString(1);
			}
			connection.close();
			if(test1.equals("0")) return false;
			else return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return false;
	}
	public boolean checkPass(String id, String pass) {
		try {
			int test = Integer.parseInt(id);
			String test1 = "0";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(urlString, userString, passString);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select pass" + "\nfrom hailonget1.staff" + "\nwhere id = " + test + ";");
//			while(resultSet.next()) {
//				idList.add(resultSet.getString(1));
//				nameList.add(resultSet.getString(2));
//				passList.add(resultSet.getString(3));
//			}
			while(resultSet.next()) {
				test1 = resultSet.getString(1);
			}
			connection.close();
			if(test1.equals(pass)) return true;
			else return false;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return false;
	}
	public String getName(String id) {
		try {
			int test = Integer.parseInt(id);
			String test1 = "0";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(urlString, userString, passString);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select namest" + "\nfrom hailonget1.staff" + "\nwhere id = " + test + ";");
//			while(resultSet.next()) {
//				idList.add(resultSet.getString(1));
//				nameList.add(resultSet.getString(2));
//				passList.add(resultSet.getString(3));
//			}
			while(resultSet.next()) {
				test1 = resultSet.getString(1);
			}
			connection.close();
			return test1;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return "dont";
	}
	public ArrayList<String> getFood() {
		ArrayList<String> resultArrayListtArrayList = new ArrayList<>();
		try {
			String test1 = "0";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(urlString, userString, passString);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from hailonget1.food");
//			while(resultSet.next()) {
//				idList.add(resultSet.getString(1));
//				nameList.add(resultSet.getString(2));
//				passList.add(resultSet.getString(3));
//			}
			while(resultSet.next()) {
				resultArrayListtArrayList.add(resultSet.getString(1));
			}
			connection.close();
			return resultArrayListtArrayList;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return resultArrayListtArrayList;
	}
	public ArrayList<String> getEurope() {
		ArrayList<String> resultArrayListtArrayList = new ArrayList<>();
		try {
			String test1 = "0";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(urlString, userString, passString);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from hailonget1.europe");
//			while(resultSet.next()) {
//				idList.add(resultSet.getString(1));
//				nameList.add(resultSet.getString(2));
//				passList.add(resultSet.getString(3));
//			}
			while(resultSet.next()) {
				resultArrayListtArrayList.add(resultSet.getString(1));
			}
			connection.close();
			return resultArrayListtArrayList;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return resultArrayListtArrayList;
	}
	public ArrayList<String> getAsian() {
		ArrayList<String> resultArrayListtArrayList = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(urlString, userString, passString);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from hailonget1.asian");
//			while(resultSet.next()) {
//				idList.add(resultSet.getString(1));
//				nameList.add(resultSet.getString(2));
//				passList.add(resultSet.getString(3));
//			}
			while(resultSet.next()) {
				resultArrayListtArrayList.add(resultSet.getString(1));
			}
			connection.close();
			return resultArrayListtArrayList;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return resultArrayListtArrayList;
	}
	public ArrayList<String> getCream() {
		ArrayList<String> resultArrayListtArrayList = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(urlString, userString, passString);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from hailonget1.cream");
//			while(resultSet.next()) {
//				idList.add(resultSet.getString(1));
//				nameList.add(resultSet.getString(2));
//				passList.add(resultSet.getString(3));
//			}
			while(resultSet.next()) {
				resultArrayListtArrayList.add(resultSet.getString(1));
			}
			connection.close();
			return resultArrayListtArrayList;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return resultArrayListtArrayList;
	}
	public Food getCake() {
		ArrayList<String> resultArrayListtArrayList = new ArrayList<>();
		Food resultFood = new Food();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(urlString, userString, passString);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from hailonget1.cake");
//			while(resultSet.next()) {
//				idList.add(resultSet.getString(1));
//				nameList.add(resultSet.getString(2));
//				passList.add(resultSet.getString(3));
//			}
			while(resultSet.next()) {
				resultFood.linkImg.add(resultSet.getString(1));
				resultFood.nameFood.add(resultSet.getString(2));
				resultFood.priceFood.add(resultSet.getString(3));
			}
			connection.close();
			return resultFood;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return resultFood;
	}
}
