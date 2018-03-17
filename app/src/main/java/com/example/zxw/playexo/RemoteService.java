package com.example.zxw.playexo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZXW23 on 2018/3/17.
 */

public class RemoteService extends Service {
    private Book book;
    List<Book> list=new ArrayList<>();
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return bookManager;
    }

    IBookManager.Stub bookManager = new IBookManager.Stub() {
        @Override
        public List<Book> getBookList() throws RemoteException {
            list.add(book);
            return list;
        }

        @Override
        public void addBook(Book book) throws RemoteException {
            RemoteService.this.book=book;
            Log.e("RemoteService", "addBook: " + book.bookName + "------" + book.bookId);
        }
    };
}
