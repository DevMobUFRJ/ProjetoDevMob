package devmob.semanasacademicas.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import devmob.semanasacademicas.R
import devmob.semanasacademicas.Types
import devmob.semanasacademicas.adapters.TypeListAdapter
import devmob.semanasacademicas.databinding.ContentEventDetailsBinding
import devmob.semanasacademicas.viewModels.SelectedWeek

class FragmentTelaDeEvento : Fragment() {
    lateinit var model: SelectedWeek

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?):View?
            = ContentEventDetailsBinding.inflate(layoutInflater, container, false).run {
        model = ViewModelProviders.of(activity!!).get(SelectedWeek::class.java)
        event = model.selectedWeek
        fragment = this@FragmentTelaDeEvento

        model.hasChanges.observe(this@FragmentTelaDeEvento, Observer {
            val viewAdapter = TypeListAdapter(model.typeList.keys.toMutableList(), model.selectedWeek, context)
            val viewManager = LinearLayoutManager(context)

            listaDeTipos.apply {
                setHasFixedSize(true)
                isNestedScrollingEnabled = false
                layoutManager = viewManager
                adapter = viewAdapter
            }
        })
        return root
    }
}