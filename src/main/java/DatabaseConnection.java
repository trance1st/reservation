import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnection {

    public void saveNewUser(String username, String pass) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://104.248.84.92:3306/hotel", "java", "Javaestetare123!");
            Statement st = connection.createStatement();
            String query = String.format("insert into user values(null, '%s', '%s')", username, pass);
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean findUser(String username, String password) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://104.248.84.92:3306/hotel", "java", "Javaestetare123!");
            Statement st = connection.createStatement();
            String query = String.format("select count(*) as nr from user where username='%s' and password = '%s'", username, password);
            ResultSet resultSet =  st.executeQuery(query);
            resultSet.next();
            int nr = resultSet.getInt("nr");
            return nr == 1;
        } catch (Exception e) {
            return false;
        }
    }

}
