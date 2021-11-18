package com.splitwise.transactionlist.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.database.model.Expense
import com.splitwise.databinding.ExpenseUserItemsBinding


class TransactionListAdapter : RecyclerView.Adapter<TransactionListAdapter.FeedViewHolder>() {
    private var items: ArrayList<Expense> = arrayListOf()

    init {
        setHasStableIds(true)
    }

    fun addTransaction(newList: List<Expense>) {
        try {
            val l = items.size
            items.addAll(newList)
            notifyItemRangeInserted(l, newList.size)
        } catch (ex: Throwable) {
            ex.printStackTrace()
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FeedViewHolder {
        val binding = ExpenseUserItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FeedViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size


    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    inner class FeedViewHolder(private val binding: ExpenseUserItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(feed: Expense) {
            with(binding) {

            }
        }
    }
}