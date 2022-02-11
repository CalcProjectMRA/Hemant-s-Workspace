package com.example.numbersystem;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    Spinner sp1,sp2;
    EditText ed1;
    TextView answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp1 = findViewById(R.id.spfrom);
        sp2 = findViewById(R.id.spto);
        ed1 = findViewById(R.id.txtamt);
        answer = findViewById(R.id.textView5);


        String[] from = {"Binary","Octal", "Decimal","Hexadecimal"};
        ArrayAdapter ad = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,from);
        sp1.setAdapter(ad);


        String[] to = {"Binary","Octal", "Decimal","Hexadecimal"};
        ArrayAdapter ad1 = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,to);
        sp2.setAdapter(ad1);

        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //check if spinner2 has a selected item and show the value in edittext
                convert();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                // sometimes you need nothing here

            }
        });
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //check if spinner2 has a selected item and show the value in edittext
                convert();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                // sometimes you need nothing here

            }
        });




        ed1.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                convert();
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int aft ) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                //call your function here of calculation here
                convert();

            }
        });

    }

    public void convert(){

        if (ed1.getText().toString().trim().length()>0) {




/*
1.Binary CONVERSION
 */
            //1.Binary to Octal
            if (sp1.getSelectedItem().toString() == "Binary" && sp2.getSelectedItem().toString() == "Octal") {
                long amt = Long.parseLong(ed1.getText().toString());
                int decimalNumber = 0, i = 0;
                while (amt > 0) {

                    // multiplying each digit of binary
                    // with increasing powers of 2 towards
                    // left
                    decimalNumber += Math.pow(2, i++) * (amt % 10);

                    // dividing the binary by 10
                    // to remove the last digit
                    amt /= 10;
                }

                    // using the toOctalString() to convert
                    // Integer to String of Octal Number
                    String octalString = Integer.toOctalString(decimalNumber);

                    // converting the String of octal number
                    // to an Integer
                    int octalNumber = Integer.parseInt(octalString);

                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + octalNumber);
            }

            //2.Binary to Decimal
            else if (sp1.getSelectedItem().toString() == "Binary" && sp2.getSelectedItem().toString() == "Decimal") {
                long amt = Long.parseLong(ed1.getText().toString());
                int decimalNumber = 0, i = 0;
                while (amt > 0) {

                    // multiplying each digit of binary
                    // with increasing powers of 2 towards
                    // left
                    decimalNumber += Math.pow(2, i++) * (amt % 10);

                    // dividing the binary by 10
                    // to remove the last digit
                    amt /= 10;
                }

                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + decimalNumber);
            }

            //3.Binary
            else if (sp1.getSelectedItem().toString() == "Binary" && sp2.getSelectedItem().toString() == "Hexadecimal") {
                long amt = Long.parseLong(ed1.getText().toString());
                int decimalNumber = 0, i = 0;
                while (amt > 0) {

                    // multiplying each digit of binary
                    // with increasing powers of 2 towards
                    // left
                    decimalNumber += Math.pow(2, i++) * (amt % 10);

                    // dividing the binary by 10
                    // to remove the last digit
                    amt /= 10;
                }

                // converting the integer to the desired
                // hex string using toHexString() method
                String hexNumber = Integer.toHexString(decimalNumber);

                // converting the string to uppercase
                // for uniformity
                hexNumber = hexNumber.toUpperCase();

                    //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + hexNumber);
            }
/*
2.Decimal CONVERSION
 */

            //1.decimal to binary
            else if (sp1.getSelectedItem().toString() == "Decimal" && sp2.getSelectedItem().toString() == "Binary") {
                long amt = Long.parseLong(ed1.getText().toString());

                int B_Number = 0;
                int cnt = 0;
                while (amt != 0) {
                    long rem = amt % 2;
                    double c = Math.pow(10, cnt);
                    B_Number += rem * c;
                    amt /= 2;

                    // Count used to store exponent value
                    cnt++;
                }

                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + B_Number);

            }
            //2.decimal to octal
            else if (sp1.getSelectedItem().toString() == "Decimal" && sp2.getSelectedItem().toString() == "Octal") {
                long amt = Long.parseLong(ed1.getText().toString());
                int octalNum = 0, countval = 1;
                long dNo = amt;
                while (amt != 0) {

                    // decimals remainder is calculated
                    long remainder = amt % 8;

                    // storing the octalvalue
                    octalNum += remainder * countval;

                    // storing exponential value
                    countval = countval * 10;
                    amt /= 8;
                }
//                System.out.println(octalNum);
                //Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                answer.setText("" + octalNum);
            }
            //3.decimal to hexadecimal
            else if (sp1.getSelectedItem().toString() == "Decimal" && sp2.getSelectedItem().toString() == "Hexadecimal") {
                long amt = Long.parseLong(ed1.getText().toString());

                answer.setText("" + Long.toHexString(amt));
            }
/*
3..Hexadecimal CONVERSION
 */
            //1.hexadecimal to binary
            else if (sp1.getSelectedItem().toString() == "Hexadecimal" && sp2.getSelectedItem().toString() == "Binary") {
                String hex = ed1.getText().toString();

                // variable to store the converted
                // Binary Sequence
                String binary = "";

                // converting the accepted Hexadecimal
                // string to upper case
                hex = hex.toUpperCase();

                // initializing the HashMap class
                HashMap<Character, String> hashMap
                        = new HashMap<Character, String>();

                // storing the key value pairs
                hashMap.put('0', "0000");
                hashMap.put('1', "0001");
                hashMap.put('2', "0010");
                hashMap.put('3', "0011");
                hashMap.put('4', "0100");
                hashMap.put('5', "0101");
                hashMap.put('6', "0110");
                hashMap.put('7', "0111");
                hashMap.put('8', "1000");
                hashMap.put('9', "1001");
                hashMap.put('A', "1010");
                hashMap.put('B', "1011");
                hashMap.put('C', "1100");
                hashMap.put('D', "1101");
                hashMap.put('E', "1110");
                hashMap.put('F', "1111");

                int i;
                char ch;

                // loop to iterate through the length
                // of the Hexadecimal String
                for (i = 0; i < hex.length(); i++) {
                    // extracting each character
                    ch = hex.charAt(i);

                    // checking if the character is
                    // present in the keys
                    if (hashMap.containsKey(ch))

                        // adding to the Binary Sequence
                        // the corresponding value of
                        // the key
                        binary += hashMap.get(ch);

                        // returning Invalid Hexadecimal
                        // String if the character is
                        // not present in the keys
                    else {
                        binary = "Invalid Hexadecimal String";
//                        return binary;
                    }
                }
                answer.setText("" + binary);

            }
            //2.hexadecimal to decimal
            else if (sp1.getSelectedItem().toString() == "Hexadecimal" && sp2.getSelectedItem().toString() == "Decimal") {

                String hexVal = ed1.getText().toString();

                int len = hexVal.length();

                // Initializing base value to 1, i.e 16^0
                int base = 1;

                int dec_val = 0;

                // Extracting characters as digits from last
                // character
                for (int i = len - 1; i >= 0; i--) {
                    // if character lies in '0'-'9', converting
                    // it to integral 0-9 by subtracting 48 from
                    // ASCII value
                    if (hexVal.charAt(i) >= '0'
                            && hexVal.charAt(i) <= '9') {
                        dec_val += (hexVal.charAt(i) - 48) * base;

                        // incrementing base by power
                        base = base * 16;
                    }

                    // if character lies in 'A'-'F' , converting
                    // it to integral 10 - 15 by subtracting 55
                    // from ASCII value
                    else if (hexVal.charAt(i) >= 'A'
                            && hexVal.charAt(i) <= 'F') {
                        dec_val += (hexVal.charAt(i) - 55) * base;

                        // incrementing base by power
                        base = base * 16;
                    }
                }
                answer.setText("" + dec_val);
            }
            //3.hexadecimal to octal
            else if (sp1.getSelectedItem().toString() == "Hexadecimal" && sp2.getSelectedItem().toString() == "Octal") {

                int dec = 0;

                String hexa = ed1.getText().toString();
                int c = hexa.length() - 1;

                // finding the decimal equivalent of the
                // hexa decimal number
                for(int i = 0; i < hexa.length() ; i ++ )
                {
                    //extracting each character from the string.
                    char ch = hexa.charAt(i);
                    switch (ch)
                    {
                        case '0':
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                        case '8':
                        case '9':
                            dec = dec + Integer.parseInt(Character.toString(ch))*
                                    (int)Math.pow(16,c);
                            c--;
                            break;
                        case 'a':
                        case 'A':
                            dec = dec + 10 * (int)Math.pow(16, c);
                            c--;
                            break;
                        case 'b':
                        case 'B':
                            dec = dec + 11 * (int)Math.pow(16, c);
                            c--;
                            break;
                        case 'c':
                        case 'C':
                            dec = dec + 12 * (int)Math.pow(16, c);
                            c--;
                            break;
                        case 'd':
                        case 'D':
                            dec = dec + 13 * (int)Math.pow(16, c);
                            c--;
                            break;
                        case 'e':
                        case 'E':
                            dec = dec + 14 * (int)Math.pow(16, c);
                            c--;
                            break;
                        case 'f':
                        case 'F':
                            dec = dec + 15 * (int)Math.pow(16, c);
                            c--;
                            break;
                        default:
                            System.out.println("Invalid hexa input");
                            break;
                    }
                }

                // String oct to store the octal equivalent of a hexadecimal number.
                String oct ="";

                //converting decimal to octal number.
                while(dec > 0)
                {
                    oct = dec % 8 + oct;
                    dec = dec / 8;
                }

                answer.setText("" + oct);
            }
/*
4.Octal CONVERSION
 */

            else if (sp1.getSelectedItem().toString() == "Octal" && sp2.getSelectedItem().toString() == "Hexadecimal") {
                String octnum = ed1.getText().toString();

                String hexnum;
                int decnum;

                decnum = Integer.parseInt(octnum, 8);

                // Convert Decimal to Hexadecimal
                hexnum = Integer.toHexString(decnum);

                answer.setText("" + hexnum);
            }
            else if (sp1.getSelectedItem().toString() == "Octal" && sp2.getSelectedItem().toString() == "Binary") {
                String octalValue = ed1.getText().toString();

                int octal = Integer.parseInt(octalValue, 8);

                // converting octal number to binary
                // and storing as a string
                String binaryValue = Integer.toBinaryString(octal);

                // returning the resultant string
//                return binaryValue;

                answer.setText("" + binaryValue);
            }
            else if (sp1.getSelectedItem().toString() == "Octal" && sp2.getSelectedItem().toString() == "Decimal") {
                String octnum = ed1.getText().toString();

                int decnum;

                decnum = Integer.parseInt(octnum, 8);
                answer.setText("" + decnum);
            }

            else {
                long amt = Long.parseLong(ed1.getText().toString());
                amt = 0;
                answer.setText("0");
            }

        }
    }

}