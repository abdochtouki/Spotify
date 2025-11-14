import java.util.InputMismatchException;

public class SpootifyPodcast extends SpootifyContent {
    private String host;
    private String description;

    public SpootifyPodcast(String title, int duration, String host, String description) {
        super(title, duration);

        if(host.isBlank() || description.isBlank()) throw new InputMismatchException("Invalid input");
        this.host = host;
        this.description = description;
    }

    public String getHost() {
        return this.host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return String.format("Podcast | Title: %s | Duration: %d seconds | Host: %s |", title, duration, host);
    }
}
