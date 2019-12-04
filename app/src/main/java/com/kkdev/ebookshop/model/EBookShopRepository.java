package com.kkdev.ebookshop.model;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class EBookShopRepository {
    private CategoryDao categoryDao;
    private BookDao bookDao;
    private LiveData<List<Category>> categories;
    private LiveData<List<Book>> books;

    public EBookShopRepository(Application application) {
        BooksDatabase booksDatabase = BooksDatabase.getInstance(application);
        categoryDao = booksDatabase.categoryDao();
        bookDao = booksDatabase.bookDao();
    }

    public LiveData<List<Category>> getCategories() {
        return categoryDao.getAllCategories();
    }

    public LiveData<List<Book>> getBooks(int categoryId) {
        return bookDao.getBooks(categoryId);
    }

    public void insertCategory(final Category category){
        //new InsertCategoryAsyncTask(categoryDao).execute(category);
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                categoryDao.Insert(category);
            }
        });
    }

//    private static class InsertCategoryAsyncTask extends AsyncTask<Category,Void,Void>{
//        private CategoryDao categoryDao;
//
//        public InsertCategoryAsyncTask(CategoryDao categoryDao) {
//            this.categoryDao = categoryDao;
//        }
//
//        @Override
//        protected Void doInBackground(Category... categories) {
//            categoryDao.Insert(categories[0]);
//            return null;
//        }
//    }

    public void insertBook(final Book book){
       // new InsertBookAsyncTask(bookDao).execute(book);
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                bookDao.Insert(book);
            }
        });
    }

//    private static class InsertBookAsyncTask extends AsyncTask<Book,Void,Void>{
//        private BookDao bookDao;
//
//        public InsertBookAsyncTask(BookDao bookDao) {
//            this.bookDao = bookDao;
//        }
//
//        @Override
//        protected Void doInBackground(Book... books) {
//            bookDao.Insert(books[0]);
//            return null;
//        }
//    }

    public void deleteCategory(final Category category){
       // new DeleteCategoryAsyncTask(categoryDao).execute(category);
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                categoryDao.Delete(category);
            }
        });
    }

//    private static class DeleteCategoryAsyncTask extends AsyncTask<Category,Void,Void>{
//        private CategoryDao categoryDao;
//
//        public DeleteCategoryAsyncTask(CategoryDao categoryDao) {
//            this.categoryDao = categoryDao;
//        }
//
//        @Override
//        protected Void doInBackground(Category... categories) {
//            categoryDao.Delete(categories[0]);
//            return null;
//        }
//    }

    public void deleteBook(final Book book){
    //    new DeleteBookAsyncTask(bookDao).execute(book);
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                bookDao.Delete(book);
            }
        });
    }

//    private static class DeleteBookAsyncTask extends AsyncTask<Book,Void,Void>{
//        private BookDao bookDao;
//
//        public DeleteBookAsyncTask(BookDao bookDao) {
//            this.bookDao = bookDao;
//        }
//
//        @Override
//        protected Void doInBackground(Book... books) {
//            bookDao.Delete(books[0]);
//            return null;
//        }
//    }

    public void updateCategory(final Category category){
        //new UpdateCategoryAsyncTask(categoryDao).execute(category);
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                categoryDao.Update(category);
            }
        });
    }

//    private static class UpdateCategoryAsyncTask extends AsyncTask<Category,Void,Void>{
//        private CategoryDao categoryDao;
//
//        public UpdateCategoryAsyncTask(CategoryDao categoryDao) {
//            this.categoryDao = categoryDao;
//        }
//
//        @Override
//        protected Void doInBackground(Category... categories) {
//            categoryDao.Update(categories[0]);
//            return null;
//        }
//    }

    public void updateBook(final Book book){
      //  new UpdateBookAsyncTask(bookDao).execute(book);
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                bookDao.Update(book);
            }
        });
    }

//    private static class UpdateBookAsyncTask extends AsyncTask<Book,Void,Void>{
//        private BookDao bookDao;
//
//        public UpdateBookAsyncTask(BookDao bookDao) {
//            this.bookDao = bookDao;
//        }
//
//        @Override
//        protected Void doInBackground(Book... books) {
//            bookDao.Update(books[0]);
//            return null;
//        }
//    }

}
