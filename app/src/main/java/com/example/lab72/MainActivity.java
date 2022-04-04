package com.example.lab72;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
   private ListView lvwContact;
    private List<Contact> contacts;
    private Button btnAdd,btncan;
    private ImageButton btnxoa,btnsua;
    private EditText txtnhap;
    private TextView txtten;
    private DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db= new DatabaseHandler(this);
        lvwContact=(ListView) findViewById(R.id.listitem);
        Log.d("Reading:  ", "Reading all contacts..");
        contacts = db.getAllContacts();

        btnAdd=(Button) findViewById(R.id.btnthem);
        btncan=(Button) findViewById(R.id.btnthoa);

        txtnhap=(EditText) findViewById(R.id.txtnhap);
        txtten=(TextView) findViewById(R.id.txtten);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.addContact(new Contact(txtnhap.getText().toString()));
                contacts = db.getAllContacts();
                dataChange();
            }
        });

        btncan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        dataChange();
    }
    public void dataChange(){
        Adaptercontact adaptercontact=new Adaptercontact(MainActivity.this,R.layout.item_contacts,contacts);
        lvwContact.setAdapter(adaptercontact);
    }
    public  void XoaDongdachon(int id)
    {
        Contact xoa=  db.getContact(id);
        db.deleteContact(xoa);
        contacts = db.getAllContacts();
        dataChange();
    }
    public  void  Suadongdachon(String ten,int id)
    {
           // txtnhap.setText(ten);
            String tenmoi=txtnhap.getText().toString().trim();
            Contact sua=new Contact(id,tenmoi);
            db.updateContact(sua);
            contacts = db.getAllContacts();
            dataChange();
    }
}
