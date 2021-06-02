package wioenena.Client;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDABuilder;
import wioenena.Client.Structures.Config;
import wioenena.Client.Structures.Commands.CommandHandler;
import wioenena.Client.Structures.Commands.Users.Say;
import wioenena.Client.Structures.Commands.Users.SayBold;
import wioenena.Client.Structures.Commands.Users.SayItalic;
import wioenena.Client.Structures.Commands.Users.SayUnderline;

public class Client {
    private final JDABuilder builder;
    private final Config config = new Config();
    private final CommandHandler commandHandler = new CommandHandler(this);

    public Client() {
        this.builder = JDABuilder.createDefault(config.getValue("TOKEN"));
    }

    public Client login() {
        try {
            this.commandHandler.setPrefix("*");
            this.commandHandler.setOwners("467915130743554059");
            this.buildCommands();
            this.builder.build();
        } catch (LoginException e) {
            System.out.println(e.getMessage());
        }

        return this;
    }

    public JDABuilder getBuilder() {
        return this.builder;
    }

    public void buildCommands() {
        this.commandHandler.addCommand(new Say(this.commandHandler));
        this.commandHandler.addCommand(new SayItalic(this.commandHandler));
        this.commandHandler.addCommand(new SayUnderline(this.commandHandler));
        this.commandHandler.addCommand(new SayBold(this.commandHandler));
    }

    public CommandHandler getCommandHandler() {
        return this.commandHandler;
    }
}