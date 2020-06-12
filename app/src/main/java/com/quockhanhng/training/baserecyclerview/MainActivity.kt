package com.quockhanhng.training.baserecyclerview

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val SPACE: Int = 10
    private val COLUMN: Int = 2

    override fun onClick(v: View?) {
        when (v) {
            btnGrid -> recyclerContact.layoutManager = GridLayoutManager(this, COLUMN)
            btnStagger -> recyclerContact.layoutManager =
                StaggeredGridLayoutManager(COLUMN, StaggeredGridLayoutManager.VERTICAL)
            btnLinear -> recyclerContact.layoutManager = LinearLayoutManager(this)
        }
        recyclerContact.adapter =
            ContactAdapter(prepareList()) { contactItem: Contact -> contactItemClicked(contactItem) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerContact.addItemDecoration(GridItemDecoration(SPACE))
        btnGrid.setOnClickListener(this)
        btnStagger.setOnClickListener(this)
        btnLinear.setOnClickListener(this)
    }

    private fun prepareList(): ArrayList<Contact> {
        val contactList: ArrayList<Contact>? = ArrayList();
        for (i in 1..10) {
            contactList?.add(Contact("ABC", "0123456", R.drawable.default_image, "content"))
            contactList?.add(
                Contact(
                    "ABC",
                    "0123456",
                    R.drawable.default_image,
                    "content content content content content content content content content"
                )
            )
        }
        return contactList!!
    }

    private fun contactItemClicked(contact: Contact) {
        Toast.makeText(this, contact.name, Toast.LENGTH_LONG).show();
    }
}
