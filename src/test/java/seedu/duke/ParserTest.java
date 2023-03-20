package seedu.duke;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    @Test
    void parseAdd() {
        Inventory inventory = new Inventory();
        Parser parser = new Parser(inventory);
        assertDoesNotThrow(() -> parser.parseAdd("n/orange upc/1231 qty/5 p/5", inventory));
        assertNotEquals(0, inventory.getItemInventory().size());
    }
}