package com.example.zxw.playexo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private IBookManager bookManager;
    private int i = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindService(new Intent(this, RemoteService.class),
                connection, Context.BIND_AUTO_CREATE);
        TextView textView = findViewById(R.id.Hello_text);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i++;
                Book book = new Book(i, "book" + i);
                try {
                    bookManager.addBook(book);
                    List<Book> bookList = bookManager.getBookList();
                    Log.e("activity", "onClick: " +bookList.size());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            bookManager = IBookManager.Stub.asInterface(iBinder);
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };
}
