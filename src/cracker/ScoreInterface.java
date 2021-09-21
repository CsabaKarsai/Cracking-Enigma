package src.cracker;

public interface ScoreInterface {
    public double calculate(String text);
    public int compare(Score score1, Score score2);
    public int getValue();
    public void setValue(Double value);
}
