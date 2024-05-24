
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



import database.PolyBayDatabase;
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        PolyBayDatabase database = new PolyBayDatabase();
        


        try {
            PreparedStatement statement =database.prepareStatement("SELECT * FROM product");
            ResultSet result = statement.executeQuery();
            while(result.next()){
                System.out.println(result.getString("name"));
            }
            
            
        } catch (SQLException exception) {
            System.err.println("An error occurred while preparing the statement.");
        }
        

    }
}
