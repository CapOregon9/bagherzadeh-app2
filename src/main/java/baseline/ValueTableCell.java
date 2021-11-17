/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Alexander Bagherzadeh
 */
package baseline;

import javafx.scene.control.TableCell;


public class ValueTableCell extends TableCell<Item, Double> {
    //used to override the formatting of the value cell of the table.
    @Override
    protected void updateItem(Double value, boolean empty) {
        super.updateItem(value, empty);
        if (empty || value == null) {
            // set back to look of empty cell
            setText(null);
        } else {
            // set formatting for item value cell
            setText(String.format("$%.2f", value));
        }
    }
}
