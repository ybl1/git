package util;
import java.sql.*;
public class ConnectionManager {
   private static String DbDriver = "com.mysql.cj.jdbc.Driver";
   private static String DbUrl =
"jdbc:mysql://localhost:3306/sample?useUnicode=true&characterEncoding=UTF-8";
   private static String DbUserName = "root";
   private static String DbPassword = "root";
   // 杩斿洖杩炴帴
   public static Connection getConnction() {
      Connection dbConnection = null;
      try {
         Class.forName(DbDriver);
         dbConnection = DriverManager.getConnection(DbUrl,
               DbUserName, DbPassword);
      }
 catch (Exception e) {
         e.printStackTrace();
      }
      return dbConnection;
   }
   // 鍏抽棴杩炴帴
   public static void closeConnection(Connection dbConnection) {
      try {
         if (dbConnection != null && (!dbConnection.isClosed())) {
            dbConnection.close();
         }
      } catch (SQLException sqlEx) {
         sqlEx.printStackTrace();
      }
   }
   // 鍏抽棴缁撴灉闆�
   public static void closeResultSet(ResultSet res) {
      try {
         if (res != null) {
            res.close();
            res = null;
         }
      }
 catch (SQLException e) {
         e.printStackTrace();
      }
   }
   public static void closePreparedStatement(PreparedStatement pStatement) {
      try {
         if (pStatement != null) {
            pStatement.close();
            pStatement = null;
         }
      }
 catch (SQLException e) {
         e.printStackTrace();
      }
   }
   public static void closeStatement(Statement Statement) {
      try {
         if (Statement != null) {
            Statement.close();
            Statement = null;
         }
      }
 catch (SQLException e) {
         e.printStackTrace();
      }
   }
}
