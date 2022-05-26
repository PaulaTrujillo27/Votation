package provider;

import db.dbConnection;
import entity.Candidate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CandidateProvider {

    public ArrayList<Candidate> getCanditates() throws SQLException, ClassNotFoundException {
        ArrayList<Candidate> candidates = new ArrayList<>();
        dbConnection connection = new dbConnection();
        ResultSet resultSet = connection.getData("SELECT * FROM CANDIDATESA00365285");

        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String president= resultSet.getString("president");
            String vice= resultSet.getString("vice");
            String presidentImage= resultSet.getString("presidentImage");
            String party= resultSet.getString("party");
            int votes= resultSet.getInt("votes");

            Candidate candidate = new Candidate(id, president,vice,presidentImage,party, votes);
            candidates.add(candidate);
        }
        connection.close();
        return candidates;
    }
}
