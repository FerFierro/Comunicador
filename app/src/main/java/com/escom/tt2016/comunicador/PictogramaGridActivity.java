package com.escom.tt2016.comunicador;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.escom.tt2016.comunicador.dummy.PictogramaContent;

import java.util.List;

/**
 * Esta clase es el adaptador
 */

public class PictogramaGridActivity extends AppCompatActivity {
    /**
     * Esta es la Activity principal para el menÃº de navegacion consejos de relajaciÃ³n
     */
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pictograma_list);



        View recyclerView = findViewById(R.id.pictograma_list);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);

    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new PictogramaAdapter(PictogramaContent.ITEMS));
        recyclerView.setLayoutManager(new GridLayoutManager(this,5));
        //recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        /*si cambiáramos de idea y quisiéramos mostrar los datos de forma tabular tan sólo tendríamos
         que cambiar la asignación del LayoutManager anterior y utilizar un GridLayoutManager, al que
         pasaremos como parámetro el número de columnas a mostrar.*/
    }


    public class PictogramaAdapter
            extends RecyclerView.Adapter<PictogramaAdapter.PictogramaViewHolder> {

        private final List<Pictograma> mValues;

        public PictogramaAdapter(List<Pictograma> items) {
            mValues = items;
        }



 /*onCreateViewHolder(). Encargado de crear los nuevos objetos ViewHolder necesarios para los elementos de la colección.*/

        @Override
        public PictogramaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_pictograma_categoria_content, parent, false);
            return new PictogramaViewHolder(view);
        }




/*onBindViewHolder(). Encargado de actualizar los datos de un RecyclerView.ViewHolder ya existente.*/

        @Override
        public void onBindViewHolder(final PictogramaViewHolder holder, int position) {
            holder.mItem = mValues.get(position);
            // holder.mIdView.setText(mValues.get(position).id);
            holder.mNombreView.setText(mValues.get(position).nombre);
            holder.mImageView.setImageResource(mValues.get(position).idDrawable);
        }



/*getItemCount(). Indica el número de elementos de la colección de datos.*/

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        public class PictogramaViewHolder extends RecyclerView.ViewHolder {
            //campos respectivos de un item Pictograma
            public final View mView;
            // public final TextView mIdView;
            public final ImageView mImageView;
            public final TextView mNombreView;

            public Pictograma mItem;

            public PictogramaViewHolder(View view) {
                super(view);
                mView = view;
                // mIdView = (TextView) view.findViewById(R.id.txt_id);
                mImageView=(ImageView) view.findViewById(R.id.iv_PicElemento_categoria_comunicador);
                mNombreView = (TextView) view.findViewById(R.id.tv_PicElemento_categoria_comunicador);
            }

            @Override
            public String toString() {
                return super.toString() + " '" + mNombreView.getText() + "'";
            }
        }
    }
}
