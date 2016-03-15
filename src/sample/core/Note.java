package sample.core;

public class Note {
    private int shape;
    private int performance;
    private String exercise_purpose;
    private String tips;
    private int sessionid_fk;

    public Note(int shape, int performance, String exercise_purpose, String tips,int sessionid_fk){
        this.shape = shape;
        this.performance = performance;
        this.exercise_purpose = exercise_purpose;
        this.tips = tips;
        this.sessionid_fk = sessionid_fk;
    }



    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public int getShape() {
        return shape;
    }

    public void setShape(int shape) {
        this.shape = shape;
    }

    public int getPerformance() {
        return performance;
    }

    public void setPerformance(int performance) {
        this.performance = performance;
    }

    public String getExercise_purpose() {
        return exercise_purpose;
    }

    public void setExercise_purpose(String exercise_purpose) {
        this.exercise_purpose = exercise_purpose;
    }

    public void storeNote() {
    }
}
