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

    public void UpdateVotes(Candidate candidate) throws SQLException, ClassNotFoundException {
        dbConnection connection = new dbConnection();
        String sql = "SELECT * FROM CANDIDATESA00365285 WHERE id = $ID";
        sql=sql.replace("$ID", Integer.toString(candidate.getId()));
        ResultSet resultSet = connection.getData(sql);
        Candidate can = new Candidate();

        while(resultSet.next()){
            can.setVotes(resultSet.getInt("votes"));
        }
            sql = "UPDATE CANDIDATESA00365285 SET votes = $VOTES WHERE id = $ID";
            sql= sql.replace("$ID", Integer.toString(candidate.getId()));
            sql= sql.replace("$VOTES", Integer.toString(candidate.getVotes()+1));
            connection.runQuery(sql);
         connection.close();
    }
}


