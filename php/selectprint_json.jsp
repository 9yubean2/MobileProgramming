<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<%@ page import="java.sql.*"%>
<%@ page import="org.json.simple.*"%>
<%@ page import="org.json.simple.parser.JSONParser"%>
<%@ page import="org.json.simple.parser.ParseException"%>
<%
    String DB_URL = "jdbc:mysql://sc1.swu.ac.kr:13306/dlrbqls3024_ts";
    String DB_USER = "dlrbqls3024";
    String DB_PASSWORD = "dlrbqls302485";
    String sql = null; 
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {   
        Class.forName("org.mariadb.jdbc.Driver");
        System.out.println("����̹� �ε� ����");
        conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        System.out.println("���� ����");
        //stmt = conn.createStatement();
 
        String userName_json = request.getParameter("userName_json");
        JSONParser parser = new JSONParser();
        Object obj = parser.parse( userName_json );
        JSONObject jsonObj = (JSONObject) obj;

        String userName_parsing = (String) jsonObj.get("name");
        
        //out.print(userName_json+"<br>");
        out.print(userName_parsing+"<br>");
        
        stmt = conn.prepareStatement("select * from userInfo where userName=?");
        stmt.setString(1,userName_parsing);
        rs = stmt.executeQuery();
        JSONArray arr = new JSONArray();
        
        while(rs.next()){
			Integer userNum = rs.getInt("userNum");
			String userPassword = rs.getString("userPassword");
			String userName = rs.getString("userName");
			Integer userAge = rs.getInt("userAge");
			String userBirthDate = rs.getString("userBirthDate");
			String createDate = rs.getString("createDate");
        	JSONObject select_obj = new JSONObject();
            
        	select_obj.put("userNum", userNum);
        	select_obj.put("userPassword", userPassword);
        	select_obj.put("userBirthDate", userBirthDate);
        	select_obj.put("userName", userName);
        	select_obj.put("userAge", userAge);
        	select_obj.put("createDate", createDate);
            
            if(select_obj != null)
                arr.add(select_obj);
            
            out.print(select_obj);
			}
        
        //out.print(arr);

      
    } catch (Exception e) {
        System.out.println("���� ����");
        e.printStackTrace();
    }
    finally {
		if (rs != null) rs.close();
		if (conn != null) conn.close();
	}
%>