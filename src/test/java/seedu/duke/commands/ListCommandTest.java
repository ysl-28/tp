package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.objects.Inventory;
import seedu.duke.objects.Item;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ListCommandTest {
    Inventory inventory;

    @Test
    public void printWithoutWrapping() {
        inventory = new Inventory();
        Item item1 = new Item("apples", "012345678", 5000, 12.0);
        Item item2 = new Item("oranges", "876543210", 3000, 0.32);

        inventory.getItemInventory().add(item1);
        inventory.getItemInventory().add(item2);
        inventory.getUpcCodes().put(item1.getUpc(), item1);
        inventory.getUpcCodes().put(item2.getUpc(), item2);
        inventory.getItemNameHash().put(item1.getName().toLowerCase(), new ArrayList<>());
        inventory.getItemNameHash().put(item2.getName().toLowerCase(), new ArrayList<>());
        inventory.getItemNameHash().get(item1.getName().toLowerCase()).add(item1);
        inventory.getItemNameHash().get(item2.getName().toLowerCase()).add(item2);
        inventory.getTrie().add(item1.getName().toLowerCase());
        inventory.getTrie().add(item2.getName().toLowerCase());

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Command command = new ListCommand(inventory);
        command.run();
        String expectedOutput =
                "+-----------------+--------------+----------+----------+" + System.lineSeparator() +
                        "| Name            | UPC          | Quantity | Price    |" + System.lineSeparator() +
                        "+-----------------+--------------+----------+----------+" + System.lineSeparator() +
                        "| apples          | 012345678    | 5000     | $12.0    |" + System.lineSeparator() +
                        "+-----------------+--------------+----------+----------+" + System.lineSeparator() +
                        "| oranges         | 876543210    | 3000     | $0.32    |" + System.lineSeparator() +
                        "+-----------------+--------------+----------+----------+" + System.lineSeparator() +
                        System.lineSeparator() + "____________________________________________________________" +
                        System.lineSeparator();
        assertTrue(outContent.toString().contains(expectedOutput));


    }

    @Test
    public void printWithWrapping() {
        inventory = new Inventory();
        Item item1 = new Item("applesorangesgreenbeansredbeans", "012345678", 5000, 12.0);

        inventory.getItemInventory().add(item1);
        inventory.getUpcCodes().put(item1.getUpc(), item1);
        inventory.getItemNameHash().put(item1.getName().toLowerCase(), new ArrayList<>());
        inventory.getItemNameHash().get(item1.getName().toLowerCase()).add(item1);
        inventory.getTrie().add(item1.getName().toLowerCase());

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Command command = new ListCommand(inventory);
        command.run();

        String expectedOutput =
                "+-----------------+--------------+----------+----------+" + System.lineSeparator() +
                        "| Name            | UPC          | Quantity | Price    |" + System.lineSeparator() +
                        "+-----------------+--------------+----------+----------+" + System.lineSeparator() +
                        "| applesorangesgr | 012345678    | 5000     | $12.0    |" + System.lineSeparator() +
                        "| eenbeansredbean |              |          |          |" + System.lineSeparator() +
                        "| s               |              |          |          |" + System.lineSeparator() +
                        "+-----------------+--------------+----------+----------+" + System.lineSeparator() +
                        System.lineSeparator() + "____________________________________________________________" +
                        System.lineSeparator();
        assertTrue(outContent.toString().contains(expectedOutput));
    }

    @Test
    public void printSpacesWithWrapping() {
        inventory = new Inventory();
        Item item1 = new Item("red orange yellow green blue violet", "012345678", 5000, 12.0);

        inventory.getItemInventory().add(item1);
        inventory.getUpcCodes().put(item1.getUpc(), item1);
        inventory.getItemNameHash().put(item1.getName().toLowerCase(), new ArrayList<>());
        inventory.getItemNameHash().get(item1.getName().toLowerCase()).add(item1);
        inventory.getTrie().add(item1.getName().toLowerCase());

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Command command = new ListCommand(inventory);
        command.run();

        String expectedOutput =
                "+-----------------+--------------+----------+----------+" + System.lineSeparator() +
                        "| Name            | UPC          | Quantity | Price    |" + System.lineSeparator() +
                        "+-----------------+--------------+----------+----------+" + System.lineSeparator() +
                        "| red orange      | 012345678    | 5000     | $12.0    |" + System.lineSeparator() +
                        "| yellow green    |              |          |          |" + System.lineSeparator() +
                        "| blue violet     |              |          |          |" + System.lineSeparator() +
                        "+-----------------+--------------+----------+----------+" + System.lineSeparator() +
                        System.lineSeparator() + "____________________________________________________________" +
                        System.lineSeparator();
        assertTrue(outContent.toString().contains(expectedOutput));

    }
}
