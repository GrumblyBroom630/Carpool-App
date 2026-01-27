import  java.sql.*;
public class connector {
    private static final String url=" jdbc:mysql://localhost:3306/mydb";
    private  static  final  String username= "root";
    private  static  final String password="Madhubani@16";
    static void main(String[] args) {

        try{
            Class.forName("com.mysql.cj.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            Connection connection = DriverManager.getConnection(url, username,password);
            Statement statement = connection.createStatement();
            String query = "select * from students";
            ResultSet resultSet= statement.executeQuery(query);
            while(resultSet.next()){
                int id= resultSet.getInt("id");
                String name = resultSet.getString("age");
                int age = resultSet.getInt("age");
                double marks = resultSet.getDouble("marks");
                System.out.println("id"+id);
                System.out.println("name"+ name);
                System.out.println("age"+age);
                System.out.println("marks"+marks);

            }


        }catch (SQLException e){
            System.out.println(e.getMessage());

        }



    }
}
