package com.quockhanhng.training.baserecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_contact.view.*

class ContactAdapter(
    override var items: ArrayList<Contact>,
    override var clickItemListener: (Contact) -> Unit
) : BaseAdapter<Contact, ContactAdapter.ContactViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ContactViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false),
        clickItemListener
    )

    class ContactViewHolder(itemView: View, override var clickItemListener: (Contact) -> Unit) :
        BaseViewHolder<Contact>(itemView) {
        override fun bindData(item: Contact) {
            super.bindData(item)
            itemView.apply {
                tvContent.text = item.content
                tvName.text = item.name
                imgAvatar.setBackgroundResource(item.imageUrl);
                tvPhone.text = item.phone
            }
        }
    }
}