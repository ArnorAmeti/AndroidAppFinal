package com.example.justjava;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;


/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increment(View view) {
        quantity = quantity + 1;
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantityText);
        quantityTextView.setText(" " + quantity);
    }

    public void decrement(View view) {
        quantity = quantity - 1;
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantityText);
        quantityTextView.setText(" " + quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whippedCream = (CheckBox) findViewById(R.id. whippedCream);
        boolean checkIfWhippedCream = whippedCream.isChecked();
        Log.v("Main Activity", "Whipped Cream? " + checkIfWhippedCream);

        int price = calculatePrice();
        String priceMessage = createOrderSummery(price, checkIfWhippedCream);
        TextView priceTextView = (TextView) findViewById(R.id.priceText);
        priceTextView.setText(priceMessage);

       /* EditText name = (EditText) findViewById(R.id.yourName);
        String text = name.getText().toString();
        Log.v("Main Activity", "Your Name: " + text);
*/

    }


    private void showMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.priceText);
        priceTextView.setText(message);
    }

    private String createOrderSummery(int price, boolean whippedCream) {

        String orderMessage = "Arnor Ameti";
        orderMessage = orderMessage + "\nWhippped Cream: " + whippedCream;
        orderMessage = orderMessage + "\nQuantity: " + quantity;
        orderMessage = orderMessage + "\nTotal: CHF" + price;
        orderMessage = orderMessage + "\nThank You!";
        return orderMessage;
    }

    /**
     * This method displays the given quantity value on the screen.
     */

    private int calculatePrice () {
        int price = quantity * 5;
        return price;
    }

    private void showPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.priceText);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    private void display() {
    }


    private void showQuantity() {
    }
}