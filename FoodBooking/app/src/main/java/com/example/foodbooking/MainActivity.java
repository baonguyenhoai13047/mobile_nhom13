package com.example.foodbooking;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.sax.Element;
import android.telephony.SmsManager;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    final Context context = this;
    public static String PACKAGE_NAME;
    public static ArrayList<Integer> listOrder = new ArrayList<Integer>();
    private String phoneNumber = "";

    @Override
    prpackage com.example.foodbooking;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.sax.Element;
import android.telephony.SmsManager;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    final Context context = this;
    public static String PACKAGE_NAME;
    public static ArrayList<Integer> listOrder = new ArrayList<Integer>();
    private String phoneNumber = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PACKAGE_NAME = getApplicationContext().getPackageName();

        final List<ItemList> list_food = getListData();
        final ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new CustomListAdapter(this, list_food));

        Button placeOrder = (Button) findViewById(R.id.placeOrder);
        placeOrder.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                final int PERMISSION_REQUEST_CODE = 1;

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {

                    if (checkSelfPermission(Manifest.permission.SEND_SMS)
                            == PackageManager.PERMISSION_DENIED) {

                        Log.d("permission", "permission denied to SEND_SMS - requesting it");
                        String[] permissions = {Manifest.permission.SEND_SMS};

                        requestPermissions(permissions, PERMISSION_REQUEST_CODE);

                    }
                }

                String listFoodName = "";
                for (Integer e : listOrder) {
                    ItemList food = list_food.get(e);
                    String foodName = food.getFoodName();
                    listFoodName = listFoodName + " + " + foodName;
                }

                final String order = "Your order : " + listFoodName;

                if (listFoodName.equals("")) {
                    Toast.makeText(MainActivity.this, "Please select food first !!!", Toast.LENGTH_SHORT).show();
                } else {
                    final AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setTitle("Please input your number !!!");

                    final AlertDialog.Builder builderSuccess = new AlertDialog.Builder(context);
                    builderSuccess.setTitle("Your order is success");

                    // Set up the buttons
                    builderSuccess.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            listOrder = new ArrayList<Integer>();
                            Intent main = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(main);
                        }
                    });

                    final EditText input = new EditText(context);
                    input.setInputType(InputType.TYPE_CLASS_PHONE);
                    builder.setView(input);


                    // Set up the buttons
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            phoneNumber = input.getText().toString();

                            SmsManager smsManager = SmsManager.getDefault();
                            smsManager.sendTextMessage(phoneNumber, null,
                                    order,
                                    null, null);
                            builderSuccess.show();

                        }
                    });
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });

                    final AlertDialog dialog = builder.create();
                    dialog.show();

                    ((AlertDialog) dialog).getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(false);
                    input.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                        }

                        @Override
                        public void onTextChanged(CharSequence s, int start,
                                                  int before, int count) {

                        }

                        @Override
                        public void afterTextChanged(Editable s) {
                            if (s.length() == 0) {
                                ((AlertDialog) dialog).getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(false);
                                input.setError("This field can not be blank");
                            } else {
                                ((AlertDialog) dialog).getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(true);
                            }
                        }
                    });
                }

            }
        });
    }

    private List<ItemList> getListData() {
        List<ItemList> items = new ArrayList<ItemList>();

        items.add(new ItemList("geo:0,0?q=14+?????ng+??en+ph?????ng+14+H???+Ch??+Minh+B???n+Ngh??",
                "Zucchini-Pear Soup",
                "f1",
                "https://www.cookingchanneltv.com/recipes/mark-bittman/zucchini-pear-soup-1961269"));
        items.add(new ItemList("geo:0,0?q=Qu??n+??n+H????ng+L??i",
                "Yangzhou Fried Rice",
                "f2",
                "https://www.cookingchanneltv.com/recipes/ching-he-huang/yangzhou-fried-rice-1961585"));
        items.add(new ItemList("geo:0,0?q=Qu??n+??n+Quang+M???p",
                "Cauliflower Fried Rice",
                "f3",
                "https://www.cookingchanneltv.com/recipes/tiffani-thiessen/cauliflower-fried-rice-3629531"));


        items.add(new ItemList("geo:0,0?q=Qu??n+??n+C???u+Non",
                "Steamed Sea Bass with Ginger and Chinese Mushrooms",
                "f4",
                "https://www.cookingchanneltv.com/recipes/ching-he-huang/steamed-sea-bass-with-ginger-and-chinese-mushrooms-2042296"));

        items.add(new ItemList("geo:0,0?q=Qu??n+??n+Bamboo",
                "Baked Chinese Rice with Peas and Ginger",
                "f5",
                "https://www.cookingchanneltv.com/recipes/bill-granger/baked-chinese-rice-with-peas-and-ginger-1959076"));

        items.add(new ItemList("geo:0,0?q=Qu??n+??n+Qu???nh",
                "Arroz con Pollo",
                "f6",
                "https://www.cookingchanneltv.com/recipes/ingrid-hoffmann/arroz-con-pollo-1952724"));

        items.add(new ItemList("geo:0,0?q=Qu??n+??n+A+S??N",
                "Chicken with Rice (Arroz con Pollo)",
                "f7",
                "https://www.cookingchanneltv.com/recipes/daisy-martinez/chicken-with-rice-arroz-con-pollo-1945235"));

        items.add(new ItemList("geo:0,0?q=Qu??n+??n+A+Ph??n",
                "Chicken Cacciatore",
                "f8",
                "https://www.cookingchanneltv.com/recipes/debi-mazar-and-gabriele-corcos/chicken-cacciatore-2106913"));

        items.add(new ItemList("geo:0,0?q=Qu??n+??n+A+C??n",
                "Trinidadian-Style Chicken",
                "f9",
                "https://www.cookingchanneltv.com/recipes/roger-mooking/trinidadian-style-chicken-1959070"));

        items.add(new ItemList("geo:0,0?q=Qu??n+??n+B???y+N???",
                "Chicken South Indian Style",
                "f10",
                "https://www.cookingchanneltv.com/recipes/bal-arneson/chicken-south-indian-style-2010126"));

        items.add(new ItemList("geo:0,0?q=Qu??n+??n+B??+B???o",
                "Martinique Coconut Chicken Curry",
                "f11",
                "https://www.cookingchanneltv.com/recipes/levi-roots/martinique-coconut-chicken-curry-2010043"));

        return items;
    }

}
