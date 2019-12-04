package com.kkdev.ebookshop.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.kkdev.ebookshop.model.Book;
import com.kkdev.ebookshop.model.Category;
import com.kkdev.ebookshop.model.EBookShopRepository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
    private EBookShopRepository eBookShopRepository;
    private LiveData<List<Category>> allCategories;
    private LiveData<List<Book>> booksOfASelectedCategory;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);

        eBookShopRepository = new EBookShopRepository(application);
    }

    public LiveData<List<Category>> getAllCategories() {
        allCategories = eBookShopRepository.getCategories();
        return allCategories;
    }

    public LiveData<List<Book>> getBooksOfASelectedCategory(int categoruId) {
        booksOfASelectedCategory = eBookShopRepository.getBooks(categoruId);
        return booksOfASelectedCategory;
    }
    public void addNewBook(Book book){
        eBookShopRepository.insertBook(book);
    }
    public void updateBook(Book book){
        eBookShopRepository.updateBook(book);
    }
    public void deleteBook(Book book){
        eBookShopRepository.deleteBook(book);
    }

}
