package model;
public class User {
   private int userId;
   private String userName;
   private String password;
   private int role;//
   private boolean status;
   
   public int getUserId() {
      return userId;
   }
   public void setUserId(int userId) {
      this.userId = userId;
   }
   
   public String getUserName() {
      return userName;
   }
   public void setUserName(String userName) {
      this.userName = userName;
   }
   public int getRole() {
      return role;
   }
   public void setRole(int role) {
      this.role = role;
   }
   
   public boolean getStatus() {
      return status;
   }
   public void setStatus(boolean status) {
      this.status = status;
   }
   
   public String getPassword() {
      return password;
   }
   public void setPassword(String password) {
      this.password = password;
   }
   
   public String toString() { //列出部分数据
      return ""+userId+","+userName+","+password+"\n";
   }

}
