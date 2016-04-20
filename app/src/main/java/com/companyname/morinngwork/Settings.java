package com.companyname.morinngwork;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class Settings extends AppCompatActivity {

    private static final int DEFAULT_TEXT_SIZE = 15;
    private static final int DEFAULT_COLOR = Color.BLACK;

    private SharedPreferences sharedPreferences;
    private EditText textViewOneSizeEditText;
    private EditText textViewTwoSizeEditText;
    private Button buttonOne;
    private Button buttonTwo;
    private int textViewOneSizeData;
    private int textViewTwoSizeData;
    private int textViewOneColor;
    private int textViewTwoColor;
    private ArrayList<String> colorList;
    private String buttonOneValue;
    private String buttonTwoValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        textViewOneSizeEditText = (EditText) findViewById(R.id.text_one_size);
        textViewTwoSizeEditText = (EditText) findViewById(R.id.text_two_size);
        buttonOne = (Button) findViewById(R.id.button_one);
        buttonTwo = (Button) findViewById(R.id.button_two);

        sharedPreferences = getApplicationContext().getSharedPreferences("secretKey", Context.MODE_PRIVATE);
        textViewOneSizeData = sharedPreferences.getInt("textViewOneSize", DEFAULT_TEXT_SIZE);
        textViewTwoSizeData = sharedPreferences.getInt("textViewTwoSize", DEFAULT_TEXT_SIZE);
        textViewOneColor = sharedPreferences.getInt("textViewOneColor", DEFAULT_COLOR);
        textViewTwoColor = sharedPreferences.getInt("textViewTwoColor", DEFAULT_COLOR);
        buttonOneValue = sharedPreferences.getString("buttonOneValue", "BLACK");
        buttonTwoValue = sharedPreferences.getString("buttonTwoValue", "BLACK");

        textViewOneSizeEditText.setText("" + textViewOneSizeData);
        textViewTwoSizeEditText.setText("" + textViewTwoSizeData);

        updateButtons();
        createColorList();
    }

    public void updateButtons() {
        buttonOne.setText(buttonOneValue);
        buttonOne.setTextColor(textViewOneColor);
        buttonTwo.setText(buttonTwoValue);
        buttonTwo.setTextColor(textViewTwoColor);
    }

    public void createColorList() {
        colorList = new ArrayList<>();
        colorList.add("BLACK");
        colorList.add("BLUE");
        colorList.add("CYAN");
        colorList.add("DKGRAY");
        colorList.add("GRAY");
        colorList.add("GREEN");
        colorList.add("LTGRAY");
        colorList.add("MAGENTA");
        colorList.add("RED");
        colorList.add("TRANSPARENT");
        colorList.add("WHITE");
        colorList.add("YELLOW");
    }

    @Override
    protected void onPause() {
        super.onPause();
        try {
            textViewOneSizeData = Integer.parseInt(textViewOneSizeEditText.getText().toString());
            textViewTwoSizeData = Integer.parseInt(textViewTwoSizeEditText.getText().toString());
        } catch (NumberFormatException e) {
        }

        sharedPreferences = getApplicationContext().getSharedPreferences("secretKey", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("textViewOneSize", textViewOneSizeData);
        editor.putInt("textViewTwoSize", textViewTwoSizeData);
        editor.putInt("textViewOneColor", textViewOneColor);
        editor.putInt("textViewTwoColor", textViewTwoColor);
        editor.putString("buttonOneValue", buttonOneValue);
        editor.putString("buttonTwoValue", buttonTwoValue);
        editor.commit();
    }

    public void clickedChangedOne(View view) {
        final Dialog dialog = new Dialog(Settings.this);
        dialog.setContentView(R.layout.dialog_list);

        ListView listView = (ListView) dialog.findViewById(R.id.list_view);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, colorList) {
            @Override
            public View getView (int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                ((TextView)view).setTextColor(Color.BLACK);
                return view;
            }
        };
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String currentColor = colorList.get(position);
                switch (currentColor) {
                    case "BLACK":
                        textViewOneColor = Color.BLACK;
                        buttonOneValue = "BLACK";
                        updateButtons();
                        dialog.cancel();
                        break;
                    case "BLUE":
                        textViewOneColor = Color.BLUE;
                        buttonOneValue = "BLUE";
                        updateButtons();
                        dialog.cancel();
                        break;
                    case "CYAN":
                        textViewOneColor = Color.CYAN;
                        buttonOneValue = "CYAN";
                        updateButtons();
                        dialog.cancel();
                        break;
                    case "DKGRAY":
                        textViewOneColor = Color.DKGRAY;
                        buttonOneValue = "DKGRAY";
                        updateButtons();
                        dialog.cancel();
                        break;
                    case "GRAY":
                        textViewOneColor = Color.GRAY;
                        buttonOneValue = "GRAY";
                        updateButtons();
                        dialog.cancel();
                        break;
                    case "GREEN":
                        textViewOneColor = Color.GREEN;
                        buttonOneValue = "GREEN";
                        updateButtons();
                        dialog.cancel();
                        break;
                    case "LTGRAY":
                        textViewOneColor = Color.LTGRAY;
                        buttonOneValue = "LTGRAY";
                        updateButtons();
                        dialog.cancel();
                        break;
                    case "MAGENTA":
                        textViewOneColor = Color.MAGENTA;
                        buttonOneValue = "MAGENTA";
                        updateButtons();
                        dialog.cancel();
                        break;
                    case "RED":
                        textViewOneColor = Color.RED;
                        buttonOneValue = "RED";
                        updateButtons();
                        dialog.cancel();
                        break;
                    case "TRANSPARENT":
                        textViewOneColor = Color.TRANSPARENT;
                        buttonOneValue = "TRANSPARENT";
                        updateButtons();
                        dialog.cancel();
                        break;
                    case "WHITE":
                        textViewOneColor = Color.WHITE;
                        buttonOneValue = "WHITE";
                        updateButtons();
                        dialog.cancel();
                        break;
                    case "YELLOW":
                        textViewOneColor = Color.YELLOW;
                        buttonOneValue = "YELLOW";
                        updateButtons();
                        dialog.cancel();
                        break;
                    default:
                        textViewOneColor = Color.BLACK;
                        buttonOneValue = "BLACK";
                        updateButtons();
                        dialog.cancel();
                        break;
                }
            }
        });
        dialog.setCancelable(true);
        dialog.setTitle("Change The Color");
        dialog.show();

    }

    public void clickedChangedTwo(View view) {
        final Dialog dialog = new Dialog(Settings.this);
        dialog.setContentView(R.layout.dialog_list);

        ListView listView = (ListView) dialog.findViewById(R.id.list_view);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, colorList) {
            @Override
            public View getView (int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                ((TextView)view).setTextColor(Color.BLACK);
                return view;
            }
        };
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String currentColor = colorList.get(position);
                switch (currentColor) {
                    case "BLACK":
                        textViewTwoColor = Color.BLACK;
                        buttonTwoValue = "BLACK";
                        updateButtons();
                        dialog.cancel();
                        break;
                    case "BLUE":
                        textViewTwoColor = Color.BLUE;
                        buttonTwoValue = "BLUE";
                        updateButtons();
                        dialog.cancel();
                        break;
                    case "CYAN":
                        textViewTwoColor = Color.CYAN;
                        buttonTwoValue = "CYAN";
                        updateButtons();
                        dialog.cancel();
                        break;
                    case "DKGRAY":
                        textViewTwoColor = Color.DKGRAY;
                        buttonTwoValue = "DKGRAY";
                        updateButtons();
                        dialog.cancel();
                        break;
                    case "GRAY":
                        textViewTwoColor = Color.GRAY;
                        buttonTwoValue = "GRAY";
                        updateButtons();
                        dialog.cancel();
                        break;
                    case "GREEN":
                        textViewTwoColor = Color.GREEN;
                        buttonTwoValue = "GREEN";
                        updateButtons();
                        dialog.cancel();
                        break;
                    case "LTGRAY":
                        textViewTwoColor = Color.LTGRAY;
                        buttonTwoValue = "LTGRAY";
                        updateButtons();
                        dialog.cancel();
                        break;
                    case "MAGENTA":
                        textViewTwoColor = Color.MAGENTA;
                        buttonTwoValue = "MAGENTA";
                        updateButtons();
                        dialog.cancel();
                        break;
                    case "RED":
                        textViewTwoColor = Color.RED;
                        buttonTwoValue = "RED";
                        updateButtons();
                        dialog.cancel();
                        break;
                    case "TRANSPARENT":
                        textViewTwoColor = Color.TRANSPARENT;
                        buttonTwoValue = "TRANSPARENT";
                        updateButtons();
                        dialog.cancel();
                        break;
                    case "WHITE":
                        textViewTwoColor = Color.WHITE;
                        buttonTwoValue = "WHITE";
                        updateButtons();
                        dialog.cancel();
                        break;
                    case "YELLOW":
                        textViewTwoColor = Color.YELLOW;
                        buttonTwoValue = "YELLOW";
                        updateButtons();
                        dialog.cancel();
                        break;
                    default:
                        textViewTwoColor = Color.BLACK;
                        buttonTwoValue = "BLACK";
                        updateButtons();
                        dialog.cancel();
                        break;
                }
            }
        });
        dialog.setCancelable(true);
        dialog.setTitle("Change The Color");
        dialog.show();

        updateButtons();
    }

}
