package seedu.duke.utils.parsers;

import seedu.duke.objects.Inventory;
import seedu.duke.utils.SessionManager;

public abstract class Parser {
    protected static final String ADD_REGEX = "n/([\\w\\s]+) upc/(\\d+) qty/(\\d+) p/(\\d+(?:\\.\\d+)?)";
    protected static final Integer NAME_INDEX = 1;
    protected static final Integer UPC_INDEX = 2;
    protected static final Integer QTY_INDEX = 3;
    protected static final Integer PRICE_INDEX = 4;

    protected static final String ALERT_REGEX = "(add|remove|list)\\s+([\\w\\s\\/]+)";
    protected static final Integer ALERT_COMMAND_INDEX = 1;
    protected static final Integer ALERT_DETAILS_INDEX = 2;
    protected static final String ALERT_ADD_REGEX = "upc/(\\d+)\\s+(min|max)(/)([1-9]\\d*)";
    protected static final Integer ALERT_UPC_INDEX = 1;
    protected static final Integer ADD_MINMAX_INDEX = 2;
    protected static final Integer STOCK_INDEX = 4;
    protected static final String ALERT_REMOVE_REGEX = "upc/(\\d+)\\s+(level\\/)(min|max)$";
    protected static final Integer REMOVE_MINMAX_INDEX = 3;
    protected String rawInput;
    protected Inventory inventory;
    protected SessionManager session;

    public Parser(String rawInput, Inventory inventory, SessionManager session) {
        this.rawInput = rawInput;
        this.inventory = inventory;
        this.session = session;
    }

    public Parser(String rawInput, Inventory inventory) {
        this.rawInput = rawInput;
        this.inventory = inventory;
    }

    public Parser(Inventory inventory) {
        this.inventory = inventory;
    }

    public Parser() {
    }

    public abstract void run();
}