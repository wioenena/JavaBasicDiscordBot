package wioenena.Client.Structures.Commands.Users;

import wioenena.Client.Structures.Commands.Command;
import wioenena.Client.Structures.Commands.CommandHandler;
import wioenena.Client.Structures.Commands.Context;
import wioenena.Client.Structures.Utils.ArrayUtil;

public class SayUnderline extends Command {

    public SayUnderline(CommandHandler handler) {
        super(handler);
        this.name = "say-underline";
        this.aliases = new String[] { "underline" };
    }

    @Override
    public void execute(Context ctx) {
        if (ctx.args.length == 0) {
            ctx.channel.sendMessage("Lütfen yazmam gereken şeyi belirt!").queue();
            return;
        }

        ctx.channel.sendMessage("__" + ArrayUtil.join(ctx.args) + "__").queue();
        return;
    }

}
