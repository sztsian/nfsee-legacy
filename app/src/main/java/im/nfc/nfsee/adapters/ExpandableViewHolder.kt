package im.nfc.nfsee.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class ExpandableViewHolder(val view: View, val expanded: MutableList<Boolean>) : RecyclerView.ViewHolder(view) {

    init {
        view.setOnClickListener {
            val position = it.tag as Int
            expanded[position] = !expanded[position]
            setDetailVisibility(view, expanded[position])
        }
    }

    abstract fun setDetailVisibility(view: View, visibility: Boolean)

    fun bind(position: Int) = with(view) {
        setDetailVisibility(this, expanded[position])
    }
}