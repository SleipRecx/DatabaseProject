package model;

import controller.Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * Class for representing and storing Notes
 */
public class Note {
    private int shape;
    private int performance;
    private String exercise_purpose;
    private String tips;
    private int session_id_fk;
    private Connection myConnection = Main.getDB().getConnection();

    /**
     * Constructor for the Note
     * @param shape
     * @param performance
     * @param exercise_purpose
     * @param tips
     * @param session_id_fk id of the session the note should be linked to
     */
    public Note(int shape, int performance, String exercise_purpose, String tips,int session_id_fk){
        this.shape = shape;
        this.performance = performance;
        this.exercise_purpose = exercise_purpose;
        this.tips = tips;
        this.session_id_fk = session_id_fk;
    }

    /**
     * Function that stores the Note in the databse
     */
    public void storeNote(){
        try {
            PreparedStatement ps = myConnection.prepareStatement("INSERT INTO Notes(session_id_fk,personal_shape,performance,exercise_purpose,tips) VALUES (?,?,?,?,?)");
            ps.setInt(1,session_id_fk);
            ps.setInt(2,shape);
            ps.setInt(3,performance);
            ps.setString(4,exercise_purpose);
            ps.setString(5,tips);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
