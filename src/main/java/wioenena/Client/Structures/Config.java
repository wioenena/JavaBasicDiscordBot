package wioenena.Client.Structures;

import io.github.cdimascio.dotenv.Dotenv;

public class Config {
    private final Dotenv dotenv = Dotenv.load();

    public String getValue(String key) {
        return dotenv.get(key);
    }
}