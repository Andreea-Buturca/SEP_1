package main.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import main.Model.BusList;
import main.Model.CustomerList;
import main.Model.DataHandler;

import main.Model.Trip;

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

                                CustomerList customers = DataHandler.getCustomerList();
                                CustomerList matching = new CustomerList();
                                if (name.getText() != null && (!name.getText().equals(""))) {
                                    String nameString = name.getText();
                                    matching = customers.findAllByAddress(nameString);
                                    if (address.getText() != null && (!address.getText().equals(""))) {
                                        String addressString = address.getText();
                                        matching = customers.findAllByAddress(addressString);
                                        if (email.getText() != null && (!email.getText().equals(""))) {
                                            String emailString = email.getText();
                                            matching = customers.findAllByEmail(emailString);
                                            if (phone.getText() != null && (!phone.getText().equals(""))) {
                                                String phoneString = phone.getText();
                                                matching = customers.findAllByPhone(phoneString);
                                            }
                                        }
                                    }
                                } else if (companyName.getText() != null && (!companyName.getText().equals(""))) {
                                    String companynameString = companyName.getText();
                                    matching = customers.findAllByCompanyName(companynameString);
                                    if (address.getText() != null && (!address.getText().equals(""))) {
                                        String addressString = address.getText();
                                        matching = customers.findAllByAddress(addressString);
                                        if (email.getText() != null && (!email.getText().equals(""))) {
                                            String emailString = email.getText();
                                            matching = customers.findAllByEmail(emailString);
                                            if (phone.getText() != null && (!phone.getText().equals(""))) {
                                                String phoneString = phone.getText();
                                                matching = customers.findAllByPhone(phoneString);
                                            }
                                        }
                                    }
                                } else if (address.getText() != null && (!address.getText().equals(""))) {
                                    String addressString = address.getText();
                                    matching = customers.findAllByAddress(addressString);
                                    if (email.getText() != null && (!email.getText().equals(""))) {
                                        String emailString = email.getText();
                                        matching = customers.findAllByEmail(emailString);
                                        if (phone.getText() != null && (!phone.getText().equals(""))) {
                                            String phoneString = phone.getText();
                                            matching = customers.findAllByPhone(phoneString);
                                        }
                                    }
                                } else if (email.getText() != null && (!email.getText().equals(""))) {
                                    String emailString = email.getText();
                                    matching = customers.findAllByEmail(emailString);

                                    if (phone.getText() != null && (!phone.getText().equals(""))) {
                                        String phoneString = phone.getText();
                                        matching = customers.findAllByPhone(phoneString);
                                    }
                                } else if (phone.getText() != null && (!phone.getText().equals(""))) {
                                    String phoneString = phone.getText();
                                    matching = customers.findAllByPhone(phoneString);
                                }

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
    }*/

//make on key method in panel
// create new object of list then call methot find by.... save it on saved call it again

    /*
    Datalist data = new DataList();

    if ..... data = data.find by...
    if ..... data = data.find by...
    if ..... data = data.find by...

    print
     */

    private void test (){
        TripTempController.edit(new Trip(DataHandler.getBusList().getAtIndex(0), DataHandler.getDestinationList().getAtIndex(0), null, new Date(2012, 1, 1, 1, 1), new Date(2012, 1, 1, 1, 1)));
    }
}
