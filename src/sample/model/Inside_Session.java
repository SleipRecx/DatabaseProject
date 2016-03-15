package sample.model;

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
            PreparedStatement ps = myConnection.prepareStatement("insert into Indoor_training(session_id_fk,ventilation,spectators) values(?,?,?)");
            ps.setInt(1,session_id_fk);
            ps.setString(2,ventilation);
            ps.setInt(3, spectators);
            ps.executeUpdate();
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
