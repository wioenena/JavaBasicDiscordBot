package wioenena.Client.Structures.Commands;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class Context {
    public final User user;
    public final Message message;
    public final Guild guild;
    public final String[] args;
    public final TextChannel channel;

    public Context(GuildMessageReceivedEvent event, String[] args) {
        this.user = event.getAuthor();
        this.message = event.getMessage();
        this.guild = event.getGuild();
        this.args = args;
        this.channel = event.getChannel();
    }
}