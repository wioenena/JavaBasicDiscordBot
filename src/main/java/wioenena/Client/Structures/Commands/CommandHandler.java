package wioenena.Client.Structures.Commands;

import wioenena.Client.Client;
import wioenena.Client.Structures.Utils.ArrayUtil;

public class CommandHandler {
    private final Client client;
    private String prefix;
    private String[] owners = new String[] {};

    public CommandHandler(Client client) {
        this.client = client;
    }

    public void addCommand(Command command) {
        this.client.getBuilder().addEventListeners(command);
    }

    public String getPrefix() {
        return this.prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setOwners(String id) {
        this.owners = ArrayUtil.push(this.owners, id);
    }

    public void setOwners(String[] ids) {
        for (String id : ids) {
            this.setOwners(id);
        }
    }

    public String[] getOwners() {
        return this.owners;
    }

    public boolean isOwner(String id) {
        boolean result = false;

        for (String _id : this.owners) {
            if (_id.equals(id)) {
                result = true;
                break;
            }
        }

        return result;
    }
}