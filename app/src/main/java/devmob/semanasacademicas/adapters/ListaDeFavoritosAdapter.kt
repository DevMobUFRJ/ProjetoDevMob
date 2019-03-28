package devmob.semanasacademicas.adapters

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import devmob.semanasacademicas.R
import devmob.semanasacademicas.dataclass.Atividade
import kotlinx.android.synthetic.main.fragment_minha_semana.*
import kotlinx.android.synthetic.main.minha_semana_dia.view.*

class ListaDeFavoritosAdapter(private val eventosFavoritados: HashMap<String, ArrayList<Atividade>>) : RecyclerView.Adapter<ListaDeFavoritosAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int)
            = ViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.minha_semana_dia, p0, false))

    override fun getItemCount() = eventosFavoritados.size

    override fun onBindViewHolder(p0: ViewHolder, p1: Int){
        val keys = eventosFavoritados.keys.toList()
        val listActivities = eventosFavoritados[keys[p1]]!!
        p0.bindItems(listActivities, keys[p1])
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val dia = itemView.dia_numero as TextView
        val diaSemana = itemView.dia_semana as TextView
        val list = itemView.listFavorite_Items as RecyclerView


        fun bindItems(listActivities: ArrayList<Atividade>, index: String){
            dia.text = index.subSequence(0, 2)
            diaSemana.text = index.subSequence(3, 6)

            list.apply {
                adapter = ItemsFavoritedListAdapter(listActivities)
                layoutManager = LinearLayoutManager(this.context)
            }



        }

    }

}
