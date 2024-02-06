public class Rating {
    private int score;
    private String feedback;

    public Rating(int score, String feedback) {
        this.score = score;
        this.feedback = feedback;
    }

    // Dependency injection
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public String getFeedback() {
        return feedback;
    }
    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
