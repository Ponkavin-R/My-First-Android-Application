package com.example.bookbazaar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class PaymentActivity extends AppCompatActivity {

    private TextView totalAmountTextView;
    private TextView discountAmountTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        totalAmountTextView = findViewById(R.id.totalAmountTextView);
        discountAmountTextView = findViewById(R.id.discountAmountTextView);

        Button calculateButton = findViewById(R.id.calculateButton);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTotalAndDiscount();
            }
        });
    }

    private void calculateTotalAndDiscount() {
        // Sample prices
        double totalPrice = 100.00; // Total price before discount
        double discountPercentage = 10.0; // Discount percentage

        // Calculate discount amount
        double discountAmount = (totalPrice * discountPercentage) / 100;

        // Calculate total amount after discount
        double totalAmount = totalPrice - discountAmount;

        // Update TextViews with calculated values
        totalAmountTextView.setText("Total Amount: $" + String.format("%.2f", totalAmount));
        discountAmountTextView.setText("Discount Amount: $" + String.format("%.2f", discountAmount));
    }
}
