package wioenena.Client.Structures.Commands.Users;

import wioenena.Client.Structures.Commands.Command;
import wioenena.Client.Structures.Commands.CommandHandler;
import wioenena.Client.Structures.Commands.Context;
import wioenena.Client.Structures.Utils.ArrayUtil;

public class SayItalic extends Command {

    public SayItalic(CommandHandler handler) {
        super(handler);
        this.name = "say-italic";
        this.aliases = new String[] { "eğik-yaz", "italic" };
    }

    @Override
    public void execute(Context ctx) {
        if (ctx.args.length == 0) {
            ctx.channel.sendMessage("Lütfen yazmam gereken şeyi belirt!").queue();
            return;
        }

        ctx.channel.sendMessage("*" + ArrayUtil.join(ctx.args) + "*").queue();
        return;
    }

}