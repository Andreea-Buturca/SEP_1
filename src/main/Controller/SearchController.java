package main.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import main.Model.*;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Date;

/**
 * Created by MartinNtb on 27-Nov-16.
 */
public class SearchController extends Controller {

/*

    public ListView matchingCustomers;
    public TextField name;
    public TextField companyName;
    public TextField address;
    public TextField email;
    public TextField phone;

    public void searchCustomer(ActionEvent actionEvent) throws FileNotFoundException, ParseException {
        System.out.println("Run");
        if (name != null) {
            if (companyName != null) {
                if (address != null) {
                    if (email != null) {
                        if (phone != null) {
                            if (matchingCustomers != null) {
                                CustomerList matching = DataHandler.getCustomerList();
                                if (name.getText() != null && (!name.getText().equals("")))
                                    matching = matching.findAllByName(name.getText());
                                if (address.getText() != null && (!address.getText().equals("")))
                                    matching = matching.findAllByAddress(address.getText());
                                if (email.getText() != null && (!email.getText().equals("")))
                                    matching = matching.findAllByEmail(email.getText());
                                if (phone.getText() != null && (!phone.getText().equals("")))
                                    matching = matching.findAllByPhone(phone.getText());

                                ObservableList<String> items = FXCollections.observableArrayList();
                                for (int i = 0; i < matching.getSize(); i++) {
                                    items.add(matching.getCustomer(i).toString());
                                }
                                matchingCustomers.setItems(items);
                            }
                        }
                    }
                }
            }
        }
    }
*/

//make on key method in panel
// create new object of list then call methot find by.... save it on saved call it again

    /*
    Datalist data = new DataList();

    if ..... data = data.find by...
    if ..... data = data.find by...
    if ..... data = data.find by...

    print
     */

    /*private void test (){
        TripTempController.edit(new Trip(DataHandler.getBusList().getAtIndex(0), DataHandler.getDestinationList().getAtIndex(0), null, new Date(2012, 1, 1, 1, 1), new Date(2012, 1, 1, 1, 1)));
    }*/
}
