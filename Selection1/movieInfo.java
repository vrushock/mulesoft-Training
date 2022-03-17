//Sinple program for quering into a sqlite database using jdbc java

import java.util.*;
import java.sql.*;
public class movieInfo{
    public static void main(String args[]){
        String jdbc="jdbc:sqlite:/media/cicada/FILES/Workspace/Java/Mulesoft/Selection1/database/movieInfo.db";
        
        try{
            try{Class.forName("org.sqlite.JDBC");}catch(ClassNotFoundException e){e.printStackTrace();}
            Connection connection=DriverManager.getConnection(jdbc);
            //Creating the table
            //String querry="CREATE TABLE details(MovieName varchar(250),LeadActor varchar(250),Actress varchar(250),YOR varchar(50),DirectorName varchar(250));";
            //Statement statement=connection.createStatement();
            //ResultSet result=statement.executeQuery(querry);
            //System.out.println(result);
            //Inserting Querry
            String querry="INSERT INTO details values ('Jungle444','Abhishek1','Smriti1','20181','Abriti1');";
           // Statement statement=connection.createStatement();
            //ResultSet result=statement.executeQuery(querry);
            //System.out.println(result);
            //Fetching Querry
            querry="SELECT * FROM details;";
            Statement statement=connection.createStatement();
            ResultSet result=statement.executeQuery(querry);
            System.out.println("Movie Name\t|\tLead Actor\t|\tActress\t|\tYear of Release\t|\tDirector Name");
            while(result.next()){
                String movieName=result.getString("MovieName");
                String leadActor=result.getString("leadActor");
                String actress=result.getString("Actress");
                String yearOfRelease=result.getString("YOR");
                String directorName=result.getString("DirectorName");

                System.out.println(movieName+"\t\t|\t"+leadActor+"\t|\t"+actress+"\t|\t"+yearOfRelease+"\t\t|\t"+directorName);
                
            }

        }catch(SQLException e){
            System.out.println("Error connecting to the database");
            e.printStackTrace();
        }

    }
}