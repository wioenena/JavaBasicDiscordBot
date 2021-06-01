package wioenena.Client.Structures.Commands;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import wioenena.Client.Structures.Utils.ArrayUtil;

public abstract class Command extends ListenerAdapter {

    private final CommandHandler handler;

    protected String name;
    protected String[] aliases = {};
    protected boolean ownerOnly = false;
    protected Permission[] permissions = {};

    public Command(CommandHandler handler) {
        this.handler = handler;
    }

    public CommandHandler getHandler() {
        return this.handler;
    }

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

        boolean isCommand = false;

        Message msg = event.getMessage();

        String raw = msg.getContentRaw();

        String prefix = this.handler.getPrefix();

        String[] args = raw.split("\\s+");

        String commandName = args[0];

        User author = event.getAuthor();

        Member member = event.getMember();

        if (commandName.equals(prefix + this.name))
            isCommand = true;
        else {
            for (String alias : this.aliases) {
                if (commandName.equals(prefix + alias)) {
                    isCommand = true;
                    break;
                }
            }
        }

        if (this.ownerOnly) {
            if (!this.handler.isOwner(author.getId()))
                return;
        } else {
            for (Permission perm : this.permissions) {
                if (!member.hasPermission(perm))
                    return;
            }
        }

        if (!isCommand)
            return;

        args = ArrayUtil.pop(args);

        Context ctx = new Context(event, args);
        this.execute(ctx);
    }

    public abstract void execute(Context ctx);
}