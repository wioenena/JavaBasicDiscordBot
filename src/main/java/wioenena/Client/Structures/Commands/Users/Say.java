package wioenena.Client.Structures.Commands.Users;

import net.dv8tion.jda.api.Permission;
import wioenena.Client.Structures.Commands.Command;
import wioenena.Client.Structures.Commands.CommandHandler;
import wioenena.Client.Structures.Commands.Context;
import wioenena.Client.Structures.Utils.ArrayUtil;

public class Say extends Command {

    public Say(CommandHandler handler) {
        super(handler);
        this.name = "say";
        this.aliases = new String[] { "yazdır", "yaz-kızım", "yaz-kizim" };
    }

    @Override
    public void execute(Context ctx) {
        if (ctx.args.length == 0) {
            ctx.message.getChannel().sendMessage("Lütfen yazmam gereken şeyi belirt!").queue();
            return;
        }

        ctx.message.getChannel().sendMessage(ArrayUtil.join(ctx.args)).queue();
        return;
    }

}