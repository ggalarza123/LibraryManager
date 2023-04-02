package classes;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.librarymanager.AddBookActivity;
import com.example.librarymanager.ManageBooksInventoryActivity;
import com.example.librarymanager.R;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/*
 * Final Project - Mobile Library Manager Admin App
 *
 * CMPR.X413 - Java Programming II
 * @author GaudencioGalarza
 * @03-28-2023
 *
 */
public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {

    List<Book> listOfBooks;
    Context context;
    static int itemSelected = RecyclerView.NO_POSITION;

    public BookAdapter(Context context, List<Book> listOfBooks) {
        this.context = context;
        Collections.reverse(listOfBooks);
        this.listOfBooks = listOfBooks;
    }

    @NonNull
    @Override
    public BookAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.layout_single_book_view, parent, false);
        return new BookAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookAdapter.ViewHolder holder, int position) {
        BookManager bookManager = new BookManager();
        Book book = listOfBooks.get(position);
        holder.authorName.setText(bookManager.getBookAuthor(book));
        holder.bookTitle.setText(bookManager.getBookTitle(book));
        holder.booksInStock.setText(String.valueOf(bookManager.getBooksInStock(book)));
        holder.bookYear.setText(String.valueOf(bookManager.getBookYear(book)));
        holder.bookBarcode.setText(bookManager.getBarcode(book));

    }

    @Override
    public int getItemCount() {
        return listOfBooks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView bookTitle, authorName, bookBarcode, bookYear, booksInStock;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            bookTitle = itemView.findViewById(R.id.book_title_view);
            authorName = itemView.findViewById(R.id.author_name_view);
            bookBarcode = itemView.findViewById(R.id.book_id_view);
            bookYear = itemView.findViewById(R.id.book_year_view);
            booksInStock = itemView.findViewById(R.id.books_in_stock_num);
        }


        @Override
        public void onClick(View view) {
            if (getAdapterPosition() == RecyclerView.NO_POSITION) {
                return;
            } else {
                notifyItemChanged(itemSelected);
                itemSelected = getAdapterPosition();
                setUpNewActivity();

            }
        }
    }

    public void setUpNewActivity() {
        Intent intent = new Intent(this.context, ManageBooksInventoryActivity.class);
        intent.putExtra("book position in list reversed", itemSelected);
        context.startActivity(intent);
    }
}
