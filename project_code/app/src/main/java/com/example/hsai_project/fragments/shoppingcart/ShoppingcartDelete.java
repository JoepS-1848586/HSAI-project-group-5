package com.example.hsai_project.fragments.shoppingcart;

        import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
                import android.view.MenuItem;

                import com.example.hsai_project.R;

public class ShoppingcartDelete extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoppingcart_delete);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }


}
