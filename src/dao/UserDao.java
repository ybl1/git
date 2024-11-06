package dao;
import model.User;
import util.ConnectionManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class UserDao { //澧炲垹鏀规煡
   private Connection con;
   private PreparedStatement pstmt;
   private ResultSet results;
   public int addUserinfo(User userinfo) {
      int result=0;
      con= ConnectionManager.getConnction();
      try {
         String sql="insert into userinfo(username,password,role,status) values(?,?,?,?)";
         pstmt=con.prepareStatement(sql);
         pstmt.setString(1,userinfo.getUserName());
         pstmt.setString(2,userinfo.getPassword());
         pstmt.setInt(3,userinfo.getRole());
         pstmt.setBoolean(4,userinfo.getStatus());
         result=pstmt.executeUpdate();
      }catch(Exception e) {
         e.printStackTrace();
      }
      finally {
         ConnectionManager.closeResultSet(results);
         ConnectionManager.closeStatement(pstmt);//闁插﹥鏂丳reparedStatement鐎电钖�
         ConnectionManager.closeConnection(con);//闁插﹥鏂丳reparedStatement鐎电钖�
      }
      return result;
   }
   
   public int delUserinfo(int id) {
      int result=0;
      con=ConnectionManager.getConnction();
      try {
         String sql="delete from userinfo where userid=? ";
         pstmt=con.prepareStatement(sql);
         pstmt.setInt(1,id);
         result=pstmt.executeUpdate();
      }catch(Exception e) {
         e.printStackTrace();
      }
      finally {
         ConnectionManager.closeResultSet(results);
         ConnectionManager.closeStatement(pstmt);//闁插﹥鏂丳reparedStatement鐎电钖�
         ConnectionManager.closeConnection(con);//闁插﹥鏂丆onnection鐎电钖�
      }
      return result;
   }
   public int updateUserinfo(User userinfo) {
      int result=0;
      con=ConnectionManager.getConnction();
      try {
         String sql="update userinfo set username=?,password=?,role=?,status=? where userid=?";
         pstmt=con.prepareStatement(sql);
         pstmt.setString(1,userinfo.getUserName());
         pstmt.setString(2,userinfo.getPassword());
         pstmt.setInt(3,userinfo.getRole());
         pstmt.setBoolean(4,userinfo.getStatus());
         pstmt.setInt(5,userinfo.getUserId());
         result=pstmt.executeUpdate();
      }catch(Exception e) {
         e.printStackTrace();
      }
      finally {
         ConnectionManager.closeResultSet(results);
         ConnectionManager.closeStatement(pstmt);//闁插﹥鏂丳reparedStatement鐎电钖�
         ConnectionManager.closeConnection(con);//闁插﹥鏂丆onnection鐎电钖�
      }
      return result;
   }
   public List<User> findByUserName(String userName) {
      String sql="select * from userinfo where username like '%"+ userName  +"%' ";
      con=ConnectionManager.getConnction();
      List<User> list = new ArrayList<User>();
      try {
         pstmt=con.prepareStatement(sql);
         results=pstmt.executeQuery();
            while (results.next()) {//if(results.next()) {
                User user=new User();
            user.setUserId(results.getInt("userId"));
            user.setUserName(results.getString("userName"));
            user.setPassword(results.getString("password"));
            user.setRole(results.getInt("role"));
            user.setStatus(results.getBoolean("status"));
            list.add(user);// 鐏忓敇ser鐎电钖勫ǎ璇插閸掔増鏆熺紒鍒瞚st娑擄拷.
         }
      }
 catch (SQLException e) {
         e.printStackTrace();
      }
      return list;
   }
  public User findByUserId(Integer id) {
      User user=new User();
      String sql="select * from userinfo where userId=? ";
      con=ConnectionManager.getConnction();
      try {
         pstmt=con.prepareStatement(sql);
         pstmt.setInt(1,id);
         results=pstmt.executeQuery();
         if(results.next()) {
            user.setUserId(results.getInt("userId"));
            user.setUserName(results.getString("userName"));
            user.setPassword(results.getString("password"));
            user.setRole(results.getInt("role"));
            user.setStatus(results.getBoolean("status"));
         }
      }
 catch (SQLException e) {
         e.printStackTrace();
      }
      return user;
   }

    public User findByLoginname(String  username) {
        User user=new User();
        String sql="select * from userinfo where username=? ";
        con=ConnectionManager.getConnction();
        try {
            pstmt=con.prepareStatement(sql);
            pstmt.setString(1,username);
            results=pstmt.executeQuery();
            if(results.next()) {
                user.setUserId(results.getInt("userId"));
                user.setUserName(results.getString("userName"));
                user.setPassword(results.getString("password"));
                user.setRole(results.getInt("role"));
                user.setStatus(results.getBoolean("status"));
            }
        }
 catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
   public List<User> listAll(){//
      con = ConnectionManager.getConnction();
      List<User> list = new ArrayList<User>();//
      try {
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery("select * from userinfo");// 
         while (rs.next()) { // 
            User user = new User(); // 
         // 
            user.setUserId(rs.getInt("userId"));
         // 
            user.setUserName(rs.getString("userName"));
         // 
            user.setPassword(rs.getString("password"));
            user.setRole(rs.getInt("role"));
            user.setStatus(rs.getBoolean("status"));
            list.add(user);// 
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         ConnectionManager.closeConnection(con);
      }
      return list;
   }
   
   public int addUser(User user) { // 娣诲姞鐢ㄦ埛
	   con = ConnectionManager.getConnction();
	   int i = 0;
	   String sql = "insert into userinfo(username, password,role,status) values(?,?,?,?)";
	   try {
		 pstmt = con.prepareStatement(sql);
		 pstmt.setString(1,user.getUserName());
		 pstmt.setString(2, user.getPassword());
		 pstmt.setInt(3, user.getRole());
		 pstmt.setBoolean(4, user.getStatus());
		 // 鎵цsql
		 i= pstmt.executeUpdate();  // 鏂板锛屼慨鏀癸紝鍒犻櫎鎿嶄綔鐨勬椂鍊欙紝鎵цsql杩斿洖鐨刬nt绫诲瀷锛屾槸褰卞搷琛屾暟锛屼篃灏辨槸鎴愬姛娣诲姞銆佷慨鏀广�佸垹闄ょ殑鏁版嵁鏉℃暟
		 		 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	   return i;
   }
   
}
