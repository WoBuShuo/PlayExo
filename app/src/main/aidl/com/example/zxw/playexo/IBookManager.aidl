// IBookManager.aidl
package com.example.zxw.playexo;

import com.example.zxw.playexo.Book;

interface IBookManager {
    List<Book> getBookList();
    void addBook(in Book book);
}
