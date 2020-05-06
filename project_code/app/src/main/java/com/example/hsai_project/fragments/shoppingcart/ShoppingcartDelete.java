package com.example.hsai_project.fragments.shoppingcart;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.fragment.app.FragmentManager;
        import androidx.fragment.app.FragmentTransaction;
        import androidx.room.Room;

        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
                import android.view.MenuItem;
        import android.view.View;
        import android.widget.Button;

        import com.example.hsai_project.ProductDatabase;
        import com.example.hsai_project.R;

        import java.util.ArrayList;
        import java.util.List;

public class ShoppingcartDelete extends AppCompatActivity {

    List<ShoppingcartDeleteItem> m_data = new ArrayList<ShoppingcartDeleteItem>();
    public static String EXTRA_REMOVED_ITEM_IDS = "com.example.hsai_project.fragments.shoppincart.REMOVED_IDS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoppingcart_delete);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button b = (Button)findViewById(R.id.shoppingcart_delete_button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Integer> ids = new ArrayList<Integer>();
                for(int i = 0; i < m_data.size();++i){
                    if(m_data.get(i).isActive()){
                        ids.add(m_data.get(i).getItemId());
                    }
                }
                int[] r = new int[ids.size()];
                int i = 0;
                for (Integer e : ids)
                    r[i++] = e;
                returnResult(r);
            }
        });

        getEntries();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setResult(Activity.RESULT_CANCELED);
        finish();
        return true;
    }


    public void getEntries(){
        ProductDatabase db = Room.databaseBuilder(getApplicationContext(), ProductDatabase.class, "shoppincart_table")
                .allowMainThreadQueries().build();

        //m_data = db.productDao().getAllShoppingcartProducts();

        addFragment(new ShoppingcartItem(1,"testprod", 150, "testStore", 2));
        addFragment(new ShoppingcartItem(2,"testprod2", 300, "testStore", 4));

    }

    public void addFragment(ShoppingcartItem data){
        ShoppingcartDeleteItem frag = new ShoppingcartDeleteItem( data);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        transaction.add(R.id.shoppingcart_delete_fragmentcontainer, frag);
        transaction.commit();

        m_data.add(frag);
    }

    private void returnResult(int[] ids){
        Intent i = new Intent();
        i.putExtra(EXTRA_REMOVED_ITEM_IDS, ids);
        setResult(Activity.RESULT_OK, i);
        finish();
    }
}
