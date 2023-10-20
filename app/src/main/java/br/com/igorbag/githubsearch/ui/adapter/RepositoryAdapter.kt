package br.com.igorbag.githubsearch.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.igorbag.githubsearch.R
import br.com.igorbag.githubsearch.domain.Repository
import org.w3c.dom.Text

class RepositoryAdapter(private val repositories: List<Repository>) :
    RecyclerView.Adapter<RepositoryAdapter.ViewHolder>() {

    var carItemLister: (Repository) -> Unit = {}
    var btnShareLister: (Repository) -> Unit = {}

    // Cria uma nova view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.repository_item, parent, false)
        return ViewHolder(view)
    }

    // Pega o conteudo da view e troca pela informacao de item de uma lista
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //@TODO 8 -  Realizar o bind do viewHolder
        //Exemplo de Bind
        //  holder.preco.text = repositories[position].atributo

        // Exemplo de click no item
        //holder.itemView.setOnClickListener {
        // carItemLister(repositores[position])
        //}

        // Exemplo de click no btn Share
        //holder.favorito.setOnClickListener {
        //    btnShareLister(repositores[position])
        //}

        holder.name.text = repositories[position].name
        holder.share.setOnClickListener {
            btnShareLister(repositories[position])
        }
    }

    // Pega a quantidade de repositorios da lista
    override fun getItemCount(): Int = repositories.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name : TextView
        val share : ImageView
        init {
            share = view.findViewById(R.id.iv_favorite)
            name = view.findViewById(R.id.tv_preco)
        }
    }
}


