package seedu.duke;


import seedu.duke.objects.Inventory;
import seedu.duke.types.Types;
import seedu.duke.utils.SessionManager;
import seedu.duke.utils.Storage;
import seedu.duke.utils.Ui;
import seedu.duke.utils.ParserHandler;

public class MagusStock {
    /**
     * Main entry-point for the java.duke.Duke application.
     */
    private Storage storage;
    private Ui ui;
    private ParserHandler parserHandler;
    private Inventory inventory;
    private SessionManager currentSession;

    public MagusStock(String filePath) {
        ui = new Ui();
        storage = new Storage();
        inventory = new Inventory();
        inventory = currentSession.getSession();
        inventory.setAlertList(currentSession.getSessionAlerts());
        parserHandler = new ParserHandler(inventory);
    }

    public void run() {
        while (true) {
            parserHandler.run();
        }
    }

    public static void main(String[] args) {
        new MagusStock(Types.SESSIONFILEPATH).run();
    }
}
