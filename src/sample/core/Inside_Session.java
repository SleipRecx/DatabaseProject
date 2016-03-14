package sample.core;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;

public class Inside_Session  extends  Session{


    private String ventilation;

    private int spectators;

    private int session_id_fk;


    public Inside_Session(Date date, int duration, int spectators, String ventilation) {
        super(date, duration);
        this.spectators = spectators;
        this.ventilation = ventilation;
    }

    public void storeInsideSession(){
        try {
            Statement statement = myConnection.createStatement();
            //TODO INSERT INTO DB
            /* String sql  = "INSERT INTO Indoor_training (session_id_fk,ventilation,spectators) VALUES (?,?,?)";
            PreparedStatement ps = myConnection.prepareStatement(sql);
            ps.setInt(1,this.session_id_fk);
            ps.setString(2,this.ventilation);
            ps.setInt(3,this.spectators);
            ps.executeUpdate(sql);
            */


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getSession_id_fk() {
        return session_id_fk;
    }

    public void setSession_id_fk(int session_id_fk) {
        this.session_id_fk = session_id_fk;
    }


}
