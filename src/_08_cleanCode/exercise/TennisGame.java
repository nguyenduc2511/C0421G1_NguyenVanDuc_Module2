package _08_cleanCode.exercise;

public class TennisGame {

    public static StringBuilder score = new StringBuilder();

    public static String getScore(String playerNameOne, String playerNameTwo, int scoreOne, int scoreTwo) {
        score = new StringBuilder();
        if (scoreOne == scoreTwo) {
            equalPoint(scoreTwo);
        } else if (scoreOne >= 4 || scoreTwo >= 4) {
            finalPoint(scoreOne, scoreTwo);
        } else {
            pointInMatch(scoreOne, scoreTwo);
        }
        return score.toString();
    }

    public static void equalPoint(int point) {
        switch (point) {
            case 0:
                score = new StringBuilder("Love-All");
                break;
            case 1:
                score = new StringBuilder("Fifteen-All");
                break;
            case 2:
                score = new StringBuilder("Thirty-All");
                break;
            case 3:
                score = new StringBuilder("Forty-All");
                break;
            default:
                score = new StringBuilder("Deuce");
                break;
        }
    }

    public static void finalPoint(int pointOne, int pointTwo) {
        int minusResult = pointOne - pointTwo;
        if (minusResult == 1) score = new StringBuilder("Advantage player1");
        else if (minusResult == -1) score = new StringBuilder("Advantage player2");
        else if (minusResult >= 2) score = new StringBuilder("Win for player1");
        else score = new StringBuilder("Win for player2");
    }

    public static void pointInMatch(int pointOne, int pointTwo) {
        int tempPoint = 0;
        for (int i = 1; i < 3; i++) {
            if (i == 1) {
                tempPoint = pointOne;
            }
            else {
                score.append("-");
                tempPoint = pointTwo;
            }
            switch (tempPoint) {
                case 0:
                    score.append("Love");
                    break;
                case 1:
                    score.append("Fifteen");
                    break;
                case 2:
                    score.append("Thirty");
                    break;
                case 3:
                    score.append("Forty");
                    break;
            }
        }

    }
}
